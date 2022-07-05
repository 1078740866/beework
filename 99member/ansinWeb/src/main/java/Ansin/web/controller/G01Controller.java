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
import Ansin.web.bean.B0501ListBean;
import Ansin.web.bean.G01DetailBean;
import Ansin.web.bean.G01ListBean;
import Ansin.web.bean.IndustryMstBean;
import Ansin.web.bean.TestGoods2TblBean;
import Ansin.web.bean.TrainingInfoTblBean;
import Ansin.web.entity.TestGoods2Entity;
import Ansin.web.entity.UserTblEntity;
import Ansin.web.service.G01Service;
import Ansin.web.serviceimpl.IB0501ServiceImpl;
import Ansin.web.serviceimpl.IG01ServiceImpl;
import Ansin.web.vueForm.B0501VueForm;
import Ansin.web.vueForm.G01VueForm;

@RestController
@RequestMapping("/getdata")
public class G01Controller {

	@Autowired
	private IG01ServiceImpl G01Service;

	/**
	 * 商品一覧画面、商品一覧を取得
	 */
	@RequestMapping(value = "/init", method = RequestMethod.POST)
	public CommonResult<G01ListBean> init(@RequestBody @Valid G01VueForm vueForm, HttpSession session,
			BindingResult results) {

		if (results.hasErrors()) {
			return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
		}

		List<TestGoods2TblBean> TestGoods2TblBean = G01Service.getAllGoods2();

		G01ListBean TestgoodsEntity = new G01ListBean();

		TestgoodsEntity.setTestGoods2TblBean(TestGoods2TblBean);

		return CommonResult.success(TestgoodsEntity);
	}

	/**
	 * 商品詳細画面、商品詳細情報を取得（jsoupを利用し、他サイトよりデータを採集）
	 */
	@RequestMapping(value = "/detail", method = RequestMethod.POST)
	public CommonResult<G01DetailBean> detail(@RequestBody @Valid G01VueForm vueForm, HttpSession session,
			BindingResult results) {

		if (results.hasErrors()) {
			return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
		}

		//他サイトよりデータを採集
		G01DetailBean g01DetailBean = new G01DetailBean();
		

		return CommonResult.success(g01DetailBean);
	}

}
