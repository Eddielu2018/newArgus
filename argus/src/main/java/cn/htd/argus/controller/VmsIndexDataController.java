package cn.htd.argus.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.htd.argus.service.VmsIndexDataService;

@RestController
@RequestMapping("vmsindex")
public class VmsIndexDataController {
	@Resource
	private VmsIndexDataService vmsIndexDataService;
	
	@RequestMapping("queryVMSIndexData")
	public Map<String,Object> queryVMSIndexData(){
		vmsIndexDataService.queryVmsIndexData("0801");
		return vmsIndexDataService.queryPagedHtyFctMemberStock("0801", 10, 1);
	}
}
