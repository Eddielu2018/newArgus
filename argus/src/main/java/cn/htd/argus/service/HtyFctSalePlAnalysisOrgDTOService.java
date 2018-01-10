package cn.htd.argus.service;

import cn.htd.argus.dto.HtyFctSalePlAnalysisOrgDTO;

import java.util.List;

/**
 * Created by wangtp on 2017/12/18.
 */
public interface HtyFctSalePlAnalysisOrgDTOService {

    List<HtyFctSalePlAnalysisOrgDTO> querySalePlAnalysisOrg(String userId, String endTime);
}
