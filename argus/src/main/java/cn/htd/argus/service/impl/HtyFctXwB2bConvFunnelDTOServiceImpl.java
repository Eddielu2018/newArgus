package cn.htd.argus.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.htd.argus.bean.HtyFctUserBeHaviorSearchDTO;
import cn.htd.argus.dao.HtyFctXwB2bConvFunnelDTOMapper;
import cn.htd.argus.dto.HtyFctXwB2bConvFunnelDTO;
import cn.htd.argus.service.HtyFctXwB2bConvFunnelDTOService;

public class HtyFctXwB2bConvFunnelDTOServiceImpl implements HtyFctXwB2bConvFunnelDTOService {
	@Autowired
	private HtyFctXwB2bConvFunnelDTOMapper htyFctXwB2bConvFunnelDTOMapperDao;

	@Override
	public List<HtyFctXwB2bConvFunnelDTO> queryStepSequenceNum(
			HtyFctUserBeHaviorSearchDTO htyFctUserBeHaviorSearchDTO) {
		return htyFctXwB2bConvFunnelDTOMapperDao.queryStepSequenceNum(htyFctUserBeHaviorSearchDTO);
	}

	@Override
	public List<HtyFctXwB2bConvFunnelDTO> queryByPaySuccessNextDay() {
		return htyFctXwB2bConvFunnelDTOMapperDao.queryByPaySuccessNextDay();
	}
}
