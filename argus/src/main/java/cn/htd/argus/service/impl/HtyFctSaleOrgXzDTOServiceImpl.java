package cn.htd.argus.service.impl;

import cn.htd.argus.bean.HtyFctSaleSearchDTO;
import cn.htd.argus.bean.SaleXzsDTO;
import cn.htd.argus.dao.HtyFctSaleOrgXzDTOMapper;
import cn.htd.argus.dto.HtyFctSaleOrgXzDTO;
import cn.htd.argus.service.HtyFctSaleOrgXzDTOService;
import cn.htd.argus.util.ArithUtil;
import cn.htd.argus.util.DateTimeUtil;
import cn.htd.argus.util.DateUtil;
import com.alibaba.dubbo.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangtp on 2017/10/10.
 */
public class HtyFctSaleOrgXzDTOServiceImpl implements HtyFctSaleOrgXzDTOService{

    @Autowired
    private HtyFctSaleOrgXzDTOMapper dao;

    @Override
    public HtyFctSaleOrgXzDTO selectByOrgCode(String userId) {
        if (userId == null) {
            throw new IllegalArgumentException("userId id is null");
        }
        HtyFctSaleOrgXzDTO dto = new HtyFctSaleOrgXzDTO();
        dto.setOrgCode(userId);
        return dao.selectByOrgCode(dto);
    }

    @Override
    public List<SaleXzsDTO> selectBySearchDTO(HtyFctSaleSearchDTO searchDTO) {
        int z=0;
        if(searchDTO.getEndTime() == null){
            String endTime = DateUtil.getCurDateStr1("yyyyMM");
            searchDTO.setEndTime(endTime);
            z = 1;
        }

        List<HtyFctSaleOrgXzDTO> list = dao.selectByMonthSearchDTO(searchDTO);
        if (z == 1){searchDTO.setEndTime(null);}
        List<SaleXzsDTO> dtos = new ArrayList<SaleXzsDTO>();
        if(list != null){
            for(HtyFctSaleOrgXzDTO i:list){
                SaleXzsDTO dto = new SaleXzsDTO();
                dto.setDateKey(i.getDateKey());
                //1销售额
                dto.setXsAmt(i.getXsAmt());
                dto.setXsAmtXz(ArithUtil.div(i.getXsAmt().doubleValue(), i.getOrgNum().doubleValue(), 2));
                //2订单数
                dto.setCnt(i.getCnt());
                dto.setCntXz(ArithUtil.div(i.getCntXz().doubleValue(), i.getOrgNum().doubleValue(), 2));
                //3毛利率
                BigDecimal rate = ArithUtil.div(i.getXsZhMl().doubleValue(), i.getXsZySr().doubleValue(), 2);
                dto.setRate(ArithUtil.div(rate.doubleValue(), i.getOrgNum().doubleValue(), 2));
                BigDecimal rateXz = ArithUtil.div(i.getXsZhMlXz().doubleValue(), i.getXsZySrXz().doubleValue(), 2);
                dto.setRateXz(ArithUtil.div(rateXz.doubleValue(), i.getOrgNum().doubleValue(), 2));
                dtos.add(dto);
            }
        }else{
            return null;
        }
        return dtos;
    }

    @Override
    public List<SaleXzsDTO> selectByMonthDTO(String userId, String endTime, String dateType) {
        HtyFctSaleSearchDTO param = new HtyFctSaleSearchDTO();
        List<HtyFctSaleOrgXzDTO> list = new ArrayList<HtyFctSaleOrgXzDTO>();
        if(StringUtils.isNotEmpty(userId)){
            param.setUserId(userId);
        }
        if("1".equals(dateType)){
            //年
            if(StringUtils.isNotEmpty(endTime)){
                endTime  = endTime.substring(0, 4);
            }else{
                endTime = DateUtil.getCurDateStr1("yyyy");
            }
            for(int i = 1; i<13 ; i++){
                //月份
                String month = endTime + String.format("%02d",i);
                param.setEndTime(month);

                HtyFctSaleOrgXzDTO htyFctSaleOrgXzDTO = dao.selectByYearSearchDTO(param);
                if(htyFctSaleOrgXzDTO != null){
                    htyFctSaleOrgXzDTO.setDateKey(month);
                    list.add(htyFctSaleOrgXzDTO);
                }
            }
        }else if("0".equals(dateType)){
            //月
            if(StringUtils.isNotEmpty(endTime)){
                endTime  = endTime.substring(0, 6);
            }else{
                endTime = DateUtil.getCurDateStr1("yyyyMM");
            }
            param.setEndTime(endTime);
            list = dao.selectByMonthSearchDTO(param);
        }else if("2".equals(dateType)){
            //季
            if(StringUtils.isNotEmpty(endTime)){
                endTime  = endTime.substring(0, 6);
            }else{
                endTime = DateUtil.getCurDateStr1("yyyyMM");
            }
            String lastTime = DateUtil.getLastMonthChar7(endTime);
            String startTime = DateUtil.getLastMonthChar7(lastTime);
            param.setEndTime(startTime);
            HtyFctSaleOrgXzDTO htyFctSaleOrgXzDTO = dao.selectByYearSearchDTO(param);
            param.setEndTime(lastTime);
            HtyFctSaleOrgXzDTO htyFctSaleOrgXzDTO2 = dao.selectByYearSearchDTO(param);
            param.setEndTime(endTime);
            HtyFctSaleOrgXzDTO htyFctSaleOrgXzDTO3 = dao.selectByYearSearchDTO(param);
            if(htyFctSaleOrgXzDTO != null){
                htyFctSaleOrgXzDTO.setDateKey(startTime);
                list.add(htyFctSaleOrgXzDTO);
            }else{
                HtyFctSaleOrgXzDTO htyFctSaleOrgXzDTO4 = new HtyFctSaleOrgXzDTO();
                htyFctSaleOrgXzDTO4.setDateKey(startTime);
                htyFctSaleOrgXzDTO4.setXsAmt(new BigDecimal(0));
                htyFctSaleOrgXzDTO4.setOrgNum(0);
                htyFctSaleOrgXzDTO4.setCnt(0);
                list.add(htyFctSaleOrgXzDTO4);
            }
            if(htyFctSaleOrgXzDTO2 != null){
                htyFctSaleOrgXzDTO2.setDateKey(lastTime);
                list.add(htyFctSaleOrgXzDTO2);
            }else{
                HtyFctSaleOrgXzDTO htyFctSaleOrgXzDTO5 = new HtyFctSaleOrgXzDTO();
                htyFctSaleOrgXzDTO5.setDateKey(lastTime);
                htyFctSaleOrgXzDTO5.setXsAmt(new BigDecimal(0));
                htyFctSaleOrgXzDTO5.setOrgNum(0);
                htyFctSaleOrgXzDTO5.setCnt(0);
                list.add(htyFctSaleOrgXzDTO5);
            }
            if(htyFctSaleOrgXzDTO3 != null){
                htyFctSaleOrgXzDTO3.setDateKey(endTime);
                list.add(htyFctSaleOrgXzDTO3);
            }else{
                HtyFctSaleOrgXzDTO htyFctSaleOrgXzDTO6 = new HtyFctSaleOrgXzDTO();
                htyFctSaleOrgXzDTO6.setDateKey(endTime);
                htyFctSaleOrgXzDTO6.setXsAmt(new BigDecimal(0));
                htyFctSaleOrgXzDTO6.setOrgNum(0);
                htyFctSaleOrgXzDTO6.setCnt(0);
                list.add(htyFctSaleOrgXzDTO6);
            }
        }

        List<SaleXzsDTO> dtos = new ArrayList<SaleXzsDTO>();
        if(list != null){
            for(HtyFctSaleOrgXzDTO i:list){
                SaleXzsDTO dto = new SaleXzsDTO();
                dto.setDateKey(i.getDateKey());
                //1销售额
                dto.setXsAmt(i.getXsAmt());
                if(i.getOrgNum().intValue() >0){
                    dto.setXsAmtXz(ArithUtil.div(i.getXsAmtXz().doubleValue(), i.getOrgNum().doubleValue(), 4));
                }else{
                    dto.setXsAmtXz(new BigDecimal(0));
                }

                //2订单数
                dto.setCnt(i.getCnt());
                if(i.getOrgNum().intValue() >0 ){
                    dto.setCntXz(ArithUtil.div(i.getCntXz().doubleValue(), i.getOrgNum().doubleValue(), 4));
                }else{
                    dto.setCntXz(new BigDecimal(0));
                }

                //3毛利率
                if(i.getXsZySr() != null && i.getXsZySr().intValue() != 0 && i.getOrgNum().intValue() >0){
                    BigDecimal rate = ArithUtil.div(i.getXsZhMl().doubleValue(), i.getXsZySr().doubleValue(), 4);
                    dto.setRate(ArithUtil.mul(rate.doubleValue(),100));

                    BigDecimal rateXz = ArithUtil.div(i.getXsZhMlXz().doubleValue(), i.getXsZySrXz().doubleValue(), 4);
                    rateXz = ArithUtil.mul(rateXz.doubleValue(),100);
                    dto.setRateXz(ArithUtil.div(rateXz.doubleValue(), i.getOrgNum().doubleValue(), 4));
                }else{
                    dto.setRate(new BigDecimal(0));
                    dto.setRateXz(new BigDecimal(0));
                }
                dtos.add(dto);
            }
        }else{
            return null;
        }
        return dtos;
    }
}
