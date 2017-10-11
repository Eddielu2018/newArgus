package cn.htd.argus.dao;

import cn.htd.argus.dto.HtyFctSaleOrgXzDTO;

public interface HtyFctSaleOrgXzDTOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(HtyFctSaleOrgXzDTO record);

    int insertSelective(HtyFctSaleOrgXzDTO record);

    HtyFctSaleOrgXzDTO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HtyFctSaleOrgXzDTO record);

    int updateByPrimaryKey(HtyFctSaleOrgXzDTO record);

    HtyFctSaleOrgXzDTO selectByOrgCode(HtyFctSaleOrgXzDTO model);
}