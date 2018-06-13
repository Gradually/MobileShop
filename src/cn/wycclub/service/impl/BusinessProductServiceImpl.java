package cn.wycclub.service.impl;

import cn.wycclub.dao.ProductDao;
import cn.wycclub.domain.PageBean;
import cn.wycclub.domain.ProductBean;
import cn.wycclub.domain.QueryInfo;
import cn.wycclub.domain.QueryResult;
import cn.wycclub.factory.DaoFactory;
import cn.wycclub.service.ProductService;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * 给Web层提供关于商品的业务服务
 *
 * @author WuYuchen
 * @date 2017-10-31 12:55
 */

public class BusinessProductServiceImpl implements ProductService {
    ProductDao dao = DaoFactory.getDaoFactory().getDao(ProductDao.class);

    /**
     * 通过商品id获取商品信息
     * */
    @Override
    public ProductBean getProductById(int pid) {
        return dao.getProductInfo(pid);
    }

    /**
     * 获取商品分页
     * */
    @Override
    public PageBean getProductByPage(QueryInfo queryInfo) {
        //调用dao获取到页面数据
        int pageSize = queryInfo.getPageSize();
        int startIndex = queryInfo.getStartIndex();
        String brand = queryInfo.getBrand();
        QueryResult qr = dao.pageQuery(startIndex, pageSize, brand);

        //根据dao查询结果,生成页面需要的pageBean
        int currentPage = queryInfo.getCurrentPage();
        List<ProductBean> list = qr.getList();
        int totalRecord = qr.getTotalRecord();
        PageBean bean = new PageBean();
        bean.setCurrentPage(currentPage);
        bean.setList(list);
        bean.setPageSize(pageSize);
        bean.setTotalRecord(totalRecord);
        return bean;
    }

    /**
     * 获取商品品牌
     * */
    @Override
    public List<String> getBrand() {
        return dao.getProductBrand();
    }

    /**
     * 获取随机商品
     * */
    @Override
    public List<ProductBean> getProductByIndex(int num) {
        return dao.getProductByRadom(num);
    }

    /**
     * 搜索商品
     * */
    @Override
    public Set<ProductBean> searchProduct(String searchStr) {
        Set<ProductBean> set = new LinkedHashSet<>();
        List<ProductBean> list;
        set.addAll(dao.searchByProduct(searchStr));
        for (int i = 0 ; i < searchStr.length() ; i ++){
            set.addAll(dao.searchByProduct(searchStr.charAt(i)+""));
        }
        return set;
    }
}
