package Ansin.web.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ansin.web.bean.A0201ListBean;
import Ansin.web.bean.IndustryMstBean;
import Ansin.web.bean.JobtypeMstBean;
import Ansin.web.bean.LanMstBean;
import Ansin.web.bean.PrefecturesMstBean;
import Ansin.web.entity.A0201ListEntity;
import Ansin.web.entity.IndustryMstEntity;
import Ansin.web.entity.JobtypeMstEntity;
import Ansin.web.entity.LanMstEntity;
import Ansin.web.entity.PrefecturesMstEntity;
import Ansin.web.mapper.ApplicantInfoTblMapper;
import Ansin.web.mapper.IndustryMstMapper;
import Ansin.web.mapper.JobtypeMstMapper;
import Ansin.web.mapper.LanMstMapper;
import Ansin.web.mapper.PrefecturesMstMapper;
import Ansin.web.service.A0201Service;
import Ansin.web.util.DateFormatUtil;
import Ansin.web.util.EditUtil;
import Ansin.web.vueForm.A0201VueForm;

@Service
public class IA0201ServiceImpl implements A0201Service{
	
		@Autowired
		private IndustryMstMapper industryMstMapper;
		@Autowired
		private JobtypeMstMapper jobtypeMstMapper;
		@Autowired
		private PrefecturesMstMapper prefecturesMstMapper;
		@Autowired
		private LanMstMapper lanMstMapper;
		@Autowired
		private ApplicantInfoTblMapper applicantInfoTblMapper;
		
		/**
		 * 応募者一覧初期表示
		 * @param a0301VueForm
		 * @return List<ApplicantInfoTblBean>
		 */
		@Override
		public List<A0201ListBean> getApplicantList(A0201VueForm a0301VueForm) {
			a0301VueForm.setBirthdayFrom(DateFormatUtil.stringToDate(DateFormatUtil.getDate(a0301VueForm.getAgeFrom())));
			a0301VueForm.setBirthdayTo(DateFormatUtil.stringToDate(DateFormatUtil.getDate(a0301VueForm.getAgeTo())));
			List<A0201ListEntity> applicantInfoTblEntity = applicantInfoTblMapper.getList(a0301VueForm);
			List<A0201ListBean> beans = new ArrayList<A0201ListBean>();
			for (A0201ListEntity entity : applicantInfoTblEntity) {
				A0201ListBean bean = new A0201ListBean();
				BeanUtils.copyProperties(entity, bean);
				bean.setHopeLand1(EditUtil.intUtil(entity.getHopeLand1()));
				bean.setHopeLand2(EditUtil.intUtil(entity.getHopeLand2()));
				bean.setHopeLand3(EditUtil.intUtil(entity.getHopeLand3()));
				bean.setCountryId(EditUtil.intUtil(entity.getCountryId()));
				bean.setIndustryId1(EditUtil.intUtil(entity.getIndustryId1()));
				bean.setIndustryId2(EditUtil.intUtil(entity.getIndustryId2()));
				bean.setIndustryId3(EditUtil.intUtil(entity.getIndustryId3()));
				bean.setJobtypeId1_1(EditUtil.intUtil(entity.getJobtypeId1_1()));
				bean.setJobtypeId1_2(EditUtil.intUtil(entity.getJobtypeId1_2()));
				bean.setJobtypeId1_3(EditUtil.intUtil(entity.getJobtypeId1_3()));
				bean.setJobtypeId2_1(EditUtil.intUtil(entity.getJobtypeId2_1()));
				bean.setJobtypeId2_2(EditUtil.intUtil(entity.getJobtypeId2_2()));
				bean.setJobtypeId2_3(EditUtil.intUtil(entity.getJobtypeId2_3()));
				bean.setJobtypeId3_1(EditUtil.intUtil(entity.getJobtypeId3_1()));
				bean.setJobtypeId3_2(EditUtil.intUtil(entity.getJobtypeId3_2()));
				bean.setJobtypeId3_3(EditUtil.intUtil(entity.getJobtypeId3_3()));
				bean.setApplicantId(EditUtil.intUtil(entity.getApplicantId()));
				bean.setBirthday(EditUtil.intUtil(DateFormatUtil.getAge(entity.getBirthday())));
				bean.setHopeSalaryFrom(EditUtil.intUtil(entity.getHopeSalaryFrom()));
				bean.setHopeSalaryTo(EditUtil.intUtil(entity.getHopeSalaryTo()));
				bean.setUserCd(EditUtil.intUtil(entity.getUserCd()));
				bean.setWorkSituation(EditUtil.intUtil(entity.getWorkSituation()));
				switch (entity.getFinalEducation()) {
				case "0":
					bean.setFinalEducation("初級レベル");
					break;
				case "1":
					bean.setFinalEducation("簡単会話");
					break;
				case "2":
					bean.setFinalEducation("日常会話");				
					break;
				case "3":
					bean.setFinalEducation("流暢");
					break;
				case "4":
					bean.setFinalEducation("ビジネス流暢");
					break;
				case "5":
					bean.setFinalEducation("ネイティブ");
					break;
				}
				beans.add(bean);
			}
			return beans;
		}
		
		/**
		 * 言語リスト取得
		 * @return List<IndustryMstBean>
		 */
		@Override
		public List<LanMstBean> getLanList() {
			List<LanMstEntity> lanMstEntity = lanMstMapper.getAll();
			List<LanMstBean> beans = new ArrayList<LanMstBean>();
			for (LanMstEntity entity : lanMstEntity) {
				LanMstBean bean = new LanMstBean();
				BeanUtils.copyProperties(entity, bean);
				bean.setLanguageId(EditUtil.intUtil(entity.getLanguageId()));
				beans.add(bean);
			}
			return beans;
		}
		
		/**
		 * 業種リスト取得
		 * @return List<IndustryMstBean>
		 */
		@Override
		public List<IndustryMstBean> getIndustryList() {
			List<IndustryMstEntity> industryMstEntity = industryMstMapper.getAll();
			List<IndustryMstBean> beans = new ArrayList<IndustryMstBean>();
			for (IndustryMstEntity entity : industryMstEntity) {
				IndustryMstBean bean = new IndustryMstBean();
				BeanUtils.copyProperties(entity, bean);
				bean.setIndustryId(EditUtil.intUtil(entity.getIndustryId()));
				beans.add(bean);
			}
			return beans;
		}
		
		/**
		 * 職種リスト取得
		 * @return List<IndustryMstBean>
		 */
		@Override
		public List<JobtypeMstBean> getJobtypeList() {
			List<JobtypeMstEntity> jobtypeMstEntities = jobtypeMstMapper.getAll();
			List<JobtypeMstBean> beans = new ArrayList<JobtypeMstBean>();
			for (JobtypeMstEntity entity : jobtypeMstEntities) {
				JobtypeMstBean bean = new JobtypeMstBean();
				BeanUtils.copyProperties(entity, bean);
				bean.setJobtypeId(EditUtil.intUtil(entity.getJobtypeId()));
				beans.add(bean);
			}
			return beans;
		}
		
		/**
		 * 都道府県リスト取得
		 * @return List<PrefecturesMstBean>
		 */
		@Override
		public List<PrefecturesMstBean> getPrefeList() {
			List<PrefecturesMstEntity> prefecturesMstEntity = prefecturesMstMapper.getAll();
			List<PrefecturesMstBean> beans = new ArrayList<PrefecturesMstBean>();
			for (PrefecturesMstEntity entity : prefecturesMstEntity) {
				PrefecturesMstBean bean = new PrefecturesMstBean();
				BeanUtils.copyProperties(entity, bean);
				bean.setPrefeId(EditUtil.intUtil(entity.getPrefeId()));
				beans.add(bean);
			}
			return beans;
		}
		
		/**
		 * 削除方法
		 * @return count
		 */
		@Override
		public Integer delete(List<Integer> applicantIds) {
			Integer count = applicantInfoTblMapper.deleteApplicant(applicantIds);
			return count;
		}
		
	

}
