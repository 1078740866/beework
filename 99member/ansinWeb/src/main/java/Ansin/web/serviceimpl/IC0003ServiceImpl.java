package Ansin.web.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ansin.web.bean.PositionTblBean;
import Ansin.web.entity.B0003UserEntity;
import Ansin.web.entity.PositionTblEntity;
import Ansin.web.mapper.PositionTblMapper;
import Ansin.web.mapper.UserTblMapper;
import Ansin.web.service.C0003Service;
import Ansin.web.util.EditUtil;

@Service
public class IC0003ServiceImpl implements C0003Service{
	
	@Autowired
	private UserTblMapper userTblMapper;
	@Autowired
	private PositionTblMapper positionTblMapper;
	
	/**
	 * 職位一覧リスト
	 */
	@Override
	public List<PositionTblBean> getPosition(Integer userCd) {
		List<PositionTblEntity> positionTblEntity = positionTblMapper.getPosition(userCd);
		List<PositionTblBean> positionTblBean = new ArrayList<PositionTblBean>();
		for (PositionTblEntity positionEntity : positionTblEntity) {
			PositionTblBean bean = new PositionTblBean();
			BeanUtils.copyProperties(positionEntity, bean);
			bean.setCompanyId(EditUtil.intUtil(positionEntity.getCompanyId()));
			bean.setIndustryId(EditUtil.intUtil(positionEntity.getIndustryId()));
			bean.setJobTypeId(EditUtil.intUtil(positionEntity.getJobTypeId()));
			bean.setPositionId(EditUtil.intUtil(positionEntity.getPositionId()));
			bean.setSkillId(EditUtil.intUtil(positionEntity.getSkillId()));
			bean.setPeoCnt(EditUtil.intUtil(positionEntity.getPeoCnt()));
			bean.setUserCd(EditUtil.intUtil(positionEntity.getUserCd()));
			bean.setSalaryMax(EditUtil.intUtil(positionEntity.getSalaryMax()));
			bean.setSalaryMin(EditUtil.intUtil(positionEntity.getSalaryMin()));
			bean.setExpDate(EditUtil.dateUtil(positionEntity.getExpDate()));
			bean.setUpdateTime(EditUtil.dateUtil(positionEntity.getUpdateTime()));
			bean.setWorkDateStr(EditUtil.dateUtil(positionEntity.getWorkDateStr()));
			bean.setWorkTimeFrom(EditUtil.timeUtil(positionEntity.getWorkTimeFrom()));
			bean.setWorkTimeTo(EditUtil.timeUtil(positionEntity.getWorkTimeTo()));
			positionTblBean.add(bean);
		}
		return positionTblBean;
	}
	/**
	 *  ユーザー情報
	 */
	@Override
	public B0003UserEntity getInfo(Integer companyId, Integer userCd) {
		B0003UserEntity getInfo = userTblMapper.getUserInfo(companyId, userCd);
		return getInfo;
	}

}
