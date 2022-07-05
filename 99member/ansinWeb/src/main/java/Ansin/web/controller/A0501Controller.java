package Ansin.web.controller;

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
import Ansin.web.bean.A0501Bean;
import Ansin.web.entity.UserTblEntity;
import Ansin.web.serviceimpl.IA0501ServiceImpl;
import Ansin.web.vueForm.A0501VueForm;
/**
 * A0501_広告一覧画面
 * @author 楊卿赫
 *
 */
@RestController
@RequestMapping("/A0501")
public class A0501Controller {
	
	@Autowired
	private IA0501ServiceImpl iA0501ServiceImpl;
	
	
	/**
	 * 広告一覧初期表示と検索ボタン押下
	 * @param a0501VueForm
	 * @return List<A0501Bean>
	 */
	@RequestMapping(value = "/init", method = RequestMethod.POST)
	public CommonResult<List<A0501Bean>> Init(@RequestBody @Valid A0501VueForm a0501VueForm,HttpSession session,BindingResult results) {
		
		if (results.hasErrors()) {
			return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
		}
		
		//広告一覧初期表示と検索ボタン押下の場合、広告一覧を表示する。
		return CommonResult.success(iA0501ServiceImpl.getAll(a0501VueForm));
	}
	
	/**
	 * 削除ボタン押下
	 * @param a0501VueForm
	 * @return List<A0501Bean>
	 */
	@RequestMapping(value = "/changeDel", method = RequestMethod.POST)
	public CommonResult<List<A0501Bean>> changeDel(@RequestBody @Valid A0501VueForm a0501VueForm,HttpSession session,BindingResult results) {
		
		if (results.hasErrors()) {
			return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
		}
		
		//SESSIONから会社IDとユーザーコードを取得
		UserTblEntity user = (UserTblEntity) session.getAttribute("USERA");
		a0501VueForm.setUserCd(user.getUserCd());
		
		//ボタン押下、データ更新
			int count = iA0501ServiceImpl.delete(a0501VueForm.getAdIds(), a0501VueForm.getUserCd());
		
		if (count == 0) {
			//失敗の場合
			return CommonResult.failed("失敗");
		}else {
			//成功の場合ユーザーリストを戻す
			return CommonResult.success(iA0501ServiceImpl.getAll(a0501VueForm));
		}
	}
	

}
