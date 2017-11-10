package cn.htd.argus.service.impl;

import cn.htd.argus.bean.HtyFctSaleSearchDTO;
import cn.htd.argus.dto.EdwFctl1DupontDetailDTO;
import cn.htd.argus.mappers.EdwFctl1DupontDetailDTOMapper;
import cn.htd.argus.service.EdwFctl1DupontDetailDTOService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by wangtp on 2017/11/9.
 */
public class EdwFctl1DupontDetailDTOServiceImpl implements EdwFctl1DupontDetailDTOService {

    @Autowired
    private EdwFctl1DupontDetailDTOMapper dao;

    @Override
    public EdwFctl1DupontDetailDTO selectTb(String userId, String endTime) {
        if (userId == null) {
            throw new IllegalArgumentException("userId id is null");
        }
        if (endTime == null) {
            throw new IllegalArgumentException("endTime id is null");
        }
        HtyFctSaleSearchDTO dto = new HtyFctSaleSearchDTO();
        dto.setEndTime(endTime);
        dto.setUserId(userId);
        return dao.selectTb(dto);
    }
}
