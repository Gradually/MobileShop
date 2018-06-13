package cn.wycclub.admin.service;

import cn.wycclub.domain.PageBean;
import cn.wycclub.domain.ProductBean;
import cn.wycclub.domain.QueryInfo;
import cn.wycclub.domain.User;

import java.math.BigDecimal;

/**
 * @author WuYuchen
 * @date 2017-11-19 15:51
 */

public interface AdminService {
    /**
     * 订单分页
     * */
    PageBean getAllOrders(QueryInfo queryInfo);

    /**
     * 商品分页
     * */
    PageBean getAllProduct(QueryInfo queryInfo);

    /**
     * 用户分页
     * */
    PageBean getAllUser(QueryInfo queryInfo);

    /**
     * 获取单个用户信息
     * */
    User getUser(int uid);

    /**
     * 添加商品
     * */
    int addProduct(ProductBean productBean);

    /**
     * 更新商品信息
     * */
    void updateProduct(ProductBean productBean);

    /**
     * 删除商品
     * */
    void removeProduct(int pid);

    /**
     * 获取某一表中的数据总量
     * */
    int getQuantity(String tableName);

    /**
     * 获取总成交金额
     * */
    BigDecimal getOrdersMoneyBySum();

    /**
     * 封禁或解封用户
     * */
    void updateUserInfo(int uid, int state);
}
