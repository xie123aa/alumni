package george.xie.utils;

import java.util.List;

public class Page<T> {
	private int pageNum;//当前页数目
	private int pageSize;//一页多少数据
	private int totalRecord;//全部数据
	private int totalPage;//全部页数
	private int startIndex;//开始索引
	private List<T> list;
	private int start;//当前显示开始页
	private int end;//当前显示最后页
	private List<T> urlList;

	public List<T> getUrlList() {
		return urlList;
	}

	public void setUrlList(List<T> urlList) {
		this.urlList = urlList;
	}

	public int getTotalRecord() {
		return totalRecord;
	}


	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}


	public int getTotalPage() {
		return totalPage;
	}


	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
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


	//构造函数
	public Page(int pageNum,int pageSize,int totalRecord){
		this.pageNum=pageNum;
		this.pageSize=pageNum;
		this.totalRecord=totalRecord;
		if(totalRecord%pageSize==0){
			this.totalPage=totalRecord/pageSize;//没有余数
		}else{
			this.totalPage=totalRecord/pageSize+1;//当前有余数，页数加一
		}
		//所要查询的起始索引
		this.startIndex=(pageNum-1)*pageSize;
		this.start=1;
		this.end=5;
		if(totalPage<=5){//总共显示5页
			this.end=this.totalPage;
		}else{
			this.start=pageNum-2;
			this.end=pageNum+2;
			if(start<0){//纠错
				this.start=1;
				this.end=5;
			}
			if(end<this.totalPage){//纠错
				this.end=totalPage;
				this.start=end-5;
			}
			
		}
		
	}


	public int getPageNum() {
		return pageNum;
	}


	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}


	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public int getStartIndex() {
		return startIndex;
	}


	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}


	public List<T> getList() {
		return list;
	}


	public void setList(List<T> list) {
		this.list = list;
	}
	
	

}
