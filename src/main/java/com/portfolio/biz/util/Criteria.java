package com.portfolio.biz.util;

public class Criteria {	
	
	private int pageNum;
	private int numPerPage;
	
	//货肺 持澜
	private int rowStart;
	private int rowEnd;

	public Criteria() {
		this.pageNum = 1;
		this.numPerPage = 10;
	}
	
	public Criteria(int pageNum, int numPerPage) {
		this.pageNum = pageNum;
		this.numPerPage = numPerPage;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		if(pageNum <= 0) {
			this.pageNum = 1;
			return;
		}	
		this.pageNum = pageNum;
	}

	public int getNumPerPage() {
		return numPerPage;
	}

	public void setNumPerPage(int numPerPage) {
		if(numPerPage <= 0 || numPerPage > 50) {
			this.numPerPage = 10;
			return;
		} else {
			this.numPerPage = numPerPage;
		}
			
	}
	
	public int getPageStart() {
		return (this.pageNum-1) * this.numPerPage + 1;
	}

	@Override
	public String toString() {
		return "Criteria [pageNum=" + pageNum + ", numPerPage=" + numPerPage + "]";
	}
	
	//货肺 持澜
	public int getRowStart() {
		rowStart = ((pageNum-1)* numPerPage) + 1;
		return rowStart;
	}
	//货肺 持澜
	public int getRowEnd() {
		rowEnd = rowStart + numPerPage - 1;
		return rowEnd;
	}

	
}
