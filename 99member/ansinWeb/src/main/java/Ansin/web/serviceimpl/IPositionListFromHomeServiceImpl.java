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

import Ansin.web.bean.CompanyAndUserBean;
import Ansin.web.bean.HomePositionLanBean;
import Ansin.web.bean.PositionListFromHomeBean;
import Ansin.web.bean.PositionTblBySearchIdBean;
import Ansin.web.entity.CompanyTblPopEntity;
import Ansin.web.entity.PositionTblBySearchIdEntity;
import Ansin.web.mapper.CompanyTblMapper;
import Ansin.web.mapper.PositionTblMapper;
import Ansin.web.service.PositionListFromHomeService;
import Ansin.web.util.EditUtil;
import Ansin.web.vueForm.HomeVueForm;

@Service
public class IPositionListFromHomeServiceImpl implements PositionListFromHomeService {
	
	@Autowired
	private PositionTblMapper positionTblMapper;
	@Autowired
	private CompanyTblMapper companyTblMapper;

	/**
	   *   ホームページの検索ボタンまたは職種または業種をクリックして、職位情報を取得
	 * @return PositionListFromHomeBean
	 */
	@Override
	public List<PositionListFromHomeBean> getPositionBySearchIdResponse(HomeVueForm homeVueForm) {
		
		List<PositionListFromHomeBean> positionList = new ArrayList<PositionListFromHomeBean>();
		int i;
		int j;
		int k;
		int h;
		int lanSize;
		
		// 職位情報を取得
		List<PositionTblBySearchIdEntity> positionTblBySearchIdEntityList = positionTblMapper.getAllBySearchId(homeVueForm);
		List<PositionTblBySearchIdBean> positionTblBySearchIdList = new ArrayList<PositionTblBySearchIdBean>();
		//取得した職位はarray型を保存する
		for (PositionTblBySearchIdEntity positionTblBySearchIdEntity : positionTblBySearchIdEntityList) {
			PositionTblBySearchIdBean bean = new PositionTblBySearchIdBean();
			BeanUtils.copyProperties(positionTblBySearchIdEntity, bean);
			bean.setCompanyId(EditUtil.intUtil(positionTblBySearchIdEntity.getCompanyId()));
			bean.setPositionId(EditUtil.intUtil(positionTblBySearchIdEntity.getPositionId()));
			bean.setIndustryId(EditUtil.intUtil(positionTblBySearchIdEntity.getIndustryId()));
			bean.setJobtypeId(EditUtil.intUtil(positionTblBySearchIdEntity.getJobtypeId()));
			bean.setWorkTimeFrom(EditUtil.timeUtil(positionTblBySearchIdEntity.getWorkTimeFrom()));
			bean.setWorkTimeTo(EditUtil.timeUtil(positionTblBySearchIdEntity.getWorkTimeTo()));
			bean.setSalaryMin(EditUtil.intUtil(positionTblBySearchIdEntity.getSalaryMin()));
			bean.setSalaryMax(EditUtil.intUtil(positionTblBySearchIdEntity.getSalaryMax()));
			bean.setPeoCnt(EditUtil.intUtil(positionTblBySearchIdEntity.getPeoCnt()));
			bean.setWorkDateStr(EditUtil.dateUtil(positionTblBySearchIdEntity.getWorkDateStr()));
			bean.setExpDate(EditUtil.dateUtil(positionTblBySearchIdEntity.getExpDate()));
			bean.setUpdateTime(EditUtil.dateUtil(positionTblBySearchIdEntity.getUpdateTime()));
			positionTblBySearchIdList.add(bean);
		}
		
		//編集上のリスト、データがbeansに保存する。
		for (i=0;i<positionTblBySearchIdList.size();i++) {
			
			PositionListFromHomeBean beans = new PositionListFromHomeBean();
			
			beans.setCompanyId(positionTblBySearchIdList.get(i).getCompanyId());
			beans.setCompanyNm(positionTblBySearchIdList.get(i).getCompanyNm());
			beans.setPositionId(positionTblBySearchIdList.get(i).getPositionId());
			beans.setPositionNm(positionTblBySearchIdList.get(i).getPositionNm());
			beans.setIndustryId(positionTblBySearchIdList.get(i).getIndustryId());
			beans.setIndustryNm(positionTblBySearchIdList.get(i).getIndustryNm());
			beans.setJobtypeId(positionTblBySearchIdList.get(i).getJobtypeId());
			beans.setJobtypeNm(positionTblBySearchIdList.get(i).getJobtypeNm());
			beans.setDegree(positionTblBySearchIdList.get(i).getDegree());
			beans.setPositionInt(positionTblBySearchIdList.get(i).getPositionInt());
			beans.setWorkContent(positionTblBySearchIdList.get(i).getWorkContent());
			beans.setContractSection(positionTblBySearchIdList.get(i).getContractSection());
			beans.setWorkTimeFrom(positionTblBySearchIdList.get(i).getWorkTimeFrom());
			beans.setWorkTimeTo(positionTblBySearchIdList.get(i).getWorkTimeTo());
			beans.setPostal(positionTblBySearchIdList.get(i).getPostal());
			beans.setPrefeNm(positionTblBySearchIdList.get(i).getPrefeNm());
			beans.setWorkAddress1(positionTblBySearchIdList.get(i).getWorkAddress1());
			beans.setWorkAddress2(positionTblBySearchIdList.get(i).getWorkAddress2());
			beans.setStation(positionTblBySearchIdList.get(i).getStation());
			beans.setExpYears(positionTblBySearchIdList.get(i).getExpYears());
			beans.setSalarySection(positionTblBySearchIdList.get(i).getSalarySection());
			beans.setSalaryMin(EditUtil.changePrice(positionTblBySearchIdList.get(i).getSalaryMin()));
			beans.setSalaryMax(EditUtil.changePrice(positionTblBySearchIdList.get(i).getSalaryMax()));
			beans.setPeoCnt(positionTblBySearchIdList.get(i).getPeoCnt());
			beans.setHoliday(positionTblBySearchIdList.get(i).getHoliday());
			beans.setEmpLaborIns(positionTblBySearchIdList.get(i).getEmpLaborIns());
			beans.setWelfare(positionTblBySearchIdList.get(i).getWelfare());
			beans.setTrainingFlg(positionTblBySearchIdList.get(i).getTrainingFlg());
			beans.setInspectionFlg(positionTblBySearchIdList.get(i).getInspectionFlg());
			beans.setConUpdFlg(positionTblBySearchIdList.get(i).getConUpdFlg());
			beans.setWorkDateStr(positionTblBySearchIdList.get(i).getWorkDateStr());
			beans.setWorkingAddress1(positionTblBySearchIdList.get(i).getWorkingAddress1());
			beans.setWorkingAddress2(positionTblBySearchIdList.get(i).getWorkingAddress2());
			beans.setWorkingAddress3(positionTblBySearchIdList.get(i).getWorkingAddress3());
			beans.setOnlineStatus(positionTblBySearchIdList.get(i).getOnlineStatus());
			beans.setTopStatus(positionTblBySearchIdList.get(i).getTopStatus());
			beans.setExpDate(positionTblBySearchIdList.get(i).getExpDate());
			beans.setCheckStatus(positionTblBySearchIdList.get(i).getCheckStatus());
			beans.setRemarks(positionTblBySearchIdList.get(i).getRemarks());
			beans.setUseFlg(positionTblBySearchIdList.get(i).getUseFlg());
			beans.setUpdateTime(positionTblBySearchIdList.get(i).getUpdateTime());
			
			lanSize = 1;
			
			//同じ職位データのサイズ取得する
			for (j=i;j<positionTblBySearchIdList.size();j++) {
				if (j+1 != positionTblBySearchIdList.size()) {
					if (positionTblBySearchIdList.get(j+1) != null && positionTblBySearchIdList.get(j).getCompanyId().equals(positionTblBySearchIdList.get(j+1).getCompanyId())
							&& positionTblBySearchIdList.get(j).getPositionId().equals(positionTblBySearchIdList.get(j+1).getPositionId())) {
						lanSize++;
					} else {
						j = positionTblBySearchIdList.size();
					}
				}
			}
			
			//当職位の職位言語データが複数時に一つずつリストに格納する。
			List<HomePositionLanBean> lanList = new ArrayList<HomePositionLanBean>();
			h=i;
			for (k=1;k<=lanSize;k++) {
				HomePositionLanBean HomePositionLanBean = new HomePositionLanBean();
				HomePositionLanBean.setLanguage(positionTblBySearchIdList.get(h).getLanguage());
				HomePositionLanBean.setLevelSection(positionTblBySearchIdList.get(h).getLevelSection());
				lanList.add(HomePositionLanBean);
				h++;
			}
			beans.setPositionLanList(lanList);
			positionList.add(beans);
			i = i + lanSize - 1;
			
		}
		
		return positionList;
	}

	/**
	   *   会社情報を取得
	 * @return CommonResult<CompanyListBean>
	 */
	@Override
	public CompanyAndUserBean getCompanyById(Integer companyId) {
		CompanyTblPopEntity entity = companyTblMapper.getInfoById(companyId);
		if (entity != null) {
			CompanyAndUserBean bean = new CompanyAndUserBean();
			BeanUtils.copyProperties(entity, bean);
			bean.setCapital(EditUtil.bigDecimalToStrUtil(entity.getCapital()));
			bean.setCompanyId(EditUtil.intUtil(entity.getCompanyId()));
			bean.setCompanyTel(EditUtil.intUtil(entity.getCountryId()));
			bean.setSalesAmount(EditUtil.bigDecimalToStrUtil(entity.getSalesAmount()));
			bean.setCreateTime(EditUtil.timeStampUtil(entity.getCreateTime()));
			bean.setIndustryId1(EditUtil.intUtil(entity.getIndustryId1()));
			bean.setIndustryId2(EditUtil.intUtil(entity.getIndustryId2()));
			bean.setIndustryId3(EditUtil.intUtil(entity.getIndustryId3()));
			bean.setLevelId(EditUtil.intUtil(entity.getLevelId()));
			bean.setPayConsSum(EditUtil.intUtil(entity.getPayConsSum()));
			bean.setPoint(EditUtil.intUtil(entity.getPoint()));
			bean.setRemainder(EditUtil.intUtil(entity.getRemainder()));
			bean.setUpdateTime(EditUtil.timeStampUtil(entity.getUpdateTime()));
			bean.setPositionCount(EditUtil.intUtil(positionTblMapper.getPositionCount(companyId)));
			bean.setUserName(entity.getFirstName() + " " + entity.getLastName());
			return bean;
		}
		return null;
	}
	
	
	/**
	 *新規登録確認画面編集
	 * @throws FileNotFoundException 
	 */
	@Override
	public CompanyAndUserBean confirmOutput(CompanyAndUserBean bean) throws IOException {
		CompanyAndUserBean companyBean = bean;

		if (companyBean.getCompanyLogo() != null) {
			// 謄本を取得
			String adress = companyBean.getCompanyLogo();//会社Logo
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
			    companyBean.setLogoByte(data);
			}
			return companyBean;
		}
		return companyBean;
		
	}

	/**
	 *会社の職位情報を取得
	 * @throws FileNotFoundException 
	 */
	@Override
	public List<PositionListFromHomeBean> getPositionByCompany(Integer companyId) {
		List<PositionListFromHomeBean> positionList = new ArrayList<PositionListFromHomeBean>();
		int i;
		int j;
		int k;
		int h;
		int lanSize;
		
		// 職位情報を取得
		List<PositionTblBySearchIdEntity> positionTblBySearchIdEntityList = positionTblMapper.getAllByCompanyId(companyId);
		List<PositionTblBySearchIdBean> positionTblBySearchIdList = new ArrayList<PositionTblBySearchIdBean>();
		//取得した職位はarray型を保存する
		for (PositionTblBySearchIdEntity positionTblBySearchIdEntity : positionTblBySearchIdEntityList) {
			PositionTblBySearchIdBean bean = new PositionTblBySearchIdBean();
			BeanUtils.copyProperties(positionTblBySearchIdEntity, bean);
			bean.setCompanyId(EditUtil.intUtil(positionTblBySearchIdEntity.getCompanyId()));
			bean.setPositionId(EditUtil.intUtil(positionTblBySearchIdEntity.getPositionId()));
			bean.setIndustryId(EditUtil.intUtil(positionTblBySearchIdEntity.getIndustryId()));
			bean.setJobtypeId(EditUtil.intUtil(positionTblBySearchIdEntity.getJobtypeId()));
			bean.setWorkTimeFrom(EditUtil.timeUtil(positionTblBySearchIdEntity.getWorkTimeFrom()));
			bean.setWorkTimeTo(EditUtil.timeUtil(positionTblBySearchIdEntity.getWorkTimeTo()));
			bean.setSalaryMin(EditUtil.intUtil(positionTblBySearchIdEntity.getSalaryMin()));
			bean.setSalaryMax(EditUtil.intUtil(positionTblBySearchIdEntity.getSalaryMax()));
			bean.setPeoCnt(EditUtil.intUtil(positionTblBySearchIdEntity.getPeoCnt()));
			bean.setWorkDateStr(EditUtil.dateUtil(positionTblBySearchIdEntity.getWorkDateStr()));
			bean.setExpDate(EditUtil.dateUtil(positionTblBySearchIdEntity.getExpDate()));
			bean.setUpdateTime(EditUtil.dateUtil(positionTblBySearchIdEntity.getUpdateTime()));
			positionTblBySearchIdList.add(bean);
		}
		
		//編集上のリスト、データがbeansに保存する。
		for (i=0;i<positionTblBySearchIdList.size();i++) {
			
			PositionListFromHomeBean beans = new PositionListFromHomeBean();
			
			beans.setCompanyId(positionTblBySearchIdList.get(i).getCompanyId());
			beans.setCompanyNm(positionTblBySearchIdList.get(i).getCompanyNm());
			beans.setPositionId(positionTblBySearchIdList.get(i).getPositionId());
			beans.setPositionNm(positionTblBySearchIdList.get(i).getPositionNm());
			beans.setIndustryId(positionTblBySearchIdList.get(i).getIndustryId());
			beans.setIndustryNm(positionTblBySearchIdList.get(i).getIndustryNm());
			beans.setJobtypeId(positionTblBySearchIdList.get(i).getJobtypeId());
			beans.setJobtypeNm(positionTblBySearchIdList.get(i).getJobtypeNm());
			beans.setDegree(positionTblBySearchIdList.get(i).getDegree());
			beans.setPositionInt(positionTblBySearchIdList.get(i).getPositionInt());
			beans.setWorkContent(positionTblBySearchIdList.get(i).getWorkContent());
			beans.setContractSection(positionTblBySearchIdList.get(i).getContractSection());
			beans.setWorkTimeFrom(positionTblBySearchIdList.get(i).getWorkTimeFrom());
			beans.setWorkTimeTo(positionTblBySearchIdList.get(i).getWorkTimeTo());
			beans.setPostal(positionTblBySearchIdList.get(i).getPostal());
			beans.setPrefeNm(positionTblBySearchIdList.get(i).getPrefeNm());
			beans.setWorkAddress1(positionTblBySearchIdList.get(i).getWorkAddress1());
			beans.setWorkAddress2(positionTblBySearchIdList.get(i).getWorkAddress2());
			beans.setStation(positionTblBySearchIdList.get(i).getStation());
			beans.setExpYears(positionTblBySearchIdList.get(i).getExpYears());
			beans.setSalarySection(positionTblBySearchIdList.get(i).getSalarySection());
			beans.setSalaryMin(EditUtil.changePrice(positionTblBySearchIdList.get(i).getSalaryMin()));
			beans.setSalaryMax(EditUtil.changePrice(positionTblBySearchIdList.get(i).getSalaryMax()));
			beans.setPeoCnt(positionTblBySearchIdList.get(i).getPeoCnt());
			beans.setHoliday(positionTblBySearchIdList.get(i).getHoliday());
			beans.setEmpLaborIns(positionTblBySearchIdList.get(i).getEmpLaborIns());
			beans.setWelfare(positionTblBySearchIdList.get(i).getWelfare());
			beans.setTrainingFlg(positionTblBySearchIdList.get(i).getTrainingFlg());
			beans.setInspectionFlg(positionTblBySearchIdList.get(i).getInspectionFlg());
			beans.setConUpdFlg(positionTblBySearchIdList.get(i).getConUpdFlg());
			beans.setWorkDateStr(positionTblBySearchIdList.get(i).getWorkDateStr());
			beans.setWorkingAddress1(positionTblBySearchIdList.get(i).getWorkingAddress1());
			beans.setWorkingAddress2(positionTblBySearchIdList.get(i).getWorkingAddress2());
			beans.setWorkingAddress3(positionTblBySearchIdList.get(i).getWorkingAddress3());
			beans.setOnlineStatus(positionTblBySearchIdList.get(i).getOnlineStatus());
			beans.setTopStatus(positionTblBySearchIdList.get(i).getTopStatus());
			beans.setExpDate(positionTblBySearchIdList.get(i).getExpDate());
			beans.setCheckStatus(positionTblBySearchIdList.get(i).getCheckStatus());
			beans.setRemarks(positionTblBySearchIdList.get(i).getRemarks());
			beans.setUseFlg(positionTblBySearchIdList.get(i).getUseFlg());
			beans.setUpdateTime(positionTblBySearchIdList.get(i).getUpdateTime());
			
			lanSize = 1;
			
			//同じ職位データのサイズ取得する
			for (j=i;j<positionTblBySearchIdList.size();j++) {
				if (j+1 != positionTblBySearchIdList.size()) {
					if (positionTblBySearchIdList.get(j+1) != null && positionTblBySearchIdList.get(j).getCompanyId().equals(positionTblBySearchIdList.get(j+1).getCompanyId())
							&& positionTblBySearchIdList.get(j).getPositionId().equals(positionTblBySearchIdList.get(j+1).getPositionId())) {
						lanSize++;
					} else {
						j = positionTblBySearchIdList.size();
					}
				}
			}
			
			//当職位の職位言語データが複数時に一つずつリストに格納する。
			List<HomePositionLanBean> lanList = new ArrayList<HomePositionLanBean>();
			h=i;
			for (k=1;k<=lanSize;k++) {
				HomePositionLanBean HomePositionLanBean = new HomePositionLanBean();
				HomePositionLanBean.setLanguage(positionTblBySearchIdList.get(h).getLanguage());
				HomePositionLanBean.setLevelSection(positionTblBySearchIdList.get(h).getLevelSection());
				lanList.add(HomePositionLanBean);
				h++;
			}
			beans.setPositionLanList(lanList);
			positionList.add(beans);
			i = i + lanSize - 1;
			
		}
		
		return positionList;
	}

}
