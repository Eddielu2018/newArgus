package cn.htd.argus.dao;

import cn.htd.argus.dto.HtyFctSaleXzHotDTO;

public interface HtyFctSaleXzHotDTOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(HtyFctSaleXzHotDTO record);

    int insertSelective(HtyFctSaleXzHotDTO record);

    HtyFctSaleXzHotDTO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HtyFctSaleXzHotDTO record);

    int updateByPrimaryKey(HtyFctSaleXzHotDTO record);

    HtyFctSaleXzHotDTO selectByOrgCode(HtyFctSaleXzHotDTO model);
}