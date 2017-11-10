package cn.htd.argus.service;

import cn.htd.argus.dto.HtyFctL2DupontDTO;

/**
 * Created by wangtp on 2017/10/31.
 */
public interface HtyFctL2DupontDTOService {

    HtyFctL2DupontDTO select(String userId,String endTime);

    HtyFctL2DupontDTO selectTb(String userId,String endTime);
}
