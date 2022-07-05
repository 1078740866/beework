package Ansin.web.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class PrefecturesMstEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	//都道府県ID
	private Integer prefeId;
	//都道府県名
	private String prefeNm;
	//削除フラグ
	private String delFlg;
	//作成日時
	private Timestamp createTime;
	//作成者
	private String createBy;
	//更新日時
	private Timestamp updateTime;
	//更新者
	private String updateBy;
	
	public PrefecturesMstEntity() {
		super();
	}

	public Integer getPrefeId() {
		return prefeId;
	}

	public void setPrefeId(Integer prefeId) {
		this.prefeId = prefeId;
	}

	public String getPrefeNm() {
		return prefeNm;
	}

	public void setPrefeNm(String prefeNm) {
		this.prefeNm = prefeNm;
	}

	public String getDelFlg() {
		return delFlg;
	}

	public void setDelFlg(String delFlg) {
		this.delFlg = delFlg;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "PrefecturesMstEntity [prefeId=" + prefeId + ", prefeNm=" + prefeNm + ", delFlg=" + delFlg
				+ ", createTime=" + createTime + ", createBy=" + createBy + ", updateTime=" + updateTime + ", updateBy="
				+ updateBy + "]";
	}


}
