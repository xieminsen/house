package com.xms.house.util;

import java.io.Serializable;

import org.apache.ibatis.session.RowBounds;

public class PageParam implements Serializable{

	private static final long serialVersionUID = 5324699979938259319L;
	private int rows;
	private int page;
	private int totalCount;
	
	//
	private int draw = 0;
	private int start = 0;
	private int length = 0;
	
	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = (rows == 0) ? 10:rows;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		
		this.page = (page == 0) ? 1:page;
	}

	private  transient RowBounds rowBounds;
	
	public RowBounds getRowBounds() {
		this.rowBounds = new RowBounds(page,rows);
		return rowBounds;
	}

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}
	
	
}
