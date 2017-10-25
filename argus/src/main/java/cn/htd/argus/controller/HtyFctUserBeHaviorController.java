package cn.htd.argus.controller;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.common.utils.StringUtils;

import cn.htd.argus.bean.HtyFctUserBeHaviorSearchDTO;
import cn.htd.argus.bean.UserBeHaviorSearchDTO;
import cn.htd.argus.dto.HtyFctSaleCityProdDTO;
import cn.htd.argus.dto.HtyFctXwB2bConvFunnelDTO;
import cn.htd.argus.dto.HtyFctXwB2bItemAccessDTO;
import cn.htd.argus.dto.HtyFctXwB2bLndPageDTO;
import cn.htd.argus.dto.HtyFctXwB2bSearchKeyDTO;
import cn.htd.argus.emuns.ResultCodeEnum;
import cn.htd.argus.service.HtyFctSaleCityProdDTOService;
import cn.htd.argus.service.HtyFctXwB2bConvFunnelDTOService;
import cn.htd.argus.service.HtyFctXwB2bItemAccessDTOService;
import cn.htd.argus.service.HtyFctXwB2bLndPageDTOService;
import cn.htd.argus.service.HtyFctXwB2bSearchKeyDTOService;
import cn.htd.argus.util.DateUtil;
import cn.htd.argus.util.RestResult;

/**
 * Created by suntao on 2017/10/16.
 */
@RestController
@RequestMapping("/userBehavior")
public class HtyFctUserBeHaviorController {
	// 日志
	Logger logger = LoggerFactory.getLogger(HtyFctUserBeHaviorController.class);
	// 落地页面的访问数量
	@Autowired
	private HtyFctXwB2bLndPageDTOService htyFctXwB2bLndPageDTOService;
	// 搜索量
	@Autowired
	private HtyFctXwB2bSearchKeyDTOService htyFctXwB2bSearchKeyDTOService;
	// 单品的访问量
	@Autowired
	private HtyFctXwB2bItemAccessDTOService htyFctXwB2bItemAccessDTOService;
	// 单品销售数量
	@Autowired
	private HtyFctSaleCityProdDTOService htyFctSaleCityProdDTOService;
	// 漏斗转化及复购
	@Autowired
	private HtyFctXwB2bConvFunnelDTOService htyFctXwB2bConvFunnelDTOService;

	/**
	 * 用户行为
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping("/behavior/whole")
	public RestResult HtyFctUserBeHavior(
			@RequestParam(value = "startTime", required = false) String startTime,
			@RequestParam(value = "endTime", required = false) String endTime,
			@RequestParam(value = "countryName", required = false) String countryName,
			@RequestParam(value = "provinceName", required = false) String provinceName,
			@RequestParam(value = "cityName", required = false) String cityName,
            @RequestParam(value = "townName", required = false) String townName
    ) {
		RestResult result = new RestResult();
		try {
			// 1.返回值 和接受参数的对象创建
			UserBeHaviorSearchDTO userBeHaviorSearchDTO = new UserBeHaviorSearchDTO();// 返回值
			HtyFctUserBeHaviorSearchDTO htyFctUserBeHaviorSearchDTO = new HtyFctUserBeHaviorSearchDTO();// 获得参数的对象
			// 2.日期类型的转换以及参数的设置 通过alibb的封装号的代码 进行判断 bean的对象的调用
			startTime = DateUtil.conversionDate(startTime);
			endTime = DateUtil.conversionDate(endTime);
			// 从请求里组装bean包中对象的参数
			if (StringUtils.isNotEmpty(startTime)) {
				htyFctUserBeHaviorSearchDTO.setStartTime(startTime);
            }
			if (StringUtils.isNotEmpty(endTime)) {
				htyFctUserBeHaviorSearchDTO.setEndTime(endTime);
            }
			if (StringUtils.isNotEmpty(countryName)) {
				htyFctUserBeHaviorSearchDTO.setCountryName(countryName);
            }
			if (StringUtils.isNotEmpty(provinceName)) {
				htyFctUserBeHaviorSearchDTO.setProvinceName(provinceName);
            }
			if (StringUtils.isNotEmpty(cityName)) {
				htyFctUserBeHaviorSearchDTO.setCityName(cityName);
            }
            if (StringUtils.isNotEmpty(townName)) {
                htyFctUserBeHaviorSearchDTO.setTownName(townName);}
			// 关键词搜索
			List<HtyFctXwB2bSearchKeyDTO> htyFctXwB2bSearchKeyDTO = htyFctXwB2bSearchKeyDTOService
					.queryAllSearchKeyWord(htyFctUserBeHaviorSearchDTO);
			userBeHaviorSearchDTO.setHtyFctXwB2bSearchKeyDTO(htyFctXwB2bSearchKeyDTO);
			// 落地 页面的访问数量
			List<HtyFctXwB2bLndPageDTO> htyFctXwB2bLndPageDTO = htyFctXwB2bLndPageDTOService
					.queryAllAccessQty(htyFctUserBeHaviorSearchDTO);
			userBeHaviorSearchDTO.setHtyFctXwB2bLndPageDTO(htyFctXwB2bLndPageDTO);
			// 单品访问数量
			List<HtyFctXwB2bItemAccessDTO> htyFctXwB2bItemAccessDTO = htyFctXwB2bItemAccessDTOService
					.queryOneItemAccessQty(htyFctUserBeHaviorSearchDTO);
			userBeHaviorSearchDTO.setHtyFctXwB2bItemAccessDTO(htyFctXwB2bItemAccessDTO);
			// 漏斗转换及复购
			// 1漏斗购买
			List<HtyFctXwB2bConvFunnelDTO> htyFctXwB2bConvFunnelDTO = htyFctXwB2bConvFunnelDTOService
					.queryStepSequenceNum(htyFctUserBeHaviorSearchDTO);
			userBeHaviorSearchDTO.setHtyFctXwB2bConvFunnelDTO(htyFctXwB2bConvFunnelDTO);
			// 2重复购买
			List<HtyFctXwB2bConvFunnelDTO> htyFctXwB2bConvFunnelDTORepeatBuy = htyFctXwB2bConvFunnelDTOService
					.queryByPaySuccessNextDay(htyFctUserBeHaviorSearchDTO);
			userBeHaviorSearchDTO.setHtyFctXwB2bConvFunnelDTORepeatBuy(htyFctXwB2bConvFunnelDTORepeatBuy);
			// 成交单品
			List<HtyFctSaleCityProdDTO> htyFctSaleCityProdDTO = htyFctSaleCityProdDTOService
					.querySaleOutItemNum(htyFctUserBeHaviorSearchDTO);
			userBeHaviorSearchDTO.setHtyFctSaleCityProdDTO(htyFctSaleCityProdDTO);
			// 组装到 result里  响应的返回数据
			result.setData(userBeHaviorSearchDTO);
			result.setCode(ResultCodeEnum.SUCCESS.getCode());
			result.setMsg(ResultCodeEnum.SUCCESS.getMsg());
		} catch (Exception e) {
			logger.error("获取用户行为的查询" + e);
			result.setCode(ResultCodeEnum.ERROR_SERVER_EXCEPTION.getCode());
			result.setMsg(ResultCodeEnum.ERROR_IS_NOT_MENBER.getMsg());
		}
		return result;
	}
}
