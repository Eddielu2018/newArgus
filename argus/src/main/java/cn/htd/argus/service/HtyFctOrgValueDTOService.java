package cn.htd.argus.service;

import cn.htd.argus.bean.HtyFctOrgSortDTO;
import cn.htd.argus.dto.HtyFctOrgValueDTO;

/**
 * Created by wangtp on 2017/9/26.
 */
public interface HtyFctOrgValueDTOService {

    HtyFctOrgValueDTO selectByPrimaryKey(Long id);

    HtyFctOrgValueDTO select(HtyFctOrgValueDTO dto);

    HtyFctOrgValueDTO selectByOrgCode(String userId,String yearMon);
    
    HtyFctOrgSortDTO selectSort(String userId,String yearMon);
    
    HtyFctOrgValueDTO selectOrgMax(String yearMon);
}
