package org.tsxuehu.pm.dao.dbobject;

import java.io.Serializable;

/**
 * User:  yunche.ch ... (ว ˙o˙)ง
 * Date: 15-7-28
 * Time: 上午9:31
 */
public class DBPageQuery implements Serializable {

    private static final long serialVersionUID = -8745138167696978267L;

    static final int DEFAULT_PAGE_SIZE = 20;

    // -- 分页参数 --//
    protected int pageNo = 1; // 当前页页号，注意页号是从1开始的
    protected int pageSize = DEFAULT_PAGE_SIZE; // 分页模型每页的大小
    protected int start = 0;//当前记录号

    protected int totalNum = 0;

    // -- 构造函数 --//
    protected DBPageQuery() {

    }

    public DBPageQuery(int pageNo, int pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    /**
     * 获得当前页的页号,序号从1开始,默认为1.
     */
    public int getPageNo() {
        return pageNo;
    }

    /**
     * 设置当前页的页号,序号从1开始,低于1时自动调整为1.
     */
    public void setPageNo(final int pageNo) {
        this.pageNo = pageNo;

        if (pageNo < 1) {
            this.pageNo = 1;
        }
    }

    /**
     * 获得每页的记录数量,默认为15.
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * 设置每页的记录数量,低于1时自动调整为默认页大小.
     */
    public void setPageSize(final int pageSize) {
        this.pageSize = pageSize;

        if (pageSize < 1) {
            this.pageSize = DEFAULT_PAGE_SIZE;
        }
    }

    /**
     * 根据pageNo和pageSize计算当前页第一条记录在总结果集中的位置.
     */
    public Integer getFirst() {
        return (getPageNo() > 0 && getPageSize() > 0) ? ((getPageNo() - 1) * getPageSize() + 0) : 0;
        /*
         * maysql=Integer((pageNo - 1) * pageSize + 0); oralce=Integer((pageNo -
		 * 1) * pageSize + 1);
		 */
    }

    public int getRowStart() {
        return getFirst();
    }

    /**
     * 根据pageNo和pageSize计算当前页最后一条记录在总结果集中的位置.
     */
    public Integer getLast() {
        return (getFirst() + getPageSize() - 1);
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getStart() {
        if (start != 0) {
            return start;
        }
        this.start = (this.pageNo - 1) * this.pageSize;
        return start;
    }


}
