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
	List<HtyFctXwB2bConvFunnelDTO> queryByPaySuccessNextDay(@Param("htyUserBeHaviorSearchDTO") HtyFctUserBeHaviorSearchDTO htyFctUserBeHaviorSearchDTO);

    List<HtyFctXwB2bConvFunnelDTO>queryByProAndCity(@Param("htyFctXwB2bConvFunnelDTO")HtyFctXwB2bConvFunnelDTO htyFctXwB2bConvFunnelDTO,@Param("htyUserBeHaviorSearchDTO") HtyFctUserBeHaviorSearchDTO htyFctUserBeHaviorSearchDTO);
    HtyFctXwB2bConvFunnelDTO queryCityName(@Param("htyUserBeHaviorSearchDTO") HtyFctUserBeHaviorSearchDTO htyFctUserBeHaviorSearchDTO);
    HtyFctXwB2bConvFunnelDTO queryProName(@Param("htyUserBeHaviorSearchDTO") HtyFctUserBeHaviorSearchDTO htyFctUserBeHaviorSearchDTO);
    List<HtyFctXwB2bConvFunnelDTO> queryByProAndCityRepeat(@Param("htyFctXwB2bConvFunnelDTO")HtyFctXwB2bConvFunnelDTO htyFctXwB2bConvFunnelDTO,@Param("htyUserBeHaviorSearchDTO") HtyFctUserBeHaviorSearchDTO htyFctUserBeHaviorSearchDTO);
}
