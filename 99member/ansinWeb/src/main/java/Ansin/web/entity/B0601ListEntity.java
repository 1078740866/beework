package Ansin.web.entity;

import java.util.List;

public class B0601ListEntity {

	private List<BriefingApplTblEntity> briefingInfoEntities;
	private int briefingInfoCount;

	public int getBriefingInfoCount() {
		return briefingInfoCount;
	}

	public void setBriefingInfoCount(int briefingInfoCount) {
		this.briefingInfoCount = briefingInfoCount;
	}

	public List<BriefingApplTblEntity> getBriefingInfoEntities() {
		return briefingInfoEntities;
	}

	public void setBriefingInfoEntities(List<BriefingApplTblEntity> briefingInfoList) {
		this.briefingInfoEntities = briefingInfoList;
	}

    @Override
    public String toString() {
        return "B0601ListEntity [briefingInfoEntities=" + briefingInfoEntities + ", briefingInfoCount="
                + briefingInfoCount + "]";
    }

}
