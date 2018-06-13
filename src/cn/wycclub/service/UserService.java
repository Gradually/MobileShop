package cn.wycclub.service;

import cn.wycclub.domain.User;
import cn.wycclub.exception.UserExistException;
import cn.wycclub.exception.UsernameOrPasswordErrorException;

/**
 * 用户的登陆注册所需要的服务层接口
 *
 * @author WuYuchen
 * @date 2017-10-26 20:36
 */

public interface UserService {
    void register(User user) throws UserExistException;

    User login(String username, String password) throws UsernameOrPasswordErrorException;

    void update(User user);
}
