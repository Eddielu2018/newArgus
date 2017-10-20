package cn.htd.argus.service;

import cn.htd.argus.bean.SaleProdDTO;
import cn.htd.argus.dto.HtyFctSaleOrgProdDTO;
import cn.htd.common.Pager;

import java.util.List;

/**
 * Created by wangtp on 2017/10/10.
 */
public interface HtyFctSaleOrgProdDTOService {

    HtyFctSaleOrgProdDTO selectByOrgCode(String userId);

    Long queryPageCount(String userId, String startTime, String endTime);

    Long queryPageSumCount(String userId, String startTime, String endTime);

    List<SaleProdDTO> queryPage(String userId, String sort, String startTime, String endTime,Pager pager);
}
