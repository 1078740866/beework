package Ansin.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Ansin.web.api.CommonResult;
import Ansin.web.bean.A0601Bean;
import Ansin.web.bean.A0601ListBean;
import Ansin.web.entity.UserTblEntity;
import Ansin.web.serviceimpl.IA0601ServiceImpl;
import Ansin.web.vueForm.A0601VueForm;
/**
 * A0601_通報一覧画面
 * @author 楊卿赫
 *
 */
@RestController
@RequestMapping("/A0601")
public class A0601Controller {
		
	@Autowired
    private IA0601ServiceImpl iA0601ServiceImpl;
	
	/**
	 * A0601通報一覧情報取得
	 * @return <List<A0601Bean>
	 * @throws IOException 
	 */
	@RequestMapping(value = "/init", method = RequestMethod.POST)
    public CommonResult<A0601Bean> Init(@RequestBody @Valid A0601VueForm a0601VueForm
    		,HttpSession session,BindingResult results) throws IOException {
		
		A0601Bean bean = new A0601Bean();
		
		//LIST取得
		List<A0601ListBean> beans = iA0601ServiceImpl.getAll(a0601VueForm);
		
		List<A0601ListBean> beanOutPut = iA0601ServiceImpl.confirmOutput(beans);
		
		//総件数取得
		String count = iA0601ServiceImpl.getCount(a0601VueForm);
		
		bean.setBean(beanOutPut);

		bean.setCount(count);
		
		return CommonResult.success(bean);
    }
	
	/**
	 * A0601単数通報または複数通報処理
	 * @param a070101VueForm
	 * @param session
	 * @param results
	 * @return List<A0601Bean>
	 * @throws IOException 
	 */
	@RequestMapping(value = "/updateSection", method = {RequestMethod.POST })
	 public CommonResult<A0601Bean> updateSection(@RequestBody @Valid A0601VueForm a0601VueForm,HttpSession session,BindingResult results) throws IOException {
		
		if (results.hasErrors()) {
			return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
		}
		
		//SESSIONから会社IDとユーザーコードを取得
		UserTblEntity user = (UserTblEntity) session.getAttribute("USERA");
		a0601VueForm.setUserCd(user.getUserCd());
		
		//通報処理
		int count = iA0601ServiceImpl.getSection(a0601VueForm);
		
		if (count == 0) {
			return CommonResult.failed();
		}else {
			
			A0601Bean bean1 = new A0601Bean();
			
			A0601VueForm a0601VueForm1 = new A0601VueForm();
			
			//LIST取得
			List<A0601ListBean> beans = iA0601ServiceImpl.getAll(a0601VueForm1);
			
			List<A0601ListBean> beanOutPut = iA0601ServiceImpl.confirmOutput(beans);
			
			//総件数取得
			String count1 = iA0601ServiceImpl.getCount(a0601VueForm);
			
			bean1.setBean(beanOutPut);

			bean1.setCount(count1);
			
			return CommonResult.success(bean1);
		}
		
	}

}
