package cn.wycclub.service;

import cn.wycclub.domain.PageBean;
import cn.wycclub.domain.ProductBean;
import cn.wycclub.domain.QueryInfo;

import java.util.List;
import java.util.Set;

/**
 * @author WuYuchen
 * @date 2017-11-02 20:52
 */

public interface ProductService {
    /**
     * 通过商品id获取商品
     * */
    ProductBean getProductById(int pid);

    /**
     * 获取所有商品的品牌
     * */
    List<String> getBrand();

    /**
     * 获取商品分页
     * */
    PageBean getProductByPage(QueryInfo queryInfo);

    /**
     * 随机获取num个商品
     * */
    List<ProductBean> getProductByIndex(int num);

    /**
     * 搜索商品
     * */
    Set<ProductBean> searchProduct(String searchStr);
}
