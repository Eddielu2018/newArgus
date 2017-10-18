package cn.htd.argus.bean;



/**
 * Created by wangtp on 2017/10/10.
 */
public class HtyFctSaleSearchDTO {
    private String userId;
    private String startTime;
    private String endTime;
    private String prodName;
    private String plCode;
    private String ppCode;
    private String xsAmt;
    private String prodCode;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getXsAmt() {
        return xsAmt;
    }

    public void setXsAmt(String xsAmt) {
        this.xsAmt = xsAmt;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getPlCode() {
        return plCode;
    }

    public void setPlCode(String plCode) {
        this.plCode = plCode;
    }

    public String getPpCode() {
        return ppCode;
    }

    public void setPpCode(String ppCode) {
        this.ppCode = ppCode;
    }

    public String getProdCode() {
        return prodCode;
    }

    public void setProdCode(String prodCode) {
        this.prodCode = prodCode;
    }
}
