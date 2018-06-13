package cn.wycclub.service.impl;

import cn.wycclub.dao.UserDao;
import cn.wycclub.domain.User;
import cn.wycclub.exception.UserExistException;
import cn.wycclub.exception.UsernameOrPasswordErrorException;
import cn.wycclub.factory.DaoFactory;
import cn.wycclub.service.UserService;
import cn.wycclub.utils.ServiceUtils;

import javax.xml.ws.Service;

/**
 * 给Web层提供关于用户的业务服务
 *
 * @author WuYuchen
 * @date 2017-10-27 16:51
 */

public class BusinessUserServiceImpl implements UserService {

    private UserDao dao = DaoFactory.getDaoFactory().getDao(UserDao.class);

    /**
     * 为web层提供注册服务
     * */
    @Override
    public void register(User user) throws UserExistException {
        //检测用户名是否存在
        String username = user.getUsername();
        boolean flag = dao.find(username);
        if (flag) {
            throw new UserExistException("用户已存在");
        } else {
            user.setPassword(ServiceUtils.md5(user.getPassword()));
            dao.add(user);
        }
    }

    /**
     * 为web层提供登陆服务
     * */
    @Override
    public User login(String username, String password) throws UsernameOrPasswordErrorException {
        password = ServiceUtils.md5(password);
        User user = dao.find(username,password);
        if (user == null) {
            throw new UsernameOrPasswordErrorException("用户名或密码不存在!");
        }
        return user;
    }

    /**
     * 修改用户信息
     * */
    @Override
    public void update(User user) {
        dao.update(user);
    }
}
