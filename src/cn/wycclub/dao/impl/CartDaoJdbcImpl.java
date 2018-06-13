package cn.wycclub.dao.impl;

import cn.wycclub.dao.CartDao;
import cn.wycclub.dao.ProductDao;
import cn.wycclub.domain.CartBean;
import cn.wycclub.domain.ProductBean;
import cn.wycclub.exception.DaoException;
import cn.wycclub.factory.DaoFactory;
import cn.wycclub.utils.DaoUtils;
import cn.wycclub.utils.JdbcUtils;
import cn.wycclub.utils.WebUtils;

import java.rmi.MarshalledObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

/**
 * 操作购物车
 *
 * @author WuYuchen
 * @date 2017-11-05 17:24
 */

public class CartDaoJdbcImpl implements CartDao {

    /**
     * 添加商品到购物车
     * */
    @Override
    public void addCart(CartBean cartBean) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "insert into product_cart(uid, pid, quantity, payable,gmt_create) values(?, ?, ?, ?, ?)";
            st = conn.prepareStatement(sql);
            st.setInt(1,cartBean.getUid());
            st.setInt(2,cartBean.getProductBean().getPid());
            st.setInt(3,cartBean.getQuantity());
            st.setBigDecimal(4,cartBean.getPayable());
            st.setString(5, DaoUtils.getNowTime());
            st.executeUpdate();
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            JdbcUtils.closeResource(conn, st, rs);
        }
    }

    /**
     * 从购物车中删除商品
     * */
    @Override
    public void deleteCart(int cid) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "delete from product_cart where cid=?";
            st = conn.prepareStatement(sql);
            st.setInt(1,cid);
            st.executeUpdate();
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            JdbcUtils.closeResource(conn, st, rs);
        }
    }

    /**
     * 更新购物车中的商品
     * */
    @Override
    public void updateCart(CartBean cartBean) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "update product_cart set quantity=?,payable=? where cid=?";
            st = conn.prepareStatement(sql);
            st.setInt(1,cartBean.getQuantity());
            st.setBigDecimal(2,cartBean.getPayable());
            st.setInt(3,cartBean.getCid());
            st.executeUpdate();
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            JdbcUtils.closeResource(conn, st, rs);
        }
    }

    /**
     * 获取购物车中的商品列表
     * */
    @Override
    public List<CartBean> getCart(int uid) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        List<CartBean> list;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select cid,uid,pid,quantity,payable from product_cart where uid=? order by gmt_create desc";
            st = conn.prepareStatement(sql);
            st.setInt(1,uid);
            rs = st.executeQuery();
            list = new LinkedList<>();
            while (rs.next()) {
                CartBean cartBean = new CartBean();
                cartBean.setCid(rs.getInt("cid"));
                cartBean.setUid(rs.getInt("uid"));
                cartBean.setPid(rs.getInt("pid"));
                cartBean.setQuantity(rs.getInt("quantity"));
                cartBean.setPayable(rs.getBigDecimal("payable"));
                list.add(cartBean);
            }
            return list;
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            JdbcUtils.closeResource(conn, st, rs);
        }
    }

    /**
     * 检查购物车中用户是否已经存在一个同样商品的购物车
     * */
    @Override
    public Map<String,Integer> checkCart(int uid, int pid) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        Map<String,Integer> map = null;
        int cid = 0;
        int quantity = 0;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select cid,quantity from product_cart where uid=? and pid=?";
            st = conn.prepareStatement(sql);
            st.setInt(1,uid);
            st.setInt(2,pid);
            rs = st.executeQuery();
            if (rs.next()) {
                map = new HashMap<>();
                cid = rs.getInt("cid");
                quantity = rs.getInt("quantity");
                map.put("cid",cid);
                map.put("quantity",quantity);
            }
            return map;
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            JdbcUtils.closeResource(conn, st, rs);
        }
    }

    /**
     * 用户结算后删除购物车中的商品
     * */
    @Override
    public void deleteCartByOrders(int uid) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "delete from product_cart where uid=?";
            st = conn.prepareStatement(sql);
            st.setInt(1,uid);
            st.executeUpdate();
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            JdbcUtils.closeResource(conn, st, rs);
        }
    }
}
