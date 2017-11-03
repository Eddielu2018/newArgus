package cn.htd.argus.dto;

public class HtyConfigZcfzSubjcodeDTO {
    private Long id;

    private String frSubjcode;

    private String frSubjname;

    private String seSubjcode;

    private String seSubjname;

    private String thSubjcode;

    private String thSubjname;

    private String foSubjcode;

    private String foSubjname;

    private String subjDesc;

    private String subjSource;

    private String qmFlag;

    private String checktype;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrSubjcode() {
        return frSubjcode;
    }

    public void setFrSubjcode(String frSubjcode) {
        this.frSubjcode = frSubjcode == null ? null : frSubjcode.trim();
    }

    public String getFrSubjname() {
        return frSubjname;
    }

    public void setFrSubjname(String frSubjname) {
        this.frSubjname = frSubjname == null ? null : frSubjname.trim();
    }

    public String getSeSubjcode() {
        return seSubjcode;
    }

    public void setSeSubjcode(String seSubjcode) {
        this.seSubjcode = seSubjcode == null ? null : seSubjcode.trim();
    }

    public String getSeSubjname() {
        return seSubjname;
    }

    public void setSeSubjname(String seSubjname) {
        this.seSubjname = seSubjname == null ? null : seSubjname.trim();
    }

    public String getThSubjcode() {
        return thSubjcode;
    }

    public void setThSubjcode(String thSubjcode) {
        this.thSubjcode = thSubjcode == null ? null : thSubjcode.trim();
    }

    public String getThSubjname() {
        return thSubjname;
    }

    public void setThSubjname(String thSubjname) {
        this.thSubjname = thSubjname == null ? null : thSubjname.trim();
    }

    public String getFoSubjcode() {
        return foSubjcode;
    }

    public void setFoSubjcode(String foSubjcode) {
        this.foSubjcode = foSubjcode == null ? null : foSubjcode.trim();
    }

    public String getFoSubjname() {
        return foSubjname;
    }

    public void setFoSubjname(String foSubjname) {
        this.foSubjname = foSubjname == null ? null : foSubjname.trim();
    }

    public String getSubjDesc() {
        return subjDesc;
    }

    public void setSubjDesc(String subjDesc) {
        this.subjDesc = subjDesc == null ? null : subjDesc.trim();
    }

    public String getSubjSource() {
        return subjSource;
    }

    public void setSubjSource(String subjSource) {
        this.subjSource = subjSource == null ? null : subjSource.trim();
    }

    public String getQmFlag() {
        return qmFlag;
    }

    public void setQmFlag(String qmFlag) {
        this.qmFlag = qmFlag == null ? null : qmFlag.trim();
    }

    public String getChecktype() {
        return checktype;
    }

    public void setChecktype(String checktype) {
        this.checktype = checktype == null ? null : checktype.trim();
    }
}