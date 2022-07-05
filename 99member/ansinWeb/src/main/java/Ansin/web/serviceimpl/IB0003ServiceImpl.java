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

import Ansin.web.bean.B0301Bean;
import Ansin.web.bean.ComChargeBean;
import Ansin.web.entity.B0003UserEntity;
import Ansin.web.entity.B0301Entity;
import Ansin.web.entity.CompanyTblEntity;
import Ansin.web.mapper.ApplicationTblMapper;
import Ansin.web.mapper.B0301ListMapper;
import Ansin.web.mapper.CompanyTblMapper;
import Ansin.web.mapper.UserTblMapper;
import Ansin.web.service.B0003Service;
import Ansin.web.util.DateFormatUtil;
import Ansin.web.util.EditUtil;

@Service
public class IB0003ServiceImpl implements B0003Service{
	
	@Autowired
	private ApplicationTblMapper applicationTblMapper;
	@Autowired
	private UserTblMapper userTblMapper;
	@Autowired
	private B0301ListMapper b0301ListMapper;
	@Autowired
	private CompanyTblMapper companyTblMapper;
	
	/**
	 * 未処理応募者件数取得
	 * @param companyId
	 * @return String
	 */
	@Override
	public String getCount(Integer companyId) {
		return EditUtil.intUtil(applicationTblMapper.getCount(companyId));
	}
	
	/**
	 * ユーザー情報取得
	 * @param userCd
	 * @param companyId
	 * @return UserTblBean
	 */
	@Override
	public ComChargeBean getUser(Integer userCd, Integer companyId) {
		B0003UserEntity b0003UserEntity = userTblMapper.getUserInfo(companyId, userCd);
		ComChargeBean userTblBean = new ComChargeBean();
		if(b0003UserEntity != null) {
			BeanUtils.copyProperties(b0003UserEntity, userTblBean);
			userTblBean.setUserName(b0003UserEntity.getFirstName() + " "  + b0003UserEntity.getLastName());
			userTblBean.setRemainder(EditUtil.intUtil(b0003UserEntity.getRemainder()));
		}
		return userTblBean;
	}
	
	/**
	 * 人材推薦リスト情報取得
	 * @param userCd
	 * @param companyId
	 * @return List<B0301Bean>
	 */
	@Override
	public List<B0301Bean> getList(Integer companyId) {
		
		//会社情報取得
		CompanyTblEntity com = companyTblMapper.getCompanyInfoById(companyId);
		
		if (com != null) {
			//人材推薦
			List<B0301Entity> b0301EntityList = b0301ListMapper.getList(com);
			List<B0301Bean> b0301BeanList = new ArrayList<B0301Bean>();
			for (B0301Entity b0301Entity : b0301EntityList) {
				B0301Bean bean = new B0301Bean();
				BeanUtils.copyProperties(b0301Entity, bean);
				bean.setApplicantId(EditUtil.intUtil(b0301Entity.getApplicantId()));
				bean.setUserCd(EditUtil.intUtil(b0301Entity.getUserCd()));
				bean.setWorkYears(EditUtil.intUtil(b0301Entity.getWorkYears()));
				bean.setName(b0301Entity.getFirstName() + " " + b0301Entity.getLastName());
				bean.setBirthday(EditUtil.intUtil(DateFormatUtil.getAge(b0301Entity.getBirthday())));
				bean.setHopeSalaryFrom(EditUtil.intUtil(b0301Entity.getHopeSalaryFrom()));
				bean.setHopeSalaryTo(EditUtil.intUtil(b0301Entity.getHopeSalaryTo()));
				bean.setUpdateTime(EditUtil.timeStampUtil(b0301Entity.getUpdateTime()));
				try {
					confirmOutput(bean);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				b0301BeanList.add(bean);
			}
			return b0301BeanList;
		}
		return null;
	}

	@Override
	public ComChargeBean confirmOutput(ComChargeBean comChargeBean) throws IOException {
		// TODO Auto-generated method stub
		ComChargeBean comChargeBeanOutput;
		comChargeBeanOutput=comChargeBean;

		// 写真を取得
		String adress=comChargeBeanOutput.getPhoto();//写真アドレス
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
		    comChargeBeanOutput.setPhotoPic(data);
		}
		return comChargeBeanOutput;
	}

	@Override
	public B0301Bean confirmOutput(B0301Bean b0301Bean) throws IOException {
		B0301Bean b0301BeanOutput;
		b0301BeanOutput=b0301Bean;

		// 写真を取得
		String adress=b0301BeanOutput.getPhoto();//写真アドレス
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
		    b0301BeanOutput.setPhotoPic(data);
		}
		return b0301BeanOutput;
	}

}
