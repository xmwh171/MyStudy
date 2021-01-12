package com.zhou.java.netty.miniTomcat;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @Description
 * @Author xiaohu
 * @Date 2020/12/15 16:02
 */
public class MiNiTomcat {
    private int port=8080;//端口
    private Map<String,MiNiServlet> map=new HashMap<>();
    private Properties webxml=new Properties();
    private void init(){
        //加载xml文件
        try{
            String WEB_INF=this.getClass().getResource("/").getPath();
            FileInputStream fis=new FileInputStream(WEB_INF+"webxml.properties");
            //基于properties实现
            webxml.load(fis);
            for (Object k:webxml.keySet()){
                String key=k.toString();
                if (key.endsWith(".url")){
                    String servletName = key.replaceAll("\\.url$", "");
                    String url = webxml.getProperty(key);
                    String className = webxml.getProperty(servletName + ".className");
                    MiNiServlet obj = (MiNiServlet)Class.forName(className).newInstance();
                    map.put(url, obj);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void start() throws InterruptedException {
        EventLoopGroup bossGroup=null;
        EventLoopGroup workGroup=null;
        try {
            init();
            //Netty 封装了NIO reator
            //主线程
            bossGroup = new NioEventLoopGroup();
            //工作线程
            workGroup = new NioEventLoopGroup();

            //
            ServerBootstrap server = new ServerBootstrap();

            server.group(bossGroup, workGroup)
                    .channel(NioServerSocketChannel.class)
                    //子线程调用
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel client) throws Exception {
                            //客户端初始化处理
                            // 无锁化串行编程
                            //Netty对HTTP协议的封装，顺序有要求
                            //HttpResponseEncoder 编码器
                            client.pipeline().addLast(new HttpResponseEncoder());
                            //HttpRequestDecoder解码器
                            client.pipeline().addLast(new HttpRequestDecoder());
                            //业务逻辑处理
                            client.pipeline().addLast(new MiNiTomcatHander());
                        }
                    })
                    //针对于主线程分配最大线程数量 --128
                    .option(ChannelOption.SO_BACKLOG, 128)
                    //针对于子线程配置
                    .childOption(ChannelOption.SO_KEEPALIVE, true);


            //启动服务
            ChannelFuture future = server.bind(port).sync();

            System.out.println("MiNi tomcat start " + port);
            //关闭服务
            future.channel().closeFuture().sync();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new MiNiTomcat().start();
    }

    private class MiNiTomcatHander extends ChannelInboundHandlerAdapter {


        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            if (msg instanceof HttpRequest){
                HttpRequest req=(HttpRequest) msg;

                //转交给自己实现的请求
                MiNiRequest request=new MiNiRequest(ctx,req);

                //自己实现
                MiNiResponse response=new MiNiResponse(ctx,req);

                String url=request.getUrl();

                if (map.containsKey(url)){
                    map.get(url).service(request,response);
                }else {
                    response.write("404 not fund url");
                }
            }
        }
    }
}
