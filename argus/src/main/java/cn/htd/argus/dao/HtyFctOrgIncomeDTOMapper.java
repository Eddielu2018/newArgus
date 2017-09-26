package cn.htd.argus.dao;

import cn.htd.argus.dto.HtyFctOrgIncomeDTO;

public interface HtyFctOrgIncomeDTOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(HtyFctOrgIncomeDTO record);

    int insertSelective(HtyFctOrgIncomeDTO record);

    HtyFctOrgIncomeDTO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HtyFctOrgIncomeDTO record);

    int updateByPrimaryKey(HtyFctOrgIncomeDTO record);
}