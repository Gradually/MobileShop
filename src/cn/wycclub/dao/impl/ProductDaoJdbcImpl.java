package cn.wycclub.dao.impl;

import cn.wycclub.dao.ProductDao;
import cn.wycclub.domain.ProductBean;
import cn.wycclub.domain.ProductImageBean;
import cn.wycclub.domain.QueryInfo;
import cn.wycclub.domain.QueryResult;
import cn.wycclub.exception.DaoException;
import cn.wycclub.utils.DaoUtils;
import cn.wycclub.utils.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 获取商品的dao层实现类
 *
 * @author WuYuchen
 * @date 2017-10-30 22:12
 */

public class ProductDaoJdbcImpl implements ProductDao {

    /**
     * 获取商品信息(通过商品ID)
     * */
    @Override
    public ProductBean getProductInfo(int pid) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        ProductBean productBean = null;
        ProductImageBean imageBean = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select title,price,stock,brand from product_info where pid=?";
            st = conn.prepareStatement(sql);
            st.setInt(1,pid);
            rs = st.executeQuery();
            if(rs.next()) {
                imageBean = new ProductImageBean();
                imageBean.setImageID(pid);
                productBean = new ProductBean();
                productBean.setImageBean(imageBean);
                productBean.setPid(pid);
                productBean.setProductName(rs.getString("title"));
                productBean.setPrice(rs.getBigDecimal("price"));
                productBean.setStock(rs.getInt("stock"));
                productBean.setBrand(rs.getString("brand"));
            }
            return productBean;
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            JdbcUtils.closeResource(conn, st, rs);
        }
    }

    /**
     * 随机获取n个商品
     * */
    @Override
    public List<ProductBean> getProductByRadom(int num) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        ProductBean productBean;
        List<ProductBean> list;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select pid,title,price,stock,brand from product_info order by rand() limit ?";
            st = conn.prepareStatement(sql);
            st.setInt(1,num);
            rs = st.executeQuery();
            list = new ArrayList();
            while (rs.next()) {
                productBean = new ProductBean();
                productBean.setPid(rs.getInt("pid"));
                productBean.setBrand(rs.getString("brand"));
                productBean.setStock(rs.getInt("stock"));
                productBean.setProductName(rs.getString("title"));
                productBean.setPrice(rs.getBigDecimal("price"));
                list.add(productBean);
            }
            return list;
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            JdbcUtils.closeResource(conn, st, rs);
        }
    }

    /**
     * 获取商品品牌
     * */
    @Override
    public List<String> getProductBrand() {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        List<String> list;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select brand from product_info group by brand";
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            list = new ArrayList();
            while (rs.next()) {
                list.add(rs.getString("brand"));
            }
            return list;
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            JdbcUtils.closeResource(conn, st, rs);
        }
    }

    /**
     * 智能手机分页的获取页面数据和页面大小
     * */
    @Override
    public QueryResult pageQuery(int startPage, int pageSize, String brand) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        QueryResult queryResult;
        ProductBean productBean;
        try {
            queryResult = new QueryResult();
            conn = JdbcUtils.getConnection();
            String sql;
            if ("".equals(brand) || brand == null) {
                sql= "select count(*) from product_info";
                st = conn.prepareStatement(sql);
            } else {
                sql = "select count(*) from product_info where brand=?";
                st = conn.prepareStatement(sql);
                st.setString(1,brand);
            }
            rs = st.executeQuery();
            if(rs.next()) {
                queryResult.setTotalRecord(rs.getInt(1));
            }

            if ("".equals(brand) || brand == null) {
                sql = "select pid,title,price,stock,brand from product_info limit ?,?";
                st = conn.prepareStatement(sql);
                st.setInt(1,startPage);
                st.setInt(2,pageSize);
            } else {
                sql = "select pid,title,price,stock,brand from product_info where brand=? limit ?,?";
                st = conn.prepareStatement(sql);
                st.setString(1,brand);
                st.setInt(2,startPage);
                st.setInt(3,pageSize);
            }
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
     * 搜索商品
     * */
    @Override
    public List<ProductBean> searchByProduct(String searchInfo) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        ProductBean productBean;
        List<ProductBean> list;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select pid,title,price,stock,brand from product_info where title like ? or title like ? or title like ?";
            st = conn.prepareStatement(sql);
            st.setString(1,searchInfo + "%");
            st.setString(2,"%" + searchInfo);
            st.setString(3,"%" + searchInfo + "%");
            rs = st.executeQuery();
            list = new LinkedList<>();
            while (rs.next()) {
                productBean = new ProductBean();
                productBean.setPid(rs.getInt("pid"));
                productBean.setProductName(rs.getString("title"));
                productBean.setPrice(rs.getBigDecimal("price"));
                productBean.setStock(rs.getInt("stock"));
                productBean.setBrand(rs.getString("brand"));
                list.add(productBean);
            }
            return list;
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            JdbcUtils.closeResource(conn, st, rs);
        }
    }
}
