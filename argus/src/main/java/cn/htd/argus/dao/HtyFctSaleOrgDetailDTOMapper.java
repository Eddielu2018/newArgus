package cn.htd.argus.dao;

import cn.htd.argus.dto.HtyFctSaleOrgDetailDTO;

public interface HtyFctSaleOrgDetailDTOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(HtyFctSaleOrgDetailDTO record);

    int insertSelective(HtyFctSaleOrgDetailDTO record);

    HtyFctSaleOrgDetailDTO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HtyFctSaleOrgDetailDTO record);

    int updateByPrimaryKey(HtyFctSaleOrgDetailDTO record);

    HtyFctSaleOrgDetailDTO selectByOrgCode(HtyFctSaleOrgDetailDTO model);
}