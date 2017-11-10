package cn.htd.argus.service;

import cn.htd.argus.dto.EdwFctl1DupontDetailDTO;

/**
 * Created by wangtp on 2017/11/9.
 */
public interface EdwFctl1DupontDetailDTOService {
    EdwFctl1DupontDetailDTO selectTb(String userId,String endTime);
}
