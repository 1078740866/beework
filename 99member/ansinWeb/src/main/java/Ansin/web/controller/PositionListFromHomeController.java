package Ansin.web.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import Ansin.web.api.CommonResult;
import Ansin.web.bean.CompanyAndUserBean;
import Ansin.web.bean.PositionListFromHomeBean;
import Ansin.web.serviceimpl.IPositionListFromHomeServiceImpl;
import Ansin.web.vueForm.HomeVueForm;

/**
 * home	
 * @author 呂培楠
 *
 */
@RestController
@RequestMapping("/positionListFromHome")
public class PositionListFromHomeController {
	
	@Autowired
    private IPositionListFromHomeServiceImpl positionListFromHomeService;
	
	/**
	   *   検索ボタンまたは業種または職種をクリックして、職位情報を取得
	 * @return CommonResult<PositionForHomeListBean>
	 */
	@RequestMapping(value = "/getPositionBySearchId", method = {RequestMethod.POST })
	public CommonResult<List<PositionListFromHomeBean>> getPositionBySearchId(@RequestBody @Valid HomeVueForm homeVueForm,HttpSession session,BindingResult results) {
		return CommonResult.success(positionListFromHomeService.getPositionBySearchIdResponse(homeVueForm));
	}
	
	/**
	   *   会社すべて情報を取得
	 * @return CommonResult<CompanyListBean>
	 * @throws IOException 
	 */
	@RequestMapping(value = "/getCompanyById", method = {RequestMethod.POST })
	public CommonResult<CompanyAndUserBean> getCompanyById(@RequestBody @Valid JSONObject companyId,HttpSession session,BindingResult results) throws IOException {
		// 会社ID取得
		Map<String, Object> jsonToMap =  JSONObject.parseObject(companyId.toJSONString());
		Integer cId = (Integer)jsonToMap.get("companyId");
		
		//会社情報取得
		CompanyAndUserBean bean = positionListFromHomeService.getCompanyById(cId);
				
		CompanyAndUserBean bean2 = positionListFromHomeService.confirmOutput(bean);
		
		return CommonResult.success(bean2);
	}
	
	/**
	   *   会社の職位情報を取得
	 * @return CommonResult<PositionForHomeListBean>
	 */
	@RequestMapping(value = "/getPositionByCompany", method = {RequestMethod.POST })
	public CommonResult<List<PositionListFromHomeBean>> getPositionByCompany(@RequestBody @Valid JSONObject companyId,HttpSession session,BindingResult results) {
		// 会社ID取得
		Map<String, Object> jsonToMap =  JSONObject.parseObject(companyId.toJSONString());
		Integer cId = (Integer) jsonToMap.get("companyId");
				
		List<PositionListFromHomeBean> beans = positionListFromHomeService.getPositionByCompany(cId);
		
		return CommonResult.success(beans);
	}
	
	
}
