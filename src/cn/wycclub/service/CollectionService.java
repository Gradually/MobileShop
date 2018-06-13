package cn.wycclub.service;

import cn.wycclub.domain.CollectionBean;
import cn.wycclub.domain.PageBean;
import cn.wycclub.domain.QueryInfo;

import java.util.List;

/**
 * @author WuYuchen
 * @date 2017-11-15 14:14
 */

public interface CollectionService {

    /**
     * 添加收藏
     * */
    void addCollection(CollectionBean collectionBean);

    /**
     * 删除收藏
     * */
    void removeCollection(int cid);

    /**
     * 获取收藏列表
     * */
    List<CollectionBean> getCollection(int uid);

    /**
     * 获取收藏列表分页
     * */
    PageBean getCollectionByPage(QueryInfo queryInfo, int uid);
}
