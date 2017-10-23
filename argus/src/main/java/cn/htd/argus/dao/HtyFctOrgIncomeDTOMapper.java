package cn.htd.argus.dao;

import cn.htd.argus.dto.HtyFctOrgIncomeDTO;

import java.math.BigDecimal;
import java.util.List;

public interface HtyFctOrgIncomeDTOMapper {

    HtyFctOrgIncomeDTO selectByPrimaryKey(Long id);

    List<HtyFctOrgIncomeDTO> select(HtyFctOrgIncomeDTO model);

    HtyFctOrgIncomeDTO selectByOrgCode(HtyFctOrgIncomeDTO model);
    
    List<HtyFctOrgIncomeDTO> selectYear(HtyFctOrgIncomeDTO model);
    
    Integer selectSortNumForHead(HtyFctOrgIncomeDTO model);
    
    Integer selectSortNumForBranch(HtyFctOrgIncomeDTO model);
    
    BigDecimal selectAvgHead(HtyFctOrgIncomeDTO model);
    
    BigDecimal selectAvgBrach(HtyFctOrgIncomeDTO model);
    
    List<String> selectCompanySortHead(HtyFctOrgIncomeDTO model);
    
    List<String> selectCompanySortBrach(HtyFctOrgIncomeDTO model);
}