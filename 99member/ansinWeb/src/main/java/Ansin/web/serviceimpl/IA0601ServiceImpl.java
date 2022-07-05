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
import org.springframework.transaction.annotation.Transactional;

import Ansin.web.bean.A0601ListBean;
import Ansin.web.entity.A0601ListEntity;
import Ansin.web.entity.A0601ReportEntity;
import Ansin.web.mapper.BriefingTblMapper;
import Ansin.web.mapper.MessageTblMapper;
import Ansin.web.mapper.MessageTextTblMapper;
import Ansin.web.mapper.PositionTblMapper;
import Ansin.web.mapper.ReportTblMapper;
import Ansin.web.mapper.TrainingTblMapper;
import Ansin.web.mapper.UserTblMapper;
import Ansin.web.service.A0601Service;
import Ansin.web.util.EditUtil;
import Ansin.web.vueForm.A0601VueForm;
@Service
public class IA0601ServiceImpl implements A0601Service{
	
	@Autowired
	private ReportTblMapper reportTblMapper;
	@Autowired
	private UserTblMapper userTblMapper;
	@Autowired
	private MessageTblMapper messageTblMapper;
	@Autowired
	private MessageTextTblMapper messageTextTblMapper;
	@Autowired
	private PositionTblMapper positionTblMapper;
	@Autowired
	private TrainingTblMapper trainingTblMapper;
	@Autowired
	private BriefingTblMapper BriefingTblMapper;
	
	
	
	/**
	 * 通報一覧情報取得
	 * @return <List<A0601Bean>
	 */
	@Override
	public List<A0601ListBean> getAll(A0601VueForm a0601VueForm) {
		List<A0601ListEntity> a0601ListEntities = reportTblMapper.getReportAll(a0601VueForm);
		List<A0601ListBean> beans = new ArrayList<A0601ListBean>();
		for (A0601ListEntity entity : a0601ListEntities) {
			A0601ListBean bean = new A0601ListBean();
			BeanUtils.copyProperties(entity, bean);
			bean.setReportId(EditUtil.intUtil(entity.getReportId()));
			bean.setApplicantId(EditUtil.intUtil(entity.getApplicantId()));
			bean.setBriefingId(EditUtil.intUtil(entity.getBriefingId()));
			bean.setCompanyId(EditUtil.intUtil(entity.getCompanyId()));
			bean.setPositionId(EditUtil.intUtil(entity.getPositionId()));
			bean.setTrainingId(EditUtil.intUtil(entity.getTrainingId()));
			bean.setUpdateTime(EditUtil.timeStampUtil(entity.getUpdateTime()));
			if (entity.getReportSection().equals("0")) {
				bean.setWhistleblower(entity.getCompanyNm());
				bean.setWhistleblowered(entity.getFirstName() + " " + entity.getLastName());
				beans.add(bean);
			}else {
				bean.setWhistleblower(entity.getFirstName() + " " + entity.getLastName());
				bean.setWhistleblowered(entity.getCompanyNm());
				beans.add(bean);
			}
		}
		return beans;
	}
	
	/**
	 * 通報処理(職位)
	 * @param a0601VueForm
	 * @return Integer
	 */
	@Transactional
	@Override
	public Integer getSection(A0601VueForm a0601VueForm) {	
		int flgNum = reportTblMapper.changeFlg(a0601VueForm);
		//通報成功なら、ここで
		if (a0601VueForm.getStatusFlg().equals("1")) {
			if (flgNum != 0) {
				List<A0601ListEntity> entitys =  reportTblMapper.getChangeData(a0601VueForm.getReportIds());
				List<Integer> userList = new ArrayList<Integer>();
				List<Integer> positionList = new ArrayList<Integer>();
				List<Integer> trainingList = new ArrayList<Integer>();
				List<Integer> briefingList = new ArrayList<Integer>();
				for (A0601ListEntity entity : entitys) {
					//会社は応募者を通報する
					if (entity.getReportSection().equals("0")) {
						userList.add(entity.getUserCd());
					}else {
						if (entity.getTypeSection().equals("0")) {
							positionList.add(entity.getPositionId());
						}else if (entity.getTypeSection().equals("1")) {
							trainingList.add(entity.getTrainingId());
						}else if (entity.getTypeSection().equals("2")) {
							briefingList.add(entity.getBriefingId());
						}else {
							break;
						}
					}
				}
				if (userList.size() != 0) {
					userTblMapper.userStatusChange(userList,a0601VueForm.getUserCd());
				}
				if (positionList.size() != 0) {
					positionTblMapper.reportPosition(positionList,a0601VueForm.getUserCd());
					List<A0601ReportEntity> positionEntities = positionTblMapper.positionListSelect(positionList);
					for (A0601ReportEntity position : positionEntities) {
						messageTextTblMapper.reportSystemMessage(position.getPositionNm(), a0601VueForm.getUserCd());
						messageTblMapper.systemReportInsert(a0601VueForm.getUserCd(), position.getUserCd(), messageTextTblMapper.getMaxId());
					}
				}
				if (trainingList.size() != 0) {
					trainingTblMapper.reportTraining(trainingList, a0601VueForm.getUserCd());
					List<A0601ReportEntity> trainingEntities = trainingTblMapper.trainingListSelect(trainingList);
					for (A0601ReportEntity training : trainingEntities) {
						messageTextTblMapper.reportSystemMessage2(training.getTrainingNm(), a0601VueForm.getUserCd());
						messageTblMapper.systemReportInsert(a0601VueForm.getUserCd(), training.getUserCd(), messageTextTblMapper.getMaxId());
					}
				}
				if (briefingList.size() != 0) {
					BriefingTblMapper.reportBriefing(briefingList, a0601VueForm.getUserCd());
					List<A0601ReportEntity> briefingEntities = BriefingTblMapper.briefingListSelect(briefingList);
					for (A0601ReportEntity briefing : briefingEntities) {
						messageTextTblMapper.reportSystemMessage3(briefing.getBriefingNm(), a0601VueForm.getUserCd());
						messageTblMapper.systemReportInsert(a0601VueForm.getUserCd(), briefing.getUserCd(),messageTextTblMapper.getMaxId());
					}
				}
			}
		}
		return flgNum;
	}

	@Override
	public List<A0601ListBean> confirmOutput(List<A0601ListBean> bean) throws IOException {
			List<A0601ListBean> bean2 = new ArrayList<A0601ListBean>();
			for (A0601ListBean a0601Bean : bean) {
				A0601ListBean beanOutPut  = a0601Bean;
				if (beanOutPut.getScreenshot() != null) {
					// 謄本を取得
					String adress = beanOutPut.getScreenshot();// スクリーンショット
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
						beanOutPut.setSsByte(data);
						bean2.add(beanOutPut);
					}
				}else {
					bean2.add(beanOutPut);
				}
			}
		return bean2;
		
	}

	/**
	 * 通報データ件数取得
	 * @return String
	 */
	@Override
	public String getCount(A0601VueForm a0601VueForm) {
		return EditUtil.intUtil(reportTblMapper.getCount(a0601VueForm));
	}

}
