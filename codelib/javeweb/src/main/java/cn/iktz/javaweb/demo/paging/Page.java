package cn.iktz.javaweb.demo.paging;

import java.util.List;

//所有与分页有关的信息的封装
public class Page<T> {
	private List<T> records;//分页记录
	private int pageNum;//记录当前页码
	private int totalPage;//共多少页
	private int pageSize = 10;//每页显示的条数
	private int startIndex;//开始记录的索引
	private int totalRecords;//总记录数
	
	private int startPageNum;//开始页码
	private int endPageNum;//结束页码
	
	
	private String url;//查询分页数据的请求地址
	
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Page(int pageNum,int totalRecords){
		this.pageNum = pageNum;
		this.totalRecords = totalRecords;
		//计算总页数
		//总共多少页=总条数%每页显示的条数==0?总条数/每页显示的条数:总条数/每页显示的条数+1;
		totalPage = totalRecords%pageSize==0?totalRecords/pageSize:totalRecords/pageSize+1;
		//计算每页开始记录的索引
//		每页开始记录的索引=(当前页码-1)*每页显示的条数
		startIndex = (pageNum-1)*pageSize;
		
		//计算开始和结束页码
		startPageNum = pageNum-4;
		endPageNum = pageNum+4;
		//判断总页数是否小于9
		if(totalPage<9){
			startPageNum = 1;
			endPageNum = totalPage;
		}else{
			if(startPageNum<1){
				startPageNum = 1;
				endPageNum = 9;
			}
			if(endPageNum>totalPage){
				endPageNum = totalPage;
				startPageNum = endPageNum-8;
			}
		}
	}

	public List<T> getRecords() {
		return records;
	}

	public void setRecords(List<T> records) {
		this.records = records;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
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

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public int getStartPageNum() {
		return startPageNum;
	}

	public void setStartPageNum(int startPageNum) {
		this.startPageNum = startPageNum;
	}

	public int getEndPageNum() {
		return endPageNum;
	}

	public void setEndPageNum(int endPageNum) {
		this.endPageNum = endPageNum;
	}
	
}
