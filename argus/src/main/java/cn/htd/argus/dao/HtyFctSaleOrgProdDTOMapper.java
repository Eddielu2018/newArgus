package cn.htd.argus.dao;

import cn.htd.argus.bean.HtyFctSaleSearchDTO;
import cn.htd.argus.dto.HtyFctSaleOrgProdDTO;
import cn.htd.common.Pager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HtyFctSaleOrgProdDTOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(HtyFctSaleOrgProdDTO record);

    int insertSelective(HtyFctSaleOrgProdDTO record);

    HtyFctSaleOrgProdDTO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HtyFctSaleOrgProdDTO record);

    int updateByPrimaryKey(HtyFctSaleOrgProdDTO record);

    HtyFctSaleOrgProdDTO selectByOrgCode(HtyFctSaleOrgProdDTO model);

    Long queryPageCount(@Param("searchDTO") HtyFctSaleSearchDTO htyFctSaleSearchDTO);

    List<HtyFctSaleOrgProdDTO> queryBrandPage(@Param("searchDTO") HtyFctSaleSearchDTO htyFctSaleSearchDTO, @Param("pager") Pager pager);

    List<HtyFctSaleOrgProdDTO> queryCategoryPage(@Param("searchDTO") HtyFctSaleSearchDTO htyFctSaleSearchDTO, @Param("pager") Pager pager);

    Long queryPageSumCount(@Param("searchDTO") HtyFctSaleSearchDTO htyFctSaleSearchDTO);

    List<HtyFctSaleOrgProdDTO> queryBrandSumPage(@Param("searchDTO") HtyFctSaleSearchDTO htyFctSaleSearchDTO, @Param("pager") Pager pager);

    List<HtyFctSaleOrgProdDTO> queryCategorySumPage(@Param("searchDTO") HtyFctSaleSearchDTO htyFctSaleSearchDTO, @Param("pager") Pager pager);
}