package cn.htd.argus.bean;

import java.util.List;

/**
 * Created by wangtp on 2017/10/12.
 */
public class SaleHotListDTO {
    private Long saleHostnum;

    private List<SaleHotDTO> saleHotDTOList;

    public Long getSaleHostnum() {
        return saleHostnum;
    }

    public void setSaleHostnum(Long saleHostnum) {
        this.saleHostnum = saleHostnum;
    }

    public List<SaleHotDTO> getSaleHotDTOList() {
        return saleHotDTOList;
    }

    public void setSaleHotDTOList(List<SaleHotDTO> saleHotDTOList) {
        this.saleHotDTOList = saleHotDTOList;
    }
}
