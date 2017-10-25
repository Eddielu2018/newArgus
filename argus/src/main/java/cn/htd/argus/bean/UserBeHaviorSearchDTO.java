package cn.htd.argus.bean;

import java.util.List;

import cn.htd.argus.dto.HtyFctSaleCityProdDTO;
import cn.htd.argus.dto.HtyFctXwB2bConvFunnelDTO;
import cn.htd.argus.dto.HtyFctXwB2bItemAccessDTO;
import cn.htd.argus.dto.HtyFctXwB2bLndPageDTO;
import cn.htd.argus.dto.HtyFctXwB2bSearchKeyDTO;

//落地页面的返回bean
public class UserBeHaviorSearchDTO {
	// 搜索量
	List<HtyFctXwB2bSearchKeyDTO> htyFctXwB2bSearchKeyDTO;
	// 落地页面访问数量
	List<HtyFctXwB2bLndPageDTO> htyFctXwB2bLndPageDTO;
	// 单品访问数量
	List<HtyFctXwB2bItemAccessDTO> htyFctXwB2bItemAccessDTO;
	// 单品销售数量
	List<HtyFctSaleCityProdDTO> htyFctSaleCityProdDTO;
	// 漏斗转化及复购
	List<HtyFctXwB2bConvFunnelDTO> htyFctXwB2bConvFunnelDTO;
	List<HtyFctXwB2bConvFunnelDTO> htyFctXwB2bConvFunnelDTORepeatBuy;

	public List<HtyFctXwB2bConvFunnelDTO> getHtyFctXwB2bConvFunnelDTORepeatBuy() {
		return htyFctXwB2bConvFunnelDTORepeatBuy;
	}

	public void setHtyFctXwB2bConvFunnelDTORepeatBuy(List<HtyFctXwB2bConvFunnelDTO> htyFctXwB2bConvFunnelDTORepeatBuy) {
		this.htyFctXwB2bConvFunnelDTORepeatBuy = htyFctXwB2bConvFunnelDTORepeatBuy;
	}

	public List<HtyFctXwB2bConvFunnelDTO> getHtyFctXwB2bConvFunnelDTO() {
		return htyFctXwB2bConvFunnelDTO;
	}

	public void setHtyFctXwB2bConvFunnelDTO(List<HtyFctXwB2bConvFunnelDTO> htyFctXwB2bConvFunnelDTO) {
		this.htyFctXwB2bConvFunnelDTO = htyFctXwB2bConvFunnelDTO;
	}

	public List<HtyFctSaleCityProdDTO> getHtyFctSaleCityProdDTO() {
		return htyFctSaleCityProdDTO;
	}

	public void setHtyFctSaleCityProdDTO(List<HtyFctSaleCityProdDTO> htyFctSaleCityProdDTO) {
		this.htyFctSaleCityProdDTO = htyFctSaleCityProdDTO;
	}

	public List<HtyFctXwB2bItemAccessDTO> getHtyFctXwB2bItemAccessDTO() {
		return htyFctXwB2bItemAccessDTO;
	}

	public void setHtyFctXwB2bItemAccessDTO(List<HtyFctXwB2bItemAccessDTO> htyFctXwB2bItemAccessDTO) {
		this.htyFctXwB2bItemAccessDTO = htyFctXwB2bItemAccessDTO;
	}

	public List<HtyFctXwB2bLndPageDTO> getHtyFctXwB2bLndPageDTO() {
		return htyFctXwB2bLndPageDTO;
	}

	public void setHtyFctXwB2bLndPageDTO(List<HtyFctXwB2bLndPageDTO> htyFctXwB2bLndPageDTO) {
		this.htyFctXwB2bLndPageDTO = htyFctXwB2bLndPageDTO;
	}

	public List<HtyFctXwB2bSearchKeyDTO> getHtyFctXwB2bSearchKeyDTO() {
		return htyFctXwB2bSearchKeyDTO;
	}

	public void setHtyFctXwB2bSearchKeyDTO(List<HtyFctXwB2bSearchKeyDTO> htyFctXwB2bSearchKeyDTO) {
		this.htyFctXwB2bSearchKeyDTO = htyFctXwB2bSearchKeyDTO;
	}
}
