package cn.htd.argus.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/test")
public class AreaController {
	Logger logger = LoggerFactory.getLogger(AreaController.class);

	@RequestMapping("/test")
	public String test1() {
		
		return "abc";
	}
	
	@RequestMapping("/test2")
    public String handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		logger.debug("123231321");
        return "213";

    }
}
