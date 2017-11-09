package cn.htd.argus.service;

import cn.htd.argus.dto.EdwFctL2OkrKpiFinanceDTO;

/**
 * Created by wangtp on 2017/11/9.
 */
public interface EdwFctL2OkrKpiFinanceDTOService {
    EdwFctL2OkrKpiFinanceDTO select(String userId,String endTime);
}
