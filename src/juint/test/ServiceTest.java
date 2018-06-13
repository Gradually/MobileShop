package juint.test;

import cn.wycclub.domain.User;
import cn.wycclub.exception.UserExistException;
import cn.wycclub.service.impl.BusinessProductServiceImpl;
import cn.wycclub.service.impl.BusinessUserServiceImpl;

import java.util.List;

/**
 * 测试service层中的方法
 *
 * @author WuYuchen
 * @date 2017-10-28 22:47
 */

public class ServiceTest {
    public static void main(String[] args) {
        testGetBrand();
    }

    public static void testRegister() {
        BusinessUserServiceImpl service = new BusinessUserServiceImpl();
        User user = new User();
        user.setPassword("123456");
        user.setEmail("123@qq.com");
        user.setUsername("111123456");
        try {
            service.register(user);
        } catch (UserExistException e) {
            e.printStackTrace();
        }
    }

    public static void testGetBrand() {
        BusinessProductServiceImpl service = new BusinessProductServiceImpl();
        List<String> list = service.getBrand();
        for (String brand : list) {
            System.out.println(brand);
        }
    }
}
