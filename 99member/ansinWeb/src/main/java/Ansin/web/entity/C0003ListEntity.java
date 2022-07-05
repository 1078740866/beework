package Ansin.web.entity;

import java.util.List;

import Ansin.web.bean.PositionTblBean;

public class C0003ListEntity {
	
	//職位推薦リスト
	private List<PositionTblBean> positionTblBean;
	//ユーザー名
	private String userName;
	//写真
	private String photo;

	public List<PositionTblBean> getPositionTblBean() {
		return positionTblBean;
	}

	public void setPositionTblBean(List<PositionTblBean> positionTblBean) {
		this.positionTblBean = positionTblBean;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "C0003ListEntity [positionTblBean=" + positionTblBean + ", userName=" + userName + ", photo=" + photo
				+ ", getPositionTblBean()=" + getPositionTblBean() + ", getUserName()=" + getUserName()
				+ ", getPhoto()=" + getPhoto() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
