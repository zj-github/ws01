package cn.innohub.web.demo.a08_jdbc;

import java.util.List;

//�������ҳ�йص���Ϣ�ķ�װ
public class Page<T> {
	private List<T> records;//��ҳ��¼
	private int pageNum;//��¼��ǰҳ��
	private int totalPage;//������ҳ
	private int pageSize = 10;//ÿҳ��ʾ������
	private int startIndex;//��ʼ��¼������
	private int totalRecords;//�ܼ�¼��
	
	private int startPageNum;//��ʼҳ��
	private int endPageNum;//����ҳ��
	
	
	private String url;//��ѯ��ҳ��ݵ������ַ
	
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Page(int pageNum,int totalRecords){
		this.pageNum = pageNum;
		this.totalRecords = totalRecords;
		//������ҳ��
		//�ܹ�����ҳ=������%ÿҳ��ʾ������==0?������/ÿҳ��ʾ������:������/ÿҳ��ʾ������+1;
		totalPage = totalRecords%pageSize==0?totalRecords/pageSize:totalRecords/pageSize+1;
		//����ÿҳ��ʼ��¼������
//		ÿҳ��ʼ��¼������=(��ǰҳ��-1)*ÿҳ��ʾ������
		startIndex = (pageNum-1)*pageSize;
		
		//���㿪ʼ�ͽ���ҳ��
		startPageNum = pageNum-4;
		endPageNum = pageNum+4;
		//�ж���ҳ���Ƿ�С��9
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
