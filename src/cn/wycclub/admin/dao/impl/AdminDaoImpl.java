package cn.wycclub.admin.dao.impl;

import cn.wycclub.admin.dao.AdminDao;
import cn.wycclub.domain.*;
import cn.wycclub.exception.DaoException;
import cn.wycclub.utils.DaoUtils;
import cn.wycclub.utils.JdbcUtils;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

/**
 * 管理员dao
 * @author WuYuchen
 * @date 2017-11-19 11:40
 */

public class AdminDaoImpl implements AdminDao {
    /**
     * 获取所有订单详情
     * */
    @Override
    public QueryResult getAllOrders(int startPage, int pageSize) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        QueryResult queryResult;
        try {
            queryResult = new QueryResult();
            conn = JdbcUtils.getConnection();
            String sql = "select count(*) from product_orders";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            if(rs.next()) {
                queryResult.setTotalRecord(rs.getInt(1));
            }
            sql = "select oid,payment,pid,uid,state,quantity,gmt_create from product_orders order by gmt_create desc limit ?,?";
            st = conn.prepareStatement(sql);
            st.setInt(1,startPage);
            st.setInt(2,pageSize);
            rs = st.executeQuery();
            List<OrdersBean> list = new LinkedList<>();
            while(rs.next()) {
                OrdersBean ordersBean = new OrdersBean();
                ordersBean.setOid(rs.getLong("oid"));
                ordersBean.setPayable(rs.getBigDecimal("payment"));
                ordersBean.setPid(rs.getInt("pid"));
                ordersBean.setUid(rs.getInt("uid"));
                ordersBean.setState(rs.getInt("state"));
                ordersBean.setQuantity(rs.getInt("quantity"));
                ordersBean.setCreateTime(rs.getString("gmt_create"));
                list.add(ordersBean);
            }
            queryResult.setList(list);
            return queryResult;
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            JdbcUtils.closeResource(conn, st, rs);
        }
    }

    /**
     * 获取所有客户详情
     * */
    @Override
    public QueryResult getAllUser(int startPage, int pageSize) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        QueryResult queryResult;
        User user;
        List<User> list;
        try {
            conn = JdbcUtils.getConnection();
            queryResult = new QueryResult();
            String sql = "select count(*) from user_info";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            if (rs.next()) {
                queryResult.setTotalRecord(rs.getInt(1));
            }
            sql = "select uid,username,password,email,tel,address,money,gmt_create,gmt_modified,state from user_info limit ?,?";
            st = conn.prepareStatement(sql);
            st.setInt(1,startPage);
            st.setInt(2,pageSize);
            rs = st.executeQuery();
            list = new LinkedList<>();
            while (rs.next()) {
                user = new User();
                user.setUid(rs.getInt("uid"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setTel(rs.getString("tel"));
                user.setAddress(rs.getString("address"));
                user.setMoney(rs.getBigDecimal("money"));
                String create = rs.getString("gmt_create");
                String modified = rs.getString("gmt_modified");
                user.setCreateTime(create.substring(0,create.length() - 2));
                user.setModifiedTime(modified.substring(0,modified.length() - 2));
                user.setState(rs.getInt("state"));
                list.add(user);
            }
            queryResult.setList(list);
            return queryResult;
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            JdbcUtils.closeResource(conn, st, rs);
        }
    }

    /**
     * 获取单个用户信息
     * */
    @Override
    public User getUser(int uid) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        User user = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select uid,username,email,tel,address,money,gmt_create,gmt_modified from user_info where uid=?";
            st = conn.prepareStatement(sql);
            st.setInt(1,uid);
            rs = st.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setUid(rs.getInt("uid"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setTel(rs.getString("tel"));
                user.setAddress(rs.getString("address"));
                user.setMoney(rs.getBigDecimal("money"));
                String create = rs.getString("gmt_create");
                String modified = rs.getString("gmt_modified");
                user.setCreateTime(create.substring(0,create.length() - 2));
                user.setModifiedTime(modified.substring(0,modified.length() - 2));
            }
            return user;
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            JdbcUtils.closeResource(conn, st, rs);
        }
    }

    /**
     * 获取所有商品详情
     * */
    @Override
    public QueryResult getAllProduct(int startPage, int pageSize) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        QueryResult queryResult;
        ProductBean productBean;
        try {
            queryResult = new QueryResult();
            conn = JdbcUtils.getConnection();
            String sql= "select count(*) from product_info";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            if(rs.next()) {
                queryResult.setTotalRecord(rs.getInt(1));
            }
            sql = "select pid,title,price,stock,brand,gmt_create,gmt_modified from product_info order by pid desc limit ?,?";
            st = conn.prepareStatement(sql);
            st.setInt(1,startPage);
            st.setInt(2,pageSize);
            rs = st.executeQuery();
            List<ProductBean> list = new ArrayList();
            while(rs.next()) {
                ProductImageBean imageBean = new ProductImageBean();
                productBean = new ProductBean();
                productBean.setPid(rs.getInt("pid"));
                imageBean.setImageID(productBean.getPid());
                productBean.setImageBean(imageBean);
                productBean.setPrice(rs.getBigDecimal("price"));
                productBean.setProductName(rs.getString("title"));
                productBean.setStock(rs.getInt("stock"));
                productBean.setBrand(rs.getString("brand"));
                String gmt_create = rs.getString("gmt_create");
                productBean.setCreateTime(gmt_create.substring(0,gmt_create.length() - 2));
                String gmt_modified = rs.getString("gmt_modified");
                productBean.setModifiedTime(gmt_modified.substring(0,gmt_modified.length() - 2));
                list.add(productBean);
            }
            queryResult.setList(list);
            return queryResult;
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            JdbcUtils.closeResource(conn, st, rs);
        }
    }

    /**
     * 添加商品信息
     * */
    @Override
    public int addProductInfo(ProductBean p) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            conn = JdbcUtils.getConnection();
            String sql = "insert into product_info(title,price,stock,brand,gmt_create) values(?,?,?,?,?)";
            st = conn.prepareStatement(sql,1);
            st.setString(1,p.getProductName());
            st.setBigDecimal(2,p.getPrice());
            st.setInt(3,p.getStock());
            st.setString(4,p.getBrand());
            st.setString(5, DaoUtils.getNowTime());
            st.executeUpdate();
            rs = st.getGeneratedKeys();
            if(rs.next()) {
                return rs.getInt(1);
            }
            return 0;
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            JdbcUtils.closeResource(conn, st, rs);
        }
    }


    /**
     * 删除商品
     * */
    @Override
    public void deleteProduct(int pid) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "delete from product_info where pid=?";
            st = conn.prepareStatement(sql);
            st.setInt(1,pid);
            st.executeUpdate();
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            JdbcUtils.closeResource(conn, st, rs);
        }
    }

    /**
     * 更新商品信息
     * */
    @Override
    public void updateProduct(ProductBean productBean) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "update product_info set title=?,price=?,stock=?,brand=? where pid=?";
            st = conn.prepareStatement(sql);
            st.setString(1,productBean.getProductName());
            st.setBigDecimal(2,productBean.getPrice());
            st.setInt(3,productBean.getStock());
            st.setString(4,productBean.getBrand());
            st.setInt(5,productBean.getPid());
            st.executeUpdate();
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            JdbcUtils.closeResource(conn, st, rs);
        }
    }

    /**
     * 获取订单中成交总金额
     * */
    @Override
    public BigDecimal getOrdersMoneyBySum() {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "SELECT sum(payment) FROM product_orders where state=1";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                return rs.getBigDecimal(1);
            }
            return new BigDecimal(0);
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            JdbcUtils.closeResource(conn, st, rs);
        }
    }

    /**
     * 获取tableName表中的数据总量
     * product_info
     * user_info
     * product_orders
     * */
    @Override
    public int getQuantity(String tableName) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "SELECT count(*) FROM " + tableName;
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
            return 0;
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            JdbcUtils.closeResource(conn, st, rs);
        }
    }

    /**
     * 封禁和解封用户
     * */
    @Override
    public void updateUserInfo(int uid, int state) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "update user_info set state=? where uid=?";
            st = conn.prepareStatement(sql);
            st.setInt(1,state);
            st.setInt(2,uid);
            st.executeUpdate();
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            JdbcUtils.closeResource(conn, st, rs);
        }
    }

}
