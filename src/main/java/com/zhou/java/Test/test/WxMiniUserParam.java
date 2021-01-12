package com.zhou.java.Test.test;

/**
 * @Description
 * @Author xiaohu
 * @Date 2020/7/10 11:27
 */
public class WxMiniUserParam {

    /**
     * 微信小程序opendid
     */
    private String openid;

    /**
     * 微信小程序包括敏感数据在内的完整用户信息的加密数据
     */
    private String encryptedData;

    /**
     * 微信小程序加密算法的初始向量
     */
    private String iv;

    /**
     * 微信小程序不包括敏感信息的原始数据字符串，用于计算签名
     */
    private String rawData;

    /**
     * 微信小程序使用 sha1( rawData + sessionkey ) 得到字符串，用于校验用户信息
     */
    private String signature;

    /**
     * 用户手机号
     */
    private String mobile;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getEncryptedData() {
        return encryptedData;
    }

    public void setEncryptedData(String encryptedData) {
        this.encryptedData = encryptedData;
    }

    public String getIv() {
        return iv;
    }

    public void setIv(String iv) {
        this.iv = iv;
    }

    public String getRawData() {
        return rawData;
    }

    public void setRawData(String rawData) {
        this.rawData = rawData;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
