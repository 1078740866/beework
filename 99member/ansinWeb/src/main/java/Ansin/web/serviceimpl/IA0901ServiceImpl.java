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

import Ansin.web.bean.CountryMstBean;
import Ansin.web.bean.UserInfoBean;
import Ansin.web.entity.CountryMstEntity;
import Ansin.web.entity.UserTblEntity;
import Ansin.web.mapper.CountryMstMapper;
import Ansin.web.mapper.UserTblMapper;
import Ansin.web.service.A0901Service;
import Ansin.web.util.EditUtil;
import Ansin.web.util.MD5Util;
import Ansin.web.vueForm.A0002VueForm;
import Ansin.web.vueForm.A0902VueForm;
@Service
public class IA0901ServiceImpl implements A0901Service{
	
	@Autowired
	private UserTblMapper userTblMapper;
	@Autowired
	private CountryMstMapper countryMstMapper;
		
	@Override
	public UserInfoBean getUserInfoA(Integer userCd) {
		UserTblEntity userTblEntity = userTblMapper.getUserInfoA(userCd);
		UserInfoBean userInfoBean = new UserInfoBean();
		if (userTblEntity != null) {
			BeanUtils.copyProperties(userTblEntity, userInfoBean);
			userInfoBean.setUserCd(EditUtil.intUtil(userTblEntity.getUserCd()));
			userInfoBean.setCompanyId(EditUtil.intUtil(userTblEntity.getCompanyId()));
			userInfoBean.setCountryZip(EditUtil.intUtil(userTblEntity.getCountryZip()));
			userInfoBean.setPhotoAddress(userTblEntity.getPhotoAddress());
		}
		return userInfoBean;
	}
	
	@Override
	public UserInfoBean getUserInfoB(Integer userCd) {
		UserTblEntity userTblEntity = userTblMapper.getUserInfoB(userCd);
		UserInfoBean userInfoBean = new UserInfoBean();
		if(userTblEntity != null) {
			BeanUtils.copyProperties(userTblEntity, userInfoBean);
			userInfoBean.setUserCd(EditUtil.intUtil(userTblEntity.getUserCd()));
			userInfoBean.setCompanyId(EditUtil.intUtil(userTblEntity.getCompanyId()));
			userInfoBean.setCountryZip(EditUtil.intUtil(userTblEntity.getCountryZip()));
			userInfoBean.setPhotoAddress(userTblEntity.getPhotoAddress());
		}
		return userInfoBean;
	}

	@Override
	public UserInfoBean getUserInfoC(Integer userCd) {
		UserTblEntity userTblEntity = userTblMapper.getUserInfoC(userCd);
		UserInfoBean userInfoBean = new UserInfoBean();
		if (userTblEntity != null) {
			BeanUtils.copyProperties(userTblEntity, userInfoBean);
			userInfoBean.setUserCd(EditUtil.intUtil(userTblEntity.getUserCd()));
			userInfoBean.setCompanyId(EditUtil.intUtil(userTblEntity.getCompanyId()));
			userInfoBean.setCountryZip(EditUtil.intUtil(userTblEntity.getCountryZip()));
			userInfoBean.setPhotoAddress(userTblEntity.getPhotoAddress());
		}
		return userInfoBean;
	}

	@Override
	public List<CountryMstBean> getAll() {
		List<CountryMstEntity> allCou = countryMstMapper.getAll();
		List<CountryMstBean> allCouBean = new ArrayList<CountryMstBean>();
		for(CountryMstEntity countryMstEntity : allCou) {
			CountryMstBean countryMstBean = new CountryMstBean();
			allCouBean.add(countryMstBean);
			BeanUtils.copyProperties(countryMstEntity, countryMstBean);
			countryMstBean.setCountryId(EditUtil.intUtil(countryMstEntity.getCountryId()));		
		}
		return allCouBean;
	}

	@Override
	public Integer updateUserInfo(UserTblEntity userEntity) {
		Integer updateUserInfo = userTblMapper.updateUserInfo(userEntity);
		return updateUserInfo;
	}

	@Override
	public String getPassword(Integer userCd) {
		String getPassword = userTblMapper.getPassword(userCd);
		return getPassword;
	}

	@Override
	public Integer updateUserPassword(A0902VueForm a0902VueForm, Integer userCd) {
		Integer updateUserPassword = userTblMapper.updateUserPwd(a0902VueForm, userCd);
		return updateUserPassword;
	}
	
	/**
	 *　ユーザー情報編集する
	 * @param companyInfo
	 * @return userEntity
	 */
	public UserTblEntity editUserInfo(A0002VueForm a0002VueForm) {

		UserTblEntity userEntity = new UserTblEntity();

		BeanUtils.copyProperties(a0002VueForm, userEntity);

		userEntity.setCompanyId(EditUtil.intUtil(a0002VueForm.getCompanyId()));
		userEntity.setCountryZip(EditUtil.intUtil(a0002VueForm.getCountryZip()));
		userEntity.setPwd(MD5Util.md5Util(a0002VueForm.getPwd()));
		userEntity.setPhotoAddress(a0002VueForm.getPhotoAddress());

		return userEntity;
	}

	@Override
	public UserInfoBean confirmOutput(UserInfoBean usrInfoBean) throws IOException {
		// TODO Auto-generated method stub
		UserInfoBean usrInfoBeanOutput;
		usrInfoBeanOutput=usrInfoBean;

		// 写真を取得
		String adress=usrInfoBeanOutput.getPhotoAddress();//写真アドレス
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
		    usrInfoBeanOutput.setPhotoAddressPic(data);
		}
		return usrInfoBeanOutput;
	}

}
