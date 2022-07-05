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

import Ansin.web.bean.PositionTblBean;
import Ansin.web.entity.PositionTblEntity;
import Ansin.web.mapper.PositionTblMapper;
import Ansin.web.service.B0101Service;
import Ansin.web.util.EditUtil;
import Ansin.web.vueForm.B0101VueForm;

@Service
public class IB0101ServiceImpl implements B0101Service{
	
	@Autowired
	private PositionTblMapper positionTblMapper;
	
	/**
	 * 職位一覧リスト
	 */
	@Override
	public List<PositionTblBean> getPositionAll(B0101VueForm b0101VueForm) {
		
		List<PositionTblEntity> positionTblEntityList = positionTblMapper.getAllPosition(b0101VueForm);
		
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
			positionTblBean.setWorkTimeFrom(EditUtil.timeUtil(positionTblEntity.getWorkTimeFrom()));
			positionTblBean.setWorkTimeTo(EditUtil.timeUtil(positionTblEntity.getWorkTimeTo()));
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
	/**
	 * 職位をオンラインするとオフラインするまたは複数操作
	 */
	@Override
	public int positionOnlineOrOffline(List<Integer> positionIdList, String onlineStatus, Integer companyId,
			Integer userCd) {
		
		int positionOnlineOrOfflineReturn = positionTblMapper.positionOnlineOrOffline(positionIdList, onlineStatus, companyId, userCd);
		return positionOnlineOrOfflineReturn;
	}
	/**
	 * 職位を削除または複数削除
	 */
	@Override
	public int positionDelete(List<Integer> positionIdList, Integer companyId, Integer userCd) {
		int positionDeleteReturn = positionTblMapper.positionDelete(positionIdList, companyId, userCd);
		return positionDeleteReturn;
	}
	/**
	 * 職位をtopまたは複数top
	 */
	@Override
	public int positionTop(List<Integer> positionIdList, String topStatus, Integer companyId,
			Integer userCd) {
		int positionTopReturn = positionTblMapper.positionTop(positionIdList, topStatus, companyId, userCd);
		return positionTopReturn;
	}
	
	
	
	@Override
	public List<PositionTblBean> confirmOutput(List<PositionTblBean> bean) throws IOException {
		List<PositionTblBean> beans;
		beans = bean;

		for (PositionTblBean positionBean : beans) {
			// 写真を取得
			if (positionBean.getWorkingAddress3() != "" && positionBean.getWorkingAddress3() != null) {
				String adress = positionBean.getWorkingAddress3();// 広告写真
				FileInputStream is = null;
				File filePic = new File(adress);
				try {
					is = new FileInputStream(filePic);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				if (is != null) {
					int i = is.available(); // ファイルサイズ
					byte data[] = new byte[i];
					is.read(data); // データ読込
					is.close();
					positionBean.setWorkingAddress3Pic(data);
				}
			}
			if (positionBean.getWorkingAddress2() != "" && positionBean.getWorkingAddress2() != null) {
				String adress = positionBean.getWorkingAddress2();// 広告写真
				FileInputStream is = null;
				File filePic = new File(adress);
				try {
					is = new FileInputStream(filePic);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				if (is != null) {
					int i = is.available(); // ファイルサイズ
					byte data[] = new byte[i];
					is.read(data); // データ読込
					is.close();
					positionBean.setWorkingAddress2Pic(data);
				}
			}
			if (positionBean.getWorkingAddress1() != "" && positionBean.getWorkingAddress1() != null) {
				String adress = positionBean.getWorkingAddress1();// 広告写真
				FileInputStream is = null;
				File filePic = new File(adress);
				try {
					is = new FileInputStream(filePic);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				if (is != null) {
					int i = is.available(); // ファイルサイズ
					byte data[] = new byte[i];
					is.read(data); // データ読込
					is.close();
					positionBean.setWorkingAddress1Pic(data);
				}
			}
			
		}
		return beans;
	}
}
