package com.imlc.demo.entity;

public class Page {
	private Integer pageSize; // 页面大小
	private Integer pageIndex; // 当前页
	private Integer startrow; // 起始行
	private Integer totalpage; // 总页数
	private Integer totalcount; // 总条数

	public Page() {
	}

	public Page(Integer pageSize, Integer pageIndex, Integer totalCount) {
		this.pageSize = pageSize; // 页面大小
		this.pageIndex = pageIndex; // 当前页
		this.totalcount = totalCount; // 计算总条数
		this.setStartrow(pageIndex, pageSize); // 计算起始行
		this.setTotalpage(totalCount, pageSize); // 计算总页数
	}

	public Integer getpageSize() {
		return pageSize;
	}

	public void setpageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getpageIndex() {
		return pageIndex;
	}

	public void setpageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getStartrow() {
		return startrow;
	}

	/**
	 * 计算起始行
	 * 
	 * @param pageIndex
	 * @param pageSize
	 */
	public void setStartrow(Integer pageIndex, Integer pageSize) {
		this.startrow = (pageIndex - 1) * pageSize;
	}

	public Integer getTotalpage() {
		return totalpage;
	}

	/**
	 * 计算总页数
	 * 
	 * @param totalCount
	 * @param pageSize
	 */
	public void setTotalpage(Integer totalCount, Integer pageSize) {
		this.totalpage = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
	}

	public Integer getTotalcount() {
		return totalcount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalcount = totalCount;
	}

	@Override
	public String toString() {
		return "[{\"pageIndex\":" + pageIndex + ",\"pageSize\":" + pageSize + ",\"startrow\":" + startrow + ",\"totalcount\":"
				+ totalcount + ",\"totalpage\":" + totalpage + "}]";
	}
}