package Ansin.web.serviceimpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import Ansin.web.bean.B0002PopListBean;
import Ansin.web.bean.CompanyRegisterInitBean;
import Ansin.web.bean.CompanyScaleBean;
import Ansin.web.bean.CompanyTblPopBean;
import Ansin.web.bean.CountryMstBean;
import Ansin.web.bean.IndustryMstBean;
import Ansin.web.bean.PrefecturesMstBean;
import Ansin.web.entity.CompanyTblEntity;
import Ansin.web.entity.CompanyTblPopEntity;
import Ansin.web.entity.CountryMstEntity;
import Ansin.web.entity.IndustryMstEntity;
import Ansin.web.entity.PrefecturesMstEntity;
import Ansin.web.entity.UserTblEntity;
import Ansin.web.mapper.AdAddressMstMapper;
import Ansin.web.mapper.CompanyTblMapper;
import Ansin.web.mapper.CountryMstMapper;
import Ansin.web.mapper.IndustryMstMapper;
import Ansin.web.mapper.PrefecturesMstMapper;
import Ansin.web.mapper.UserTblMapper;
import Ansin.web.service.B0002Service;
import Ansin.web.util.EditUtil;
import Ansin.web.util.MD5Util;
import Ansin.web.vueForm.B0002VueForm;
import Ansin.web.vueForm.CompanyInfo;

@Service
public class IB0002ServiceImpl implements B0002Service{

	@Autowired
	private CompanyTblMapper companyRegisterMapper;
	@Autowired
	private IndustryMstMapper industryMstMapper;
	@Autowired
	private CountryMstMapper countryTblMapper;
	@Autowired
	private PrefecturesMstMapper prefecturesMstMapper;
	@Autowired
	private AdAddressMstMapper adAddressMstMapper;
	@Autowired
	private UserTblMapper userTblMapper;


	/**
	 * 画面初期化情報を取得
	 * @return companyRegisterInitResponse
	 */
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
	public List<CompanyTblPopEntity> selectCompanyInfo(String companyNm) {

		List<CompanyTblPopEntity> company = companyRegisterMapper.selectCompanyPop(companyNm, "", null, "",null);

		return company;
	}

	/**
	 * 検索条件通り、会社情報を取得
	 * @param companyNm address1 industryId1 companyScale
	 * @return company
	 */
	@Override
	public List<CompanyTblPopEntity> selectCompanyInfo(String companyNm, String address1, Integer industryId1,
			String companyScale,Integer countryId) {

		List<CompanyTblPopEntity> company = companyRegisterMapper.selectCompanyPop(companyNm, address1, industryId1,
				companyScale,countryId);

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

	/**
	 *都道府県と所属市区町村を取得
	 */
	@Override
	public List<String> getPostaOne(String postal) {
		List<String> str = adAddressMstMapper.getOne(postal);
 		return str;
	}

	/**
	 *都道府県を取得
	 */
	@Override
	public String getPrefeNm(String postal) {
		String str = adAddressMstMapper.getPrefeNm(postal);
 		return str;
	}


	/**
	 * 会社データを挿入
	 * @param companyInfoEntity
	 */
	@Override
	public Integer insertCompanyInfo(CompanyTblEntity companyInfoEntity) {
		return companyRegisterMapper.insertCompanyInfo(companyInfoEntity);
	}

	/**
	 * ユーザーデータを挿入
	 * @param companyInfoEntity
	 */
	@Override
	public Integer insertUserInfo(UserTblEntity userEntity) {
		return userTblMapper.insertUserInfo(userEntity);

	}


	/**
	 * Popup戻り値を取得
	 * @param companyInfo
	 * @return companyEntity
	 */
	public CompanyTblEntity editCompanyInfo(CompanyInfo companyInfo) {

		CompanyTblEntity companyEntity = new CompanyTblEntity();

		BeanUtils.copyProperties(companyInfo, companyEntity);
		companyEntity.setCountryId(EditUtil.intUtil(companyInfo.getCountryId()));
		companyEntity.setIndustryId1(EditUtil.intUtil(companyInfo.getIndustryId1()));
		companyEntity.setIndustryId2(EditUtil.intUtil(companyInfo.getIndustryId2()));
		companyEntity.setIndustryId3(EditUtil.intUtil(companyInfo.getIndustryId3()));
		companyEntity.setCapital(EditUtil.bigDecimalUtil(companyInfo.getCapital()));
		String salesAmount = companyInfo.getSalesAmount();
		companyEntity.setSalesAmount(StringUtils.isEmpty(salesAmount) ? null : EditUtil.bigDecimalUtil(salesAmount));
		companyEntity.setLicenseAddress(companyInfo.getLicenseAddress());
		return companyEntity;
	}

	/**
	 *　ユーザー情報編集する
	 * @param companyInfo
	 * @return userEntity
	 */
	public UserTblEntity editUserInfo(CompanyInfo companyInfo,Integer companyId) {

		UserTblEntity userEntity = new UserTblEntity();

		BeanUtils.copyProperties(companyInfo, userEntity);

		if (!"1".equals(companyInfo.getPopFlg())){
			userEntity.setAuthority("会社会員管理員(未認証)");
		} else {
			userEntity.setAuthority("会社会員(未認証)");
		}
		if (companyId != 0){
			userEntity.setCompanyId(companyId);
		}
		userEntity.setCountryZip(EditUtil.intUtil(companyInfo.getCountryZip()));
		userEntity.setPwd(MD5Util.md5Util(companyInfo.getPassword()));
		userEntity.setPhotoAddress(companyInfo.getPhotoAddress());

		return userEntity;
	}

	/**
	 *  メール存在チェック
	 * @param userEmail
	 * @return int
	 */
	@Override
	public Integer checkEmail(String userEmail) {
		return userTblMapper.userEmailCheck(userEmail);
	}
	/**
	 *新規登録確認画面編集
	 * @throws FileNotFoundException 
	 */
	@Override
	public B0002VueForm confirmOutput(B0002VueForm b0002VueForm) throws IOException{
		B0002VueForm b0002VueFormOutput;
		b0002VueFormOutput=b0002VueForm;

		// 謄本を取得
		String adress=b0002VueFormOutput.getCompanyInfo().getLicenseAddress();//謄本アドレス
		FileInputStream is = null;  
		File filePic = new File(adress);
		try {
			is = new FileInputStream(filePic);
		} catch (FileNotFoundException e) {
			 e.printStackTrace();
		}
		if (is != null){
			int i = is.available(); // ファイルサイズ
		    byte data[] = new byte[i];  
		    is.read(data); //データ読込 
		    is.close();  
		    b0002VueFormOutput.getCompanyInfo().setLicenseAddressPic(data);
		}
		return b0002VueFormOutput;
	}
}
