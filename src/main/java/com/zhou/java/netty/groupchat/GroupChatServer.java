package com.zhou.java.netty.groupchat;

import com.sun.corba.se.internal.CosNaming.BootstrapServer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @Description
 * @Author xiaohu
 * @Date 2021/1/14 15:37
 */
public class GroupChatServer {

    private int port;

    public GroupChatServer(int port){this.port = port;}

    public void run() throws Exception{


        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workGroup = new NioEventLoopGroup();

        try {

            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(bossGroup, workGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            //获取到pipeline
                            ChannelPipeline pipeline = socketChannel.pipeline();
                            // 加入解码器
                            pipeline.addLast("decoder", new StringDecoder());
                            // 加入编码器
                            pipeline.addLast("encoder", new StringEncoder());
                            pipeline.addLast(new GroupChatServerHandler());
                        }
                    });

            System.out.println("netty 服务器启动");
            ChannelFuture cf = serverBootstrap.bind(port).sync();
            cf.channel().closeFuture().sync();
        }finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }

    }


    public static void main(String[] args) throws Exception {

        new GroupChatServer(7000).run();
    }

}
