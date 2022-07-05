package Ansin.web.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Ansin.web.bean.ProjectHisTblBean;
import Ansin.web.entity.ProjectHisTblEntity;
import Ansin.web.mapper.ProjectHisTblMapper;
import Ansin.web.service.C010107Service;
import Ansin.web.util.EditUtil;
import Ansin.web.vueForm.C010107VueForm;

@Service
public class IC010107ServiceImpl implements C010107Service{
	
	@Autowired
	private ProjectHisTblMapper projectHisTblMapper;
	
	/**
	 * C0101応募者のプロジェクト履歴リスト
	 */
	@Override
	public List<ProjectHisTblBean> getAll(Integer applicantId) {
		List<ProjectHisTblEntity> projectHis = projectHisTblMapper.getAll(applicantId);
		List<ProjectHisTblBean> projectHisBean = new ArrayList<ProjectHisTblBean>();
		for(ProjectHisTblEntity projectHisTblEntity : projectHis) {
			ProjectHisTblBean projectHisTblBean = new ProjectHisTblBean();
			projectHisBean.add(projectHisTblBean);
			BeanUtils.copyProperties(projectHisTblEntity, projectHisTblBean);
			projectHisTblBean.setProjectId(EditUtil.intUtil(projectHisTblEntity.getProjectId()));
			projectHisTblBean.setApplicantId(EditUtil.intUtil(projectHisTblEntity.getApplicantId()));
			projectHisTblBean.setProDateFrom(EditUtil.dateUtil(projectHisTblEntity.getProDateFrom()));
			projectHisTblBean.setProDateTo(EditUtil.dateUtil(projectHisTblEntity.getProDateTo()));
			projectHisTblBean.setProCnt(EditUtil.intUtil(projectHisTblEntity.getProCnt()));
		}
		
		return projectHisBean;
	}
	/**
	 * C0101応募者のプロジェクト履歴を新規
	 */
	@Override
	public int projectHisInsert(C010107VueForm c010107VueForm) {
		// TODO Auto-generated method stub
		int projectHisInsert = projectHisTblMapper.projectHisInsert(c010107VueForm);
		return projectHisInsert;
	}
	/**
	 * C0101応募者のプロジェクト履歴を更新
	 */
	@Override
	public int projectHisUpdate(C010107VueForm c010107VueForm) {
		// TODO Auto-generated method stub
		int projectHisUpdate = projectHisTblMapper.projectHisUpdate(c010107VueForm);
		return projectHisUpdate;
	}
	/**
	 * C0101応募者のプロジェクト履歴を削除
	 */
	@Override
	public int projectHisDelete(Integer applicantId, Integer projectId, Integer userCd) {
		// TODO Auto-generated method stub
		int projectHisDelete = projectHisTblMapper.projectHisDelete(applicantId, projectId,userCd);
		return projectHisDelete;
	}
}
