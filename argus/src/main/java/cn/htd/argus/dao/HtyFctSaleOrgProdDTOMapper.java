package cn.htd.argus.dao;

import cn.htd.argus.dto.HtyFctSaleOrgProdDTO;

public interface HtyFctSaleOrgProdDTOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(HtyFctSaleOrgProdDTO record);

    int insertSelective(HtyFctSaleOrgProdDTO record);

    HtyFctSaleOrgProdDTO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HtyFctSaleOrgProdDTO record);

    int updateByPrimaryKey(HtyFctSaleOrgProdDTO record);

    HtyFctSaleOrgProdDTO selectByOrgCode(HtyFctSaleOrgProdDTO model);
}