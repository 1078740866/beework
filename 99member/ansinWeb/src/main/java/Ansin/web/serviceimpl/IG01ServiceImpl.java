package Ansin.web.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ansin.web.bean.TestGoods2TblBean;
import Ansin.web.entity.TestGoods2Entity;
import Ansin.web.service.G01Service;
import Ansin.web.vueForm.G01VueForm;

@Service
public class IG01ServiceImpl implements G01Service {
	@Autowired
	private Ansin.web.mapper.TestGoods2Mapper TestGoods2Mapper ;


	/**
	 * 研修情報を取得
	 * 
	 * private String goodsDetail;
	private String goodsPhoto;
	private String goodsLink;
	private String goodsName;
	private String goodsTag;
	private String goodsPrice;
	 * 
	 * 
	 * 
	 * 
	 * @return training
	 */
	@Override
	public List<TestGoods2TblBean> getAllGoods2() {
		List<TestGoods2Entity> TestGoods2infoTblEntity = TestGoods2Mapper.getAllGoods2();
		List<TestGoods2TblBean> TestGoods2TblBean = new ArrayList<TestGoods2TblBean>();
		for (TestGoods2Entity TestGoods22Entity : TestGoods2infoTblEntity) {
			TestGoods2TblBean bean = new TestGoods2TblBean();
			BeanUtils.copyProperties(TestGoods22Entity, bean);
			bean.setGoodsDetail(TestGoods22Entity.getGoodsDetail());
			bean.setGoodsPhoto(TestGoods22Entity.getGoodsPhoto());
			bean.setGoodsLink(TestGoods22Entity.getGoodsLink());
			bean.setGoodsName(TestGoods22Entity.getGoodsName());
			bean.setGoodsTag(TestGoods22Entity.getGoodsTag());
			bean.setGoodsPrice(TestGoods22Entity.getGoodsPrice());
			
			
			TestGoods2TblBean.add(bean);
		}
		return TestGoods2TblBean;
	}

	

}
