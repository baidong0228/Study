/*   
 * Copyright (c) 2016-2026 Founder Bdong. All Rights Reserved.   
 *   
 * This software is the confidential and proprietary information of   
 * Founder. You shall not disclose such Confidential Information   
 * and shall use it only in accordance with the terms of the agreements   
 * you entered into with Founder.   
 *   
 */     
package org.app.base.common;

import java.util.List;
    
/**
 * 分页
 * This class is used for ...   
 * @author Bdong  
 * @version   
 *       1.0, 2016年5月21日 上午11:42:02
 */
public class Pagination<T> {
	//总数据条数
	private int total;
	//总页数
	private int pageCount;
	//每页数据条数
	private int pageSize;
	//当前页数
	private int pageIndex;
	//数据集
	private List<T> rows;
	//当前页数据起始位置
	private int start;
	//当前页数据结束位置
	private int end;
	//分页开关
	private boolean flag;
	
	private void init(){
		if(this.flag){
			if(pageSize!=0){
				//总页数=总数据条数/总页数
		        int pageCountTemp=(int)total/pageSize;
		        if(total>=pageSize){
		            this.pageCount=total%pageSize==0?pageCountTemp:pageCountTemp+1;
		        }else{
		            this.pageCount=1;
		        }
		        
		        //判断页数和当前页数
		        if(pageIndex>pageCount){
		            pageIndex=pageCount;
		        }
		        //如果每页数据条数小于1，则修正为1
		        if(pageSize<1){
		        	pageSize=1;
		        }
		        //如果设置的每页数据条数大于真实数据条数，则修正为真实数据条数
		        if(pageSize>rows.size()){
		        	pageSize=rows.size();
		        }
		        //根据当前页计算起始和结束条目
		        this.start=(pageIndex-1)*pageSize+1;
		        this.end=this.start+this.pageSize-1;
		        //结束数据下标大于数据总数，则修正
		        if(this.end>rows.size()){
		        	this.end=rows.size();
		        }
		        	this.rows=rows.subList(start-1, end);
			}
		}
    }
	
	/**
	 * 构造
	 * @param pageIndex 当前页面
	 * @param pageSize	每页总数据条数
	 * @param rows	展示数据
	 * @param flag	分页开关
	 */
    public Pagination(int pageIndex, int pageSize, List<T> rows,boolean flag) {
        this.pageIndex = pageIndex;
        this.total = rows.size();
        this.pageSize = pageSize;
        this.rows = rows;
        this.flag = flag;
        init();
    }

    /**
     * 无参构造
     */
    public Pagination() {
        // TODO Auto-generated constructor stub
    }
    
    /**
     * 重写toString,打印Json字符串
     */
    @Override
    public String toString() {
        return "\"total\":" + total + ", \"end\":" + end + ", \"rows\":" + rows
                + ", \"pageCount\":" + pageCount + ", \"pageIndex\":" + pageIndex
                + ", \"pageSize\":" + pageSize + ", \"start\":" + start;
    }


	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}
}
  