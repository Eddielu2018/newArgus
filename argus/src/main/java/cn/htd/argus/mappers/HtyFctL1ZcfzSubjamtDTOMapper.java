package cn.htd.argus.mappers;

import cn.htd.argus.dto.HtyFctL1ZcfzSubjamtDTO;

public interface HtyFctL1ZcfzSubjamtDTOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(HtyFctL1ZcfzSubjamtDTO record);

    int insertSelective(HtyFctL1ZcfzSubjamtDTO record);

    HtyFctL1ZcfzSubjamtDTO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HtyFctL1ZcfzSubjamtDTO record);

    int updateByPrimaryKey(HtyFctL1ZcfzSubjamtDTO record);
}