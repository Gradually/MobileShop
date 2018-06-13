package cn.wycclub.admin.dao;

import cn.wycclub.domain.ProductBean;
import cn.wycclub.domain.QueryResult;
import cn.wycclub.domain.User;

import java.math.BigDecimal;

/**
 * @author WuYuchen
 * @date 2017-11-19 15:32
 */

public interface AdminDao {
    /**
     * 获取所有订单分页
     * */
    QueryResult getAllOrders(int startPage, int pageSize);

    /**
     * 获取所有用户分页
     * */
    QueryResult getAllUser(int startPage, int pageSize);

    /**
     * 获取单个用户信息
     * */
    User getUser(int uid);

    /**
     * 获取所有商品分页
     * */
    QueryResult getAllProduct(int startPage, int pageSize);

    /**
     * 添加商品
     * */
    int addProductInfo(ProductBean p);

    /**
     * 删除商品
     * */
    void deleteProduct(int pid);

    /**
     * 更新商品
     * */
    void updateProduct(ProductBean productBean);

    /**
     * 获取tableName表中的数据总量
     * product_info
     * user_info
     * product_orders
     * */
    int getQuantity(String tableName);

    /**
     * 获取订单中成交总金额
     * */
    BigDecimal getOrdersMoneyBySum();

    /**
     * 封禁或解封用户
     * */
    void updateUserInfo(int uid, int state);
}
