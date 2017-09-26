package cn.htd.argus.dao;

import cn.htd.argus.dto.HtyFctOrgSaleDTO;

public interface HtyFctOrgSaleDTOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(HtyFctOrgSaleDTO record);

    int insertSelective(HtyFctOrgSaleDTO record);

    HtyFctOrgSaleDTO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HtyFctOrgSaleDTO record);

    int updateByPrimaryKey(HtyFctOrgSaleDTO record);
}