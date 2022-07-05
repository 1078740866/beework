package Ansin.web.service;

import java.util.List;

import Ansin.web.bean.BriefingInfoTblBean;
import Ansin.web.bean.PrefecturesMstBean;
import Ansin.web.entity.IdListEntity;
import Ansin.web.vueForm.A070105VueForm;

public interface A070105Service {
		
		//A0701_05_承認一覧画面(説明会)一覧リスト
		List<BriefingInfoTblBean> getBrie(A070105VueForm a070105VueForm);
		
		//A0701_05_承認一覧画面(説明会)単数または複数承認、拒否
		Integer briefingConfirmOrDeny(List<IdListEntity> list,Integer userCd,String statusFlg);
		
		// 全部都道府県を取得
		List<PrefecturesMstBean> getAllPrefe();
}
