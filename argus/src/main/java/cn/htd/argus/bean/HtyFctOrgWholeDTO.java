package cn.htd.argus.bean;

import java.util.List;
import java.util.Map;

public class HtyFctOrgWholeDTO {

	private List<BaseNumDTO> wholeLeft;
	private List<BaseNumDTO> wholeTop;
	private List<String> wholeName;
	private List<Map<String,String>> wholeBottom;
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
	public List<String> getWholeName() {
		return wholeName;
	}
	public void setWholeName(List<String> wholeName) {
		this.wholeName = wholeName;
	}
	public List<Map<String, String>> getWholeBottom() {
		return wholeBottom;
	}
	public void setWholeBottom(List<Map<String, String>> wholeBottom) {
		this.wholeBottom = wholeBottom;
	}
	public List<Map<String, String>> getWholePic() {
		return wholePic;
	}
	public void setWholePic(List<Map<String, String>> wholePic) {
		this.wholePic = wholePic;
	}
	
}
