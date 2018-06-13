package cn.wycclub.domain;

import cn.wycclub.service.ProductService;

/**
 * 收藏实例
 *
 * @author WuYuchen
 * @date 2017-11-15 14:49
 */

public class CollectionBean {
    private int cid;
    private int pid;
    private int uid;
    private ProductBean productBean;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public ProductBean getProductBean() {
        return productBean;
    }

    public void setProductBean(ProductBean productBean) {
        this.productBean = productBean;
    }
}
