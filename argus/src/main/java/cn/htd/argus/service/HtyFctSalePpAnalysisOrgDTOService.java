package cn.htd.argus.service;

import cn.htd.argus.dto.HtyFctSalePpAnalysisOrgDTO;

import java.util.List;

/**
 * Created by wangtp on 2017/12/18.
 */
public interface HtyFctSalePpAnalysisOrgDTOService {

    List<HtyFctSalePpAnalysisOrgDTO> querySalePpAnalysisOrg(String userId, String endTime, String isEndflag, String plCode);
}
