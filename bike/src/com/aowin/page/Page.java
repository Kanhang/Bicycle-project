package com.aowin.page;

import java.util.List;

public class Page<E> {
	
	private int currentPage;//当前页
	private int pageSize = 2;//每页显示多少条数据
	private int totalPage;//总页数
	private int totalCount;//总条数
	private List<E> dataList;
	
	
	public int getCurrentPage() {
		return currentPage;
	}
	@Override
	public String toString() {
		return "Page [currentPage=" + currentPage + ", pageSize=" + pageSize
				+ ", totalPage=" + totalPage + ", totalCount=" + totalCount
				+ ", dataList=" + dataList + "]";
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
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public List<E> getDataList() {
		return dataList;
	}
	public void setDataList(List<E> dataList) {
		this.dataList = dataList;
	}
	
	
	
	

}
