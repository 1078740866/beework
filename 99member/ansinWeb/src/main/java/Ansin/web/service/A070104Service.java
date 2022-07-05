package Ansin.web.service;

import java.util.List;

import Ansin.web.bean.IndustryMstBean;
import Ansin.web.bean.PrefecturesMstBean;
import Ansin.web.bean.TrainingInfoTblBean;
import Ansin.web.entity.IdListEntity;
import Ansin.web.vueForm.A070104VueForm;

public interface A070104Service {
		
		//A0701_04_承認一覧画面(研修会)一覧リスト
		List<TrainingInfoTblBean> getTra(A070104VueForm a070104VueForm);
		
		//A0701_04_承認一覧画面(研修会)単数または複数承認、拒否
		Integer trainingConfirmOrDeny(List<IdListEntity> list,Integer userCd,String statusFlg);
		
		// 全部業種を取得
		List<IndustryMstBean> getAllIndustry();
		
		// 全部都道府県を取得
		List<PrefecturesMstBean> getAllPrefe();

}
