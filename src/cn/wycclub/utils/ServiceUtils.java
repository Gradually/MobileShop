package cn.wycclub.utils;

import java.security.MessageDigest;
import java.util.Base64;

/**
 * Service层所需要用到的工具栏
 *
 * @author WuYuchen
 * @date 2017-10-27 17:55
 */

public class ServiceUtils {

    /**
     * 将传进来的值转换成一个md5值返回
     * */
    public static String md5(String message) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
            byte[] md5 = md.digest(message.getBytes());
            Base64.Encoder encoder = Base64.getEncoder();
            return encoder.encodeToString(md5);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
