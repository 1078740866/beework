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
import Ansin.web.bean.InterviewHisTblBean;
import Ansin.web.entity.InterviewHisTblEntity;
import Ansin.web.mapper.ApplicantInfoTblMapper;
import Ansin.web.mapper.InterviewHisTblMapper;
import Ansin.web.service.C0501Service;
import Ansin.web.util.EditUtil;
import Ansin.web.vueForm.B0401VueForm;

/**
 * C0501_面接一覧画面Service
 * 
 * @author 楊卿赫
 * @date 2021-01-04 17:30:07
 */

@Service
public class IC0501ServiceImpl implements C0501Service {

	@Autowired
	private InterviewHisTblMapper interviewHisTblMapper;
	@Autowired
	private ApplicantInfoTblMapper applicantInfoTblMapper;

	/**
	 * C0501_面接一覧画面データ
	 * 
	 * @param b0401VueForm
	 * @return List<InterviewHisTblEntity>
	 */
	@Override
	public List<InterviewHisTblBean> getInterviewHisTblEntityList(B0401VueForm b0401VueForm) {
		
		//ユーザー応募者IDを取得
		int appId = applicantInfoTblMapper.getApplicantIds(b0401VueForm.getUserCd());
		
		if (appId != 0) {
			b0401VueForm.setApplicantId(appId);
			List<InterviewHisTblEntity> interviewHisTblEntityList = interviewHisTblMapper.getAllInfoUser(b0401VueForm);
			List<InterviewHisTblBean> interviewHisTblBeanList = new ArrayList<InterviewHisTblBean>();
			
			for(InterviewHisTblEntity interviewHisTblEntity : interviewHisTblEntityList) {
				InterviewHisTblBean interviewHisTblBean = new InterviewHisTblBean();
				BeanUtils.copyProperties(interviewHisTblEntity, interviewHisTblBean);
				interviewHisTblBean.setInterviewId(EditUtil.intUtil(interviewHisTblEntity.getInterviewId()));
				interviewHisTblBean.setCompanyId(EditUtil.intUtil(interviewHisTblEntity.getCompanyId()));
				interviewHisTblBean.setPositionId(EditUtil.intUtil(interviewHisTblEntity.getPositionId()));
				interviewHisTblBean.setApplicantId(EditUtil.intUtil(interviewHisTblEntity.getApplicantId()));
				interviewHisTblBean.setInterviewDate(EditUtil.dateUtil(interviewHisTblEntity.getInterviewDate()));
				interviewHisTblBean.setDateFrom(EditUtil.timeUtil(interviewHisTblEntity.getDateFrom()));
				interviewHisTblBean.setDateTo(EditUtil.timeUtil(interviewHisTblEntity.getDateTo()));
				interviewHisTblBean.setName(interviewHisTblEntity.getFirstName() + " " + interviewHisTblEntity.getLastName());
				try {
					confirmOutput(interviewHisTblBean);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				interviewHisTblBeanList.add(interviewHisTblBean);
			}
			return interviewHisTblBeanList;
		}
		return null;
	}

	/**
	 * C0501_面接一覧画面未処理データ
	 * 
	 * @param b0401VueForm
	 * @return List<InterviewHisTblEntity>
	 */
	@Override
	public List<InterviewHisTblBean> getInterviewHisTblEntityList2(B0401VueForm b0401VueForm) {
		
		//ユーザー応募者IDを取得
		int appId = applicantInfoTblMapper.getApplicantIds(b0401VueForm.getUserCd());
		
		if (appId != 0) {
			b0401VueForm.setApplicantId(appId);
			List<InterviewHisTblEntity> interviewHisTblEntityList = interviewHisTblMapper.getAllForUser(b0401VueForm);
			List<InterviewHisTblBean> interviewHisTblBeanList = new ArrayList<InterviewHisTblBean>();
			
			for(InterviewHisTblEntity interviewHisTblEntity : interviewHisTblEntityList) {
				InterviewHisTblBean interviewHisTblBean = new InterviewHisTblBean();
				BeanUtils.copyProperties(interviewHisTblEntity, interviewHisTblBean);
				interviewHisTblBean.setInterviewId(EditUtil.intUtil(interviewHisTblEntity.getInterviewId()));
				interviewHisTblBean.setCompanyId(EditUtil.intUtil(interviewHisTblEntity.getCompanyId()));
				interviewHisTblBean.setPositionId(EditUtil.intUtil(interviewHisTblEntity.getPositionId()));
				interviewHisTblBean.setApplicantId(EditUtil.intUtil(interviewHisTblEntity.getApplicantId()));
				interviewHisTblBean.setInterviewDate(EditUtil.dateUtil(interviewHisTblEntity.getInterviewDate()));
				interviewHisTblBean.setDateFrom(EditUtil.timeUtil(interviewHisTblEntity.getDateFrom()));
				interviewHisTblBean.setDateTo(EditUtil.timeUtil(interviewHisTblEntity.getDateTo()));
				interviewHisTblBean.setName(interviewHisTblEntity.getFirstName() + " " + interviewHisTblEntity.getLastName());
				try {
					confirmOutput(interviewHisTblBean);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				interviewHisTblBeanList.add(interviewHisTblBean);
			}
			return interviewHisTblBeanList;
		}
		return null;
	}

	/**
	 * C0501_面接一覧画面削除
	 * 
	 * @param interviewIdList
	 * @param userCd
	 * @param statusFlg
	 * @return Integer
	 */
	@Override
	public Integer update(List<Integer> interviewIdList, Integer userCd, String statusFlg) {
		return interviewHisTblMapper.updateStatus(interviewIdList, userCd, statusFlg);
	}

	@Override
	public InterviewHisTblBean confirmOutput(InterviewHisTblBean interviewHisTblBean) throws IOException {
		// TODO Auto-generated method stub
		InterviewHisTblBean interviewHisTblBeanOutput;
		interviewHisTblBeanOutput=interviewHisTblBean;

		// 写真を取得
		String adress=interviewHisTblBeanOutput.getPhoto();//写真アドレス
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
		    interviewHisTblBeanOutput.setPhotoPic(data);
		}
		return interviewHisTblBeanOutput;
	}

	

}
