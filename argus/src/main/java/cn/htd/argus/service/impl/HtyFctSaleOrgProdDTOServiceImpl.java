package cn.htd.argus.service.impl;

import cn.htd.argus.bean.HtyFctSaleSearchDTO;
import cn.htd.argus.bean.SaleProdDTO;
import cn.htd.argus.dao.HtyFctSaleOrgProdDTOMapper;
import cn.htd.argus.dto.HtyFctSaleOrgProdDTO;
import cn.htd.argus.service.HtyFctSaleOrgProdDTOService;
import cn.htd.argus.util.ArithUtil;
import cn.htd.common.Pager;
import com.alibaba.dubbo.common.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by wangtp on 2017/10/10.
 */
public class HtyFctSaleOrgProdDTOServiceImpl implements HtyFctSaleOrgProdDTOService{
    Logger logger = LoggerFactory.getLogger(HtyFctSaleOrgProdDTOServiceImpl.class);

    @Autowired
    private HtyFctSaleOrgProdDTOMapper dao;

    @Override
    public HtyFctSaleOrgProdDTO selectByOrgCode(String userId) {
        if (userId == null) {
            throw new IllegalArgumentException("userId id is null");
        }
        HtyFctSaleOrgProdDTO dto = new HtyFctSaleOrgProdDTO();
        dto.setOrgCode(userId);
        return dao.selectByOrgCode(dto);
    }

    @Override
    public Long queryPageCount(String userId, String startTime, String endTime) {
        if (userId == null) {
            throw new IllegalArgumentException("userId id is null");
        }
        Long count = 0L;
        try {
            HtyFctSaleSearchDTO searchDTO = new HtyFctSaleSearchDTO();
            searchDTO.setUserId(userId);
            if(StringUtils.isNotEmpty(startTime)){
                searchDTO.setStartTime(startTime);
            }
            if(StringUtils.isNotEmpty(endTime)){
                searchDTO.setStartTime(endTime);
            }
            count = dao.queryPageCount(searchDTO);
        } catch (Exception e) {
            logger.error("HtyFctSaleOrgProdDTOServiceImpl.queryPageCount:获取品牌品类销售数量错误" + e);
        }
        return count;
    }

    @Override
    public Long queryPageSumCount(String userId, String startTime, String endTime) {
        if (userId == null) {
            throw new IllegalArgumentException("userId id is null");
        }
        Long count = 0L;
        try {
            HtyFctSaleSearchDTO searchDTO = new HtyFctSaleSearchDTO();
            searchDTO.setUserId(userId);
            if(StringUtils.isNotEmpty(startTime)){
                searchDTO.setStartTime(startTime);
            }
            if(StringUtils.isNotEmpty(endTime)){
                searchDTO.setStartTime(endTime);
            }
            count = dao.queryPageSumCount(searchDTO);
        } catch (Exception e) {
            logger.error("HtyFctSaleOrgProdDTOServiceImpl.queryPageCount:获取品牌品类销售数量错误" + e);
        }
        return count;
    }

    @Override
    public List<SaleProdDTO> queryPage(String userId, String sort, String startTime, String endTime, Pager pager) {
        if (userId == null) {
            throw new IllegalArgumentException("userId id is null");
        }
        List<HtyFctSaleOrgProdDTO> list = new ArrayList<HtyFctSaleOrgProdDTO>();
        List<SaleProdDTO> dtos = new ArrayList<SaleProdDTO>();
        HtyFctSaleSearchDTO searchDTO = new HtyFctSaleSearchDTO();
        searchDTO.setUserId(userId);
        if(StringUtils.isNotEmpty(startTime)){
            searchDTO.setStartTime(startTime);
        }
        if(StringUtils.isNotEmpty(endTime)){
            searchDTO.setEndTime(endTime);
        }
        if("1".equals(sort)){
            //品类排序
            list = dao.queryCategorySumPage(searchDTO, pager);
        }else{
            //品牌排序
            list = dao.queryBrandSumPage(searchDTO, pager);
        }
        if(list != null){
            for(HtyFctSaleOrgProdDTO i:list){
                SaleProdDTO dto = new SaleProdDTO();
                dto.setPlName(i.getPlName());
                dto.setPpName(i.getPpName());
                //销售单价 XS_AMT/XS_QTY
                if(i.getXsQty().intValue() >0){
                    dto.setXsPrice(ArithUtil.div(i.getXsAmt().doubleValue(), i.getXsQty().doubleValue(), 2));
                }else{
                    dto.setXsPrice(null);
                }
                dto.setXsQty(i.getXsQty());
                dto.setXsAmt(i.getXsAmt());
                //销售金额占比XS_AMT/XS_AMT_ALL
                if(i.getXsAmtAll().intValue() >0){
                    dto.setXsRatio(ArithUtil.div(i.getXsAmt().doubleValue(), i.getXsAmtAll().doubleValue(), 2));
                }else {
                    dto.setXsRatio(null);
                }
                //平均毛利XS_SR-XS_CB
                dto.setXsAvg(ArithUtil.sub(i.getXsSr().doubleValue(), i.getXsCb().doubleValue()));
                //平均毛利率（XS_SR-XS_CB）/XS_SR
                if(i.getXsSr().intValue() >0){
                    dto.setXsAvgRatio(ArithUtil.div(dto.getXsAvg().doubleValue(), i.getXsSr().doubleValue(), 2));
                }else{
                    dto.setXsAvgRatio(null);
                }
                dtos.add(dto);
            }
        }else{
            return  null;
        }
        return dtos;
    }

}
