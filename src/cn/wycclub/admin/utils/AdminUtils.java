package cn.wycclub.admin.utils;

import java.io.IOException;
import java.util.Properties;

/**
 * @author WuYuchen
 * @date 2017-11-19 16:13
 */

public class AdminUtils {
    private static Properties config = new Properties();
    static {
        try {
            config.load(AdminUtils.class.getClassLoader().getResourceAsStream("admin.properties"));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 从配置文件中读取后台管理员账号和密码,并对用户输入的用户名密码进行校验
     * */
    public static boolean intoAdmin(String username, String password) throws IOException {
        if (config.getProperty("username").equals(username) && config.getProperty("password").equals(password)) {
            return true;
        }
        return false;
    }

    /**
     * 获取管理员用户名
     * */
    public static String getAdminUsername() throws IOException {
        return config.getProperty("username");
    }
}
