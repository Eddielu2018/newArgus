package cn.htd.argus.dao;

import java.util.List;

import cn.htd.argus.dto.HtyFctOrgCustDTO;

public interface HtyFctOrgCustDTOMapper {

    HtyFctOrgCustDTO selectByPrimaryKey(Long id);

    List<HtyFctOrgCustDTO> select(HtyFctOrgCustDTO model);
    
    HtyFctOrgCustDTO selectByOrgCode(HtyFctOrgCustDTO model);
    
    List<HtyFctOrgCustDTO> selectYear(HtyFctOrgCustDTO model);
    
    List<Integer> selectSortNumForHead(HtyFctOrgCustDTO model);
    
    List<Integer> selectSortNumForBranch(HtyFctOrgCustDTO model);
    
    Integer selectAvgHead(HtyFctOrgCustDTO model);
    
    Integer selectAvgBrach(HtyFctOrgCustDTO model);
    
    List<String> selectCompanySortHead(HtyFctOrgCustDTO model);
    
    List<String> selectCompanySortBrach(HtyFctOrgCustDTO model);
}