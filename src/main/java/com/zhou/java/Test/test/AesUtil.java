package com.zhou.java.Test.test;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang.StringUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.*;

/**
 * @Description
 * @Author xiaohu
 * @Date 2020/7/10 11:24
 */
public class AesUtil {

    private static final String KEY_ALGORITHM = "AES";
    private static final String CBC_CIPHER_PKCS_ALGORITHM = "AES/CBC/PKCS7Padding";

    /**
     * 微信小程序解密
     *
     * @param sessionKey    密文
     * @param encryptedData 加密数据
     * @param iv            初始向量
     * @return 返回解密后的数据
     */
    public static String wxDecrypt(String sessionKey, String encryptedData, String iv) {
        try {
            byte[] sessionKeyBytes = Base64.decodeBase64(sessionKey.getBytes(StandardCharsets.UTF_8));
            byte[] encryptedDataBytes = Base64.decodeBase64(encryptedData.getBytes(StandardCharsets.UTF_8));
            byte[] ivBytes = Base64.decodeBase64(iv.getBytes(StandardCharsets.UTF_8));

            // 如果密钥不足16位，那么就补足.  这个if 中的内容很重要
            int base = 16;
            if (sessionKeyBytes.length % base != 0) {
                int groups = sessionKeyBytes.length / base + 1;
                byte[] temp = new byte[groups * base];
                Arrays.fill(temp, (byte) 0);
                System.arraycopy(sessionKeyBytes, 0, temp, 0, sessionKeyBytes.length);
                sessionKeyBytes = temp;
            }

            // 初始化
            Security.addProvider(new BouncyCastleProvider());

            // 生成aes key
            Key sKeySpec = new SecretKeySpec(sessionKeyBytes, KEY_ALGORITHM);

            // 设置偏移量参数
            AlgorithmParameters params = AlgorithmParameters.getInstance(KEY_ALGORITHM);
            params.init(new IvParameterSpec(ivBytes));

            // 初始化
            Cipher cipher = Cipher.getInstance(CBC_CIPHER_PKCS_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, sKeySpec, new IvParameterSpec(ivBytes));

            // 返回结果
            return new String(cipher.doFinal(encryptedDataBytes), StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new RuntimeException("aes解密失败", e);
        }
    }


    public static WxMiniUser decodeWxMiniUnionId(WxMiniUserParam userParam,String sessionKey) throws NoSuchAlgorithmException {
        System.out.println("sessionKey为："+sessionKey);
        // 获取指定摘要算法的messageDigest对象
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
        // 调用digest方法，进行加密操作
//        byte[] bytes = (userParam.getRawData() + sessionKey).getBytes(StandardCharsets.UTF_8);
//        byte[] digestBytes = messageDigest.digest(bytes);
//        String digestStr = Hex.encodeHexString(digestBytes);
//        if(!userParam.getSignature().equals(digestStr)){
//            return null;
//        }
        // 获取解密数据
        String decryptStr = AesUtil.wxDecrypt(sessionKey, userParam.getEncryptedData(), userParam.getIv());
        // 获取数据对象
        WxMiniUser wxMiniUser = JSONObject.parseObject(decryptStr, WxMiniUser.class);
        String unionId = wxMiniUser.getUnionId();
        System.out.println("解析出的unionId为:"+unionId);
        return wxMiniUser;
    }

}
