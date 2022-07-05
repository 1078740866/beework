package Ansin.web.entity;

/**
 * B0401 面接一覧list entity
 * @author コウ　テンキ
 * @date 2020-10-19 10:57:21
 */

import java.util.List;

public class B0401ListEntity {
	
	//面接一覧list
	private List<InterviewHisTblEntity> interviewHisTblEntities;
	//面接一覧list count
	private int count;
	
	public List<InterviewHisTblEntity> getInterviewHisTblEntities() {
		return interviewHisTblEntities;
	}
	public void setInterviewHisTblEntities(List<InterviewHisTblEntity> interviewHisTblEntities) {
		this.interviewHisTblEntities = interviewHisTblEntities;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

}
