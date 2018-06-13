package juint.test;

import cn.wycclub.admin.dao.AdminDao;
import cn.wycclub.admin.dao.impl.AdminDaoImpl;
import cn.wycclub.dao.UserDao;
import cn.wycclub.domain.*;
import cn.wycclub.factory.DaoFactory;
import cn.wycclub.utils.JdbcUtils;
import javafx.scene.input.DataFormat;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 测试Dao层
 *
 * @author WuYuchen
 * @date 2017-10-27 16:31
 */

public class DaoTest {
    private static UserDao dao = DaoFactory.getDaoFactory().getDao(UserDao.class);

    public static void main(String[] args) throws SQLException {
        AdminDao dao = new AdminDaoImpl();
        System.out.println(dao.getQuantity("user_info"));
    }

    private static void test2() {
        Calendar calendar = Calendar.getInstance();
        /*** 定制每日00:00执行方法 ***/
        calendar.set(Calendar.HOUR_OF_DAY, 24);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        //第一次执行定时任务的时间
        Date date = calendar.getTime();
        System.out.println(date);
        System.out.println(DateFormat.getDateInstance().format(new Date()));
        System.out.println("before 方法比较："+date.before(new Date()));
    }

    private static void test1() {
        AdminDaoImpl dao = new AdminDaoImpl();
        ProductBean p = new ProductBean();
        p.setBrand("华为");
        p.setProductName("荣耀8");
        p.setStock(1000);
        p.setPrice(new BigDecimal(1499));
        int num = dao.addProductInfo(p);
        System.out.println(num);
    }

    public static void testAdd() {
        User user = new User();
        user.setUsername("123456");
        user.setPassword("123456");
        user.setEmail("425031186@qq.com");
        boolean b = dao.add(user);
        System.out.print(b);
    }

    public static void testFindOne() {
        String username = "111";
        boolean b = dao.find(username);
        System.out.println(b);
    }

    public static void testFindTwo() {
        String username = "123456";
        String password = "123456";
        User user = dao.find(username,password);
        if (user != null) {
            System.out.println(user.getUsername());
        } else {
            System.out.println("用户名或密码不存在!");
        }

    }

}
