package cn.htd.argus.bean;

import java.util.List;

/**
 * Created by wangtp on 2017/10/12.
 */
public class SaleXzListDTO {
    private List<String> xzBottom;
    private List<String> xzBottomDate;
    private List<String> xzBottomPair;

    public List<String> getXzBottom() {
        return xzBottom;
    }

    public void setXzBottom(List<String> xzBottom) {
        this.xzBottom = xzBottom;
    }

    public List<String> getXzBottomDate() {
        return xzBottomDate;
    }

    public void setXzBottomDate(List<String> xzBottomDate) {
        this.xzBottomDate = xzBottomDate;
    }

    public List<String> getXzBottomPair() {
        return xzBottomPair;
    }

    public void setXzBottomPair(List<String> xzBottomPair) {
        this.xzBottomPair = xzBottomPair;
    }
}
