package cn.htd.argus.dto;

import java.math.BigDecimal;

public class HtyFctSaleOrgXzDTO {
    private Long id;

    private String dateKey;

    private String orgCode;

    private String orgXzcode;

    private BigDecimal xsAmt;

    private Integer xsQty;

    private BigDecimal xsZhMl;

    private BigDecimal xsZySr;

    private BigDecimal xsAmtXz;

    private Integer xsQtyXz;

    private BigDecimal xsZhMlXz;

    private BigDecimal xsZySrXz;

    private Integer orgNum;

    private Integer cnt;

    private Integer cntXz;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDateKey() {
        return dateKey;
    }

    public void setDateKey(String dateKey) {
        this.dateKey = dateKey == null ? null : dateKey.trim();
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    public String getOrgXzcode() {
        return orgXzcode;
    }

    public void setOrgXzcode(String orgXzcode) {
        this.orgXzcode = orgXzcode == null ? null : orgXzcode.trim();
    }

    public BigDecimal getXsAmt() {
        return xsAmt;
    }

    public void setXsAmt(BigDecimal xsAmt) {
        this.xsAmt = xsAmt;
    }

    public Integer getXsQty() {
        return xsQty;
    }

    public void setXsQty(Integer xsQty) {
        this.xsQty = xsQty;
    }

    public BigDecimal getXsZhMl() {
        return xsZhMl;
    }

    public void setXsZhMl(BigDecimal xsZhMl) {
        this.xsZhMl = xsZhMl;
    }

    public BigDecimal getXsZySr() {
        return xsZySr;
    }

    public void setXsZySr(BigDecimal xsZySr) {
        this.xsZySr = xsZySr;
    }

    public BigDecimal getXsAmtXz() {
        return xsAmtXz;
    }

    public void setXsAmtXz(BigDecimal xsAmtXz) {
        this.xsAmtXz = xsAmtXz;
    }

    public Integer getXsQtyXz() {
        return xsQtyXz;
    }

    public void setXsQtyXz(Integer xsQtyXz) {
        this.xsQtyXz = xsQtyXz;
    }

    public BigDecimal getXsZhMlXz() {
        return xsZhMlXz;
    }

    public void setXsZhMlXz(BigDecimal xsZhMlXz) {
        this.xsZhMlXz = xsZhMlXz;
    }

    public BigDecimal getXsZySrXz() {
        return xsZySrXz;
    }

    public void setXsZySrXz(BigDecimal xsZySrXz) {
        this.xsZySrXz = xsZySrXz;
    }

    public Integer getOrgNum() {
        return orgNum;
    }

    public void setOrgNum(Integer orgNum) {
        this.orgNum = orgNum;
    }

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    public Integer getCntXz() {
        return cntXz;
    }

    public void setCntXz(Integer cntXz) {
        this.cntXz = cntXz;
    }
}