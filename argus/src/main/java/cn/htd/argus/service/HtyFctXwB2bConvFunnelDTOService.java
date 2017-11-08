package cn.htd.argus.service;

import java.util.List;

import cn.htd.argus.bean.HtyFctUserBeHaviorSearchDTO;
import cn.htd.argus.dto.HtyFctXwB2bConvFunnelDTO;
import org.apache.ibatis.annotations.Param;

public interface HtyFctXwB2bConvFunnelDTOService {
	List<HtyFctXwB2bConvFunnelDTO> queryStepSequenceNum(HtyFctUserBeHaviorSearchDTO htyFctUserBeHaviorSearchDTO);
	List<HtyFctXwB2bConvFunnelDTO> queryByPaySuccessNextDay(HtyFctUserBeHaviorSearchDTO htyFctUserBeHaviorSearchDTO);
    List<HtyFctXwB2bConvFunnelDTO>queryByProAndCity(HtyFctXwB2bConvFunnelDTO htyFctXwB2bConvFunnelDTO, HtyFctUserBeHaviorSearchDTO htyFctUserBeHaviorSearchDTO);
    List<HtyFctXwB2bConvFunnelDTO> queryByProAndCityRepeat(HtyFctXwB2bConvFunnelDTO htyFctXwB2bConvFunnelDTO,HtyFctUserBeHaviorSearchDTO htyFctUserBeHaviorSearchDTO);

}
