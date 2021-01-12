package com.zhou.java.netty.miniTomcat;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.*;

import java.io.UnsupportedEncodingException;

/**
 * @Description
 * @Author xiaohu
 * @Date 2020/12/15 16:03
 */
public class MiNiResponse {

    private ChannelHandlerContext ctx;

    private HttpRequest req;
    public MiNiResponse(ChannelHandlerContext ctx, HttpRequest req) {
        this.ctx=ctx;
        this.req=req;
    }

    public void write(String out) {
        if (out == null || out.length()==0){
            return;
        }
        try {
            FullHttpResponse fullHttpResponse=new DefaultFullHttpResponse(
                    HttpVersion.HTTP_1_1,
                    HttpResponseStatus.OK,
                    // 将输出值写出 编码为UTF-8
                    Unpooled.wrappedBuffer(out.getBytes("UTF-8")));
            fullHttpResponse.headers().set("Content-Type", "text/html;");
            ctx.write(fullHttpResponse);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }finally {
            ctx.flush();
            ctx.close();

        }
    }

}
