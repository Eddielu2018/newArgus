package cn.htd.argus.service;

import cn.htd.argus.bean.BrandSortDTO;
import cn.htd.argus.bean.HtyFctSaleSearchDTO;
import cn.htd.argus.bean.SaleDetailDTO;
import cn.htd.argus.dto.HtyFctSaleOrgDetailDTO;
import cn.htd.common.Pager;

import java.util.List;

/**
 * Created by wangtp on 2017/10/10.
 */
public interface HtyFctSaleOrgDetailDTOService {
//    HtyFctSaleOrgDetailDTO selectByOrgCode(String userId);
//
//    Long queryPageCount(HtyFctSaleSearchDTO searchDTO);

    Long queryPageSumCount(HtyFctSaleSearchDTO searchDTO);

    List<SaleDetailDTO> queryPage(HtyFctSaleSearchDTO searchDTO,Pager pager);

    List<BrandSortDTO> queryBrandByCategory(String plCode);

    List<BrandSortDTO> queryCategory();

    List<BrandSortDTO> queryBrand();

    List<BrandSortDTO> queryCategoryByBrand(String ppCode);
}
