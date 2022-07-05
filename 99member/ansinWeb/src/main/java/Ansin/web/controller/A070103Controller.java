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
import Ansin.web.bean.A070103ListBean;
import Ansin.web.bean.IndustryMstBean;
import Ansin.web.bean.JobtypeMstBean;
import Ansin.web.bean.PositionTblBean;
import Ansin.web.bean.PrefecturesMstBean;
import Ansin.web.entity.UserTblEntity;
import Ansin.web.serviceimpl.IA070103ServiceImpl;
import Ansin.web.vueForm.A070103VueForm;
/**
 * A0701_03_承認一覧画面(職位)
 * @author 劉智浩
 *
 */
@RestController
@RequestMapping("/A070103")
public class A070103Controller {

	@Autowired
    private IA070103ServiceImpl a070103Service;
	
	int positionConfirmOrDeny;
	
	/**
	 * A070103職位一覧
	 * @param a070103VueForm
	 * @param session
	 * @param results
	 * @return
	 */
	@RequestMapping(value = "/init", method = RequestMethod.POST)
    public CommonResult<A070103ListBean> Init(@RequestBody @Valid A070103VueForm a070103VueForm,HttpSession session,BindingResult results) {
		
		if (results.hasErrors()) {
			return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
		}
		
		// 業種を取得
		List<IndustryMstBean> industryMstBean = a070103Service.getAllIndustry();
		
		//職種を取得
		List<JobtypeMstBean> jobtypeMstBean = a070103Service.getAllJobtype();
		
		//都道府県を取得
		List<PrefecturesMstBean> prefecturesMstBean = a070103Service.getAllPrefe();
		 
		//職位リスト取得
		List<PositionTblBean> positionTblBean = a070103Service.getPo(a070103VueForm);
		
		A070103ListBean a070103ListBean = new A070103ListBean();
		
		a070103ListBean.setPositionTblBean(positionTblBean);
		
		a070103ListBean.setIndustryMstBean(industryMstBean);
		
		a070103ListBean.setJobtypeMstBean(jobtypeMstBean);
		
		a070103ListBean.setPrefecturesMstBean(prefecturesMstBean);
		
		return CommonResult.success(a070103ListBean);
		
    }
	
	/**
	 * A070103職位単数または複数承認、拒否
	 * @param a070103VueForm
	 * @param session
	 * @param results
	 * @return
	 */
	@RequestMapping(value = "/positionConfirmOrDeny", method = {RequestMethod.POST })
	 public CommonResult<A070103ListBean> positionConfirmOrDeny(@RequestBody @Valid A070103VueForm a070103VueForm,HttpSession session,BindingResult results) {
		
		if (results.hasErrors()) {
			return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
		}
		
		UserTblEntity user = (UserTblEntity) session.getAttribute("USERA");
		
		if (a070103VueForm.getListData() != null && a070103VueForm.getListData().size() != 0) {
			// 職位単数または複数承認、拒否
			positionConfirmOrDeny = a070103Service.positionConfirmOrDeny(a070103VueForm.getListData(), user.getUserCd(), a070103VueForm.getStatusFlg());			
		}else {
			
		}
		//成功するかどうか判断します
		if (positionConfirmOrDeny == 0 ) {
			return CommonResult.failed("失敗");
		}else {
			
			A070103VueForm a070103VueForm1 = new A070103VueForm();
			
			// 業種を取得
			List<IndustryMstBean> industryMstBean = a070103Service.getAllIndustry();
			
			//職種を取得
			List<JobtypeMstBean> jobtypeMstBean = a070103Service.getAllJobtype();
			
			//都道府県を取得
			List<PrefecturesMstBean> prefecturesMstBean = a070103Service.getAllPrefe();
			 
			//職位リスト取得
			List<PositionTblBean> positionTblBean = a070103Service.getPo(a070103VueForm1);
			
			A070103ListBean a070103ListBean = new A070103ListBean();
			
			a070103ListBean.setPositionTblBean(positionTblBean);
			
			a070103ListBean.setIndustryMstBean(industryMstBean);
			
			a070103ListBean.setJobtypeMstBean(jobtypeMstBean);
			
			a070103ListBean.setPrefecturesMstBean(prefecturesMstBean);
			
			return CommonResult.success(a070103ListBean);
		}     
	}
	
}
