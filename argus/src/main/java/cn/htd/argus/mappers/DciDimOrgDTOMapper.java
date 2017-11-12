package cn.htd.argus.mappers;

import cn.htd.argus.bean.HtyFctCustAnalysisInDTO;
import cn.htd.argus.dto.DciDimOrgDTO;

import java.util.List;

public interface DciDimOrgDTOMapper {
    
    int selectAllNum();
    
    Integer selectRegionNum(HtyFctCustAnalysisInDTO dto);
    
    Integer selectRegionNumWithOutCust(HtyFctCustAnalysisInDTO dto);
}