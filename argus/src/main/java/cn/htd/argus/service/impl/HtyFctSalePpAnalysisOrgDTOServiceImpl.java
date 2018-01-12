package cn.htd.argus.service.impl;

import cn.htd.argus.bean.HtyFctSaleSearchDTO;
import cn.htd.argus.dto.HtyFctSalePlAnalysisOrgDTO;
import cn.htd.argus.dto.HtyFctSalePpAnalysisOrgDTO;
import cn.htd.argus.mappers.HtyFctSalePpAnalysisOrgDTOMapper;
import cn.htd.argus.service.HtyFctSalePpAnalysisOrgDTOService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by wangtp on 2017/12/18.
 */
public class HtyFctSalePpAnalysisOrgDTOServiceImpl implements HtyFctSalePpAnalysisOrgDTOService {
    private Logger logger = LoggerFactory.getLogger(HtyFctSalePpAnalysisOrgDTOServiceImpl.class);

    @Autowired
    private HtyFctSalePpAnalysisOrgDTOMapper dao;

    @Override
    public List<HtyFctSalePpAnalysisOrgDTO> querySalePpAnalysisOrg(String userId, String endTime, String isEndflag, String ppCode) {
        if (userId == null) {
            throw new IllegalArgumentException("parameter erpCategoryCode is userId");
        }
        if (endTime == null) {
            throw new IllegalArgumentException("parameter erpCategoryCode is endTime");
        }
        HtyFctSaleSearchDTO searchDTO = new HtyFctSaleSearchDTO();
        searchDTO.setUserId(userId);
        searchDTO.setEndTime(endTime);
        if(ppCode != ""){
            searchDTO.setPpCode(ppCode);
        }
        searchDTO.setIsEndflag(isEndflag);
        List<HtyFctSalePpAnalysisOrgDTO> result = dao.querySalePpAnalysisOrg(searchDTO);

        if (result == null || result.isEmpty()) {
            return null;
        }
        return result;
    }
}
