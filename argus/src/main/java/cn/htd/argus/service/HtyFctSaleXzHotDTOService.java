package cn.htd.argus.service;

import cn.htd.argus.bean.BrandSortDTO;
import cn.htd.argus.bean.HtyFctSaleSearchDTO;
import cn.htd.argus.bean.SaleHotDTO;
import cn.htd.argus.dto.HtyFctSaleXzHotDTO;
import cn.htd.common.Pager;

import java.util.List;

/**
 * Created by wangtp on 2017/10/10.
 */
public interface HtyFctSaleXzHotDTOService {

    Long queryPageSumCount(HtyFctSaleSearchDTO searchDTO);

    List<SaleHotDTO> queryPage(HtyFctSaleSearchDTO searchDTO,Pager pager);

    List<BrandSortDTO> queryBrand(String plCode);

    List<BrandSortDTO> queryCategory();
}
