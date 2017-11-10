package cn.htd.argus.dto;

import java.math.BigDecimal;

public class ZeusConfigDTO {
    private BigDecimal cValue1;

    private String cValue2;

    private BigDecimal cValue3;

    public BigDecimal getcValue1() {
        return cValue1;
    }

    public void setcValue1(BigDecimal cValue1) {
        this.cValue1 = cValue1;
    }

    public String getcValue2() {
        return cValue2;
    }

    public void setcValue2(String cValue2) {
        this.cValue2 = cValue2 == null ? null : cValue2.trim();
    }

    public BigDecimal getcValue3() {
        return cValue3;
    }

    public void setcValue3(BigDecimal cValue3) {
        this.cValue3 = cValue3;
    }
}