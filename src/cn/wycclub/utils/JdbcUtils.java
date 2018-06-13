package cn.wycclub.utils;


import java.sql.*;
import java.util.Properties;


/**
 * 使用Jdbc连接数据库所用到的工具方法,含有获取连接器,关闭资源的方法
 *
 * @author WuYuchen
 * @date 2017-10-26 20:59
 */

public class JdbcUtils {
    private static String mysqlAccount;
    private static String mysqlPassword;
    private static String url;
    private static Properties config = new Properties();

    static {
        try {
            config.load(JdbcUtils.class.getClassLoader().getResourceAsStream("db.properties"));
            mysqlAccount = config.getProperty("mysqlAccount");
            mysqlPassword = config.getProperty("mysqlPassword");
            url = config.getProperty("url");
            Class.forName(config.getProperty("driver"));
        } catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    /**
     * 获取数据库连接器
     * @throws SQLException
     * */
    public static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(url,mysqlAccount,mysqlPassword);
        return conn;
    }

    /**
     * 关闭资源
     * */
    public static void closeResource(Connection conn, PreparedStatement st, ResultSet rs) {
        if(rs != null) {
            try {
                rs.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
            rs = null;
        }

        if(st != null) {
            try {
                st.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
            st = null;
        }

        if(conn != null) {
            try {
                conn.close();
            } catch(Exception e) {
                e.printStackTrace();
            }
            conn = null;
        }
    }

    public static int getID() {
        int id = new Long(System.currentTimeMillis()).intValue();
        return id;
    }
}
