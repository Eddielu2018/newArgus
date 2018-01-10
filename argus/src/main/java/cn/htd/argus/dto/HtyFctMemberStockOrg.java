package cn.htd.argus.dto;

import java.math.BigDecimal;

public class HtyFctMemberStockOrg {
    private String statDay;

    private String orgCode;

    private String orgFname;

    private String custCode;

    private String custName;

    private String plCodeLv1;

    private String plNameLv1;

    private String plCodeLv2;

    private String plNameLv2;

    private String plCodeLv3;

    private String plNameLv3;

    private BigDecimal stockNum;
    
    private String id;

    public String getStatDay() {
        return statDay;
    }

    public void setStatDay(String statDay) {
        this.statDay = statDay == null ? null : statDay.trim();
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    public String getOrgFname() {
        return orgFname;
    }

    public void setOrgFname(String orgFname) {
        this.orgFname = orgFname == null ? null : orgFname.trim();
    }

    public String getCustCode() {
        return custCode;
    }

    public void setCustCode(String custCode) {
        this.custCode = custCode == null ? null : custCode.trim();
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName == null ? null : custName.trim();
    }

    public String getPlCodeLv1() {
        return plCodeLv1;
    }

    public void setPlCodeLv1(String plCodeLv1) {
        this.plCodeLv1 = plCodeLv1 == null ? null : plCodeLv1.trim();
    }

    public String getPlNameLv1() {
        return plNameLv1;
    }

    public void setPlNameLv1(String plNameLv1) {
        this.plNameLv1 = plNameLv1 == null ? null : plNameLv1.trim();
    }

    public String getPlCodeLv2() {
        return plCodeLv2;
    }

    public void setPlCodeLv2(String plCodeLv2) {
        this.plCodeLv2 = plCodeLv2 == null ? null : plCodeLv2.trim();
    }

    public String getPlNameLv2() {
        return plNameLv2;
    }

    public void setPlNameLv2(String plNameLv2) {
        this.plNameLv2 = plNameLv2 == null ? null : plNameLv2.trim();
    }

    public String getPlCodeLv3() {
        return plCodeLv3;
    }

    public void setPlCodeLv3(String plCodeLv3) {
        this.plCodeLv3 = plCodeLv3 == null ? null : plCodeLv3.trim();
    }

    public String getPlNameLv3() {
        return plNameLv3;
    }

    public void setPlNameLv3(String plNameLv3) {
        this.plNameLv3 = plNameLv3 == null ? null : plNameLv3.trim();
    }

    public BigDecimal getStockNum() {
        return stockNum;
    }

    public void setStockNum(BigDecimal stockNum) {
        this.stockNum = stockNum;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
    
}