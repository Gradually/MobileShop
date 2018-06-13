package cn.wycclub.admin.service.impl;

import cn.wycclub.admin.dao.AdminDao;
import cn.wycclub.admin.dao.impl.AdminDaoImpl;
import cn.wycclub.admin.service.AdminService;
import cn.wycclub.domain.*;
import cn.wycclub.factory.DaoFactory;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author WuYuchen
 * @date 2017-11-19 15:38
 */

public class AdminServiceImpl implements AdminService {
    AdminDao dao = DaoFactory.getDaoFactory().getDao(AdminDao.class);
    /**
     * 获取所有订单分页
     * */
    @Override
    public PageBean getAllOrders(QueryInfo queryInfo) {
        int startIndex = queryInfo.getStartIndex();
        int pageSize = queryInfo.getPageSize();
        int currentPage = queryInfo.getCurrentPage();
        QueryResult queryResult = dao.getAllOrders(startIndex,pageSize);
        int totalRecord = queryResult.getTotalRecord();
        List<OrdersBean> list = queryResult.getList();
        for (OrdersBean ordersBean : list) {
            ordersBean.setUser(getUser(ordersBean.getUid()));
        }
        PageBean pageBean = new PageBean();
        pageBean.setPageSize(pageSize);
        pageBean.setCurrentPage(currentPage);
        pageBean.setList(list);
        pageBean.setTotalRecord(totalRecord);
        return pageBean;
    }

    /**
     * 获取所有商品分页
     * */
    @Override
    public PageBean getAllProduct(QueryInfo queryInfo) {
        int startIndex = queryInfo.getStartIndex();
        int pageSize = queryInfo.getPageSize();
        int currentPage = queryInfo.getCurrentPage();
        QueryResult queryResult = dao.getAllProduct(startIndex,pageSize);
        int totalRecord = queryResult.getTotalRecord();
        List list = queryResult.getList();
        PageBean pageBean = new PageBean();
        pageBean.setPageSize(pageSize);
        pageBean.setCurrentPage(currentPage);
        pageBean.setList(list);
        pageBean.setTotalRecord(totalRecord);
        return pageBean;
    }

    /**
     * 获取单个用户信息
     * */
    @Override
    public User getUser(int uid) {
        return dao.getUser(uid);
    }

    /**
     * 获取所有用户分页
     * */
    @Override
    public PageBean getAllUser(QueryInfo queryInfo) {
        int startIndex = queryInfo.getStartIndex();
        int pageSize = queryInfo.getPageSize();
        int currentPage = queryInfo.getCurrentPage();
        QueryResult queryResult = dao.getAllUser(startIndex,pageSize);
        int totalRecord = queryResult.getTotalRecord();
        List list = queryResult.getList();
        PageBean pageBean = new PageBean();
        pageBean.setPageSize(pageSize);
        pageBean.setCurrentPage(currentPage);
        pageBean.setList(list);
        pageBean.setTotalRecord(totalRecord);
        return pageBean;
    }

    /**
     * 添加商品
     * */
    @Override
    public int addProduct(ProductBean productBean) {
        return dao.addProductInfo(productBean);
    }

    /**
     * 更新商品
     * */
    @Override
    public void updateProduct(ProductBean productBean) {
        dao.updateProduct(productBean);
    }

    /**
     * 删除商品
     * */
    @Override
    public void removeProduct(int pid) {
        dao.deleteProduct(pid);
    }

    /**
     * 获取总成交金额
     * */
    @Override
    public BigDecimal getOrdersMoneyBySum() {
        return dao.getOrdersMoneyBySum();
    }

    /**
     * 获取某一表中的数据总量
     * */
    @Override
    public int getQuantity(String tableName) {
        return dao.getQuantity(tableName);
    }

    /**
     * 封禁或解封用户
     * */
    @Override
    public void updateUserInfo(int uid, int state) {
        dao.updateUserInfo(uid, state);
    }
}
