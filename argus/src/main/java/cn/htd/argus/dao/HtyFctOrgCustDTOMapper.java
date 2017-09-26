package cn.htd.argus.dao;

import cn.htd.argus.dto.HtyFctOrgCustDTO;

import java.util.List;

public interface HtyFctOrgCustDTOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(HtyFctOrgCustDTO record);

    int insertSelective(HtyFctOrgCustDTO record);

    HtyFctOrgCustDTO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HtyFctOrgCustDTO record);

    int updateByPrimaryKey(HtyFctOrgCustDTO record);

    List<HtyFctOrgCustDTO> select(HtyFctOrgCustDTO model);
}