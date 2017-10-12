package cn.htd.argus.dao;

import cn.htd.argus.bean.HtyFctSaleSearchDTO;
import cn.htd.argus.dto.HtyFctSaleOrgDetailDTO;
import cn.htd.argus.dto.HtyFctSaleOrgProdDTO;
import cn.htd.common.Pager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HtyFctSaleOrgDetailDTOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(HtyFctSaleOrgDetailDTO record);

    int insertSelective(HtyFctSaleOrgDetailDTO record);

    HtyFctSaleOrgDetailDTO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HtyFctSaleOrgDetailDTO record);

    int updateByPrimaryKey(HtyFctSaleOrgDetailDTO record);

    HtyFctSaleOrgDetailDTO selectByOrgCode(HtyFctSaleOrgDetailDTO model);

    Long queryPageCount(@Param("searchDTO") HtyFctSaleSearchDTO htyFctSaleSearchDTO);

    List<HtyFctSaleOrgDetailDTO> queryBurstPage(@Param("searchDTO") HtyFctSaleSearchDTO htyFctSaleSearchDTO, @Param("pager") Pager pager);

    List<HtyFctSaleOrgDetailDTO> queryStopPage(@Param("searchDTO") HtyFctSaleSearchDTO htyFctSaleSearchDTO, @Param("pager") Pager pager);
}