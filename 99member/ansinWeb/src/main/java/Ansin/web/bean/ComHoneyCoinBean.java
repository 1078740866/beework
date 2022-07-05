package Ansin.web.bean;

public class ComHoneyCoinBean {
	//残高
	private String remainderCoin;
	//今月取得コイン
	private String monAcquiredCoin;
	//総取得コイン
	private String sumAcquiredCoin;
	//今月利用コイン
	private String monUsedCoin;
	//総利用コイン
	private String sumUsedCoin;
	//チャージ総金額
	private String chargeSumMoney;
	//まもなく締切日
	private String deadlineSoon;
	//まもなく締切日の金額
	private String deadlineMoney;
	
	
	public String getRemainderCoin() {
		return remainderCoin;
	}
	public void setRemainderCoin(String remainderCoin) {
		this.remainderCoin = remainderCoin;
	}
	public String getMonAcquiredCoin() {
		return monAcquiredCoin;
	}
	public void setMonAcquiredCoin(String monAcquiredCoin) {
		this.monAcquiredCoin = monAcquiredCoin;
	}
	public String getSumAcquiredCoin() {
		return sumAcquiredCoin;
	}
	public void setSumAcquiredCoin(String sumAcquiredCoin) {
		this.sumAcquiredCoin = sumAcquiredCoin;
	}
	public String getMonUsedCoin() {
		return monUsedCoin;
	}
	public void setMonUsedCoin(String monUsedCoin) {
		this.monUsedCoin = monUsedCoin;
	}
	public String getSumUsedCoin() {
		return sumUsedCoin;
	}
	public void setSumUsedCoin(String sumUsedCoin) {
		this.sumUsedCoin = sumUsedCoin;
	}
	public String getChargeSumMoney() {
		return chargeSumMoney;
	}
	public void setChargeSumMoney(String chargeSumMoney) {
		this.chargeSumMoney = chargeSumMoney;
	}
	public String getDeadlineSoon() {
		return deadlineSoon;
	}
	public void setDeadlineSoon(String deadlineSoon) {
		this.deadlineSoon = deadlineSoon;
	}
	public String getDeadlineMoney() {
		return deadlineMoney;
	}
	public void setDeadlineMoney(String deadlineMoney) {
		this.deadlineMoney = deadlineMoney;
	}
	@Override
	public String toString() {
		return "ComHoneyCoinBean [remainderCoin=" + remainderCoin + ", monAcquiredCoin=" + monAcquiredCoin
				+ ", sumAcquiredCoin=" + sumAcquiredCoin + ", monUsedCoin=" + monUsedCoin + ", sumUsedCoin="
				+ sumUsedCoin + ", chargeSumMoney=" + chargeSumMoney + ", deadlineSoon=" + deadlineSoon
				+ ", deadlineMoney=" + deadlineMoney + ", getRemainderCoin()=" + getRemainderCoin()
				+ ", getMonAcquiredCoin()=" + getMonAcquiredCoin() + ", getSumAcquiredCoin()=" + getSumAcquiredCoin()
				+ ", getMonUsedCoin()=" + getMonUsedCoin() + ", getSumUsedCoin()=" + getSumUsedCoin()
				+ ", getChargeSumMoney()=" + getChargeSumMoney() + ", getDeadlineSoon()=" + getDeadlineSoon()
				+ ", getDeadlineMoney()=" + getDeadlineMoney() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}
