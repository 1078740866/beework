package Ansin.web.service;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import Ansin.web.bean.IndustryMstBean;
import Ansin.web.bean.JobtypeMstBean;
import Ansin.web.bean.SkillMstBean;
import Ansin.web.vueForm.B0102VueForm;

/**
 * B0102_職位詳細情報 positionInfoService
 * 
 * @author コウ テンキ
 * @date 2020-10-29 13:19:18
 */

public interface B0102Service {
	
	/**
	 * 画面初期化職種情報を取得
	 * @return
	 */
	List<IndustryMstBean> getIndustryAll();
	/**
	 *画面初期化業種情報を取得
	 * @return
	 */
	List<JobtypeMstBean> getJobtypeAll();
	/**
	 * 画面初期化skill情報を取得
	 * @return
	 */
	List<SkillMstBean> getSkillAll();
    /**
     * B0102 職位情報追加
     * @param b0102VueForm
     * @param companyId
     * @param userCd
     * @return 情報追加結果
     */
    int addPosition(B0102VueForm b0102VueForm);
    
    /**
     * B0102 職位情報更新
     * @param b0102VueForm
     * @param companyId
     * @param userCd
     * @return 情報更新結果
     */
    int updPosition(B0102VueForm b0102VueForm);
    /**
     * 都道府県と所属市区町村を取得
     * @param postal
     * @return
     */
 	List<String> getPostaOne(String postal);
 	/**
 	 * 都道府県を取得
 	 * @param postal
 	 * @return
 	 */
 	String getPrefeNm(@Param("postal") String postal);
 	
 	B0102VueForm confirmOutput(B0102VueForm b0102VueForm) throws IOException;
}
