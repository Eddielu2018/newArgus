package cn.htd.argus.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.htd.argus.bean.HtyFctUserBeHaviorSearchDTO;
import cn.htd.argus.dto.HtyFctXwB2bConvFunnelDTO;

/**
 * @author suntao
 * @since 2017/10/16
 * */
public interface HtyFctXwB2bConvFunnelDTOMapper {
	//购买漏斗转化
	List<HtyFctXwB2bConvFunnelDTO> queryStepSequenceNum(@Param("htyUserBeHaviorSearchDTO") HtyFctUserBeHaviorSearchDTO htyFctUserBeHaviorSearchDTO);
	//复购
	List<HtyFctXwB2bConvFunnelDTO> queryByPaySuccessNextDay();
}
