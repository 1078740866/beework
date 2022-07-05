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

import Ansin.web.bean.IndustryMstBean;
import Ansin.web.bean.JobtypeMstBean;
import Ansin.web.bean.SkillMstBean;
import Ansin.web.entity.IndustryMstEntity;
import Ansin.web.entity.JobtypeMstEntity;
import Ansin.web.entity.SkillMstEntity;
import Ansin.web.mapper.AdAddressMstMapper;
import Ansin.web.mapper.IndustryMstMapper;
import Ansin.web.mapper.JobtypeMstMapper;
import Ansin.web.mapper.PositionTblMapper;
import Ansin.web.mapper.SkillMstMapper;
import Ansin.web.service.B0102Service;
import Ansin.web.util.EditUtil;
import Ansin.web.vueForm.B0102VueForm;

/**
 * B0102_職位詳細情報 positionInfoServiceImpl
 * 
 * @author コウ テンキ
 * @date 2020-10-29 13:20:00
 */

@Service
public class IB0102ServiceImpl implements B0102Service {
	
	@Autowired
	private IndustryMstMapper industryMapper;
	@Autowired
	private JobtypeMstMapper jobtypeMstMapper;
	@Autowired
	private SkillMstMapper skillMstMapper;
    @Autowired
    private PositionTblMapper positionTblMapper;
    @Autowired
	private AdAddressMstMapper adAddressMstMapper;
    
    /**
	 * 画面初期化情報を取得
	 * @return
	 */
	@Override
	public List<IndustryMstBean> getIndustryAll(){
		List<IndustryMstEntity> industryMstEntity = industryMapper.getAll();
		List<IndustryMstBean> industryMstBean = new ArrayList<IndustryMstBean>();
		for (IndustryMstEntity industryEntity : industryMstEntity) {
			IndustryMstBean bean = new IndustryMstBean();
			BeanUtils.copyProperties(industryEntity, bean);
			bean.setIndustryId(EditUtil.intUtil(industryEntity.getIndustryId()));
			industryMstBean.add(bean);
		}
		return industryMstBean;
	}
	
	/**
	 * 初期職種選択リストを取得
	 */
	@Override
	public List<JobtypeMstBean> getJobtypeAll() {
		List<JobtypeMstEntity> allJobtype = jobtypeMstMapper.getAll();
		List<JobtypeMstBean> allJobtypeBean = new ArrayList<JobtypeMstBean>();
		for (JobtypeMstEntity jobtypeMstEntity : allJobtype) {
			JobtypeMstBean jobtypeMstBean = new JobtypeMstBean();
			allJobtypeBean.add(jobtypeMstBean);
			BeanUtils.copyProperties(jobtypeMstEntity, jobtypeMstBean);
			jobtypeMstBean.setIndustryId(EditUtil.intUtil(jobtypeMstEntity.getIndustryId()));
			jobtypeMstBean.setJobtypeId(EditUtil.intUtil(jobtypeMstEntity.getJobtypeId()));
		}
		return allJobtypeBean;
	}
	/**
	 * 初期skill選択リストを取得
	 */
	@Override
	public List<SkillMstBean> getSkillAll() {
		List<SkillMstEntity> allSkill = skillMstMapper.getAll();
		List<SkillMstBean> allSkillBean = new ArrayList<SkillMstBean>();
		for (SkillMstEntity skillMstEntity : allSkill) {
			SkillMstBean skillMstBean = new SkillMstBean();
			allSkillBean.add(skillMstBean);
			BeanUtils.copyProperties(skillMstEntity, skillMstBean);
			skillMstBean.setIndustryId(EditUtil.intUtil(skillMstEntity.getIndustryId()));
			skillMstBean.setJobtypeId(EditUtil.intUtil(skillMstEntity.getJobtypeId()));
			skillMstBean.setSkillId(EditUtil.intUtil(skillMstEntity.getSkillId()));
		}
		return allSkillBean;
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
     * B0102 職位情報追加
     * 
     * @param b0102VueForm
     * @param companyId
     * @param userCd
     * @return 情報追加結果
     */
    @Override
    public int addPosition(B0102VueForm b0102VueForm) {
        return positionTblMapper.addPosition(b0102VueForm);
    }

    /**
     * B0102 職位情報更新
     * 
     * @param b0102VueForm
     * @param companyId
     * @param userCd
     * @return 情報更新結果
     */
    @Override
    public int updPosition(B0102VueForm b0102VueForm) {
        return positionTblMapper.updPosition(b0102VueForm);
    }

	@Override
	public B0102VueForm confirmOutput(B0102VueForm b0102VueForm) throws IOException {
		// TODO Auto-generated method stub
		B0102VueForm b0102VueFormOutput;
		
		b0102VueFormOutput = b0102VueForm;

		// 写真を取得
		if (b0102VueFormOutput.getWorkingAddress3() != "" && b0102VueFormOutput.getWorkingAddress3() != null) {
			String adress = b0102VueFormOutput.getWorkingAddress3();// 広告写真
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
				b0102VueFormOutput.setWorkingAddress3Pic(data);
			}
		}
		if (b0102VueFormOutput.getWorkingAddress2() != "" && b0102VueFormOutput.getWorkingAddress2() != null) {
			String adress = b0102VueFormOutput.getWorkingAddress2();// 広告写真
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
				b0102VueFormOutput.setWorkingAddress2Pic(data);
			}
		}
		if (b0102VueFormOutput.getWorkingAddress1() != "" && b0102VueFormOutput.getWorkingAddress1() != null) {
			String adress = b0102VueFormOutput.getWorkingAddress1();// 広告写真
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
				b0102VueFormOutput.setWorkingAddress1Pic(data);
			}
		}
		return b0102VueFormOutput;
	}

	

}
