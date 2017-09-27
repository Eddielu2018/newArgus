package cn.htd.argus.dao;

import cn.htd.argus.dto.HtyFctOrgIncomeDTO;

import java.util.List;

public interface HtyFctOrgIncomeDTOMapper {

    HtyFctOrgIncomeDTO selectByPrimaryKey(Long id);

    List<HtyFctOrgIncomeDTO> select(HtyFctOrgIncomeDTO model);

    HtyFctOrgIncomeDTO selectByOrgCode(Long orgCode);
}