package cn.htd.argus.dao;

import cn.htd.argus.dto.HtyFctOrgValueDTO;

public interface HtyFctOrgValueDTOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(HtyFctOrgValueDTO record);

    int insertSelective(HtyFctOrgValueDTO record);

    HtyFctOrgValueDTO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HtyFctOrgValueDTO record);

    int updateByPrimaryKey(HtyFctOrgValueDTO record);
}