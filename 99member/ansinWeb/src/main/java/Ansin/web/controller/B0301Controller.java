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
import Ansin.web.bean.ApplicantRecommendInitBean;
import Ansin.web.bean.B0301Bean;
import Ansin.web.entity.UserTblEntity;
import Ansin.web.serviceimpl.IB0301ServiceImpl;
import Ansin.web.vueForm.B0301VueForm;

/**
 * B0301人材推薦一覧画面
 * @author 劉智浩
 *
 */
@RestController
@RequestMapping("/B0301")
public class B0301Controller {
	@Autowired
    private IB0301ServiceImpl b0301Service;
	/**
	   *  人材推薦一覧画面初期表示
	 * @return CompanyRegisterInitResponseEntity
	 */
	@RequestMapping(value = "/init", method = RequestMethod.POST)
	  public CommonResult<ApplicantRecommendInitBean> Init(@RequestBody @Valid B0301VueForm b0301VueForm,HttpSession session,BindingResult results) {
	
			// 画面戻り値を取得
			ApplicantRecommendInitBean applicantRecommendInitBean = b0301Service.getApplicantRecommendInitResponse();
			
			//SESSIONから会社IDとユーザーコードを取得
			UserTblEntity user = (UserTblEntity) session.getAttribute("USER");
			b0301VueForm.setCompanyId(user.getCompanyId());
			b0301VueForm.setUserCd(user.getUserCd());
	
			//LISTを取得する
			List<B0301Bean> b0301Bean = b0301Service.getAll(b0301VueForm);
			
			applicantRecommendInitBean.setB0301Beans(b0301Bean);
			
			// TODO メッセージ「I0001」
			return CommonResult.success(applicantRecommendInitBean);
	
	  }
	
}
