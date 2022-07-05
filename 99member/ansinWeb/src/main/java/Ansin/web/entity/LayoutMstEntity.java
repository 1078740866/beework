package Ansin.web.entity;

import java.util.Date;

public class LayoutMstEntity {
	
	//レイアウトID
	private Integer layoutId;
	//値段
	private Integer layoutMoney;
	//削除フラグ
	private String delFlg;
	//作成日時
	private Date createTime;
	//作成者
	private String createBy;
	//更新日時
	private Date updateTime;
	//更新者
	private String updateBy;

	public Integer getLayoutId() {
		return layoutId;
	}

	public void setLayoutId(Integer layoutId) {
		this.layoutId = layoutId;
	}

	public Integer getLayoutMoney() {
		return layoutMoney;
	}

	public void setLayoutMoney(Integer layoutMoney) {
		this.layoutMoney = layoutMoney;
	}
	
	public String getDelFlg() {
		return delFlg;
	}

	public void setDelFlg(String delFlg) {
		this.delFlg = delFlg;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	@Override
	public String toString() {
		return "LayoutMstEntity [layoutId=" + layoutId + ", layoutMoney=" + layoutMoney + ", delFlg=" + delFlg
				+ ", createTime=" + createTime + ", createBy=" + createBy + ", updateTime=" + updateTime + ", updateBy="
				+ updateBy + ", getLayoutId()=" + getLayoutId() + ", getLayoutMoney()=" + getLayoutMoney()
				+ ", getDelFlg()=" + getDelFlg() + ", getCreateTime()=" + getCreateTime() + ", getCreateBy()="
				+ getCreateBy() + ", getUpdateTime()=" + getUpdateTime() + ", getUpdateBy()=" + getUpdateBy()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
	
}
