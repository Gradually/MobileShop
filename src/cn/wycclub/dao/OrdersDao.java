package cn.wycclub.dao;

import cn.wycclub.domain.OrdersBean;
import cn.wycclub.domain.QueryResult;

import java.util.List;

/**
 * @author WuYuchen
 * @date 2017-11-12 19:20
 */

public interface OrdersDao {

    /**
     * 添加订单
     * */
    void addOrders(OrdersBean ordersBean);

    /**
     * 更新订单
     * */
    void updateOrders(long oid, int state);

    /**
     * 删除订单
     * */
    void deleteOrders(long oid);

    /**
     * 获取订单分页列表
     * */
    QueryResult pageQuery(int startPage, int pageSize, int uid);
}
