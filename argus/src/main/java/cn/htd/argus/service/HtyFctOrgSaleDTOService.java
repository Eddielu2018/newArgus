package cn.htd.argus.service;

import java.math.BigDecimal;
import java.util.List;

import cn.htd.argus.bean.CompanySortDTO;
import cn.htd.argus.bean.HtyFctOrgSortDTO;
import cn.htd.argus.dto.HtyFctOrgSaleDTO;

/**
 * Created by wangtp on 2017/9/26.
 */
public interface HtyFctOrgSaleDTOService {

    HtyFctOrgSaleDTO selectByPrimaryKey(Long id);

    HtyFctOrgSaleDTO select(HtyFctOrgSaleDTO dto);
    
    HtyFctOrgSaleDTO selectByOrgCode(String userId,String yearMon);
    
    List<HtyFctOrgSaleDTO> selectYear(String userId,String yearMon);
    
    HtyFctOrgSortDTO selectSort(String userId,String yearMon);
    
    BigDecimal selectAvgHead(String yearMon);
    
    BigDecimal selectAvgBrach(String userId,String yearMon);
    
    List<CompanySortDTO> selectCompanySortHead(String yearMon);
    
    List<CompanySortDTO> selectCompanySortBrach(String userId,String yearMon);
}
