package cn.htd.argus.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/test2")
public class Test2Controller {
	Logger logger = LoggerFactory.getLogger(Test2Controller.class);

	@RequestMapping("/test2")
    public String handleRequest(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        return "index";
    }
	
}
