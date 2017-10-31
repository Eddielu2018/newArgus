package cn.htd.argus.dao;

import cn.htd.argus.dto.HtyFctL2DupontDTO;

public interface HtyFctL2DupontDTOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(HtyFctL2DupontDTO record);

    int insertSelective(HtyFctL2DupontDTO record);

    HtyFctL2DupontDTO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HtyFctL2DupontDTO record);

    int updateByPrimaryKey(HtyFctL2DupontDTO record);
}