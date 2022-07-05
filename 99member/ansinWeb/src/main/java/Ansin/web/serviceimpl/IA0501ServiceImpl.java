package Ansin.web.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ansin.web.bean.A0501Bean;
import Ansin.web.bean.AdTblBean;
import Ansin.web.entity.A0501ListEntity;
import Ansin.web.entity.AdTblEntity;
import Ansin.web.mapper.AdTblMapper;
import Ansin.web.service.A0501Service;
import Ansin.web.util.EditUtil;
import Ansin.web.vueForm.A0501VueForm;
@Service
public class IA0501ServiceImpl implements A0501Service{
	
	@Autowired
	private AdTblMapper adTblMapper;
	
	/**
	 * 広告一覧情報取得
	 * @param a0501VueForm
	 * @return <List<A0601Bean>
	 */
	@Override
	public List<A0501Bean> getAll(A0501VueForm a0501VueForm) {
		//広告リスト取得
		List<A0501ListEntity> a0501ListEntity = adTblMapper.getAll(a0501VueForm);
		List<A0501Bean> beans = new ArrayList<A0501Bean>();
		//編集
		for (A0501ListEntity entity : a0501ListEntity) {
			A0501Bean bean = new A0501Bean();
			BeanUtils.copyProperties(entity, bean);
			bean.setAdId(EditUtil.intUtil(entity.getAdId()));
			bean.setCompanyId(EditUtil.intUtil(entity.getCompanyId()));
			bean.setLayoutId(EditUtil.intUtil(entity.getLayoutId()));
			bean.setSum(EditUtil.intUtil(entity.getSum()));
			bean.setDateFrom(EditUtil.dateUtil(entity.getDateFrom()));
			bean.setDateTo(EditUtil.dateUtil(entity.getDateTo()));
			bean.setDays(EditUtil.intUtil(entity.getDays()));
			bean.setLayoutMoney(EditUtil.intUtil(entity.getLayoutMoney()));
			beans.add(bean);
		}
		return beans;
	}
	
	/**
	 * 削除ボタン押下
	 * @param a0501VueForm
	 * @return Integer
	 */
	@Override
	public Integer delete(List<Integer> adIds,Integer userCd) {
		return adTblMapper.delete(adIds, userCd);
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
		}
		return bean;
	}
	
}
