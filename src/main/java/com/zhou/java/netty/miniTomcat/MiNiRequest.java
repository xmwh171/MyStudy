package com.zhou.java.netty.miniTomcat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.HttpRequest;

/**
 * @Description
 * @Author xiaohu
 * @Date 2020/12/15 16:02
 */
public class MiNiRequest {

    ChannelHandlerContext ctx;
    HttpRequest req;


    public MiNiRequest(ChannelHandlerContext ctx, HttpRequest req) {
        this.ctx=ctx;
        this.req=req;
    }

    public String getUrl() {
        return req.getUri();
    }

    public String getMethod() {
        return req.getMethod().name();
    }
}
