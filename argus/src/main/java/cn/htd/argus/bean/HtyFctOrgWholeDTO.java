package cn.htd.argus.bean;

import java.util.List;
import java.util.Map;

public class HtyFctOrgWholeDTO {

	private List<BaseNumDTO> wholeLeft;
	private List<BaseNumDTO> wholeTop;
	private List<Map<String,String>> wholeName;
	private List<String> wholeIncomeRatio;
	private List<String> wholeBottom;
	private List<String> wholeBottomDate;
	private List<String> wholeBottomPair;
	private List<Map<String,String>> wholePic;
	public List<BaseNumDTO> getWholeLeft() {
		return wholeLeft;
	}
	public void setWholeLeft(List<BaseNumDTO> wholeLeft) {
		this.wholeLeft = wholeLeft;
	}
	public List<BaseNumDTO> getWholeTop() {
		return wholeTop;
	}
	public void setWholeTop(List<BaseNumDTO> wholeTop) {
		this.wholeTop = wholeTop;
	}
	public List<Map<String, String>> getWholeName() {
		return wholeName;
	}
	public void setWholeName(List<Map<String, String>> wholeName) {
		this.wholeName = wholeName;
	}
	public List<Map<String, String>> getWholePic() {
		return wholePic;
	}
	public void setWholePic(List<Map<String, String>> wholePic) {
		this.wholePic = wholePic;
	}
	public List<String> getWholeBottom() {
		return wholeBottom;
	}
	public void setWholeBottom(List<String> wholeBottom) {
		this.wholeBottom = wholeBottom;
	}
	public List<String> getWholeBottomDate() {
		return wholeBottomDate;
	}
	public void setWholeBottomDate(List<String> wholeBottomDate) {
		this.wholeBottomDate = wholeBottomDate;
	}
	public List<String> getWholeBottomPair() {
		return wholeBottomPair;
	}
	public void setWholeBottomPair(List<String> wholeBottomPair) {
		this.wholeBottomPair = wholeBottomPair;
	}

	public List<String> getWholeIncomeRatio() {
		return wholeIncomeRatio;
	}

	public void setWholeIncomeRatio(List<String> wholeIncomeRatio) {
		this.wholeIncomeRatio = wholeIncomeRatio;
	}
}
