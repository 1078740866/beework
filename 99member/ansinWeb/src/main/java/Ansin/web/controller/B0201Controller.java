package Ansin.web.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Ansin.web.api.CommonResult;
import Ansin.web.bean.DegreeBean;
import Ansin.web.bean.EduSectionBean;
import Ansin.web.bean.OubosyaListBean;
import Ansin.web.bean.PositionBean;
import Ansin.web.entity.UserTblEntity;
import Ansin.web.serviceimpl.IB0201ServiceImpl;
import Ansin.web.vueForm.B0201SearchVueForm;
import Ansin.web.vueForm.B0201VueForm;

/**
 * B0201_応募者一覧
 * @author 吕建宇
 *
 */
@RestController
@RequestMapping("/B0201")
public class B0201Controller {

	@Autowired
	private IB0201ServiceImpl b0201Service;

	/**
	 * 応募者一覧画面初期表示
	 * @return B0201VueForm
	 */
	@RequestMapping(value = "/init", method = RequestMethod.POST)
	public CommonResult<B0201VueForm> init(HttpSession session) {

		// 出力用
		B0201VueForm outForm = new B0201VueForm();
		B0201SearchVueForm searchForm = new B0201SearchVueForm();
		// 1.1.sessionから、ユーザー情報を取得する
		// ユーザーコード
		// SESSIONから会社IDを取得
		UserTblEntity user = (UserTblEntity) session.getAttribute("USER");
		searchForm.setCompanyId(user.getCompanyId());
		// SESSIONからユーザーCD取得
		outForm.setUserCd(user.getUserCd());
		// ハニーコイン残高
		//int remainder = (int) session.getAttribute("REMAINDER");

		// 1.2.該当会社の初期選択職位を取得する
		ArrayList<PositionBean> positionBeanList = b0201Service.getPosition(searchForm.getCompanyId());

		session.setAttribute("PositionBeanList", positionBeanList);
		searchForm.setPositionBeanList(positionBeanList);

		// 1.3.該当会社の初期選択学位、学歴区分を取得する
		ArrayList<DegreeBean> degreeBeanList = b0201Service.editDegree();
		session.setAttribute("DegreeBeanList", degreeBeanList);
		searchForm.setDegreeBeanList(degreeBeanList);

		ArrayList<EduSectionBean> eduSectionBeanList = b0201Service.editEduSection();
		session.setAttribute("EduSectionBeanList", eduSectionBeanList);
		searchForm.setEduSectionList(eduSectionBeanList);

		outForm.setB0201SearchVueForm(searchForm);
		// 1.4.応募者明細リストを取得する
		//1.4.1.以下SQLを実行して、結果を画面に表示する。
		searchForm.setApplicationStatus("0");
		ArrayList<OubosyaListBean> oubosyaList = b0201Service.getList(searchForm);

		// 明細リスト
		outForm.setOubosyaList(oubosyaList);

		return CommonResult.success(outForm);

	}

	/**
	 * 応募者一覧画面を検索
	 * @param searchVueForm
	 * @return B0201VueForm
	 */
	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public CommonResult<ArrayList<OubosyaListBean>> search(@RequestBody @Valid B0201SearchVueForm searchVueForm, HttpSession session,
			BindingResult results) {

		if (results.hasErrors()) {
			return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
		}

		// 2.1. 入力した募集者名前、職位、時間による、応募者情報を取得する。
		UserTblEntity user = (UserTblEntity) session.getAttribute("USER");
		searchVueForm.setCompanyId(user.getCompanyId());
		if (StringUtils.isEmpty(searchVueForm.getApplicationStatus())) {
			searchVueForm.setApplicationStatus("1");
		}
		ArrayList<OubosyaListBean> oubosyaList = b0201Service.getList(searchVueForm);

		if (oubosyaList == null || oubosyaList.size() == 0) {
			return CommonResult.failed("E0014：検索条件と一致するデータが存在しません。");
		}

		return CommonResult.success(oubosyaList);
	}


	/**
	 * 状態を更新
	 * @param json
	 * @return b0201StatusForm
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public CommonResult<ArrayList<OubosyaListBean>> update(@RequestBody B0201SearchVueForm searchVueForm, HttpSession session) {

		// 応募者IDリスト
		ArrayList<Integer> applicantIdList = new ArrayList<Integer>();
		// 職位IDリスト
		ArrayList<Integer> positionIdList = new ArrayList<Integer>();
		for (Integer applicantId : searchVueForm.getApplicantIdList()) {
			applicantIdList.add(applicantId);
		}

		for (Integer positionId : searchVueForm.getPositionIdList()) {
			positionIdList.add(positionId);
		}
		// イベントにより、応募状態を設定
		String hdnSentakuEvent = searchVueForm.getHdnSentakuEvent();
		// 会社IDを取得
		UserTblEntity user = (UserTblEntity) session.getAttribute("USER");

		b0201Service.update(hdnSentakuEvent, user.getCompanyId(), positionIdList, applicantIdList);

		searchVueForm.setCompanyId(user.getCompanyId());
		ArrayList<OubosyaListBean> oubosyaList = b0201Service.getList(searchVueForm);

		return CommonResult.success(oubosyaList);
	}
}
