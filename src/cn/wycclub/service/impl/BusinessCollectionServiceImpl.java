package cn.wycclub.service.impl;

import cn.wycclub.dao.CollectionDao;
import cn.wycclub.domain.*;
import cn.wycclub.factory.DaoFactory;

import java.util.List;

/**
 * 收藏的业务服务层
 *
 * @author WuYuchen
 * @date 2017-11-15 14:10
 */

public class BusinessCollectionServiceImpl implements cn.wycclub.service.CollectionService {

    private CollectionDao dao = DaoFactory.getDaoFactory().getDao(CollectionDao.class);

    /**
     * 添加收藏
     * */
    @Override
    public void addCollection(CollectionBean collectionBean) {
        dao.addCollection(collectionBean);
    }

    /**
     * 删除收藏
     * */
    @Override
    public void removeCollection(int cid) {
        dao.removeCollection(cid);
    }

    /**
     * 查询收藏列表
     * */
    @Override
    public List<CollectionBean> getCollection(int uid) {
        return dao.getCollection(uid);
    }

    /**
     * 获取收藏分页列表
     * */
    @Override
    public PageBean getCollectionByPage(QueryInfo queryInfo, int uid) {
        //调用dao获取到页面数据
        int pageSize = queryInfo.getPageSize();
        int startIndex = queryInfo.getStartIndex();
        QueryResult qr = dao.pageQuery(startIndex, pageSize, uid);

        //根据dao查询结果,生成页面需要的pageBean
        int currentPage = queryInfo.getCurrentPage();
        List<CollectionBean> list = qr.getList();
        int totalRecord = qr.getTotalRecord();
        PageBean bean = new PageBean();
        bean.setCurrentPage(currentPage);
        bean.setList(list);
        bean.setPageSize(pageSize);
        bean.setTotalRecord(totalRecord);
        return bean;
    }
}
