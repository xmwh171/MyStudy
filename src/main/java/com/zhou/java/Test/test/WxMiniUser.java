package com.zhou.java.Test.test;

/**
 * @Description
 * @Author xiaohu
 * @Date 2020/7/10 11:25
 */
public class WxMiniUser {

    private String unionId;

    private String nickName;

    private Integer gender;

    private String language;

    private String province;

    private String city;

    private String country;

    private String avatarUrl;

    private WxMiniWatermark watermark;

    @Override
    public String toString() {
        return "WxMiniUser{" +
                "unionId='" + unionId + '\'' +
                ", nickName='" + nickName + '\'' +
                ", gender=" + gender +
                ", language='" + language + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", watermark=" + watermark +
                '}';
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public WxMiniWatermark getWatermark() {
        return watermark;
    }

    public void setWatermark(WxMiniWatermark watermark) {
        this.watermark = watermark;
    }
}
