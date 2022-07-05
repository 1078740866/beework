package Ansin.web.service;

import java.io.IOException;
import java.util.List;

import Ansin.web.bean.ApplicantEduTblBean;
import Ansin.web.bean.ApplicantInfoTblBean;
import Ansin.web.bean.ApplicantLanTblBean;
import Ansin.web.bean.ApplicantQuaTblBean;
import Ansin.web.bean.ApplicantSkillTblBean;
import Ansin.web.bean.ApplicantWorkHisTblBean;
import Ansin.web.bean.CountryMstBean;
import Ansin.web.bean.IndustryMstBean;
import Ansin.web.bean.JobtypeMstBean;
import Ansin.web.bean.LanMstBean;
import Ansin.web.bean.PrefecturesMstBean;
import Ansin.web.bean.ProjectHisTblBean;
import Ansin.web.bean.SkillMstBean;
import Ansin.web.bean.UserInfoBean;
import Ansin.web.vueForm.C010101VueForm;

public interface C010101Service {

	/**
	 * C010101初期国選択リストを取得
	 * 
	 * @return allCou
	 */
	List<CountryMstBean> getAll();

	/**
	 * C010101初期業種選択リストを取得
	 * 
	 * @return allIndustry
	 */
	List<IndustryMstBean> getAllIndustry();

	/**
	 * C010101初期職種選択リストを取得
	 * 
	 * @return allJobtype
	 */
	List<JobtypeMstBean> getAllJobtype();

	/**
	 * C010101初期都道県選択リストを取得
	 * 
	 * @return preAndCity
	 */
	List<PrefecturesMstBean> getPreAndCity();

	/**
	 * C010101初期スキル選択リストを取得
	 * 
	 * @return
	 */
	List<SkillMstBean> getAllSkill();

	/**
	 * C010101初期言語能力選択リストを取得
	 * 
	 * @return
	 */
	List<LanMstBean> getAllLan();

	/**
	 * C010101応募者情報を取得
	 * 
	 * @param c010101VueForm
	 * @return applicantInfo
	 */
	ApplicantInfoTblBean getApplicantInfo(Integer userCd);

	UserInfoBean getUserInfo(Integer userCd);

	/**
	 * C010101応募者情報を挿入
	 * 
	 * @param c010101VueForm
	 * @return insertApplicantReturn
	 */
	int insertApplicant(C010101VueForm c010101VueForm);

	/**
	 * C010101応募者情報を更新
	 * 
	 * @param c010101VueForm
	 * @return updateApplicantReturn
	 */
	int updateApplicant(C010101VueForm c010101VueForm);

	/**
	 * C0101応募者の資格リスト
	 * 
	 * @param applicantId
	 * @return applicantQua
	 */
	List<ApplicantQuaTblBean> getApplicantQua(Integer applicantId);

	/**
	 * C0101応募者のスキルリスト
	 * 
	 * @param applicantId
	 * @return applicantSkill
	 */
	List<ApplicantSkillTblBean> getApplicantSkill(Integer applicantId);

	/**
	 * C0101応募者の職歴リスト
	 * 
	 * @param applicantId
	 * @return applicantWorkHis
	 */
	List<ApplicantWorkHisTblBean> getApplicantWorkHis(Integer applicantId);

	/**
	 * C0101応募者の言語能力リスト
	 * 
	 * @param applicantId
	 * @return lan
	 */
	List<ApplicantLanTblBean> getAll(Integer applicantId);

	/**
	 * C0101応募者の学歴能力リスト
	 * 
	 * @param applicantId
	 * @return edu
	 */
	List<ApplicantEduTblBean> getEdu(Integer applicantId);

	/**
	 * C0101応募者のプロジェクト履歴リスト
	 * 
	 * @param applicantId
	 * @return projectHis
	 */
	List<ProjectHisTblBean> getProjectHis(Integer applicantId);

	/**
	 * 郵便番号から都道府県名取得
	 * 
	 * @param postal
	 * @return String
	 */
	String getPrefeNm(String postal);

	/**
	 * 応募者情報詳細取得
	 * 
	 * @param applicantId
	 * @return C010101ListBean
	 */
	ApplicantInfoTblBean getApplicantAll(Integer applicantId);

	ApplicantInfoTblBean confirmOutput(ApplicantInfoTblBean applicantInfoTblBean) throws IOException;

	ApplicantQuaTblBean confirmOutput(ApplicantQuaTblBean applicantQuaTblBean) throws IOException;

	ApplicantEduTblBean confirmOutput(ApplicantEduTblBean applicantEduTblBean) throws IOException;

}
