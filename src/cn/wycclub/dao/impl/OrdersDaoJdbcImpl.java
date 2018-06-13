package cn.wycclub.dao.impl;

import cn.wycclub.domain.OrdersBean;
import cn.wycclub.domain.QueryResult;
import cn.wycclub.exception.DaoException;
import cn.wycclub.utils.DaoUtils;
import cn.wycclub.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 操作数据库中订单表
 *
 * @author WuYuchen
 * @date 2017-11-12 18:33
 */

public class OrdersDaoJdbcImpl implements cn.wycclub.dao.OrdersDao {
    @Override
    public void addOrders(OrdersBean ordersBean) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "insert into product_orders(oid,payment,quantity,pid,uid,gmt_create) values(?, ?, ?, ?, ?, ?)";
            st = conn.prepareStatement(sql);
            st.setLong(1,DaoUtils.getOid());
            st.setBigDecimal(2,ordersBean.getPayable());
            st.setInt(3,ordersBean.getQuantity());
            st.setInt(4,ordersBean.getPid());
            st.setInt(5,ordersBean.getUid());
            st.setString(6, DaoUtils.getNowTime());
            st.executeUpdate();
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            JdbcUtils.closeResource(conn, st, rs);
        }
    }

    @Override
    public void updateOrders(long oid, int state) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "update product_orders set state=? where oid=?";
            st = conn.prepareStatement(sql);
            st.setInt(1,state);
            st.setLong(2,oid);
            st.executeUpdate();
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            JdbcUtils.closeResource(conn, st, rs);
        }
    }

    @Override
    public void deleteOrders(long oid) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "delete from product_orders where oid=?";
            st = conn.prepareStatement(sql);
            st.setLong(1,oid);
            st.executeUpdate();
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            JdbcUtils.closeResource(conn, st, rs);
        }
    }

    /**
     * 获取订单分页列表
     * */
    @Override
    public QueryResult pageQuery(int startPage, int pageSize, int uid) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        QueryResult queryResult;
        OrdersBean ordersBean;
        try {
            queryResult = new QueryResult();
            conn = JdbcUtils.getConnection();
            String sql = "select count(*) from product_orders where uid=?";
            st = conn.prepareStatement(sql);
            st.setInt(1,uid);
            rs = st.executeQuery();
            if(rs.next()) {
                queryResult.setTotalRecord(rs.getInt(1));
            }
            sql = "select oid,payment,pid,uid,state,quantity from product_orders where uid=? order by gmt_create desc limit ?,?";
            st = conn.prepareStatement(sql);
            st.setInt(1,uid);
            st.setInt(2,startPage);
            st.setInt(3,pageSize);
            rs = st.executeQuery();
            List<OrdersBean> list = new ArrayList();
            while(rs.next()) {
                ordersBean = new OrdersBean();
                ordersBean.setOid(rs.getLong("oid"));
                ordersBean.setPayable(rs.getBigDecimal("payment"));
                ordersBean.setPid(rs.getInt("pid"));
                ordersBean.setUid(rs.getInt("uid"));
                ordersBean.setState(rs.getInt("state"));
                ordersBean.setQuantity(rs.getInt("quantity"));
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

}
