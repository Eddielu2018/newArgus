package cn.htd.argus.service.impl;

import cn.htd.argus.bean.HtyFctSaleSearchDTO;
import cn.htd.argus.dto.HtyFctSalePlAnalysisOrgDTO;
import cn.htd.argus.mappers.HtyFctSalePlAnalysisOrgDTOMapper;
import cn.htd.argus.service.HtyFctSalePlAnalysisOrgDTOService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by wangtp on 2017/12/18.
 */
public class HtyFctSalePlAnalysisOrgDTOServiceImpl implements HtyFctSalePlAnalysisOrgDTOService {
    private Logger logger = LoggerFactory.getLogger(HtyFctSalePlAnalysisOrgDTOServiceImpl.class);

    @Autowired
    private HtyFctSalePlAnalysisOrgDTOMapper dao;

    @Override
    public List<HtyFctSalePlAnalysisOrgDTO> querySalePlAnalysisOrg(String userId, String endTime, String isEndflag, String plCode) {
        if (userId == null) {
            throw new IllegalArgumentException("parameter erpCategoryCode is userId");
        }
        if (endTime == null) {
            throw new IllegalArgumentException("parameter erpCategoryCode is endTime");
        }
        HtyFctSaleSearchDTO searchDTO = new HtyFctSaleSearchDTO();
        searchDTO.setUserId(userId);
        searchDTO.setEndTime(endTime);
        if(plCode != ""){
            searchDTO.setPlCode(plCode);
        }
        searchDTO.setIsEndflag(isEndflag);
        List<HtyFctSalePlAnalysisOrgDTO> result = dao.querySalePlAnalysisOrg(searchDTO);

        if (result == null || result.isEmpty()) {
            return null;
        }
        return result;
    }
}
