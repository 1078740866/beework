package Ansin.web.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ansin.web.bean.AdTblBean;
import Ansin.web.bean.B0002PopListBean;
import Ansin.web.bean.CompanyRegisterInitBean;
import Ansin.web.bean.CompanyScaleBean;
import Ansin.web.bean.CompanyTblPopBean;
import Ansin.web.bean.CountryMstBean;
import Ansin.web.bean.IndustryMstBean;
import Ansin.web.bean.LayoutMstBean;
import Ansin.web.bean.PrefecturesMstBean;
import Ansin.web.entity.AdTblEntity;
import Ansin.web.entity.CompanyTblPopEntity;
import Ansin.web.entity.CountryMstEntity;
import Ansin.web.entity.IndustryMstEntity;
import Ansin.web.entity.LayoutMstEntity;
import Ansin.web.entity.PrefecturesMstEntity;
import Ansin.web.mapper.AdTblMapper;
import Ansin.web.mapper.CompanyTblMapper;
import Ansin.web.mapper.CountryMstMapper;
import Ansin.web.mapper.IndustryMstMapper;
import Ansin.web.mapper.LayoutMstMapper;
import Ansin.web.mapper.PrefecturesMstMapper;
import Ansin.web.service.A0502Service;
import Ansin.web.util.EditUtil;
import Ansin.web.vueForm.A0502VueForm;
@Service
public class IA0502ServiceImpl implements A0502Service{
	
	@Autowired
	private AdTblMapper adTblMapper;
	@Autowired
	private LayoutMstMapper layoutMstMapper;
	@Autowired
	private CompanyTblMapper companyRegisterMapper;
	@Autowired
	private IndustryMstMapper industryMstMapper;
	@Autowired
	private CountryMstMapper countryTblMapper;
	@Autowired
	private PrefecturesMstMapper prefecturesMstMapper;
	
	/**
	 * 広告一覧情報取得
	 * @param a0501VueForm
	 * @return <List<AdTblBean>
	 */
	@Override
	public List<AdTblBean> getAll() {
		//広告リスト取得
		List<AdTblEntity> adTblEntity = adTblMapper.getAllInit();
		List<AdTblBean> beans = new ArrayList<AdTblBean>();
		//編集
		for (AdTblEntity entity : adTblEntity) {
			AdTblBean bean = new AdTblBean();
			BeanUtils.copyProperties(entity, bean);
			bean.setAdId(EditUtil.intUtil(entity.getAdId()));
			bean.setCompanyId(EditUtil.intUtil(entity.getCompanyId()));
			bean.setLayoutId(EditUtil.intUtil(entity.getLayoutId()));
			bean.setSum(EditUtil.intUtil(entity.getSum()));
			bean.setDateFrom(EditUtil.dateUtil(entity.getDateFrom()));
			bean.setDateTo(EditUtil.dateUtil(entity.getDateTo()));
			beans.add(bean);
		}
		return beans;
	}
	
	/**
	 * 一つ広告情報取得
	 * @param adId
	 * @return AdTblBean
	 */
	@Override
	public AdTblBean getOne(Integer adId) {
		AdTblEntity entity = adTblMapper.getOne(adId);
		AdTblBean bean = new AdTblBean();
		if (entity != null) {
			BeanUtils.copyProperties(entity, bean);
			bean.setAdId(EditUtil.intUtil(entity.getAdId()));
			bean.setCompanyId(EditUtil.intUtil(entity.getCompanyId()));
			bean.setLayoutId(EditUtil.intUtil(entity.getLayoutId()));
			bean.setSum(EditUtil.intUtil(entity.getSum()));
			bean.setDateFrom(EditUtil.dateUtil(entity.getDateFrom()));
			bean.setDateTo(EditUtil.dateUtil(entity.getDateTo()));
			bean.setDays(EditUtil.intUtil(entity.getDays()));
			bean.setSalary(EditUtil.intUtil(entity.getSalary()));
		}
		return bean;
	}

	/**
	 * 広告更新
	 * @param a0502VueForm
	 * @return Integer
	 */
	@Override
	public Integer update(A0502VueForm a0502VueForm) {
		return adTblMapper.update(a0502VueForm);
	}

	/**
	 * 広告登録
	 * @param a0502VueForm
	 * @return Integer
	 */
	@Override
	public Integer insert(A0502VueForm a0502VueForm) {
		return adTblMapper.insert(a0502VueForm);
	}


	/**
	 * Popup戻り値を取得
	 * @param companyList pageCount
	 * @return companyRegisterPOPResponse
	 */
	@Override
	public List<LayoutMstBean> getLayoutAll() {
		List<LayoutMstEntity> entitys = layoutMstMapper.getAll();
		List<LayoutMstBean> beans = new ArrayList<LayoutMstBean>();
		for (LayoutMstEntity entity : entitys) {
			LayoutMstBean bean = new LayoutMstBean();
			bean.setLayoutId(EditUtil.intUtil(entity.getLayoutId()));
			bean.setLayoutMoney(EditUtil.intUtil(entity.getLayoutMoney()));
			beans.add(bean);
		}
		return beans;
	}

	/**
	 * 検索状態更新できるのデータ
	 * @return List<AdTblEntity>
	 */
	@Override
	public List<Integer> getSelectFlg() {
		return adTblMapper.getSelectFlg();
	}

	/**
	 * 更新状態
	 * @param List<Integer>
	 * @return Integer
	 */
	@Override
	public Integer updateFlg(List<Integer> list) {
		return adTblMapper.updagtFlg(list);
	}

	
	
	@Override
	public CompanyRegisterInitBean getCompanyRegisterInitResponse() {

		CompanyRegisterInitBean companyRegisterInitBean = new CompanyRegisterInitBean();

		// 業種を取得
		List<IndustryMstEntity> industryMstEntityList = industryMstMapper.getAll();
		List<IndustryMstBean> industryMstList = new ArrayList<IndustryMstBean>();
		for (IndustryMstEntity industryMstEntity : industryMstEntityList) {
			IndustryMstBean industryMstBean = new IndustryMstBean();
			industryMstList.add(industryMstBean);
			BeanUtils.copyProperties(industryMstEntity, industryMstBean);
			industryMstBean.setIndustryId(EditUtil.intUtil(industryMstEntity.getIndustryId()));
		}
		companyRegisterInitBean.setIndustryList(industryMstList);

		// 国情報を取得
		List<CountryMstEntity> countryTblEntityList = countryTblMapper.getAll();
		List<CountryMstBean> countryMstList = new ArrayList<CountryMstBean>();
		for (CountryMstEntity countryTblEntity : countryTblEntityList) {
			CountryMstBean countryMstBean = new CountryMstBean();
			countryMstList.add(countryMstBean);
			BeanUtils.copyProperties(countryTblEntity, countryMstBean);
			countryMstBean.setCountryId(EditUtil.intUtil(countryTblEntity.getCountryId()));
		}
		companyRegisterInitBean.setCountryList(countryMstList);

		// 都道府県を取得
		List<PrefecturesMstEntity> prefecturesMstEntityList = prefecturesMstMapper.getAll();
		List<PrefecturesMstBean> prefecturesList = new ArrayList<PrefecturesMstBean>();
		for (PrefecturesMstEntity prefecturesMstEntity : prefecturesMstEntityList) {
			PrefecturesMstBean prefecturesMstBean = new PrefecturesMstBean();
			prefecturesList.add(prefecturesMstBean);
			BeanUtils.copyProperties(prefecturesMstEntity, prefecturesMstBean);
			prefecturesMstBean.setPrefeId(EditUtil.intUtil(prefecturesMstEntity.getPrefeId()));
		}
		companyRegisterInitBean.setPrefecturesList(prefecturesList);

		// 都道府県を取得
		List<CompanyScaleBean> companyScaleList = new ArrayList<CompanyScaleBean>();
		companyScaleList.add(new CompanyScaleBean("",""));
		companyScaleList.add(new CompanyScaleBean("0","20人以下"));
		companyScaleList.add(new CompanyScaleBean("1","20～99人"));
		companyScaleList.add(new CompanyScaleBean("2","100～299人"));
		companyScaleList.add(new CompanyScaleBean("3","300～499人"));
		companyScaleList.add(new CompanyScaleBean("4","500人以上"));
		companyRegisterInitBean.setCompanyScaleList(companyScaleList);

		return companyRegisterInitBean;
	}

	/**
	 * 検索条件通り、会社情報を取得
	 * @param companyNm address1 industryId1 companyScale
	 * @return company
	 */
	@Override
	public List<CompanyTblPopEntity> selectCompanyInfo(String companyNm, String address1, Integer industryId1,
			String companyScale, Integer countryId) {

		List<CompanyTblPopEntity> company = companyRegisterMapper.selectCompanyPop(companyNm, address1, industryId1,
				companyScale,countryId);

		return company;
	}

	/**
	 * 検索条件通り、会社情報を取得
	 * @param companyNm address1 industryId1 companyScale
	 * @return company
	 */
	@Override
	public List<CompanyTblPopEntity> selectCompanyInfo(String companyNm) {

		List<CompanyTblPopEntity> company = companyRegisterMapper.selectCompanyPop(companyNm, "", null, "",null);

		return company;
	}
	
	/**
	 * Popup戻り値を取得
	 * @param companyList pageCount
	 * @return companyRegisterPOPResponse
	 */
	public B0002PopListBean getPopListInfo(List<CompanyTblPopEntity> companyList) {

		B0002PopListBean b0002PopListBean = new B0002PopListBean();
		List<CompanyTblPopBean> companyTblBeanList = new ArrayList<>();
		CompanyTblPopBean bean = new CompanyTblPopBean();
		for (CompanyTblPopEntity companyTblEntity : companyList) {
			bean = new CompanyTblPopBean();
			BeanUtils.copyProperties(companyTblEntity, bean);
			bean.setCompanyId(EditUtil.intUtil(companyTblEntity.getCompanyId()));
			bean.setIndustryId1(EditUtil.intUtil(companyTblEntity.getIndustryId1()));
			bean.setIndustryId2(EditUtil.intUtil(companyTblEntity.getIndustryId2()));
			bean.setIndustryId3(EditUtil.intUtil(companyTblEntity.getIndustryId3()));
			bean.setCountryId(EditUtil.intUtil(companyTblEntity.getCountryId()));
			bean.setCapital(String.valueOf(companyTblEntity.getCapital()));
			bean.setSalesAmount(EditUtil.bigDecimalToStrUtil(companyTblEntity.getSalesAmount()));
			switch(companyTblEntity.getCompanyScale()) {
				case "0":
					bean.setCompanyScaleNm("20人以下");
					break;
				case "1":
					bean.setCompanyScaleNm("20～99人");
					break;
				case "2":
					bean.setCompanyScaleNm("100～299人");
					break;
				case "3":
					bean.setCompanyScaleNm("300～499人");
					break;
				case "4":
					bean.setCompanyScaleNm("500人以上");
					break;
				default:
			}
			companyTblBeanList.add(bean);
		}

		b0002PopListBean.setCompanyTblBeanList(companyTblBeanList);

		return b0002PopListBean;
	}


	
}
