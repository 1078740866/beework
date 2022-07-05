package Ansin.web.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ansin.web.bean.BriefingInfoTblBean;
import Ansin.web.bean.PrefecturesMstBean;
import Ansin.web.entity.ApplicantConnEntity;
import Ansin.web.entity.BriefingInfoTblEntity;
import Ansin.web.entity.PrefecturesMstEntity;
import Ansin.web.mapper.ApplicantInfoTblMapper;
import Ansin.web.mapper.BriefingApplTblMapper;
import Ansin.web.mapper.BriefingTblMapper;
import Ansin.web.mapper.PrefecturesMstMapper;
import Ansin.web.service.C0401Service;
import Ansin.web.util.EditUtil;
import Ansin.web.vueForm.C0401ListVueForm;
import Ansin.web.vueForm.C0401VueForm;

@Service
public class IC0401ServiceImpl implements C0401Service{
	
	@Autowired
	private PrefecturesMstMapper prefecturesMstMapper;
	@Autowired
	private ApplicantInfoTblMapper applicantInfoTblMapper;
	@Autowired
    private BriefingTblMapper briefingTblMapper;
	@Autowired
    private BriefingApplTblMapper briefingApplTblMapper;
	@Override
	
	public List<PrefecturesMstBean> getPreAndCity() {
		List<PrefecturesMstEntity> allPrefectures = prefecturesMstMapper.getAll();
		List<PrefecturesMstBean> allPrefecturesBean = new ArrayList<PrefecturesMstBean>();
		for(PrefecturesMstEntity prefecturesMstEntity : allPrefectures) {
			PrefecturesMstBean prefecturesMstBean = new PrefecturesMstBean();
			allPrefecturesBean.add(prefecturesMstBean);
			BeanUtils.copyProperties(prefecturesMstEntity, prefecturesMstBean);
			prefecturesMstBean.setPrefeId(EditUtil.intUtil(prefecturesMstEntity.getPrefeId()));
		}
		return allPrefecturesBean;
	}
	
	/**
	 * C0401説明会推薦一覧リスト
	 * @param c0401VueForm
	 * @param session
	 * @param results
	 * @return
	 */
	@Override
	public List<BriefingInfoTblBean> getBriefing(Integer userCd) {
		
		ApplicantConnEntity app = applicantInfoTblMapper.getApplicantInfo(userCd);
		
		if(app != null) {
			List<BriefingInfoTblEntity> briefingInfoTblEntity = briefingTblMapper.getBriefing(app);
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
		 return null;
       
    }
	@Override
	public List<BriefingInfoTblBean> getBriefingPost(C0401ListVueForm c0401ListVueForm) {
    	List<BriefingInfoTblEntity> briefingInfoTblEntity = briefingTblMapper.getBriefingPost(c0401ListVueForm);
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
	public List<BriefingInfoTblBean> getBriefingLike(C0401ListVueForm c0401ListVueForm) {
    	List<BriefingInfoTblEntity> briefingInfoTblEntity = briefingTblMapper.getBriefingLike(c0401ListVueForm);
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
	public Integer getAppId(Integer userCd) {
		Integer applicantId = applicantInfoTblMapper.getApplicantIds(userCd);
		return applicantId;
	}
	@Override
	public Integer insertPost(List<C0401VueForm> c0401VueForm) {
		int insertPost = briefingApplTblMapper.insertPost(c0401VueForm);
		return insertPost;
	}
	@Override
	public Integer insertLike(List<C0401VueForm> c0401VueForm) {
		int insertLike = briefingApplTblMapper.insertLike(c0401VueForm);
		return insertLike;
	}
	@Override
	public Integer updateLike(List<C0401VueForm> c0401VueForm, Integer userCd, Integer applicantId) {
		int updateLike = briefingApplTblMapper.updateLike(c0401VueForm, userCd, applicantId);
		return updateLike;
	}
	@Override
	public Integer deleteBriefingAppl(List<C0401VueForm> c0401VueForm, Integer userCd, Integer applicantId) {
		int deleteTrainingAppl = briefingApplTblMapper.deleteBriefingAppl(c0401VueForm, userCd, applicantId);
		return deleteTrainingAppl;
	}

	/**
	 * C0401説明会検索ボタン押下リスト
	 * @param c0401VueForm
	 * @param session
	 * @param results
	 * @return
	 */
	public List<BriefingInfoTblBean> getList(C0401ListVueForm c0401ListVueForm) {
		c0401ListVueForm.setApplicantId(applicantInfoTblMapper.getApplicantIds(c0401ListVueForm.getUserCd()));
    	List<BriefingInfoTblEntity> briefingInfoTblEntity = briefingTblMapper.getList(c0401ListVueForm);
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

	

}
