package Ansin.web.entity;

import java.util.Date;

public class ComCoinPointEntity {
	//残高
	private Integer remainderCoin;
	//今月取得コイン
	private Integer monAcquiredCoin;
	//総取得コイン
	private Integer sumAcquiredCoin;
	//今月利用コイン
	private Integer monUsedCoin;
	//総利用コイン
	private Integer sumUsedCoin;
	//チャージ総金額
	private Integer chargeSumMoney;
	//まもなく締切日
	private Date deadlineSoon;
	//まもなく締切日の金額
	private Integer deadlineMoney;
	//ポイント残高
	private Integer remainderPoint;
	//取得総ポイント
	private Integer sumAcquiredPoint;
	
	
	public Integer getRemainderCoin() {
		return remainderCoin;
	}
	public void setRemainderCoin(Integer remainderCoin) {
		this.remainderCoin = remainderCoin;
	}
	public Integer getMonAcquiredCoin() {
		return monAcquiredCoin;
	}
	public void setMonAcquiredCoin(Integer monAcquiredCoin) {
		this.monAcquiredCoin = monAcquiredCoin;
	}
	public Integer getSumAcquiredCoin() {
		return sumAcquiredCoin;
	}
	public void setSumAcquiredCoin(Integer sumAcquiredCoin) {
		this.sumAcquiredCoin = sumAcquiredCoin;
	}
	public Integer getMonUsedCoin() {
		return monUsedCoin;
	}
	public void setMonUsedCoin(Integer monUsedCoin) {
		this.monUsedCoin = monUsedCoin;
	}
	public Integer getSumUsedCoin() {
		return sumUsedCoin;
	}
	public void setSumUsedCoin(Integer sumUsedCoin) {
		this.sumUsedCoin = sumUsedCoin;
	}
	public Integer getChargeSumMoney() {
		return chargeSumMoney;
	}
	public void setChargeSumMoney(Integer chargeSumMoney) {
		this.chargeSumMoney = chargeSumMoney;
	}
	public Date getDeadlineSoon() {
		return deadlineSoon;
	}
	public void setDeadlineSoon(Date deadlineSoon) {
		this.deadlineSoon = deadlineSoon;
	}
	public Integer getRemainderPoint() {
		return remainderPoint;
	}
	public void setRemainderPoint(Integer remainderPoint) {
		this.remainderPoint = remainderPoint;
	}
	public Integer getSumAcquiredPoint() {
		return sumAcquiredPoint;
	}
	public void setSumAcquiredPoint(Integer sumAcquiredPoint) {
		this.sumAcquiredPoint = sumAcquiredPoint;
	}
	public Integer getDeadlineMoney() {
		return deadlineMoney;
	}
	public void setDeadlineMoney(Integer deadlineMoney) {
		this.deadlineMoney = deadlineMoney;
	}
	@Override
	public String toString() {
		return "ComCoinPointEntity [remainderCoin=" + remainderCoin + ", monAcquiredCoin=" + monAcquiredCoin
				+ ", sumAcquiredCoin=" + sumAcquiredCoin + ", monUsedCoin=" + monUsedCoin + ", sumUsedCoin="
				+ sumUsedCoin + ", chargeSumMoney=" + chargeSumMoney + ", deadlineSoon=" + deadlineSoon
				+ ", deadlineMoney=" + deadlineMoney + ", remainderPoint=" + remainderPoint + ", sumAcquiredPoint="
				+ sumAcquiredPoint + ", getRemainderCoin()=" + getRemainderCoin() + ", getMonAcquiredCoin()="
				+ getMonAcquiredCoin() + ", getSumAcquiredCoin()=" + getSumAcquiredCoin() + ", getMonUsedCoin()="
				+ getMonUsedCoin() + ", getSumUsedCoin()=" + getSumUsedCoin() + ", getChargeSumMoney()="
				+ getChargeSumMoney() + ", getDeadlineSoon()=" + getDeadlineSoon() + ", getRemainderPoint()="
				+ getRemainderPoint() + ", getSumAcquiredPoint()=" + getSumAcquiredPoint() + ", getDeadlineMoney()="
				+ getDeadlineMoney() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	
}
