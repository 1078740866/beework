package Ansin.web.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
import Ansin.web.bean.UserInfoBean;
import Ansin.web.entity.UserTblEntity;
import Ansin.web.serviceimpl.IC010101ServiceImpl;
import Ansin.web.util.EditUtil;
import Ansin.web.vueForm.C010101VueForm;

/**
 * C010101履歴書詳細画面01
 * 
 * @author 劉智浩
 *
 */
@RestController
@RequestMapping("/C010101")
public class C010101Controller {

	@Value("${uploadfile.path}")
	private String uploadpath;

	@Autowired
	private IC010101ServiceImpl c010101Service;

	/**
	 * 応募者情報詳細表示
	 * 
	 * @param session
	 * @param results
	 * @return c0101001Entity
	 * @throws IOException
	 */
	@RequestMapping(value = "/getApplicant", method = RequestMethod.POST)
	public CommonResult<C010101ListBean> getApplicant(@RequestBody JSONObject applicantJsonId, HttpSession session)
			throws IOException {

		// TAB状態取得
		Map<String, Object> jsonToMap = JSONObject.parseObject(applicantJsonId.toJSONString());
		Integer applicantId = (Integer) jsonToMap.get("applicantId");

		// 出力を取得する
		C010101ListBean c010101ListBean = new C010101ListBean();

		ApplicantInfoTblBean applicantInfoTblBean = c010101Service.getApplicantAll(applicantId);

		UserInfoBean userInfoBean = c010101Service.getUserInfo(EditUtil.intUtil(applicantInfoTblBean.getUserCd()));

		// C010101初期国選択リストを取得
		List<CountryMstBean> couList = c010101Service.getAll();
		// C010101初期業種選択リストを取得
		List<IndustryMstBean> industryList = c010101Service.getAllIndustry();
		// C010101初期職種選択リストを取得
		List<JobtypeMstBean> jobtypeList = c010101Service.getAllJobtype();
		// C010101初期都道県選択リストを取得
		List<PrefecturesMstBean> prefecturestAndCityList = c010101Service.getPreAndCity();
		// C010101初期スキル選択リストを取得
		List<SkillMstBean> skillList = c010101Service.getAllSkill();
		// C010101初期言語能力選択リストを取得
		List<LanMstBean> lanList = c010101Service.getAllLan();

		c010101ListBean.setUserInfoBean(userInfoBean);

		c010101ListBean.setCountryMstBean(couList);

		c010101ListBean.setIndustryMstBean(industryList);

		c010101ListBean.setJobtypeMstBean(jobtypeList);

		c010101ListBean.setPrefecturesMstBean(prefecturestAndCityList);

		c010101ListBean.setSkillMstBean(skillList);

		c010101ListBean.setLanMstBean(lanList);

		if (applicantInfoTblBean == null) {

			c010101ListBean.setFlgData("1");

			return CommonResult.success(c010101ListBean);
		} else {

			// 応募者基本情報取得
			c010101ListBean.setApplicantInfoTblBean(c010101Service.confirmOutput(applicantInfoTblBean));
			// C0101応募者の資格リスト
			c010101ListBean.setApplicantQuaTblBean(c010101Service.getApplicantQua(applicantId));
			// C0101応募者のスキルリスト
			c010101ListBean.setApplicantSkillTblBean(c010101Service.getApplicantSkill(applicantId));
			// C0101応募者の職歴リスト
			c010101ListBean.setApplicantWorkHisTblBean(c010101Service.getApplicantWorkHis(applicantId));
			// C0101応募者の言語能力リスト
			c010101ListBean.setApplicantLanTblBean(c010101Service.getAll(applicantId));
			// C0101応募者の学歴能力リスト
			c010101ListBean.setApplicantEduTblBean(c010101Service.getEdu(applicantId));
			// C0101応募者のプロジェクト履歴リスト
			c010101ListBean.setProjectHisTblBean(c010101Service.getProjectHis(applicantId));
			// C0101応募者のプロジェクト履歴リスト

			return CommonResult.success(c010101ListBean);
		}

	}

	/**
	 * 応募者情報と初期表示
	 * 
	 * @param session
	 * @param results
	 * @return c0101001Entity
	 * @throws IOException
	 */
	@RequestMapping(value = "/init", method = RequestMethod.POST)
	public CommonResult<C010101ListBean> Init(HttpSession session) throws IOException {
		// 出力を取得する
		C010101ListBean c010101ListBean = new C010101ListBean();
		// SESSIONからuserCd取得する
		UserTblEntity user = (UserTblEntity) session.getAttribute("USERC");
		// 応募者情報を取得する
		ApplicantInfoTblBean applicantInfoTblBean = c010101Service.getApplicantInfo(user.getUserCd());

		ApplicantInfoTblBean applicantInfoTblBeanOutput = c010101Service.confirmOutput(applicantInfoTblBean);
		// C010101初期国選択リストを取得
		List<CountryMstBean> couList = c010101Service.getAll();
		// C010101初期業種選択リストを取得
		List<IndustryMstBean> industryList = c010101Service.getAllIndustry();
		// C010101初期職種選択リストを取得
		List<JobtypeMstBean> jobtypeList = c010101Service.getAllJobtype();
		// C010101初期都道県選択リストを取得
		List<PrefecturesMstBean> prefecturestAndCityList = c010101Service.getPreAndCity();
		// C010101初期スキル選択リストを取得
		List<SkillMstBean> skillList = c010101Service.getAllSkill();
		// C010101初期言語能力選択リストを取得
		List<LanMstBean> lanList = c010101Service.getAllLan();

		c010101ListBean.setApplicantInfoTblBean(applicantInfoTblBeanOutput);

		c010101ListBean.setCountryMstBean(couList);

		c010101ListBean.setIndustryMstBean(industryList);

		c010101ListBean.setJobtypeMstBean(jobtypeList);

		c010101ListBean.setPrefecturesMstBean(prefecturestAndCityList);

		c010101ListBean.setSkillMstBean(skillList);

		c010101ListBean.setLanMstBean(lanList);

		if (applicantInfoTblBeanOutput == null) {

			c010101ListBean.setFlgData("1");

			return CommonResult.success(c010101ListBean);
		} else {
			// C0101応募者の資格リスト
			List<ApplicantQuaTblBean> getApplicantQuaList = c010101Service
					.getApplicantQua(EditUtil.intUtil(applicantInfoTblBeanOutput.getApplicantId()));
			// C0101応募者のスキルリスト
			List<ApplicantSkillTblBean> getApplicantSkillList = c010101Service
					.getApplicantSkill(EditUtil.intUtil(applicantInfoTblBeanOutput.getApplicantId()));
			// C0101応募者の職歴リスト
			List<ApplicantWorkHisTblBean> getApplicantWorkHisList = c010101Service
					.getApplicantWorkHis(EditUtil.intUtil(applicantInfoTblBeanOutput.getApplicantId()));
			// C0101応募者の言語能力リスト
			List<ApplicantLanTblBean> getApplicantLanList = c010101Service
					.getAll(EditUtil.intUtil(applicantInfoTblBeanOutput.getApplicantId()));
			// C0101応募者の学歴能力リスト
			List<ApplicantEduTblBean> getApplicantEduList = c010101Service
					.getEdu(EditUtil.intUtil(applicantInfoTblBeanOutput.getApplicantId()));
			// C0101応募者のプロジェクト履歴リスト
			List<ProjectHisTblBean> getProjectHisList = c010101Service
					.getProjectHis(EditUtil.intUtil(applicantInfoTblBeanOutput.getApplicantId()));

			c010101ListBean.setApplicantQuaTblBean(getApplicantQuaList);

			c010101ListBean.setApplicantSkillTblBean(getApplicantSkillList);

			c010101ListBean.setApplicantWorkHisTblBean(getApplicantWorkHisList);

			c010101ListBean.setApplicantLanTblBean(getApplicantLanList);

			c010101ListBean.setApplicantEduTblBean(getApplicantEduList);

			c010101ListBean.setProjectHisTblBean(getProjectHisList);

			return CommonResult.success(c010101ListBean);
		}

	}

	/**
	 * 応募者情報を更新する
	 * 
	 * @param c010101VueForm
	 * @param session
	 * @param results
	 * @return applicantInfoTblEntity
	 */
	@RequestMapping(value = "/update", method = { RequestMethod.POST })
	public CommonResult<C010101ListBean> c010101update(@RequestBody @Valid C010101VueForm c010101VueForm,
			HttpSession session, BindingResult results) {

		if (results.hasErrors()) {
			return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
		}
		// SESSIONから会社IDとユーザーコードを取得
		UserTblEntity user = (UserTblEntity) session.getAttribute("USERC");
		c010101VueForm.setCompanyId(user.getCompanyId());
		c010101VueForm.setUserCd(user.getUserCd());

		// 都道府県を取得
		c010101VueForm.setPrefeNm(c010101Service.getPrefeNm(c010101VueForm.getApplicantPostal()));

		int updateApplicantInfo = c010101Service.updateApplicant(c010101VueForm);

		if (updateApplicantInfo == 0) {
			return CommonResult.failed("失敗");
		} else {
			// 出力を取得する
			C010101ListBean c010101ListBean = new C010101ListBean();
			// 応募者情報を取得する
			ApplicantInfoTblBean applicantInfoTblBean = c010101Service.getApplicantInfo(c010101VueForm.getUserCd());

			c010101ListBean.setApplicantInfoTblBean(applicantInfoTblBean);

			return CommonResult.success(c010101ListBean);
		}
	}

	/**
	 * 応募者情報を新規作成する
	 * 
	 * @param c010101VueForm
	 * @param session
	 * @param results
	 * @return applicantInfoTblEntity
	 */
	@RequestMapping(value = "/insert", method = { RequestMethod.POST })
	public CommonResult<C010101ListBean> c010101insert(@RequestBody @Valid C010101VueForm c010101VueForm,
			HttpSession session, BindingResult results) {

		if (results.hasErrors()) {
			return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
		}
		// SESSIONから会社IDとユーザーコードを取得
		UserTblEntity user = (UserTblEntity) session.getAttribute("USERC");
		c010101VueForm.setCompanyId(user.getCompanyId());
		c010101VueForm.setUserCd(user.getUserCd());

		// 都道府県を取得
		c010101VueForm.setPrefeNm(c010101Service.getPrefeNm(c010101VueForm.getApplicantPostal()));

		int updateApplicantInfo = c010101Service.insertApplicant(c010101VueForm);

		if (updateApplicantInfo == 0) {
			return CommonResult.failed("失敗");
		} else {
			// 出力を取得する
			C010101ListBean c010101ListBean = new C010101ListBean();
			// 応募者情報を取得する
			ApplicantInfoTblBean applicantInfoTblBean = c010101Service.getApplicantInfo(c010101VueForm.getUserCd());

			c010101ListBean.setApplicantInfoTblBean(applicantInfoTblBean);

			return CommonResult.success(c010101ListBean);
		}
	}

	@PostMapping(value = "/upload")
	public @ResponseBody String upload(@RequestParam("file") MultipartFile multipartFile, HttpSession session)
			throws IOException {

		// ファイル名を設定
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String date = df.format(new Date());
		UUID uuid = UUID.randomUUID();
		String path = uploadpath + date + "/";
		String fileName = uuid.toString() + "_" + multipartFile.getOriginalFilename();

		File filepath = new File(path);
		if (!filepath.exists()) {
			filepath.mkdirs();
		}

		File file = new File(path, fileName);
		// ファイルを保存
		multipartFile.transferTo(file);

		return file.getAbsolutePath().replace("\\\\", "/");

	}

}
