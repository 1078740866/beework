package Ansin.web.bean;

public class ComPointBean {
	
	//ポイント残高
	private String remainderPoint;
	//取得総ポイント
	private String sumAcquiredPoint;
	public String getRemainderPoint() {
		return remainderPoint;
	}
	public void setRemainderPoint(String remainderPoint) {
		this.remainderPoint = remainderPoint;
	}
	public String getSumAcquiredPoint() {
		return sumAcquiredPoint;
	}
	public void setSumAcquiredPoint(String sumAcquiredPoint) {
		this.sumAcquiredPoint = sumAcquiredPoint;
	}
	@Override
	public String toString() {
		return "ComPointBean [remainderPoint=" + remainderPoint + ", sumAcquiredPoint=" + sumAcquiredPoint
				+ ", getRemainderPoint()=" + getRemainderPoint() + ", getSumAcquiredPoint()=" + getSumAcquiredPoint()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
}
