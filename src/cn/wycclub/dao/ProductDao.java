package cn.wycclub.dao;

import cn.wycclub.domain.ProductBean;
import cn.wycclub.domain.QueryResult;

import java.util.List;

/**
 * @author WuYuchen
 * @date 2017-11-02 15:29
 */

public interface ProductDao {

    /**
     * 根据商品ID获取商品信息
     * */
    ProductBean getProductInfo(int pid);

    /**
     * 随机获取n个商品
     * */
    List<ProductBean> getProductByRadom(int num);

    /**
     * 获取商品品牌
     * */
    List<String> getProductBrand();

    /**
     * 智能手机分页的获取页面数据和页面大小
     * */
    QueryResult pageQuery(int startPage, int pageSize, String brand);

    /**
     * 搜索商品
     * */
    List<ProductBean> searchByProduct(String searchInfo);
}
