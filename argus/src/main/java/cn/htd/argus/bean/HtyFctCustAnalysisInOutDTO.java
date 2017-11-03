package cn.htd.argus.bean;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class HtyFctCustAnalysisInOutDTO {
	private BigDecimal amtAll;
	private BigDecimal amtOnline;
	private BigDecimal qtyB2b;
	private BigDecimal qtyBoss;
	private BigDecimal qtyHzg;
	private BigDecimal amtDk;
	private Integer amtAllNum; 
	private Integer amtOnlineNum;
	private Integer qtyB2bNum;
	private Integer qtyBossNum;
	private Integer qtyHzgNum;
	private Integer amtDkNum;
	private List<String> listName;
	private List<String> listDate;
	private List<String> listPair;
	private List<Map<String,String>> map;
	public BigDecimal getAmtAll() {
		return amtAll;
	}
	public void setAmtAll(BigDecimal amtAll) {
		this.amtAll = amtAll;
	}
	public BigDecimal getAmtOnline() {
		return amtOnline;
	}
	public void setAmtOnline(BigDecimal amtOnline) {
		this.amtOnline = amtOnline;
	}
	public BigDecimal getQtyB2b() {
		return qtyB2b;
	}
	public void setQtyB2b(BigDecimal qtyB2b) {
		this.qtyB2b = qtyB2b;
	}
	public BigDecimal getQtyBoss() {
		return qtyBoss;
	}
	public void setQtyBoss(BigDecimal qtyBoss) {
		this.qtyBoss = qtyBoss;
	}
	public BigDecimal getQtyHzg() {
		return qtyHzg;
	}
	public void setQtyHzg(BigDecimal qtyHzg) {
		this.qtyHzg = qtyHzg;
	}
	public BigDecimal getAmtDk() {
		return amtDk;
	}
	public void setAmtDk(BigDecimal amtDk) {
		this.amtDk = amtDk;
	}
	public Integer getAmtAllNum() {
		return amtAllNum;
	}
	public void setAmtAllNum(Integer amtAllNum) {
		this.amtAllNum = amtAllNum;
	}
	public Integer getAmtOnlineNum() {
		return amtOnlineNum;
	}
	public void setAmtOnlineNum(Integer amtOnlineNum) {
		this.amtOnlineNum = amtOnlineNum;
	}
	public Integer getQtyB2bNum() {
		return qtyB2bNum;
	}
	public void setQtyB2bNum(Integer qtyB2bNum) {
		this.qtyB2bNum = qtyB2bNum;
	}
	public Integer getQtyBossNum() {
		return qtyBossNum;
	}
	public void setQtyBossNum(Integer qtyBossNum) {
		this.qtyBossNum = qtyBossNum;
	}
	public Integer getQtyHzgNum() {
		return qtyHzgNum;
	}
	public void setQtyHzgNum(Integer qtyHzgNum) {
		this.qtyHzgNum = qtyHzgNum;
	}
	public Integer getAmtDkNum() {
		return amtDkNum;
	}
	public void setAmtDkNum(Integer amtDkNum) {
		this.amtDkNum = amtDkNum;
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
	public List<String> getListPair() {
		return listPair;
	}
	public void setListPair(List<String> listPair) {
		this.listPair = listPair;
	}
	public List<Map<String, String>> getMap() {
		return map;
	}
	public void setMap(List<Map<String, String>> map) {
		this.map = map;
	}
}
