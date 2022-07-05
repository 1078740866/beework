package Ansin.web.entity;

import java.util.List;

/**
 * 
 * @author コウ テンキ
 * @date 2020-10-16 15:26:23
 */

// 説明会応募者一覧
public class B0603ListEntity {

    // 説明会応募者リスト
    private List<BriefingApplTblEntity> briefingApplEntities;
    // 応募者数
    private int briefingApplCount;

    public List<BriefingApplTblEntity> getBriefingApplEntities() {
        return briefingApplEntities;
    }

    public void setBriefingApplEntities(List<BriefingApplTblEntity> briefingApplEntities) {
        this.briefingApplEntities = briefingApplEntities;
    }

    public int getBriefingApplCount() {
        return briefingApplCount;
    }

    public void setBriefingApplCount(int briefingApplCount) {
        this.briefingApplCount = briefingApplCount;
    }

    @Override
    public String toString() {
        return "B0603ListEntity [briefingApplEntities=" + briefingApplEntities + ", briefingApplCount="
                + briefingApplCount + "]";
    }

}
