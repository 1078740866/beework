package Ansin.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import Ansin.exception.BusinessException;
import Ansin.exception.CommonReturnType;
import Ansin.exception.EmBusinessError;

@Controller
@RequestMapping("/GetData")
public class Test2Controller {

	@RequestMapping("/")
	@ResponseBody
	public String testSpringBoot() {
		return "恭喜您！测试成功，您可以开心的编写代码了，码农哥哥！";
	}
	
}