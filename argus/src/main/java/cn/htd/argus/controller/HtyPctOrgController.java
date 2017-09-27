package cn.htd.argus.controller;

import cn.htd.argus.dto.HtyFctOrgIncomeDTO;
import cn.htd.argus.dto.HtyFctOrgValueDTO;
import cn.htd.argus.emuns.ResultCodeEnum;
import cn.htd.argus.service.HtyFctOrgIncomeDTOService;
import cn.htd.argus.service.HtyFctOrgValueDTOService;
import cn.htd.argus.util.RestResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangtp on 2017/9/27.
 */
@RestController
@RequestMapping("/htypctorg")
public class HtyPctOrgController {
    Logger logger = LoggerFactory.getLogger(HtyPctOrgController.class);

    @Autowired
    private HtyFctOrgValueDTOService htyFctOrgValueDTOService;

    @Autowired
    private HtyFctOrgIncomeDTOService htyFctOrgIncomeDTOService;

    /**
     * 首页头部
     * @param userId
     * @return
     */
    @SuppressWarnings("rawtypes")
    @RequestMapping("/index/handle")
    public RestResult indexForHandle(@RequestParam(value = "userId", required = true) Long userId) {
        RestResult result = new RestResult();
        ObjectMapper mapper = new ObjectMapper();
        logger.info("调用(HtyPctOrgController.indexForHandle)埋点信息获取入参，userId="+userId);
        try {
            HtyFctOrgValueDTO htyFctOrgValueDTO = this.htyFctOrgValueDTOService.selectByOrgCode(userId);
            if(htyFctOrgValueDTO != null){
                String json = mapper.writeValueAsString(htyFctOrgValueDTO);
                result.setData(json);
                result.setCode(ResultCodeEnum.SUCCESS.getCode());
                result.setMsg(ResultCodeEnum.SUCCESS.getMsg());
            }else{
                result.setCode(ResultCodeEnum.FAIL.getCode());
                result.setMsg(ResultCodeEnum.FAIL.getMsg());
            }
        } catch (Exception e) {
            logger.error("获取首页头部错误" + e);
            result.setCode(ResultCodeEnum.ERROR_SERVER_EXCEPTION.getCode());
            result.setMsg(ResultCodeEnum.ERROR_IS_NOT_MENBER.getMsg());
        }
        return result;
    }

    /**
     * 首页左侧+中间
     * @param userId
     * @return
     */
    @SuppressWarnings("rawtypes")
    @RequestMapping("/index/whole")
    public RestResult indexForWhole(@RequestParam(value = "userId", required = true) Long userId) {
        RestResult result = new RestResult();
        ObjectMapper mapper = new ObjectMapper();
        logger.info("调用(HtyPctOrgController.indexForWhole)埋点信息获取入参，userId="+userId);
        try {
            HtyFctOrgIncomeDTO htyFctOrgIncomeDTO= this.htyFctOrgIncomeDTOService.selectByOrgCode(userId);
            if(htyFctOrgIncomeDTO != null){
                String json = mapper.writeValueAsString(htyFctOrgIncomeDTO);
                result.setData(json);
                result.setCode(ResultCodeEnum.SUCCESS.getCode());
                result.setMsg(ResultCodeEnum.SUCCESS.getMsg());
            }else{
                result.setCode(ResultCodeEnum.FAIL.getCode());
                result.setMsg(ResultCodeEnum.FAIL.getMsg());
            }
        } catch (Exception e) {
            logger.error("首页左侧+中间错误" + e);
            result.setCode(ResultCodeEnum.ERROR_SERVER_EXCEPTION.getCode());
            result.setMsg(ResultCodeEnum.ERROR_IS_NOT_MENBER.getMsg());
        }
        return result;
    }
}
