package Ansin.web.serviceimpl;

import java.util.ArrayList;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ansin.web.bean.DegreeBean;
import Ansin.web.bean.EduSectionBean;
import Ansin.web.bean.OubosyaListBean;
import Ansin.web.bean.PositionBean;
import Ansin.web.dto.B0201SearchDto;
import Ansin.web.entity.B0201Entity;
import Ansin.web.entity.PositionTblEntity;
import Ansin.web.mapper.B0201ListMapper;
import Ansin.web.mapper.PositionTblMapper;
import Ansin.web.service.B0201Service;
import Ansin.web.util.DateFormatUtil;
import Ansin.web.util.EditUtil;
import Ansin.web.vueForm.B0201SearchVueForm;

@Service
public class IB0201ServiceImpl implements B0201Service{

	@Autowired
	private PositionTblMapper positionTblMapper;
	@Autowired
	private B0201ListMapper b0201ListMapper;

	/**
	 * 該当会社の全部職位を取得する
	 * @param companyId
	 * @return 職位LIST
	 */
	@Override
	public ArrayList<PositionBean> getPosition(Integer companyId) {

		ArrayList<PositionTblEntity> positionEntityList = positionTblMapper.getPositionForDroplist(companyId);

		PositionBean positionBean = new PositionBean();
		ArrayList<PositionBean> syokuIBeanList = new ArrayList<PositionBean>();
		for (PositionTblEntity entity : positionEntityList) {
			positionBean = new PositionBean();
			positionBean.setPositionId(entity.getPositionId());
			positionBean.setPositionNm(entity.getPositionNm());
			syokuIBeanList.add(positionBean);
		}

		return syokuIBeanList;

	}

	/**
	 *  学位を編集する
	 */
	public ArrayList<DegreeBean> editDegree() {

		ArrayList<DegreeBean> gakuIFromBeanList = new ArrayList<DegreeBean>();
		gakuIFromBeanList.add(new DegreeBean("0", "その他"));
		gakuIFromBeanList.add(new DegreeBean("1", "職業訓練校、予備校"));
		gakuIFromBeanList.add(new DegreeBean("2", "専門学校"));
		gakuIFromBeanList.add(new DegreeBean("3", "短期大学"));
		gakuIFromBeanList.add(new DegreeBean("4", "大学"));
		gakuIFromBeanList.add(new DegreeBean("5", "大学院（修士）"));
		gakuIFromBeanList.add(new DegreeBean("6", "大学院（博士）"));
		return gakuIFromBeanList;
	}

	/**
	 *  学歴区分を編集する
	 */
	public ArrayList<EduSectionBean> editEduSection() {

		ArrayList<EduSectionBean> eduSectionBeanList = new ArrayList<EduSectionBean>();
		eduSectionBeanList.add(new EduSectionBean("0", "非大学"));
		eduSectionBeanList.add(new EduSectionBean("1", "私立大学"));
		eduSectionBeanList.add(new EduSectionBean("2", "国立大学"));
		return eduSectionBeanList;

	}

	/**
	 * 応募者明細リストを取得する
	 * @param b0201VueForm
	 * @return OubosyaListBean
	 */
	@Override
	public ArrayList<OubosyaListBean> getList(B0201SearchVueForm searchForm) {

		B0201SearchDto searchDto = new B0201SearchDto();
		BeanUtils.copyProperties(searchForm, searchDto);
		searchDto.setAgeFrom(DateFormatUtil.convertDate(searchForm.getAgeTo()));
		searchDto.setAgeTo(DateFormatUtil.convertDate(searchForm.getAgeFrom()));

		ArrayList<B0201Entity> b0201EntityList = b0201ListMapper.getAll(searchDto);

		ArrayList<OubosyaListBean> oubosyaList = new ArrayList<OubosyaListBean>();
		OubosyaListBean oubosyaListBean = new OubosyaListBean();
		for (B0201Entity b0201Entity : b0201EntityList) {

			oubosyaListBean = new OubosyaListBean();
			BeanUtils.copyProperties(b0201Entity, oubosyaListBean);

			// 応募者名前
			oubosyaListBean.setOubosyaName(b0201Entity.getFirstName() + " " + b0201Entity.getLastName());
			// 住所
			oubosyaListBean.setAddress(b0201Entity.getAddress1());
			// 年齢
			oubosyaListBean.setAge(String.valueOf(DateFormatUtil.getAge(b0201Entity.getBirthday())));
			// 応募日
			oubosyaListBean.setUpdateTime(DateFormatUtil.dateToString(b0201Entity.getUpdateTime()));
			// 仕事経験年数
			oubosyaListBean.setWorkYears(String.valueOf(b0201Entity.getWorkYears()));
			// 職位ID
			oubosyaListBean.setPositionId(EditUtil.intUtil(b0201Entity.getPositionId()));
			// 応募者ID
			oubosyaListBean.setApplicantId(EditUtil.intUtil(b0201Entity.getApplicantId()));

			oubosyaList.add(oubosyaListBean);
		}

		return oubosyaList;
	}

	/**
	   *   応募者の状態を変更する
	 * @param applicationStatus
	 * @param companyId
	 * @param positionIdList
	 * @param applicantIdList
	 * @return updateReturn
	 */
	@Override
	public int update(String applicationStatus, Integer companyId, ArrayList<Integer> positionIdList,
			ArrayList<Integer> applicantIdList) {

		int updateReturn = b0201ListMapper.deleteMultiple(applicationStatus, companyId, positionIdList, applicantIdList);

		return updateReturn;
	}
}
