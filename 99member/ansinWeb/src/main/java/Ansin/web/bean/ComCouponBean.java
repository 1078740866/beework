package Ansin.web.bean;

public class ComCouponBean {
	
	//会社クーポンID
	private String comCouId;
	//会社ID
	private String companyId;
	//使用状態
	private String statusFlg;
	//締切日
	private String deadline;
	//クーポンID
	private String couponId;       
	//クーポン名前
	private String couponNm;
	//必要なハニーポイント
	private String pointNum;
	//詳細内容
	private String detail;
	//有効期間
	private String expDays;
	public String getComCouId() {
		return comCouId;
	}
	public void setComCouId(String comCouId) {
		this.comCouId = comCouId;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getStatusFlg() {
		return statusFlg;
	}
	public void setStatusFlg(String statusFlg) {
		this.statusFlg = statusFlg;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	public String getCouponId() {
		return couponId;
	}
	public void setCouponId(String couponId) {
		this.couponId = couponId;
	}
	public String getCouponNm() {
		return couponNm;
	}
	public void setCouponNm(String couponNm) {
		this.couponNm = couponNm;
	}
	public String getPointNum() {
		return pointNum;
	}
	public void setPointNum(String pointNum) {
		this.pointNum = pointNum;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getExpDays() {
		return expDays;
	}
	public void setExpDays(String expDays) {
		this.expDays = expDays;
	}
	@Override
	public String toString() {
		return "ComCouponBean [comCouId=" + comCouId + ", companyId=" + companyId + ", statusFlg=" + statusFlg
				+ ", deadline=" + deadline + ", couponId=" + couponId + ", couponNm=" + couponNm + ", pointNum="
				+ pointNum + ", detail=" + detail + ", expDays=" + expDays + ", getComCouId()=" + getComCouId()
				+ ", getCompanyId()=" + getCompanyId() + ", getStatusFlg()=" + getStatusFlg() + ", getDeadline()="
				+ getDeadline() + ", getCouponId()=" + getCouponId() + ", getCouponNm()=" + getCouponNm()
				+ ", getPointNum()=" + getPointNum() + ", getDetail()=" + getDetail() + ", getExpDays()=" + getExpDays()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
