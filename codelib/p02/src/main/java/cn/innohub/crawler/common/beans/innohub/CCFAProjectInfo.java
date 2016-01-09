package cn.innohub.crawler.common.beans.innohub;

import cn.innohub.crawler.common.beans.BeanDatum;

public class CCFAProjectInfo extends BeanDatum {

	@Override
	public String toString() {
		return "CCFAProjectInfo [ projectName=" + projectName  + ", projectLogo="
				+ projectLogo + ", url=" + url + ", description=" + description + ", introduction=" + introduction
				+ ", city=" + city + ", financeId=" + financeId + ", isfinance=" + isfinance + ", contactName="
				+ contactName + ", contactPhone=" + contactPhone + ", contactEmail=" + contactEmail  + "]";
	}
	private Integer id;
	private String projectName;// '项目名称',
	private Integer userId;
	private String projectLogo;// '项目Logo地址',
	private String url;// '网址链接',
	private String description;// '项目描述',
	private String introduction;// '产品介绍',
	private String city;// '所在城市',
	private Integer financeId;// '融资id',
	private Integer isfinance;// '是否融资（0,开始融资1,没有融资2,融资完成)',
	private String contactName;// '联系人姓名',
	private String contactPhone;// '联系人电话',
	private String contactEmail;// '联系人邮箱',
	private String addTime;// '项目添加时间',
	private String analysisUrl;// '内部人对项目的分析报告位置（路径）',
	private String status;// ' 0表示新增，1表示审核通过 ，2表示审核未通过，-1表示删除的',
	private String view;// '审核意见',
	
	public int getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getProjectLogo() {
		return projectLogo;
	}
	public void setProjectLogo(String projectLogo) {
		this.projectLogo = projectLogo;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Integer getFinanceId() {
		return financeId;
	}
	public void setFinanceId(Integer financeId) {
		this.financeId = financeId;
	}
	public Integer getIsfinance() {
		return isfinance;
	}
	public void setIsfinance(Integer isfinance) {
		this.isfinance = isfinance;
	}
	public String getContactName() {
		return contactName;
	}
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}
	public String getContactPhone() {
		return contactPhone;
	}
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	public String getAddTime() {
		return addTime;
	}
	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}
	public String getAnalysisUrl() {
		return analysisUrl;
	}
	public void setAnalysisUrl(String analysisUrl) {
		this.analysisUrl = analysisUrl;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getView() {
		return view;
	}
	public void setView(String view) {
		this.view = view;
	}
}