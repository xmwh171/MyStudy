package com.zhou.java.netty.miniTomcat;

/**
 * @Description
 * @Author xiaohu
 * @Date 2020/12/15 16:03
 */
public class FirstServlet extends MiNiServlet {
    @Override
    protected void doPost(MiNiRequest request, MiNiResponse response) {
        this.doPost(request,response);
    }

    @Override
    protected void doGet(MiNiRequest request, MiNiResponse response) {
        response.write("FirstServlet alreadly start !");
    }
}
