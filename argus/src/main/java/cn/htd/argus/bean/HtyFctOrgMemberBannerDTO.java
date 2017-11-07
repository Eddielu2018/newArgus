package cn.htd.argus.bean;

import java.util.List;

public class HtyFctOrgMemberBannerDTO {

	private List<HtyFctOrgMemberMothOutDTO> sortList;
	private List<String> listName;
	private List<String> listDate;
	public List<HtyFctOrgMemberMothOutDTO> getSortList() {
		return sortList;
	}
	public void setSortList(List<HtyFctOrgMemberMothOutDTO> sortList) {
		this.sortList = sortList;
	}
	public List<String> getListName() {
		return listName;
	}
	public void setListName(List<String> listName) {
		this.listName = listName;
	}
	public List<String> getListDate() {
		return listDate;
	}
	public void setListDate(List<String> listDate) {
		this.listDate = listDate;
	}
	
}
