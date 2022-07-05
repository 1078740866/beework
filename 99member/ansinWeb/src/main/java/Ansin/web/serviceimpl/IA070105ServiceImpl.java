package Ansin.web.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ansin.web.bean.BriefingInfoTblBean;
import Ansin.web.bean.PrefecturesMstBean;
import Ansin.web.entity.BriefingInfoTblEntity;
import Ansin.web.entity.IdListEntity;
import Ansin.web.entity.PrefecturesMstEntity;
import Ansin.web.mapper.BriefingTblMapper;
import Ansin.web.mapper.PrefecturesMstMapper;
import Ansin.web.service.A070105Service;
import Ansin.web.util.EditUtil;
import Ansin.web.vueForm.A070105VueForm;

@Service
public class IA070105ServiceImpl implements A070105Service{

	@Autowired
	private BriefingTblMapper briefingTblMapper;
	@Autowired
	private PrefecturesMstMapper prefecturesMstMapper;
	
	@Override
	public List<BriefingInfoTblBean> getBrie(A070105VueForm a070105VueForm) {
		if (a070105VueForm.getDateFromString() != null || a070105VueForm.getDateFromString() != "") {
			a070105VueForm.setDateFrom(EditUtil.timeUtil(a070105VueForm.getDateFromString()));
		}
		if (a070105VueForm.getDateToString() != null || a070105VueForm.getDateToString() != "") {
			a070105VueForm.setDateTo(EditUtil.timeUtil(a070105VueForm.getDateToString()));
		}
    	List<BriefingInfoTblEntity> briefingInfoTblEntity = briefingTblMapper.getBrie2(a070105VueForm);
    	List<BriefingInfoTblBean> briefingInfoTblBean = new ArrayList<BriefingInfoTblBean>();
    	for (BriefingInfoTblEntity BriefingInfo : briefingInfoTblEntity) {
    		BriefingInfoTblBean Bean = new BriefingInfoTblBean();
    		BeanUtils.copyProperties(BriefingInfo, Bean);
    		Bean.setBriefingId(EditUtil.intUtil(BriefingInfo.getBriefingId()));
    		Bean.setCompanyId(EditUtil.intUtil(BriefingInfo.getCompanyId()));
    		Bean.setBriefingDate(EditUtil.dateUtil(BriefingInfo.getBriefingDate()));
    		Bean.setDateFrom(EditUtil.timeUtil(BriefingInfo.getDateFrom()));
    		Bean.setDateTo(EditUtil.timeUtil(BriefingInfo.getDateTo()));
    		Bean.setProCntPlan(EditUtil.intUtil(BriefingInfo.getProCntPlan()));
    		briefingInfoTblBean.add(Bean);
		}
    	
        return briefingInfoTblBean;
    }

	@Override
	public Integer briefingConfirmOrDeny(List<IdListEntity> list,Integer userCd,String statusFlg) {
		Integer briefingConfirmOrDeny = briefingTblMapper.briefingConfirmOrDeny(list, userCd, statusFlg);
		return briefingConfirmOrDeny;
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
