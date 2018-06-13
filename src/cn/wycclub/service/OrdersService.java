package cn.wycclub.service;

import cn.wycclub.domain.OrdersBean;
import cn.wycclub.domain.PageBean;
import cn.wycclub.domain.QueryInfo;

import java.util.List;

/**
 * @author WuYuchen
 * @date 2017-11-12 19:33
 */

public interface OrdersService {
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
     * 获取订单分页
     * */
    PageBean getCollectionByPage(QueryInfo queryInfo, int uid);
}
