package Ansin.web.service;

import java.util.List;

import Ansin.web.bean.IndustryMstBean;
import Ansin.web.bean.JobtypeMstBean;
import Ansin.web.bean.PositionTblBean;
import Ansin.web.bean.PrefecturesMstBean;
import Ansin.web.entity.IdListEntity;
import Ansin.web.vueForm.A070103VueForm;

public interface A070103Service {

		//A070103職位一覧
		List<PositionTblBean> getPo(A070103VueForm a070103VueForm);
		
		//A070103職位単数または複数承認、拒否
		Integer positionConfirmOrDeny(List<IdListEntity> list,Integer userCd,String statusFlg);
		
		// 全部業種を取得
		List<IndustryMstBean> getAllIndustry();
		
		// 全部職種を取得
		List<JobtypeMstBean> getAllJobtype();
		
		// 全部都道府県を取得
		List<PrefecturesMstBean> getAllPrefe();
}
