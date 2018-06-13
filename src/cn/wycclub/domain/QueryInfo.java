package cn.wycclub.domain;

/**
 * 分页记录当前页和想看页面大小,及用户想看的数据在数据库的位置
 *
 * @author WuYuchen
 * @date 2017-10-30 22:29
 */

public class QueryInfo {
    private int currentPage = 1;
    private int pageSize = 12;
    private int startIndex;
    private String brand = "";

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getStartIndex() {
        this.startIndex = pageSize * (this.currentPage - 1);
        return startIndex;
    }
}
