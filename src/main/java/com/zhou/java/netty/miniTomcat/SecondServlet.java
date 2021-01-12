package com.zhou.java.netty.miniTomcat;

/**
 * @Description
 * @Author xiaohu
 * @Date 2020/12/15 16:04
 */
public class SecondServlet extends MiNiServlet {
    @Override
    protected void doPost(MiNiRequest request, MiNiResponse response) {
        System.out.println("第二个servlet");
    }

    @Override
    protected void doGet(MiNiRequest request, MiNiResponse response) {
        this.doPost(request,response);
    }
}
