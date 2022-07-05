package Ansin.web.service;

import java.util.ArrayList;

import Ansin.web.bean.OubosyaListBean;
import Ansin.web.bean.PositionBean;
import Ansin.web.vueForm.B0201SearchVueForm;

public interface B0201Service {

	// 該当会社の全部職位を取得
	ArrayList<PositionBean> getPosition(Integer companyId);

	//  応募者明細リストを取得
	ArrayList<OubosyaListBean> getList(B0201SearchVueForm b0201VueForm);

	// 応募者の状態を変更
	int update(String applicationStatus, Integer companyId, ArrayList<Integer> positionIdList,
			ArrayList<Integer> applicantIdList);

}
