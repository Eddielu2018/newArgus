package cn.htd.argus.mappers;

import cn.htd.argus.bean.HtyFctSaleSearchDTO;
import cn.htd.argus.dto.HtyFctSaleOrgDetailDTO;
import cn.htd.common.Pager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HtyFctSaleOrgDetailDTOMapper {

    Long queryPageSumCount(@Param("searchDTO") HtyFctSaleSearchDTO htyFctSaleSearchDTO);

    List<HtyFctSaleOrgDetailDTO> queryBurstPage(@Param("searchDTO") HtyFctSaleSearchDTO htyFctSaleSearchDTO, @Param("pager") Pager pager);

    List<HtyFctSaleOrgDetailDTO> queryStopPage(@Param("searchDTO") HtyFctSaleSearchDTO htyFctSaleSearchDTO, @Param("pager") Pager pager);

    HtyFctSaleOrgDetailDTO selectByProdCode(@Param("searchDTO") HtyFctSaleSearchDTO htyFctSaleSearchDTO);

    List<HtyFctSaleOrgDetailDTO> queryBurstSumPage(@Param("searchDTO") HtyFctSaleSearchDTO htyFctSaleSearchDTO, @Param("pager") Pager pager);

    List<HtyFctSaleOrgDetailDTO> queryStopSumPage(@Param("searchDTO") HtyFctSaleSearchDTO htyFctSaleSearchDTO, @Param("pager") Pager pager);

    List<HtyFctSaleOrgDetailDTO> queryBrandByCategory(String plCode);

    List<HtyFctSaleOrgDetailDTO> queryCategory();

    List<HtyFctSaleOrgDetailDTO> queryCategoryByBrand(String ppCode);

    List<HtyFctSaleOrgDetailDTO> queryBrand();
}