package com.zhou.java.Test;

/**
 * @Description 代理主题角色：内部包含对真实主题的引用，并且提供和真实主题角色相同的接口
 * @Author xiaohu
 * @Date 2019/7/24 17:48
 */
public class TalkProxy implements ITalk {

    private ITalk talker;

    public TalkProxy(ITalk talker) {
        // super();
        this.talker = talker;
    }

    @Override
    public void talk(String msg) {
        talker.talk(msg);
    }

    public void talk(String msg, String singname) {
        talker.talk(msg);
        sing(singname);
    }

    private void sing(String singname) {
        System.out.println("唱歌：" + singname);
    }


}
