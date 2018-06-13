package cn.wycclub.service.impl;

import cn.wycclub.dao.OrdersDao;
import cn.wycclub.domain.OrdersBean;
import cn.wycclub.domain.PageBean;
import cn.wycclub.domain.QueryInfo;
import cn.wycclub.domain.QueryResult;
import cn.wycclub.factory.DaoFactory;

import java.util.List;

/**
 * 管理订单的业务层
 *
 * @author WuYuchen
 * @date 2017-11-12 19:22
 */

public class BusinessOrdersServiceImpl implements cn.wycclub.service.OrdersService {
    private OrdersDao dao = DaoFactory.getDaoFactory().getDao(OrdersDao.class);

    /**
     * 添加订单
     * */
    @Override
    public void addOrders(OrdersBean ordersBean) {
            dao.addOrders(ordersBean);
    }

    /**
     * 更新订单状态
     * */
    @Override
    public void updateOrders(long oid, int state) {
        dao.updateOrders(oid, state);
    }

    /**
     * 删除订单
     * */
    @Override
    public void deleteOrders(long oid) {
        dao.deleteOrders(oid);
    }


    /**
     * 获取订单分页列表
     * */
    @Override
    public PageBean getCollectionByPage(QueryInfo queryInfo, int uid) {
        //调用dao获取到页面数据
        int pageSize = queryInfo.getPageSize();
        int startIndex = queryInfo.getStartIndex();
        QueryResult qr = dao.pageQuery(startIndex, pageSize, uid);

        //根据dao查询结果,生成页面需要的pageBean
        int currentPage = queryInfo.getCurrentPage();
        List<OrdersBean> list = qr.getList();
        int totalRecord = qr.getTotalRecord();
        PageBean bean = new PageBean();
        bean.setCurrentPage(currentPage);
        bean.setList(list);
        bean.setPageSize(pageSize);
        bean.setTotalRecord(totalRecord);
        return bean;
    }
}
