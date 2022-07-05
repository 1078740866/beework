package Ansin.web.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ansin.web.bean.IndustryMstBean;
import Ansin.web.bean.PrefecturesMstBean;
import Ansin.web.bean.TrainingInfoTblBean;
import Ansin.web.entity.IdListEntity;
import Ansin.web.entity.IndustryMstEntity;
import Ansin.web.entity.PrefecturesMstEntity;
import Ansin.web.entity.TrainingInfoTblEntity;
import Ansin.web.mapper.IndustryMstMapper;
import Ansin.web.mapper.PrefecturesMstMapper;
import Ansin.web.mapper.TrainingTblMapper;
import Ansin.web.service.A070104Service;
import Ansin.web.util.EditUtil;
import Ansin.web.vueForm.A070104VueForm;
@Service
public class IA070104ServiceImpl implements A070104Service{
	
	@Autowired
	private TrainingTblMapper trainingTblMapper;
	@Autowired
	private IndustryMstMapper industryMapper;
	@Autowired
	private PrefecturesMstMapper prefecturesMstMapper;

	/**
	 * A0701_04_承認一覧画面(研修会)一覧リスト
	 */
	@Override
	public List<TrainingInfoTblBean> getTra(A070104VueForm a070104VueForm) {
		List<TrainingInfoTblEntity> trainingInfoTblEntity = trainingTblMapper.getTra(a070104VueForm);
		List<TrainingInfoTblBean> trainingInfoTblBean = new ArrayList<TrainingInfoTblBean>();
		for (TrainingInfoTblEntity trainingInfoEntity : trainingInfoTblEntity) {
			TrainingInfoTblBean bean = new TrainingInfoTblBean();
			BeanUtils.copyProperties(trainingInfoEntity, bean);
			bean.setCompanyId(EditUtil.intUtil(trainingInfoEntity.getCompanyId()));
			bean.setIndustryId(EditUtil.intUtil(trainingInfoEntity.getIndustryId()));
			bean.setTrainingId(EditUtil.intUtil(trainingInfoEntity.getTrainingId()));
			bean.setDateFrom(EditUtil.dateUtil(trainingInfoEntity.getDateFrom()));
			bean.setDateTo(EditUtil.dateUtil(trainingInfoEntity.getDateTo()));
			bean.setTimeFrom(EditUtil.timeUtil(trainingInfoEntity.getTimeFrom()));
			bean.setTimeTo(EditUtil.timeUtil(trainingInfoEntity.getTimeTo()));
			bean.setProCnt(EditUtil.intUtil(trainingInfoEntity.getProCnt()));
			bean.setCost(EditUtil.intUtil(trainingInfoEntity.getCost()));
			trainingInfoTblBean.add(bean);
		}
		return trainingInfoTblBean;
	}
	
	/**
	 * A0701_04_承認一覧画面(研修会)単数または複数承認、拒否
	 */
	@Override
	public Integer trainingConfirmOrDeny(List<IdListEntity> list,Integer userCd,String statusFlg) {
		Integer trainingConfirmOrDeny = trainingTblMapper.trainingConfirmOrDeny(list, userCd,  statusFlg);
		return trainingConfirmOrDeny;
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
