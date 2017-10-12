package cn.htd.argus.bean;

import java.util.List;

/**
 * Created by wangtp on 2017/10/11.
 */
public class SaleDetailListDTO {
    private Long detainum;

    private List<SaleDetailDTO> saleDetailDTOList;

    public Long getDetainum() {
        return detainum;
    }

    public void setDetainum(Long detainum) {
        this.detainum = detainum;
    }

    public List<SaleDetailDTO> getSaleDetailDTOList() {
        return saleDetailDTOList;
    }

    public void setSaleDetailDTOList(List<SaleDetailDTO> saleDetailDTOList) {
        this.saleDetailDTOList = saleDetailDTOList;
    }
}
