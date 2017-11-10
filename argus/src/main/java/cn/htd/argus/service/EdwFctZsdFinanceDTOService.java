package cn.htd.argus.service;

import cn.htd.argus.dto.EdwFctZsdFinanceDTO;

/**
 * Created by wangtp on 2017/11/9.
 */
public interface EdwFctZsdFinanceDTOService {
    EdwFctZsdFinanceDTO select(String userId,String endTime);

    EdwFctZsdFinanceDTO selectSupport(String userId,String endTime);

}
