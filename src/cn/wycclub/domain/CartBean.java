package cn.wycclub.domain;

import java.math.BigDecimal;

/**
 * 购物车
 *
 * @author WuYuchen
 * @date 2017-11-05 17:25
 */

public class CartBean {
    private int cid;
    private int uid;
    private int pid;
    private ProductBean productBean;
    private int quantity;
    private BigDecimal payable;

    public void setPayable(BigDecimal payable) {
        this.payable = payable;
    }

    public int getPid() {

        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public ProductBean getProductBean() {
        return productBean;
    }

    public void setProductBean(ProductBean productBean) {
        this.productBean = productBean;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPayable() {
        BigDecimal q = new BigDecimal(this.quantity);
        BigDecimal price = productBean.getPrice();
        this.payable = q.multiply(price);
        return payable;
    }

}
