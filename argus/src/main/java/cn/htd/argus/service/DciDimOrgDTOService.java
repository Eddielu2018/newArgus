package cn.htd.argus.service;

import cn.htd.argus.bean.HtyFctCustAnalysisInDTO;
import cn.htd.argus.dto.DciDimOrgDTO;

/**
 * Created by wangtp on 2017/9/26.
 */
public interface DciDimOrgDTOService {
    int selectAllNum();
    
    Integer selectRegionNum(String userId);
    
    Integer selectRegionNumWithOutCust(String userId);
}
