package cn.wycclub.domain;

import java.util.List;

/**
 * 显示条
 *
 * @author WuYuchen
 * @date 2017-10-30 22:51
 */

public class PageBean {
    private List list;					//当前页面数据
    private int totalRecord;			//总记录数
    private int pageSize;				//每页数据数量
    private int totalPage;			//总共多少页
    private int currentPage;			//当前看的页
    private int previousPage;		//上一页页码
    private int nextPage;				//下一页页码
    private int[] pageBar;			//页码条


    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        int num = this.totalRecord / this.pageSize;
        this.totalPage = this.totalRecord % this.pageSize == 0 ? num : ++num;
        return totalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPreviousPage() {
        this.previousPage = this.currentPage == 1 ? 1 : this.currentPage - 1;
        return this.previousPage;
    }

    public int getNextPage() {
        this.nextPage = this.currentPage == this.totalPage ? this.totalPage : this.currentPage + 1;
        return this.nextPage;
    }

    public int[] getPageBar() {
        int[] pageBar;
        int startPage = 1;
        int endPage = 9;
        this.getTotalPage();
        if(this.totalPage <= 9) {
            pageBar = new int[this.totalPage];
            startPage = 1;
            endPage = this.totalPage;
        } else {
            pageBar = new int[9];
            startPage = this.currentPage - 4;
            endPage = this.currentPage + 4;
            if(startPage < 1) {
                startPage = 1;
                endPage = 9;
            }
            if(endPage > this.totalPage) {
                startPage = this.totalPage - 8 ;
                endPage = this.totalPage;
            }
        }

        for (int i = startPage, j = 0 ; j < pageBar.length && i <=endPage ; i++, j++) {
            pageBar[j] = i;
        }
        this.pageBar = pageBar;
        return this.pageBar;
    }
}
