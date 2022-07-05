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

import Ansin.web.bean.AdTblBean;
import Ansin.web.bean.HomeInitBean;
import Ansin.web.bean.JobtypeMstBean;
import Ansin.web.entity.AdTblEntity;
import Ansin.web.entity.JobtypeMstEntity;
import Ansin.web.mapper.AdTblMapper;
import Ansin.web.mapper.JobtypeMstMapper;
import Ansin.web.service.HomeService;
import Ansin.web.util.EditUtil;

@Service
public class IHomeServiceImpl implements HomeService {
	
	@Autowired
	private JobtypeMstMapper jobtypeMstMapper;
	@Autowired
	private AdTblMapper adTblMapper;
	
	/**
	   * 画面初期化情報を取得
	 * @return HomeInitResponse
	 */
	@Override
	public HomeInitBean getHomeInitResponse() {

		HomeInitBean homeInitBean = new HomeInitBean();
		
		// 職種を取得
		List<JobtypeMstEntity> jobtypeMstEntityList = jobtypeMstMapper.getAll();
		List<JobtypeMstBean> jobtypeMstList = new ArrayList<JobtypeMstBean>();
		for (JobtypeMstEntity jobtypeMstEntity : jobtypeMstEntityList) {
			JobtypeMstBean jobtypeMstBean = new JobtypeMstBean();
			BeanUtils.copyProperties(jobtypeMstEntity, jobtypeMstBean);
			jobtypeMstBean.setJobtypeId(EditUtil.intUtil(jobtypeMstEntity.getJobtypeId()));
			jobtypeMstBean.setIndustryId(EditUtil.intUtil(jobtypeMstEntity.getIndustryId()));
			jobtypeMstList.add(jobtypeMstBean);
		}
		homeInitBean.setJobtypeList(jobtypeMstList);
		
		// 広告を取得
		List<AdTblEntity> adTblEntityList = adTblMapper.getAllInit();
		List<AdTblBean> adTblList = new ArrayList<AdTblBean>();
		for (AdTblEntity adTblEntity : adTblEntityList) {
			AdTblBean adTblBean = new AdTblBean();
			BeanUtils.copyProperties(adTblEntity, adTblBean);
			adTblBean.setAdId(EditUtil.intUtil(adTblEntity.getAdId()));
			adTblBean.setLayoutId(EditUtil.intUtil(adTblEntity.getLayoutId()));
			adTblBean.setSalary(EditUtil.intUtil(adTblEntity.getSalary()));
			adTblBean.setCompanyId(EditUtil.intUtil(adTblEntity.getCompanyId()));
			adTblBean.setDateFrom(EditUtil.dateUtil(adTblEntity.getDateFrom()));
			adTblBean.setDateTo(EditUtil.dateUtil(adTblEntity.getDateTo()));
			adTblBean.setDays(EditUtil.intUtil(adTblEntity.getDays()));
			adTblBean.setSum(EditUtil.intUtil(adTblEntity.getSum()));
			adTblList.add(adTblBean);
		}
		homeInitBean.setAdList(adTblList);
		
		return homeInitBean;
	}
	
	/**
	 * 写真転換方法
	 * @param homeInitBean
	 * @return homeInitBeanList
	 * @throws IOException 
	 */
	@Override
	public HomeInitBean confirmOutput(HomeInitBean homeInitBean) throws IOException {
		HomeInitBean homeInitBeanList;
		homeInitBeanList = homeInitBean;

		for (AdTblBean adTblBean : homeInitBeanList.getAdList()) {
			// 写真を取得
			String adress = adTblBean.getPhoto();// 広告写真
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
				adTblBean.setPhotoAddress(data);
			}
		}
		return homeInitBeanList;
	}

}
