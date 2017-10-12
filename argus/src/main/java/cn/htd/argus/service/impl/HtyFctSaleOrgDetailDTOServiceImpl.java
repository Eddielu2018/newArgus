package cn.htd.argus.service.impl;

import cn.htd.argus.bean.HtyFctSaleSearchDTO;
import cn.htd.argus.bean.SaleDetailDTO;
import cn.htd.argus.dao.HtyFctSaleOrgDetailDTOMapper;
import cn.htd.argus.dto.HtyFctSaleOrgDetailDTO;
import cn.htd.argus.service.HtyFctSaleOrgDetailDTOService;
import cn.htd.argus.util.ArithUtil;
import cn.htd.common.Pager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangtp on 2017/10/10.
 */
public class HtyFctSaleOrgDetailDTOServiceImpl implements HtyFctSaleOrgDetailDTOService{

    @Autowired
    private HtyFctSaleOrgDetailDTOMapper dao;

    @Override
    public HtyFctSaleOrgDetailDTO selectByOrgCode(String userId) {
        if (userId == null) {
            throw new IllegalArgumentException("userId id is null");
        }
        HtyFctSaleOrgDetailDTO dto = new HtyFctSaleOrgDetailDTO();
        dto.setOrgCode(userId);
        return dao.selectByOrgCode(dto);
    }

    @Override
    public Long queryPageCount(HtyFctSaleSearchDTO searchDTO) {
        return dao.queryPageCount(searchDTO);
    }

    @Override
    public List<SaleDetailDTO> queryPage(HtyFctSaleSearchDTO searchDTO, Pager pager) {
        List<HtyFctSaleOrgDetailDTO> list = new ArrayList<HtyFctSaleOrgDetailDTO>();
        List<SaleDetailDTO> dtos = new ArrayList<SaleDetailDTO>();
        if("0".equals(searchDTO.getXsAmt())){
            list = dao.queryBurstPage(searchDTO, pager);
        }else if("1".equals(searchDTO.getXsAmt())){
            list = dao.queryStopPage(searchDTO, pager);
        }
        if(list != null){
            for(HtyFctSaleOrgDetailDTO i:list){
                SaleDetailDTO dto = new SaleDetailDTO();
                dto.setProdName(i.getProdName());
                dto.setPpName(i.getPpName());
                dto.setPlName(i.getPlName());
                dto.setSort("");
                dto.setXsPrice(ArithUtil.div(i.getXsAmt().doubleValue(), i.getXsQty().doubleValue(), 2));
                dto.setMaxXsAmt(i.getMaxXsAmt());
                dto.setMinXsAmt(i.getMinXsAmt());
                dto.setXsQty(i.getXsQty());
                dto.setmJcQty(i.getmJcQty());
                dto.setXsAmt(i.getXsAmt());
                dto.setXsDd(i.getXsDd());
                dtos.add(dto);
            }
        }else{
            return null;
        }
        return dtos;
    }
}
