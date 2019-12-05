package com.chenly.util;

import java.io.Serializable;
import java.util.List;

/**
 * @author weidong
 * @date 20190529
 * @description 分页返回工具类
 */
public class Page<T extends Serializable> implements Serializable {
    private static final long serialVersionUID = 9027588550147287672L;

    private int pageSize = 20;    //分页大小
    private int currentPageNo = 1;    //当前页
    private int totalRecord;    //总页数
    private List<T> result;        //返回对象

    public Page() {
    }

    public Page(int pageNo, int pageSize) {
        this.pageSize = pageSize;
        this.currentPageNo = pageNo;
    }

    /**
     * 获取总页数
     *
     * @return int
     */
    public int getTotalPage() {
        int totalPage = 0;
        if (this.getTotalRecord() % this.pageSize == 0) {
            totalPage = this.getTotalRecord() / this.pageSize;
        } else {
            totalPage = this.getTotalRecord() / this.pageSize + 1;
        }
        return totalPage;
    }


    /**
     * 获取上一页
     *
     * @return int
     */
    public int getPrevPageNo() {
        int prevPageNo = 0;
        if (this.currentPageNo == 1) {
            prevPageNo = this.currentPageNo;
        } else {
            prevPageNo = this.currentPageNo - 1;
        }
        return prevPageNo;
    }

    /**
     * 获取下一页
     *
     * @return
     */
    public int getNextPageNo() {
        int nextPageNo = 0;
        if (this.currentPageNo == this.getLastPageNo()) {
            nextPageNo = this.currentPageNo;
        } else {
            nextPageNo = this.currentPageNo + 1;
        }
        return nextPageNo;
    }

    /**
     * 获取最后一页
     *
     * @return
     */
    public int getLastPageNo() {
        int lastPage = 0;
        if (this.getTotalRecord() % this.pageSize == 0) {
            lastPage = this.getTotalRecord() / this.pageSize;
        } else {
            lastPage = (this.getTotalRecord() / this.pageSize) + 1;
        }

        return lastPage;
    }


    public int getPageSize() {
        return pageSize;
    }


    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }


    public int getCurrentPageNo() {
        return currentPageNo;
    }


    public void setCurrentPageNo(int currentPageNo) {
        this.currentPageNo = currentPageNo;
    }


    public int getTotalRecord() {
        return totalRecord;
    }


    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }


    public List<T> getResult() {
        return result;
    }


    public void setResult(List<T> result) {
        this.result = result;
    }
}
