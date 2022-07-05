package Ansin.web.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ansin.web.bean.UserInfoBean;
import Ansin.web.entity.UserTblEntity;
import Ansin.web.mapper.UserTblMapper;
import Ansin.web.service.A070101Service;
import Ansin.web.util.EditUtil;
import Ansin.web.vueForm.A070101VueForm;
@Service
public class IA070101ServiceImpl implements A070101Service{
	
	@Autowired
	private UserTblMapper userTblMapper;

	/**
	 * B0805未認証会社員一覧リスト
	 * @param companyId
	 * @return List<UserInfoBean>
	 */
	@Override
	public List<UserInfoBean> getEmployeeAll(Integer companyId,A070101VueForm a070101VueForm) {
		List<UserTblEntity> alluserInfoEntity = userTblMapper.getEmployeeAll(companyId, a070101VueForm);
		List<UserInfoBean> alluserInfoBean = new ArrayList<UserInfoBean>();
		for(UserTblEntity userTblEntity : alluserInfoEntity) {
			UserInfoBean userInfoBean = new UserInfoBean();
			alluserInfoBean.add(userInfoBean);
			BeanUtils.copyProperties(userTblEntity, userInfoBean);
			userInfoBean.setUserCd(EditUtil.intUtil(userTblEntity.getUserCd()));
			userInfoBean.setCompanyId(EditUtil.intUtil(userTblEntity.getCompanyId()));
			userInfoBean.setCountryZip(EditUtil.intUtil(userTblEntity.getCountryZip()));
			userInfoBean.setPhotoAddress(userTblEntity.getPhotoAddress());
		}
		return alluserInfoBean;
	}

	/**
	 * すべてユーザーリスト
	 * @return List<UserInfoBean>
	 */
	@Override
	public List<UserInfoBean> getAll(A070101VueForm a070101VueForm) {
		List<UserTblEntity> alluserInfoEntity = userTblMapper.getCheckAll(a070101VueForm);
		List<UserInfoBean> alluserInfoBean = new ArrayList<UserInfoBean>();
		for(UserTblEntity userTblEntity : alluserInfoEntity) {
			UserInfoBean userInfoBean = new UserInfoBean();
			alluserInfoBean.add(userInfoBean);
			BeanUtils.copyProperties(userTblEntity, userInfoBean);
			userInfoBean.setUserCd(EditUtil.intUtil(userTblEntity.getUserCd()));
			userInfoBean.setCompanyId(EditUtil.intUtil(userTblEntity.getCompanyId()));
			userInfoBean.setCountryZip(EditUtil.intUtil(userTblEntity.getCountryZip()));
			userInfoBean.setPhotoAddress(userTblEntity.getPhotoAddress());
		}
		return alluserInfoBean;
	}
	
	/**
	 *未認証ユーザーから単数承認または複数承認（システム管理者）
	 * @param userCdList
	 * @param userCd
	 * @return Integer
	 */
	@Override
	public Integer updateUserStatusA(List<Integer> userCdList, Integer userCd) {
		Integer updateUserStatusA = userTblMapper.updateUserStatusA(userCdList,userCd);
		return updateUserStatusA;
	}


	/**
	 *未認証ユーザーから単数承認または複数承認（会社会員）
	 * @param userCdList
	 * @param userCd
	 * @return Integer
	 */
	@Override
	public Integer updateUserStatusC(List<Integer> userCdList, Integer userCd) {
		Integer updateUserStatusB = userTblMapper.updateUserStatusB(userCdList,userCd);
		return updateUserStatusB;
	}
	
	/**
	 *未認証ユーザーから単数承認または複数拒否（すべて拒否）
	 * @param userCdList
	 * @param userCd
	 * @return Integer
	 */
	@Override
	public Integer rejectUserStatus(List<Integer> userCdList, Integer userCd) {
		Integer updateUserStatus = userTblMapper.rejectUserStatus(userCdList,userCd);
		return updateUserStatus;
	}


}
