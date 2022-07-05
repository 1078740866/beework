package Ansin.web.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ansin.web.bean.CompanyListBean;
import Ansin.web.bean.IndustryMstBean;
import Ansin.web.bean.PrefecturesMstBean;
import Ansin.web.entity.CompanyTblEntity;
import Ansin.web.entity.IndustryMstEntity;
import Ansin.web.entity.PrefecturesMstEntity;
import Ansin.web.mapper.CompanyTblMapper;
import Ansin.web.mapper.IndustryMstMapper;
import Ansin.web.mapper.PrefecturesMstMapper;
import Ansin.web.mapper.UserTblMapper;
import Ansin.web.service.A070102Service;
import Ansin.web.util.EditUtil;
import Ansin.web.vueForm.A070102VueForm;
@Service
public class IA070102ServiceImpl implements A070102Service{
	
	@Autowired
	private CompanyTblMapper companyTblMapper;
	@Autowired
	private IndustryMstMapper industryMstMapper;
	@Autowired
	private PrefecturesMstMapper prefecturesMstMapper;
	@Autowired
	private UserTblMapper userTblMapper;

	/**
	 * A0701_02_承認一覧画面(会社)一覧リスト
	 * @param a070102VueForm
	 * @return List<CompanyListBean>
	 */
	@Override
	public List<CompanyListBean> getCompanyInfo(A070102VueForm a070102VueForm) {
		List<CompanyTblEntity> entitys = companyTblMapper.selectCompany(a070102VueForm);
		List<CompanyListBean> beans = new ArrayList<CompanyListBean>();
		for (CompanyTblEntity entity : entitys) {
			CompanyListBean bean = new CompanyListBean();
			BeanUtils.copyProperties(entity, bean);
			bean.setCapital(EditUtil.bigDecimalToStrUtil(entity.getCapital()));
			bean.setSalesAmount(EditUtil.bigDecimalToStrUtil(entity.getSalesAmount()));
			bean.setCompanyId(EditUtil.intUtil(entity.getCompanyId()));
			bean.setCountryId(EditUtil.intUtil(entity.getCountryId()));
			bean.setCreateTime(EditUtil.timeStampUtil(entity.getCreateTime()));
			bean.setIndustryId1(EditUtil.intUtil(entity.getIndustryId1()));
			bean.setIndustryId2(EditUtil.intUtil(entity.getIndustryId2()));
			bean.setIndustryId3(EditUtil.intUtil(entity.getIndustryId3()));
			bean.setLevelId(EditUtil.intUtil(entity.getLevelId()));
			bean.setPayConsSum(EditUtil.intUtil(entity.getPayConsSum()));
			bean.setPoint(EditUtil.intUtil(entity.getPoint()));
			bean.setRemainder(EditUtil.intUtil(entity.getRemainder()));
			bean.setLicenseAddress(entity.getLicenseAddress());
			bean.setUpdateTime(EditUtil.timeStampUtil(entity.getUpdateTime()));
			beans.add(bean);
		}
		return beans;
	}
	
	/**
	 * A0701_02_承認一覧画面(業種)一覧リスト
	 * @return List<IndustryMstBean>
	 */
	@Override
	public List<IndustryMstBean> getIndustryMst() {
		List<IndustryMstEntity> industryMstEntity =  industryMstMapper.getAll();
		List<IndustryMstBean> list = new ArrayList<IndustryMstBean>();
		for (IndustryMstEntity entity : industryMstEntity) {
			IndustryMstBean bean = new IndustryMstBean();
			bean.setIndustryId(EditUtil.intUtil(entity.getIndustryId()));
			bean.setIndustryNm(entity.getIndustryNm());
			list.add(bean);
		}
		return list;
	}
	
	/**
	 * A0701_02_承認一覧画面(都道府県)一覧リスト
	 * @return List<PrefecturesMstBean>
	 */
	@Override
	public List<PrefecturesMstBean> getPrefecturesMst() {
		List<PrefecturesMstEntity> prefecturesMstEntity =  prefecturesMstMapper.getAll();
		List<PrefecturesMstBean> list = new ArrayList<PrefecturesMstBean>();
		for (PrefecturesMstEntity entity : prefecturesMstEntity) {
			PrefecturesMstBean bean = new PrefecturesMstBean();
			bean.setPrefeId(EditUtil.intUtil(entity.getPrefeId()));
			bean.setPrefeNm(entity.getPrefeNm());
			list.add(bean);
		}
		return list;
	}
	
	/**
	 * A0701_02_承認一覧画面(会社)単数または複数承認、拒否
	 * @param companyIdList
	 * @param userCd
	 * @param statusFlg
	 * @return Integer
	 */
	@Override
	public Integer companyConfirmOrDeny(List<Integer> companyIdList,Integer userCd,String statusFlg) {
		Integer companyConfirmOrDeny = companyTblMapper.updateCompanyInfo(companyIdList, userCd, statusFlg);
		
		if (companyConfirmOrDeny != 0) {
			List<Integer> list = companyTblMapper.getUsers(companyIdList);
			
			userTblMapper.updateUserStatusB(list,userCd);	
		}
		return companyConfirmOrDeny;
	}



}
