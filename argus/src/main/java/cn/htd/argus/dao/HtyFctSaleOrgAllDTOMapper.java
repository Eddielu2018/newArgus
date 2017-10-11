package cn.htd.argus.dao;

import cn.htd.argus.dto.HtyFctSaleOrgAllDTO;

public interface HtyFctSaleOrgAllDTOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(HtyFctSaleOrgAllDTO record);

    int insertSelective(HtyFctSaleOrgAllDTO record);

    HtyFctSaleOrgAllDTO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HtyFctSaleOrgAllDTO record);

    int updateByPrimaryKey(HtyFctSaleOrgAllDTO record);

    HtyFctSaleOrgAllDTO selectByOrgCode(HtyFctSaleOrgAllDTO model);
}