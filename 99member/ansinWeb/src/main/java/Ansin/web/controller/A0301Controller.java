package Ansin.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Ansin.web.api.CommonResult;
import Ansin.web.bean.A0301ListBean;
import Ansin.web.serviceimpl.IA0301ServiceImpl;
import Ansin.web.vueForm.A0301VueForm;
/**
 * A0301_管理者一覧画面
 * @author 楊卿赫
 *
 */
@RestController
@RequestMapping("/A0301")
public class A0301Controller {

	@Autowired
	private IA0301ServiceImpl iA0301ServiceImpl;


	/**
	 * 管理者一覧初期表示と検索ボタン押下
	 * @param a0301VueForm
	 * @return List<UserTblBean>
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public CommonResult<List<A0301ListBean>> search(@RequestBody @Valid A0301VueForm a0301VueForm, BindingResult results) {

		if (results.hasErrors()) {
			return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
		}

		//管理者一覧初期表示と検索ボタン押下の場合、管理者一覧を表示する。
		return CommonResult.success(iA0301ServiceImpl.getUserList(a0301VueForm));
	}

	/**
	 * ブロックボタン又は削除ボタン押下
	 * @param a0301VueForm
	 * @return List<UserTblBean>
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public CommonResult<List<A0301ListBean>> changeUse(@RequestBody A0301VueForm a0301VueForm) {

		int count = 0;
		String eventFlg = a0301VueForm.getEventFlg();
		if ("2".equals(eventFlg)) {
			//ボタン押下、データ更新
			count = iA0301ServiceImpl.changeUse(a0301VueForm);
		} else if ("3".equals(eventFlg)) {
			count = iA0301ServiceImpl.changeDel(a0301VueForm);
		}

		if (count == 0) {
			//失敗の場合
			return CommonResult.failed("失敗");
		}else {
			//成功の場合ユーザーリストを戻す
			return CommonResult.success(iA0301ServiceImpl.getUserList(a0301VueForm));
		}
	}

}
