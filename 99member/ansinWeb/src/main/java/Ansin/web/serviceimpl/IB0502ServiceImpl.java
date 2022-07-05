package Ansin.web.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ansin.web.bean.IndustryMstBean;
import Ansin.web.entity.IndustryMstEntity;
import Ansin.web.mapper.AdAddressMstMapper;
import Ansin.web.mapper.IndustryMstMapper;
import Ansin.web.mapper.TrainingTblMapper;
import Ansin.web.service.B0502Service;
import Ansin.web.util.EditUtil;
import Ansin.web.vueForm.B0502VueForm;



@Service
public class IB0502ServiceImpl implements B0502Service{
	@Autowired
	private TrainingTblMapper trainingTblMapper;
	@Autowired
	private IndustryMstMapper industryMapper;
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
	 * 市区町村の値を取得します
	 * @param postal
	 * @return List<String>
	 */
	@Override
	public List<String> getPostaOne(String postal){
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
　　	 * 研修情報を改修
	 * @param trainingEntity
	 * @return
	 */
	@Override
	public int specificsUpdate(B0502VueForm trainingEntity) {
		int specificsUpdateReturn = trainingTblMapper.specificsUpdate(trainingEntity);
		return specificsUpdateReturn;
	}
	/**
	  * 研修情報を新規
	 * @param trainingEntity
	 * @return
	 */
	@Override
	public int specificsInsert(B0502VueForm trainingEntity) {
		int specificsInsertReturn = trainingTblMapper.specificsInsert(trainingEntity);
		return specificsInsertReturn;
	}
	
		
}