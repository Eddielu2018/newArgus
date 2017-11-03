package cn.htd.argus.dao;

import java.math.BigDecimal;
import java.util.List;

import cn.htd.argus.dto.HtyFctOrgSaleDTO;

public interface HtyFctOrgSaleDTOMapper {

    HtyFctOrgSaleDTO selectByPrimaryKey(Long id);

    List<HtyFctOrgSaleDTO> select(HtyFctOrgSaleDTO model);
    
    HtyFctOrgSaleDTO selectByOrgCode(HtyFctOrgSaleDTO model);
    
    List<HtyFctOrgSaleDTO> selectYear(HtyFctOrgSaleDTO model);
    
    Integer selectSortNumForHead(HtyFctOrgSaleDTO model);
    
    Integer selectSortNumForBranch(HtyFctOrgSaleDTO model);
    
    BigDecimal selectAvgHead(HtyFctOrgSaleDTO model);
    
    BigDecimal selectAvgBrach(HtyFctOrgSaleDTO model);
    
    List<String> selectCompanySortHead(HtyFctOrgSaleDTO model);
    
    List<String> selectCompanySortBrach(HtyFctOrgSaleDTO model);
}