package cn.htd.argus.bean;


import java.util.List;

/**
 * Created by wangtp on 2017/10/13.
 */
public class SaleAllDTO {

    //销售商品品牌品类
    List<BrandSortDTO> detailBrand;
    List<BrandSortDTO> detailCategory;

    //销售爆款品牌品类
    List<BrandSortDTO> hotBrand;
    List<BrandSortDTO> hotCategory;

    //上部统计
    SaleCompareDTO saleCompareDTO;

    //中部趋势图
    SaleXzListDTO saleXzListDTO;

    //品牌品类
    SaleProdListDTO saleProdListDTO;

    //商品销售
    SaleDetailListDTO saleDetailListDTO;

    //爆款
    SaleHotListDTO saleHotListDTO;

    public List<BrandSortDTO> getDetailBrand() {
        return detailBrand;
    }

    public void setDetailBrand(List<BrandSortDTO> detailBrand) {
        this.detailBrand = detailBrand;
    }

    public List<BrandSortDTO> getDetailCategory() {
        return detailCategory;
    }

    public void setDetailCategory(List<BrandSortDTO> detailCategory) {
        this.detailCategory = detailCategory;
    }

    public List<BrandSortDTO> getHotBrand() {
        return hotBrand;
    }

    public void setHotBrand(List<BrandSortDTO> hotBrand) {
        this.hotBrand = hotBrand;
    }

    public List<BrandSortDTO> getHotCategory() {
        return hotCategory;
    }

    public void setHotCategory(List<BrandSortDTO> hotCategory) {
        this.hotCategory = hotCategory;
    }

    public SaleCompareDTO getSaleCompareDTO() {
        return saleCompareDTO;
    }

    public void setSaleCompareDTO(SaleCompareDTO saleCompareDTO) {
        this.saleCompareDTO = saleCompareDTO;
    }

    public SaleXzListDTO getSaleXzListDTO() {
        return saleXzListDTO;
    }

    public void setSaleXzListDTO(SaleXzListDTO saleXzListDTO) {
        this.saleXzListDTO = saleXzListDTO;
    }

    public SaleProdListDTO getSaleProdListDTO() {
        return saleProdListDTO;
    }

    public void setSaleProdListDTO(SaleProdListDTO saleProdListDTO) {
        this.saleProdListDTO = saleProdListDTO;
    }

    public SaleDetailListDTO getSaleDetailListDTO() {
        return saleDetailListDTO;
    }

    public void setSaleDetailListDTO(SaleDetailListDTO saleDetailListDTO) {
        this.saleDetailListDTO = saleDetailListDTO;
    }

    public SaleHotListDTO getSaleHotListDTO() {
        return saleHotListDTO;
    }

    public void setSaleHotListDTO(SaleHotListDTO saleHotListDTO) {
        this.saleHotListDTO = saleHotListDTO;
    }
}
