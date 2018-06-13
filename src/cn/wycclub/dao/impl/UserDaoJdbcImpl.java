package cn.wycclub.dao.impl;

import cn.wycclub.dao.UserDao;
import cn.wycclub.domain.User;
import cn.wycclub.exception.DaoException;
import cn.wycclub.utils.DaoUtils;
import cn.wycclub.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * UserDao接口的实现类,用于连接数据库
 *
 * @author WuYuchen
 * @date 2017-10-26 20:34
 */

public class UserDaoJdbcImpl implements UserDao {

    /**
     * 添加用户
     * */
    @Override
    public boolean add(User user) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "insert into user_info(username, password, email, gmt_create) values(?, ?, ?, ?)";
            st = conn.prepareStatement(sql);
            st.setString(1, user.getUsername());
            st.setString(2, user.getPassword());
            st.setString(3, user.getEmail());
            st.setString(4, DaoUtils.getNowTime());
            int num = st.executeUpdate();
            if (num > 0) {
                return true;
            }
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            JdbcUtils.closeResource(conn, st, rs);
        }
        return false;
    }

    /**
     * 查询用户名是否存在
     * */
    @Override
    public boolean find(String username) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select username from user_info where username=?";
            st = conn.prepareStatement(sql);
            st.setString(1,username);
            rs = st.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            JdbcUtils.closeResource(conn, st, rs);
        }
        return false;
    }

    /**
     * 登陆所用,检测用户名和密码是否匹配,以及是否被封禁
     * */
    @Override
    public User find(String username, String password) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            User user = new User();
            conn = JdbcUtils.getConnection();
            String sql = "select uid,username,password,email,tel,address,money,state from user_info where username=? and password=?";
            st = conn.prepareStatement(sql);
            st.setString(1,username);
            st.setString(2,password);
            rs = st.executeQuery();
            if (rs.next()) {
                user.setUid(rs.getInt("uid"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setTel(rs.getString("tel"));
                user.setAddress(rs.getString("address"));
                user.setMoney(rs.getBigDecimal("money"));
                user.setState(rs.getInt("state"));
                return user;
            }
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            JdbcUtils.closeResource(conn, st, rs);
        }
        return null;
    }

    /**
     * 修改用户信息
     * */
    @Override
    public void update(User user) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "update user_info set address=?,tel=?,money=?,password=? where uid=?";
            st = conn.prepareStatement(sql);
            st.setString(1,user.getAddress());
            st.setString(2,user.getTel());
            st.setBigDecimal(3,user.getMoney());
            st.setString(4,user.getPassword());
            st.setInt(5,user.getUid());
            st.executeUpdate();
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            JdbcUtils.closeResource(conn, st, rs);
        }
    }
}
