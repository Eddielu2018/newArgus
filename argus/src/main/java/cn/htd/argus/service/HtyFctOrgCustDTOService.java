package cn.htd.argus.service;

import java.util.List;

import cn.htd.argus.bean.CompanySortDTO;
import cn.htd.argus.bean.HtyFctOrgSortDTO;
import cn.htd.argus.dto.HtyFctOrgCustDTO;

/**
 * Created by wangtp on 2017/9/26.
 */
public interface HtyFctOrgCustDTOService {

    HtyFctOrgCustDTO selectByPrimaryKey(Long id);

    HtyFctOrgCustDTO select(HtyFctOrgCustDTO dto);
    
    HtyFctOrgCustDTO selectByOrgCode(String userId);
    
    List<HtyFctOrgCustDTO> selectYear(String userId,String yearMon);
    
    HtyFctOrgSortDTO selectSort(String userId,String yearMon);
    
    Integer selectAvgHead(String yearMon);
    
    Integer selectAvgBrach(String userId,String yearMon);
    
    List<CompanySortDTO> selectCompanySortHead(String yearMon);
    
    List<CompanySortDTO> selectCompanySortBrach(String userId,String yearMon);
}
