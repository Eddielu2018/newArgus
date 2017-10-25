package cn.htd.argus.service;

import java.util.List;

import cn.htd.argus.bean.HtyFctUserBeHaviorSearchDTO;
import cn.htd.argus.dto.HtyFctXwB2bSearchKeyDTO;

public interface HtyFctXwB2bSearchKeyDTOService {
	List<HtyFctXwB2bSearchKeyDTO> queryAllSearchKeyWord(HtyFctUserBeHaviorSearchDTO htyFctUserBeHaviorSearchDTO);
}
