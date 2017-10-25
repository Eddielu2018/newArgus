package cn.htd.argus.service;

import java.util.List;

import cn.htd.argus.bean.HtyFctUserBeHaviorSearchDTO;
import cn.htd.argus.dto.HtyFctXwB2bLndPageDTO;

public interface HtyFctXwB2bLndPageDTOService {
	List<HtyFctXwB2bLndPageDTO> queryAllAccessQty(HtyFctUserBeHaviorSearchDTO htyFctUserBeHaviorSearchDTO);
}
