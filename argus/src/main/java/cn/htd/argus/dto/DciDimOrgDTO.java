package cn.htd.argus.dto;

public class DciDimOrgDTO {
    private Long id;

    private String orgCode;

    private String orgSname;

    private String orgPcode;

    private String orgPsname;

    private String orgXzcode;

    private String orgXz;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    public String getOrgSname() {
        return orgSname;
    }

    public void setOrgSname(String orgSname) {
        this.orgSname = orgSname == null ? null : orgSname.trim();
    }

    public String getOrgPcode() {
        return orgPcode;
    }

    public void setOrgPcode(String orgPcode) {
        this.orgPcode = orgPcode == null ? null : orgPcode.trim();
    }

    public String getOrgPsname() {
        return orgPsname;
    }

    public void setOrgPsname(String orgPsname) {
        this.orgPsname = orgPsname == null ? null : orgPsname.trim();
    }

    public String getOrgXzcode() {
        return orgXzcode;
    }

    public void setOrgXzcode(String orgXzcode) {
        this.orgXzcode = orgXzcode == null ? null : orgXzcode.trim();
    }

    public String getOrgXz() {
        return orgXz;
    }

    public void setOrgXz(String orgXz) {
        this.orgXz = orgXz == null ? null : orgXz.trim();
    }
}