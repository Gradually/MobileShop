package cn.wycclub.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Dao层工具类
 *
 * @author WuYuchen
 * @date 2017-10-30 19:31
 */

public class DaoUtils {
    public static String getNowTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = simpleDateFormat.format(new Date());
        return date;
    }

    public static long getOid() {
        return System.nanoTime();
    }
}
