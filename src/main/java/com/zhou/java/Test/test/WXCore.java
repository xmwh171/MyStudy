package com.zhou.java.Test.test;

import net.sf.json.JSONObject;
import org.apache.commons.codec.binary.Base64;

import java.security.NoSuchAlgorithmException;

/**
 * @Description
 * @Author xiaohu
 * @Date 2020/7/10 9:39
 */
public class WXCore {

    private static final String WATERMARK = "watermark";
    private static final String APPID = "appid";
    /**
     * 解密数据
     * @return
     * @throws Exception
     */
    public static String decrypt(String appId, String encryptedData, String sessionKey, String iv){
        String result = "";
        try {
            AES aes = new AES();
            byte[] resultByte = aes.decrypt(Base64.decodeBase64(encryptedData), Base64.decodeBase64(sessionKey), Base64.decodeBase64(iv));
            if(null != resultByte && resultByte.length > 0){
                result = new String(WxPKCS7Encoder.decode(resultByte));
                JSONObject jsonObject = JSONObject.fromObject(result);
                String decryptAppid = jsonObject.getJSONObject(WATERMARK).getString(APPID);
                if(!appId.equals(decryptAppid)){
                    result = "";
                }
            }
        } catch (Exception e) {
            result = "";
            e.printStackTrace();
        }
        return result;
    }


    public static void main(String[] args) throws Exception{
        String otherAppId = "wx4f4bc4dec97d474b";
        String otherEncrytedData = "CiyLU1Aw2KjvrjMdj8YKliAjtP4gsMZMQmRzooG2xrDcvSnxIMXFufNstNGTyaGS9uT5geRa0W4oTOb1WT7fJlAC+oNPdbB+3hVbJSRgv+4lGOETKUQz6OYStslQ142dNCuabNPGBzlooOmB231qMM85d2/fV6ChevvXvQP8Hkue1poOFtnEtpyxVLW1zAo6/1Xx1COxFvrc2d7UL/lmHInNlxuacJXwu0fjpXfz/YqYzBIBzD6WUfTIF9GRHpOn/Hz7saL8xz+W//FRAUid1OksQaQx4CMs8LOddcQhULW4ucetDf96JcR3g0gfRK4PC7E/r7Z6xNrXd2UIeorGj5Ef7b1pJAYB6Y5anaHqZ9J6nKEBvB4DnNLIVWSgARns/8wR2SiRS7MNACwTyrGvt9ts8p12PKFdlqYTopNHR1Vf7XjfhQlVsAJdNiKdYmYVoKlaRv85IfVunYzO0IKXsyl7JCUjCpoG20f0a04COwfneQAGGwd5oa+T8yO5hzuyDb/XcxxmK01EpqOyuxINew==";
        String otherSessionKey = "tiihtNczf5v6AKRyjwEUhQ==";
        String otherIv = "r7BXXKkLb8qrSNn05n0qiA==";

        testOther(otherAppId,otherEncrytedData,otherSessionKey,otherIv);

        String myAppId = "wx5c2a1d489a3b5bac";
        String myEncrytedData = "JcFa3W2hrjbl+ogJnvKV4Y+23mS69mWQbeYJ9jT+qeQcMdkeiuj0ByAPW8FnitOnTrYmJ/u0Inficv0RBci9aczkncj1AWgJ1FP/bjd7faWlf2gt098+TeGe4dQukJ0KlXf8+6Dr87/fnt1tzwt30E6swLcSVKmLKqyRF5gamLAPtdyxbTh6wTgfLztIznTvq8FrOu389g70TvWRVerZW7iX0I/PRu9kJI6JTvTJCvFoEofAuEVSG8jUv46NXzWSaF2mn6DDdVgl55iYUtTs5qxHtQQZKYQndl4FyrGgUym2ODB6wiP0j/xB8cEbWl+VCMqyxtmrdC+RFEDxjpRRB1KlSGCitrOiH8d1m5qseKFmlgrf0wffyc2TmKiBzCqYmDTgC5VSYqjFC0CJQW2RnT7E5+QCiVCOyUjyfiC+5LJHOvs+2QJkoib4vv2hr5RZrI7H6jhEP2ODpc6OC2750gA0GVRWcCaXJ/YeMh+gIyU=";
        String mySessionKey = "VMMh8Qk8vp0ZSTB/qnW4Gg==";
        String myIv = "FQNtW6/jPg2mWoPeIzFNHw==";

        testMy(myAppId,myEncrytedData,mySessionKey,myIv);

        String myRawData = "{\"nickName\":\"德福\",\"gender\":1,\"language\":\"zh_CN\",\"city\":\"Xingtai\",\"province\":\"Hebei\",\"country\":\"China\",\"avatarUrl\":\"https://wx.qlogo.cn/mmopen/vi_32/ZdHZ8vlDjCoqujBqdVbbqFib96icXlAFB8T1sjh1S9JzPx0z9HVbEeCvwKTHISAkWibO1tjuS3LGp0ta6x4dhedzA/132\"}";
        String mySignature = "8431df76b6d2826c96b375df96ba6406200c13bf";

        WxMiniUserParam userParam = new WxMiniUserParam();
        userParam.setEncryptedData(myEncrytedData);
        userParam.setIv(myIv);
        userParam.setRawData(myRawData);
        userParam.setSignature(mySignature);
        test(userParam,mySessionKey);

        WxMiniUserParam userParam2 = new WxMiniUserParam();
        userParam2.setEncryptedData(otherEncrytedData);
        userParam2.setIv(otherIv);
//        userParam.setRawData("{\"nickName\":\"德福\",\"gender\":1,\"language\":\"zh_CN\",\"city\":\"Xingtai\",\"province\":\"Hebei\",\"country\":\"China\",\"avatarUrl\":\"https://wx.qlogo.cn/mmopen/vi_32/ZdHZ8vlDjCoqujBqdVbbqFib96icXlAFB8T1sjh1S9JzPx0z9HVbEeCvwKTHISAkWibO1tjuS3LGp0ta6x4dhedzA/132\"}");
//        userParam.setSignature("8431df76b6d2826c96b375df96ba6406200c13bf");
        test(userParam,otherSessionKey);

    }

    public static void testOther(String appId, String encryptedData, String sessionKey, String iv){
        System.out.println(decrypt(appId, encryptedData, sessionKey, iv));
    }


    public static void testMy(String appId, String encryptedData, String sessionKey, String iv){
        System.out.println(decrypt(appId, encryptedData, sessionKey, iv));
    }

    public static void test(WxMiniUserParam userParam,String sessionKey){
        try {
            System.out.println(AesUtil.decodeWxMiniUnionId(userParam,sessionKey));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
