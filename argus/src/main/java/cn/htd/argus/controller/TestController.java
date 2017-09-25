package cn.htd.argus.controller;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/test1")
public class TestController {
	Logger logger = LoggerFactory.getLogger(TestController.class);

	@RequestMapping("/test")
	public String test1() {
		
		return "abc";
	}
	
}
