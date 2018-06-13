package cn.wycclub.domain;

import java.util.List;

/**
 * 记住客户看的页的数据,和总记录数
 *
 * @author WuYuchen
 * @date 2017-10-30 22:33
 */

public class QueryResult {
    private List list;

    private int totalRecord;

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
}
