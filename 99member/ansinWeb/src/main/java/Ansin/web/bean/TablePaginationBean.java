package Ansin.web.bean;

import java.util.List;

public class TablePaginationBean<T> {

	// データ
	private List<T> dataList;
	// リスト件数
	private int dataCount;
	// ページサイズ
	private int pageSize;
	// ページ数
	private int pageCount;
	// 現在のページ数
	private int currentPage;

	public List<T> getDataList() {
		return dataList;
	}

	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}

	public int getDataCount() {
		return dataCount;
	}

	public void setDataCount(int dataCount) {
		this.dataCount = dataCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	@Override
	public String toString() {
		return "TablePaginationBean [dataList=" + dataList + ", dataCount=" + dataCount + ", pageSize=" + pageSize
				+ ", pageCount=" + pageCount + ", currentPage=" + currentPage + "]";
	}
}
