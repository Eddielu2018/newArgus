package cn.htd.argus.controller;

import cn.htd.argus.emuns.ResultCodeEnum;
import cn.htd.argus.util.PropertyUtil;
import cn.htd.argus.util.RestResult;
import cn.htd.common.ExecuteResult;
import cn.htd.membercenter.dto.MemberDetailInfo;
import cn.htd.membercenter.service.MemberBaseInfoService;
import cn.htd.usercenter.dto.LoginResDTO;
import cn.htd.usercenter.service.UserExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangtp on 2017/10/25.
 */
@RestController
@RequestMapping("/login")
public class ArgusLoginController {

    @Autowired
    private MemberBaseInfoService memberBaseInfoService;
    @Autowired
    private UserExportService userExportService;
    @Autowired
    PropertyUtil propertyUtil;


    /**
     * 登录验证
     * @param userId
     * @return
     */
    @RequestMapping(value = "/validate")
    public RestResult loginValidate (@RequestParam(value = "userId", required = false)  String userId,
                               @RequestParam(value = "ticket", required = false)  String ticket,
                               @RequestParam(value = "accessChannel ", required = false)  String accessChannel ){
        RestResult result = new RestResult();
        Map<String,String> map1 = new HashMap<String,String>();
        if("1".equals(accessChannel)){
            map1.put("vmsUrl", propertyUtil.getNewVmsUrl());
        }else if("2".equals(accessChannel)){
            map1.put("vmsUrl", propertyUtil.getVmsUrl());
        }else{
            map1.put("vmsUrl", propertyUtil.getVmsUrl());
        }
        ExecuteResult<LoginResDTO> executeResult = userExportService.validTicket(ticket);
        if(null != executeResult.getResult()){
            ExecuteResult<MemberDetailInfo> memberdetailinfo = memberBaseInfoService
                    .getMemberDetailBySellerId(executeResult.getResult().getCusCompanyId());
            if (memberdetailinfo.isSuccess() && memberdetailinfo.getResult() != null
                    && memberdetailinfo.getResult().getMemberBaseInfoDTO() != null){
                String erpCode = memberdetailinfo.getResult().getMemberBaseInfoDTO().getCompanyCode();
                String erpName = memberdetailinfo.getResult().getMemberBaseInfoDTO().getCompanyName();
                map1.put("erpCode",erpCode);
                map1.put("erpName",erpName);
                if(erpCode.equals(userId)){
                    //登录
                    result.setCode(ResultCodeEnum.LOGIN_SUCCESS.getCode());
                    result.setMsg(ResultCodeEnum.LOGIN_SUCCESS.getMsg());
                    result.setData(map1);
                }else{
                    //未登录
                    result.setCode(ResultCodeEnum.LOGIN_FAIL.getCode());
                    result.setMsg(ResultCodeEnum.LOGIN_FAIL.getMsg());
                    result.setData(map1);
                }
            }else{
                //商家不存在
                result.setCode(ResultCodeEnum.ERROR_IS_NOT_MENBER.getCode());
                result.setMsg(ResultCodeEnum.ERROR_IS_NOT_MENBER.getMsg());
                result.setData(map1);
            }
        }else{
            //登录超时
            result.setCode(ResultCodeEnum.LOGIN_TIMEOUT.getCode());
            result.setMsg(ResultCodeEnum.LOGIN_TIMEOUT.getMsg());
            result.setData(map1);
        }
        return result;
    }

}
