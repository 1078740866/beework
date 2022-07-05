package Ansin.web.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ansin.web.bean.TrainingApplTblBean;
import Ansin.web.entity.TrainingApplTblEntity;
import Ansin.web.mapper.TrainingApplTblMapper;
import Ansin.web.service.B0503Service;
import Ansin.web.util.DateFormatUtil;
import Ansin.web.util.EditUtil;
import Ansin.web.vueForm.B0503VueForm;

@Service
public class IB0503ServiceImpl implements B0503Service {
	@Autowired
	private TrainingApplTblMapper b0503mapper;

	/**
	 * 研修応募者を取得
	 * 
	 * @param B0503VueForm
	 * @return trainingAppl
	 */
	@Override
	public List<TrainingApplTblBean> getTrainingAppl(B0503VueForm B0503VueForm) {
		List<TrainingApplTblEntity> trainingApplTblEntity = b0503mapper.getTrainingAppl(B0503VueForm);
		List<TrainingApplTblBean> trainingApplTblBean = new ArrayList<TrainingApplTblBean>();
		for (TrainingApplTblEntity trainingAppl : trainingApplTblEntity) {
			TrainingApplTblBean bean = new TrainingApplTblBean();
			BeanUtils.copyProperties(trainingAppl, bean);
			bean.setApplicantId(EditUtil.intUtil(trainingAppl.getApplicantId()));
			bean.setCompanyId(EditUtil.intUtil(trainingAppl.getCompanyId()));
			bean.setTrainingId(EditUtil.intUtil(trainingAppl.getTrainingId()));
			bean.setUserCd(EditUtil.intUtil(trainingAppl.getUserCd()));
			bean.setBirthday(EditUtil.intUtil(DateFormatUtil.getAge(trainingAppl.getBirthday())));
			trainingApplTblBean.add(bean);
		}
		return trainingApplTblBean;
	}

	/**
	 * 研修応募者を受け取れまたは拒否
	 * 
	 * @param applicantIdList
	 * @param companyId
	 * @param training_id
	 * @return int型applConfirmUpdateReturn
	 */
	@Override
	public int applUpdateConfirmOrDeny(B0503VueForm b0503VueForm) {
		int applConfirmUpdateReturn = b0503mapper.applUpdateConfirmOrDeny(b0503VueForm);
		return applConfirmUpdateReturn;
	}
}
