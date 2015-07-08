package cn.goll.common;

public class DoPage {
    int pageSize=15;//每页显示条数
	int currentPage=1;//当前第几页
	int counts;//总条数
	int pageCount;//总页数
	public int getCurrentPage() {
		return this.currentPage;
	}
	public void setCurrentPage(int currentPage) {
		if(currentPage<=1){
			this.currentPage=1;
		}
		else if(currentPage>getPageCount()){
			this.currentPage=getPageCount();
		}
		else{
			this.currentPage = currentPage;
		}
	}
	public int getCounts() {
		return counts;
	}
	public void setCounts(int counts) {
		this.counts = counts;
	}
	public int getPageCount() {
		return (int) Math.ceil( getCounts()*1.0/getPageSize());
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
	 
	
}
