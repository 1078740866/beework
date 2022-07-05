package Ansin.web.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Ansin.web.api.CommonResult;
import Ansin.web.bean.HomeInitBean;
import Ansin.web.serviceimpl.IHomeServiceImpl;

/**
 * home	
 * @author 呂培楠
 *
 */
@RestController
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
    private IHomeServiceImpl homeService;
	
	/**
	   *   ホームページ初期化
	 * @return CommonResult<HomeInitBean>
	 */
	@RequestMapping(value = "/init", method = {RequestMethod.POST })
	public CommonResult<HomeInitBean> getHomeInitInfo() {
		HomeInitBean bean = homeService.getHomeInitResponse();
		try {
			return CommonResult.success(homeService.confirmOutput(bean));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
