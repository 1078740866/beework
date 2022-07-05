package Ansin.web.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Ansin.web.api.CommonResult;
import Ansin.web.bean.A0201Bean;
import Ansin.web.serviceimpl.IA0201ServiceImpl;
import Ansin.web.vueForm.A0201VueForm;
/**
 * A0201_応募者一覧画面
 * @author 楊卿赫
 *
 */
@RestController
@RequestMapping("/A0201")
public class A0201Controller {
	
	@Autowired
	private IA0201ServiceImpl iA0201ServiceImpl;
	
	/**
	 * 応募者一覧初期表示と検索ボタン押下
	 * @param a0201VueForm
	 * @param session
	 * @param results
	 * @return A0201Bean
	 */
	@RequestMapping(value = "/init", method = RequestMethod.POST)
	public CommonResult<A0201Bean> Init(@RequestBody @Valid A0201VueForm a0201VueForm,HttpSession session,BindingResult results) {
		
		if (results.hasErrors()) {
			return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
		}
		
		A0201Bean bean = new A0201Bean();
		//業種リストを取得
		bean.setIndustryMstBeans(iA0201ServiceImpl.getIndustryList());
		//職種リストを取得
		bean.setJobtypeMstBeans(iA0201ServiceImpl.getJobtypeList());
		//言語リストを取得
		bean.setLanMstBeans(iA0201ServiceImpl.getLanList());
		//都道府県リストを取得
		bean.setPrefecturesMstBeans(iA0201ServiceImpl.getPrefeList());
		//応募者情報リストを取得
		bean.setA0201ListBean(iA0201ServiceImpl.getApplicantList(a0201VueForm));
		
		return CommonResult.success(bean);
	}
	
	/**
	 * 削除方法
	 * @param a0201VueForm
	 * @param session
	 * @param results
	 * @return
	 */
	@RequestMapping(value = "/delete", method = {RequestMethod.POST })
	 public CommonResult<A0201Bean> delete(@RequestBody @Valid A0201VueForm a0201VueForm,HttpSession session,BindingResult results) {
		
		if (results.hasErrors()) {
			return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
		}
		
		// 削除
		int count = iA0201ServiceImpl.delete(a0201VueForm.getApplicantIds());
		
		if (count == 0 ) {
			return CommonResult.failed("失敗");
		}else {
			
			A0201Bean bean = new A0201Bean();
			//業種リストを取得
			bean.setIndustryMstBeans(iA0201ServiceImpl.getIndustryList());
			//職種リストを取得
			bean.setJobtypeMstBeans(iA0201ServiceImpl.getJobtypeList());
			//言語リストを取得
			bean.setLanMstBeans(iA0201ServiceImpl.getLanList());
			//都道府県リストを取得
			bean.setPrefecturesMstBeans(iA0201ServiceImpl.getPrefeList());
			//応募者情報リストを取得
			bean.setA0201ListBean(iA0201ServiceImpl.getApplicantList(a0201VueForm));
			
			return CommonResult.success(bean);
		}
     
	}
	

}
