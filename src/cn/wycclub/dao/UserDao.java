package cn.wycclub.dao;

import cn.wycclub.domain.User;

/**
 * 用户的登陆注册功能对于Dao层调用的接口类
 *
 * @author WuYuchen
 * @date 2017-10-26 20:37
 */

public interface UserDao {
    /**
     * 在注册验证完成后将用户注册数据储存到数据库中
     * */
    boolean add(User user);

    /**
     * 在注册验证时,查询数据库中是否存在相同的用户名
     * */
    boolean find(String username);

    /**
     * 用户登陆时,用于验证数据库中是否存在次用户,存在则返回一个用户,不存在则返回空.
     * */
    User find(String username, String password);

    /**
     * 修改用户信息
     */
    void update(User user);
}
