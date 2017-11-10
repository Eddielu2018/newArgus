package cn.htd.argus.dao;

import java.util.List;
import cn.htd.argus.dto.HtyFctOrgValueDTO;

public interface HtyFctOrgValueDTOMapper {

    HtyFctOrgValueDTO selectByPrimaryKey(Long id);

    List<HtyFctOrgValueDTO> select(HtyFctOrgValueDTO model);

    HtyFctOrgValueDTO selectByOrgCode(HtyFctOrgValueDTO model);
    
    Integer selectSortNumForHead(HtyFctOrgValueDTO model);
    
    Integer selectSortNumForBranch(HtyFctOrgValueDTO model);
    
    HtyFctOrgValueDTO selectOrgMax(HtyFctOrgValueDTO model);
    
}