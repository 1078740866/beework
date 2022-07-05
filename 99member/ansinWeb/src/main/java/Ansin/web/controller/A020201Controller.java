package Ansin.web.controller;

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
import Ansin.web.bean.ApplicantEduTblBean;
import Ansin.web.bean.ApplicantInfoTblBean;
import Ansin.web.bean.ApplicantLanTblBean;
import Ansin.web.bean.ApplicantQuaTblBean;
import Ansin.web.bean.ApplicantSkillTblBean;
import Ansin.web.bean.ApplicantWorkHisTblBean;
import Ansin.web.bean.C010101ListBean;
import Ansin.web.bean.CountryMstBean;
import Ansin.web.bean.IndustryMstBean;
import Ansin.web.bean.JobtypeMstBean;
import Ansin.web.bean.LanMstBean;
import Ansin.web.bean.PrefecturesMstBean;
import Ansin.web.bean.ProjectHisTblBean;
import Ansin.web.bean.SkillMstBean;
import Ansin.web.serviceimpl.IA020201ServiceImpl;
import Ansin.web.util.EditUtil;
import Ansin.web.vueForm.C010101VueForm;
/**
 * A0202_応募者履歴書詳細画面
 * @author 楊卿赫
 *
 */
@RestController
@RequestMapping("/A020201")
public class A020201Controller {
	
	@Autowired
	private IA020201ServiceImpl iA020201ServiceImpl;
	
	/**
	 * 応募者履歴書詳細初期表示
	 * @param a0201VueForm
	 * @param session
	 * @param results
	 * @return A0201Bean
	 */
	@RequestMapping(value = "/init", method = RequestMethod.POST)
	public CommonResult<C010101ListBean> Init(@RequestBody JSONObject JsonApplicantId,BindingResult results) {
		
		// 応募者ID取得
		Map<String, Object> jsonToMap =  JSONObject.parseObject(JsonApplicantId.toJSONString());
		Integer applicantId = (Integer)jsonToMap.get("applicantId");
		
		// 出力を取得する
		C010101ListBean c010101ListBean = new C010101ListBean();
		//応募者情報を取得する
		ApplicantInfoTblBean applicantInfoTblBean = iA020201ServiceImpl.getApplicantInfo(applicantId);
		//C010101初期国選択リストを取得
		List<CountryMstBean> couList = iA020201ServiceImpl.getAll();
		//C010101初期業種選択リストを取得
		List<IndustryMstBean> industryList = iA020201ServiceImpl.getAllIndustry();
		//C010101初期職種選択リストを取得
		List<JobtypeMstBean> jobtypeList = iA020201ServiceImpl.getAllJobtype();
		//C010101初期都道県選択リストを取得
		List<PrefecturesMstBean> prefecturestAndCityList = iA020201ServiceImpl.getPreAndCity();
		//C010101初期スキル選択リストを取得
		List<SkillMstBean> skillList = iA020201ServiceImpl.getAllSkill();
		//C010101初期言語能力選択リストを取得
		List<LanMstBean> lanList = iA020201ServiceImpl.getAllLan();
		
		c010101ListBean.setApplicantInfoTblBean(applicantInfoTblBean);
		
		c010101ListBean.setCountryMstBean(couList);
		
		c010101ListBean.setIndustryMstBean(industryList);
		
		c010101ListBean.setJobtypeMstBean(jobtypeList);
		
		c010101ListBean.setPrefecturesMstBean(prefecturestAndCityList);
		
		c010101ListBean.setSkillMstBean(skillList);
		
		c010101ListBean.setLanMstBean(lanList);

		if(applicantInfoTblBean == null) {
			return CommonResult.success(c010101ListBean);
		}else {
			//C0101応募者の資格リスト
			List<ApplicantQuaTblBean> getApplicantQuaList = iA020201ServiceImpl.getApplicantQua(EditUtil.intUtil(applicantInfoTblBean.getApplicantId()));
			//C0101応募者のスキルリスト
			List<ApplicantSkillTblBean> getApplicantSkillList = iA020201ServiceImpl.getApplicantSkill(EditUtil.intUtil(applicantInfoTblBean.getApplicantId()));
			//C0101応募者の職歴リスト
			List<ApplicantWorkHisTblBean> getApplicantWorkHisList = iA020201ServiceImpl.getApplicantWorkHis(EditUtil.intUtil(applicantInfoTblBean.getApplicantId()));
			//C0101応募者の言語能力リスト
			List<ApplicantLanTblBean> getApplicantLanList = iA020201ServiceImpl.getAll(EditUtil.intUtil(applicantInfoTblBean.getApplicantId()));
			//C0101応募者の学歴能力リスト
			List<ApplicantEduTblBean> getApplicantEduList = iA020201ServiceImpl.getEdu(EditUtil.intUtil(applicantInfoTblBean.getApplicantId()));
			//C0101応募者のプロジェクト履歴リスト
			List<ProjectHisTblBean> getProjectHisList = iA020201ServiceImpl.getProjectHis(EditUtil.intUtil(applicantInfoTblBean.getApplicantId()));
			
			c010101ListBean.setApplicantQuaTblBean(getApplicantQuaList);
			
			c010101ListBean.setApplicantSkillTblBean(getApplicantSkillList);
			
			c010101ListBean.setApplicantWorkHisTblBean(getApplicantWorkHisList);
			
			c010101ListBean.setApplicantLanTblBean(getApplicantLanList);
			
			c010101ListBean.setApplicantEduTblBean(getApplicantEduList);
			
			c010101ListBean.setProjectHisTblBean(getProjectHisList);
		}
		
		return CommonResult.success(c010101ListBean);
		
	}
	
	/**
	 * 応募者情報を更新する
	 * @param c010101VueForm
	 * @param session
	 * @param results
	 * @return　applicantInfoTblEntity
	 */
	@RequestMapping(value = "/update", method = {RequestMethod.POST })
	 public CommonResult<C010101ListBean> c010101update(@RequestBody @Valid C010101VueForm c010101VueForm,HttpSession session,BindingResult results) {
		
		if (results.hasErrors()) {
			return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
		}
		
		int updateApplicantInfo = iA020201ServiceImpl.updateApplicant(c010101VueForm);
		
		if (updateApplicantInfo == 0 ) {
			return CommonResult.failed("失敗");
		}else {
			// 出力を取得する
			C010101ListBean c010101ListBean = new C010101ListBean();
			//応募者情報を取得する
			ApplicantInfoTblBean applicantInfoTblBean = iA020201ServiceImpl.getApplicantInfo(c010101VueForm.getApplicantId());
			//C0101応募者の資格リスト
			List<ApplicantQuaTblBean> getApplicantQuaList = iA020201ServiceImpl.getApplicantQua(EditUtil.intUtil(applicantInfoTblBean.getApplicantId()));
			//C0101応募者のスキルリスト
			List<ApplicantSkillTblBean> getApplicantSkillList = iA020201ServiceImpl.getApplicantSkill(EditUtil.intUtil(applicantInfoTblBean.getApplicantId()));
			//C0101応募者の職歴リスト
			List<ApplicantWorkHisTblBean> getApplicantWorkHisList = iA020201ServiceImpl.getApplicantWorkHis(EditUtil.intUtil(applicantInfoTblBean.getApplicantId()));
			//C0101応募者の言語能力リスト
			List<ApplicantLanTblBean> getApplicantLanList = iA020201ServiceImpl.getAll(EditUtil.intUtil(applicantInfoTblBean.getApplicantId()));
			//C0101応募者の学歴能力リスト
			List<ApplicantEduTblBean> getApplicantEduList = iA020201ServiceImpl.getEdu(EditUtil.intUtil(applicantInfoTblBean.getApplicantId()));
			//C0101応募者のプロジェクト履歴リスト
			List<ProjectHisTblBean> getProjectHisList = iA020201ServiceImpl.getProjectHis(EditUtil.intUtil(applicantInfoTblBean.getApplicantId()));
			
			c010101ListBean.setApplicantQuaTblBean(getApplicantQuaList);
			
			c010101ListBean.setApplicantSkillTblBean(getApplicantSkillList);
			
			c010101ListBean.setApplicantWorkHisTblBean(getApplicantWorkHisList);
			
			c010101ListBean.setApplicantLanTblBean(getApplicantLanList);
			
			c010101ListBean.setApplicantEduTblBean(getApplicantEduList);
			
			c010101ListBean.setProjectHisTblBean(getProjectHisList);
			
			c010101ListBean.setApplicantInfoTblBean(applicantInfoTblBean);
			
			return CommonResult.success(c010101ListBean);
		}    	
	}
	
}
