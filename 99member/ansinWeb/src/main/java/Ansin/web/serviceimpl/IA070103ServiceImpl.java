package Ansin.web.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ansin.web.bean.IndustryMstBean;
import Ansin.web.bean.JobtypeMstBean;
import Ansin.web.bean.PositionTblBean;
import Ansin.web.bean.PrefecturesMstBean;
import Ansin.web.entity.IdListEntity;
import Ansin.web.entity.IndustryMstEntity;
import Ansin.web.entity.JobtypeMstEntity;
import Ansin.web.entity.PositionTblEntity;
import Ansin.web.entity.PrefecturesMstEntity;
import Ansin.web.mapper.IndustryMstMapper;
import Ansin.web.mapper.JobtypeMstMapper;
import Ansin.web.mapper.PositionTblMapper;
import Ansin.web.mapper.PrefecturesMstMapper;
import Ansin.web.service.A070103Service;
import Ansin.web.util.EditUtil;
import Ansin.web.vueForm.A070103VueForm;

@Service
public class IA070103ServiceImpl implements A070103Service{
	
	@Autowired
	private PositionTblMapper positionTblMapper;
	@Autowired
	private IndustryMstMapper industryMapper;
	@Autowired
	private JobtypeMstMapper jobtypeMstMapper;
	@Autowired
	private PrefecturesMstMapper prefecturesMstMapper;

	@Override
	public List<PositionTblBean> getPo(A070103VueForm a070103VueForm) {
		
		List<PositionTblEntity> positionTblEntityList = positionTblMapper.getPo(a070103VueForm);
		
		List<PositionTblBean> positionTblList = new ArrayList<PositionTblBean>();
		
		for(PositionTblEntity positionTblEntity : positionTblEntityList) {
			
			PositionTblBean positionTblBean = new PositionTblBean();
			
			BeanUtils.copyProperties(positionTblEntity, positionTblBean);
			
			positionTblBean.setCompanyId(EditUtil.intUtil(positionTblEntity.getCompanyId()));
			positionTblBean.setUserCd(EditUtil.intUtil(positionTblEntity.getUserCd()));
			positionTblBean.setPositionId(EditUtil.intUtil(positionTblEntity.getPositionId()));
			positionTblBean.setIndustryId(EditUtil.intUtil(positionTblEntity.getIndustryId()));
			positionTblBean.setJobTypeId(EditUtil.intUtil(positionTblEntity.getJobTypeId()));
			positionTblBean.setSkillId(EditUtil.intUtil(positionTblEntity.getSkillId()));
			positionTblBean.setWorkTimeFrom(EditUtil.dateUtil(positionTblEntity.getWorkTimeFrom()));
			positionTblBean.setWorkTimeTo(EditUtil.dateUtil(positionTblEntity.getWorkTimeTo()));
			positionTblBean.setSalaryMin(EditUtil.intUtil(positionTblEntity.getSalaryMin()));
			positionTblBean.setSalaryMax(EditUtil.intUtil(positionTblEntity.getSalaryMax()));
			positionTblBean.setPeoCnt(EditUtil.intUtil(positionTblEntity.getPeoCnt()));
			positionTblBean.setWorkDateStr(EditUtil.dateUtil(positionTblEntity.getWorkDateStr()));
			positionTblBean.setExpDate(EditUtil.dateUtil(positionTblEntity.getExpDate()));
			positionTblBean.setUpdateTime(EditUtil.dateUtil(positionTblEntity.getUpdateTime()));

			positionTblList.add(positionTblBean);
		}		
 		return positionTblList;
	}

	@Override
	public Integer positionConfirmOrDeny(List<IdListEntity> list,Integer userCd, String statusFlg) {
		Integer positionConfirmOrDeny = positionTblMapper.positionConfirmOrDeny(list, userCd, statusFlg);
		return positionConfirmOrDeny;
	}
	
	/**
	 * 全部業種を取得
	 * 
	 * @return
	 */
	@Override
	public List<IndustryMstBean> getAllIndustry() {
		List<IndustryMstEntity> industryMstEntity = industryMapper.getAll();
		List<IndustryMstBean> industryMstBean = new ArrayList<IndustryMstBean>();
		for (IndustryMstEntity industryEntity : industryMstEntity) {
			IndustryMstBean bean = new IndustryMstBean();
			BeanUtils.copyProperties(industryEntity, bean);
			bean.setIndustryId(EditUtil.intUtil(industryEntity.getIndustryId()));
			industryMstBean.add(bean);
		}
		return industryMstBean;
	}
	
	/**
	 * 初期職種選択リストを取得
	 */
	@Override
	public List<JobtypeMstBean> getAllJobtype() {
		List<JobtypeMstEntity> allJobtype = jobtypeMstMapper.getAll();
		List<JobtypeMstBean> allJobtypeBean = new ArrayList<JobtypeMstBean>();
		for (JobtypeMstEntity jobtypeMstEntity : allJobtype) {
			JobtypeMstBean jobtypeMstBean = new JobtypeMstBean();
			allJobtypeBean.add(jobtypeMstBean);
			BeanUtils.copyProperties(jobtypeMstEntity, jobtypeMstBean);
			jobtypeMstBean.setIndustryId(EditUtil.intUtil(jobtypeMstEntity.getIndustryId()));
			jobtypeMstBean.setJobtypeId(EditUtil.intUtil(jobtypeMstEntity.getJobtypeId()));
		}
		return allJobtypeBean;
	}

	/**
	 * 初期都道府県選択リストを取得
	 */
	@Override
	public List<PrefecturesMstBean> getAllPrefe() {
		List<PrefecturesMstEntity> prefecturesMstEntities = prefecturesMstMapper.getAll();
		List<PrefecturesMstBean> beans = new ArrayList<PrefecturesMstBean>();
		for (PrefecturesMstEntity prefe : prefecturesMstEntities) {
			PrefecturesMstBean bean = new PrefecturesMstBean();
			beans.add(bean);
			BeanUtils.copyProperties(prefe, bean);
			bean.setPrefeId(EditUtil.intUtil(prefe.getPrefeId()));
			bean.setPrefeNm(prefe.getPrefeNm());
		}
		return beans;
	}

}
