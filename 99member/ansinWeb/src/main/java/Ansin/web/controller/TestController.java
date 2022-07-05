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
@RequestMapping("/UserLogin")
public class TestController {

	@RequestMapping("/testSpringBoot")
	@ResponseBody
	public String testSpringBoot() {
		return "恭喜您！测试成功，您可以开心的编写代码了，码农哥哥！";
	}
	
	@RequestMapping("/testyou1")
	@ResponseBody
	public CommonReturnType test() {
	    BusinessException e = new BusinessException(EmBusinessError.UNKNOWN_ERROR);
	    Map<String, Object> data = new HashMap<>();
	    data.put("errorCode", e.getErrorCode());
	    data.put("errorMsg", e.getErrorMsg());
	    // 返回的json数据就是{status:"success", data:{errorCode:10001, errorMsg:"未知错误"}}
	    return CommonReturnType.create(data, "fail");
	}
	@RequestMapping(value = "/testyou2", method = RequestMethod.POST)
	public CommonReturnType testyou2(@RequestParam(name = "id") Integer id) throws BusinessException {
	    if (id == null) {
	        throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
	    }

	    Map<String, Object> data = new HashMap<>();
	    data.put("errorCode", "HEHE");
	    data.put("errorMsg", "HEHE");
		return CommonReturnType.create(data, "fail");
	}
}