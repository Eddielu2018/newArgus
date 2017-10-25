package cn.htd.argus.service;

import java.util.List;

import cn.htd.argus.bean.HtyFctUserBeHaviorSearchDTO;
import cn.htd.argus.dto.HtyFctXwB2bConvFunnelDTO;

public interface HtyFctXwB2bConvFunnelDTOService {
	List<HtyFctXwB2bConvFunnelDTO> queryStepSequenceNum(HtyFctUserBeHaviorSearchDTO htyFctUserBeHaviorSearchDTO);
	List<HtyFctXwB2bConvFunnelDTO> queryByPaySuccessNextDay();
}
