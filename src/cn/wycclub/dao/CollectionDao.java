package cn.wycclub.dao;

import cn.wycclub.domain.CollectionBean;
import cn.wycclub.domain.QueryResult;

import java.util.List;

/**
 * @author WuYuchen
 * @date 2017-11-15 14:08
 */

public interface CollectionDao {
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
     * 获取收藏分页列表
     */
    QueryResult pageQuery(int startPage, int pageSize, int uid);
}
