package cn.wycclub.dao.impl;

import cn.wycclub.domain.CollectionBean;
import cn.wycclub.domain.ProductBean;
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
 * 收藏
 *
 * @author WuYuchen
 * @date 2017-11-14 23:10
 */

public class CollectionDaoJdbcImpl implements cn.wycclub.dao.CollectionDao {

    /**
     * 为用户添加收藏
     * */
    @Override
    public void addCollection(CollectionBean collectionBean) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "insert into user_collection(uid,pid,gmt_create) values(?, ?, ?)";
            st = conn.prepareStatement(sql);
            st.setInt(1,collectionBean.getUid());
            st.setInt(2,collectionBean.getPid());
            st.setString(3, DaoUtils.getNowTime());
            st.executeUpdate();
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            JdbcUtils.closeResource(conn, st, rs);
        }
    }

    /**
     * 取消收藏
     * */
    @Override
    public void removeCollection(int cid) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "delete from user_collection where cid=?";
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
     * 查询用户收藏的列表
     * */
    @Override
    public List<CollectionBean> getCollection(int uid) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        List<CollectionBean> list;
        QueryResult queryResult;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select cid,uid,pid from user_collection where uid=?";
            st = conn.prepareStatement(sql);
            st.setInt(1, uid);
            rs = st.executeQuery();
            list = new LinkedList<>();
            while (rs.next()) {
                CollectionBean collectionBean = new CollectionBean();
                collectionBean.setCid(rs.getInt("cid"));
                collectionBean.setPid(rs.getInt("pid"));
                collectionBean.setUid(rs.getInt("uid"));
                list.add(collectionBean);
            }
            return list;
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            JdbcUtils.closeResource(conn, st, rs);
        }
    }

    /**
     * 获取收藏分页列表
     * */
    @Override
    public QueryResult pageQuery(int startPage, int pageSize, int uid) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        QueryResult queryResult;
        CollectionBean collectionBean;
        try {
            queryResult = new QueryResult();
            conn = JdbcUtils.getConnection();
            String sql = "select count(*) from user_collection where uid=?";
            st = conn.prepareStatement(sql);
            st.setInt(1,uid);
            rs = st.executeQuery();
            if(rs.next()) {
                queryResult.setTotalRecord(rs.getInt(1));
            }
            sql = "select cid,pid,uid from user_collection where uid=? order by gmt_create desc limit ?,?";
            st = conn.prepareStatement(sql);
            st.setInt(1,uid);
            st.setInt(2,startPage);
            st.setInt(3,pageSize);
            rs = st.executeQuery();
            List<CollectionBean> list = new ArrayList();
            while(rs.next()) {
                collectionBean = new CollectionBean();
                collectionBean.setCid(rs.getInt("cid"));
                collectionBean.setUid(rs.getInt("uid"));
                collectionBean.setPid(rs.getInt("pid"));
                list.add(collectionBean);
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
