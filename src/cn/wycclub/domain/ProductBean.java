package cn.wycclub.domain;

import java.math.BigDecimal;

/**
 * 商品的对象
 *
 * @author WuYuchen
 * @date 2017-10-30 22:15
 */

public class ProductBean {
    private int pid;
    private String productName;
    private BigDecimal price;
    private int stock;
    private String brand;
    private ProductImageBean imageBean;
    private String createTime;
    private String modifiedTime;

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(String modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public ProductImageBean getImageBean() {
        return imageBean;
    }

    public void setImageBean(ProductImageBean imageBean) {
        this.imageBean = imageBean;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
                                                       
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ProductBean that = (ProductBean) o;

        return productName.equals(that.productName);
    }

    @Override
    public int hashCode() {
        return productName.hashCode();
    }
}
