package com.zhou.java.netty.miniTomcat;

/**
 * @Description
 * @Author xiaohu
 * @Date 2020/12/15 16:03
 */
public abstract  class MiNiServlet {

    public void service(MiNiRequest request, MiNiResponse response) {
        if ("GET".equalsIgnoreCase(request.getMethod())){
            doGet(request,response);
        }else{
            doPost(request,response);
        }
    }

    protected abstract void doPost(MiNiRequest request, MiNiResponse response);

    protected abstract void doGet(MiNiRequest request, MiNiResponse response);
}
