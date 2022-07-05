package Ansin.web.entity;

import java.sql.Timestamp;
import java.util.Date;
/**
 * 会社チャージ履歴Entity
 * @author 楊卿赫
 *
 */
public class ComChargeTblEntity {
	
	//会社ID
	private Integer companyId;
	//チャージID
	private Integer chargeId;
	//チャージ日時
	private Timestamp chargeTime;
	//チャージ金額
	private Integer chargeMoney;
	//チャージハニーコイン
	private Integer chargeHoney;
	//支払方式
	private String payMethod;
	//支払状態
	private String statusFlg;
	//ハニーコイン残高
	private Integer remainder;
	//ハニーコイン締切日
	private Date honeyLastDate;
	//無効フラグ
	private String mukouFlg;
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
	
	
	public Integer getCompanyId() {
		return companyId;
	}
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
	public Integer getChargeId() {
		return chargeId;
	}
	public void setChargeId(Integer chargeId) {
		this.chargeId = chargeId;
	}
	public Timestamp getChargeTime() {
		return chargeTime;
	}
	public void setChargeTime(Timestamp chargeTime) {
		this.chargeTime = chargeTime;
	}
	public Integer getChargeMoney() {
		return chargeMoney;
	}
	public void setChargeMoney(Integer chargeMoney) {
		this.chargeMoney = chargeMoney;
	}
	public Integer getChargeHoney() {
		return chargeHoney;
	}
	public void setChargeHoney(Integer chargeHoney) {
		this.chargeHoney = chargeHoney;
	}
	public String getPayMethod() {
		return payMethod;
	}
	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}
	public String getStatusFlg() {
		return statusFlg;
	}
	public void setStatusFlg(String statusFlg) {
		this.statusFlg = statusFlg;
	}
	public Integer getRemainder() {
		return remainder;
	}
	public void setRemainder(Integer remainder) {
		this.remainder = remainder;
	}
	public Date getHoneyLastDate() {
		return honeyLastDate;
	}
	public void setHoneyLastDate(Date honeyLastDate) {
		this.honeyLastDate = honeyLastDate;
	}
	public String getMukouFlg() {
		return mukouFlg;
	}
	public void setMukouFlg(String mukouFlg) {
		this.mukouFlg = mukouFlg;
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
	@Override
	public String toString() {
		return "ComchargeTblEntity [companyId=" + companyId + ", chargeId=" + chargeId + ", chargeTime=" + chargeTime
				+ ", chargeMoney=" + chargeMoney + ", chargeHoney=" + chargeHoney + ", payMethod=" + payMethod
				+ ", statusFlg=" + statusFlg + ", remainder=" + remainder + ", honeyLastDate=" + honeyLastDate
				+ ", mukouFlg=" + mukouFlg + ", delFlg=" + delFlg + ", createTime=" + createTime + ", createBy=" + createBy + ", updateTime="
				+ updateTime + ", updateBy=" + updateBy + "]";
	}
	
	
	
	
}
