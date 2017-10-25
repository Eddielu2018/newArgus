package cn.htd.argus.service;

import java.util.List;

import cn.htd.argus.bean.HtyFctUserBeHaviorSearchDTO;
import cn.htd.argus.dto.HtyFctXwB2bItemAccessDTO;

public interface HtyFctXwB2bItemAccessDTOService {
	List<HtyFctXwB2bItemAccessDTO>	queryOneItemAccessQty(HtyFctUserBeHaviorSearchDTO htyFctUserBeHaviorSearchDTO);
}
