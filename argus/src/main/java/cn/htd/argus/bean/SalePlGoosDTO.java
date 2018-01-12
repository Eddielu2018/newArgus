package cn.htd.argus.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangtp on 2018/1/9.
 */
public class SalePlGoosDTO {
    List<String> plDate = new ArrayList<String>();
    List<String> plEnd = new ArrayList<String>();
    List<String> plStart = new ArrayList<String>();

    public List<String> getPlDate() {
        return plDate;
    }

    public void setPlDate(List<String> plDate) {
        this.plDate = plDate;
    }

    public List<String> getPlEnd() {
        return plEnd;
    }

    public void setPlEnd(List<String> plEnd) {
        this.plEnd = plEnd;
    }

    public List<String> getPlStart() {
        return plStart;
    }

    public void setPlStart(List<String> plStart) {
        this.plStart = plStart;
    }
}
