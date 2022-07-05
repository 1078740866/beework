package Ansin.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Ansin.web.api.CommonResult;
import Ansin.web.bean.C0201ListBean;
import Ansin.web.bean.IndustryMstBean;
import Ansin.web.bean.JobtypeMstBean;
import Ansin.web.bean.PositionTblBean;
import Ansin.web.bean.PrefecturesMstBean;
import Ansin.web.entity.UserTblEntity;
import Ansin.web.serviceimpl.IC0201ServiceImpl;
import Ansin.web.vueForm.AllObjectVueForm;
import Ansin.web.vueForm.C0201ListVueForm;
import Ansin.web.vueForm.C0201VueForm;
/**
 * C0201_職位一覧画面
 * @author 劉智浩
 *
 */
@RestController
@RequestMapping("/C0201")
public class C0201Controller {
	
		@Autowired
	    private IC0201ServiceImpl c0201Service;
		/**
		 * C0201職位推薦一覧リスト
		 * @param c0201VueForm
		 * @param session
		 * @param results
		 * @return C0201ListBean
		 */
		@RequestMapping(value = "/init", method = RequestMethod.POST)
		public CommonResult<C0201ListBean> Init(@RequestBody @Valid C0201ListVueForm c0201VueForm, HttpSession session,BindingResult results) {
			if (results.hasErrors()) {
				return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
			}
			
			// SESSIONから会社IDを取得
			UserTblEntity user = (UserTblEntity) session.getAttribute("USERC");
			// 出力を取得する
			C0201ListBean c0201ListBean = new C0201ListBean();
			//C0201初期業種選択リストを取得
			List<IndustryMstBean> industryList = c0201Service.getAllIndustry();
			//C0201初期職種選択リストを取得
			List<JobtypeMstBean> jobtypeList = c0201Service.getAllJobtype();
			//C0201初期都道県選択リストを取得
			List<PrefecturesMstBean> prefecturestAndCityList = c0201Service.getPreAndCity();
			//C0201職位推薦一覧リスト
			List<PositionTblBean> allList = c0201Service.getRecommend(user.getUserCd());

			c0201ListBean.setIndustryMstBean(industryList);
			
			c0201ListBean.setJobtypeMstBean(jobtypeList);
			
			c0201ListBean.setPrefecturesMstBean(prefecturestAndCityList);
			
			c0201ListBean.setGetAll(allList);
			
			return CommonResult.success(c0201ListBean);
		}
		
		/**
		 * C0201職位一覧ボタン押下
		 * @param c0201VueForm
		 * @param session
		 * @param results
		 * @return C0201ListBean
		 */
		@RequestMapping(value = "/getDate", method = RequestMethod.POST)
		public CommonResult<C0201ListBean> getDate(@RequestBody @Valid C0201ListVueForm c0201VueForm, HttpSession session,BindingResult results) {
			if (results.hasErrors()) {
				return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
			}
			
			UserTblEntity user = (UserTblEntity) session.getAttribute("USERC");
			
			c0201VueForm.setUserCd(user.getUserCd());
			
			// 出力を取得する
			C0201ListBean c0201ListBean = new C0201ListBean();
			//C0201初期業種選択リストを取得
			List<IndustryMstBean> industryList = c0201Service.getAllIndustry();
			//C0201初期職種選択リストを取得
			List<JobtypeMstBean> jobtypeList = c0201Service.getAllJobtype();
			//C0201初期都道県選択リストを取得
			List<PrefecturesMstBean> prefecturestAndCityList = c0201Service.getPreAndCity();
			//C0201職位一覧リストを取得
			List<PositionTblBean> allList = c0201Service.getList(c0201VueForm);

			c0201ListBean.setIndustryMstBean(industryList);
			
			c0201ListBean.setJobtypeMstBean(jobtypeList);
			
			c0201ListBean.setPrefecturesMstBean(prefecturestAndCityList);
			
			c0201ListBean.setGetAll(allList);
			
			return CommonResult.success(c0201ListBean);
		}
		
		
		/**
		 * C0201職位推薦応募済み一覧リスト
		 * @param c0201VueForm
		 * @param session
		 * @param results
		 * @return C0201ListBean
		 */
		@RequestMapping(value = "/initPost", method = RequestMethod.POST)
		public CommonResult<C0201ListBean> initPost(@RequestBody @Valid C0201ListVueForm c0201VueForm, HttpSession session,BindingResult results) {
			if (results.hasErrors()) {
				return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
			}
			// SESSIONから会社IDを取得
			UserTblEntity user = (UserTblEntity) session.getAttribute("USERC");
		    // SESSIONからユーザーCD取得
			c0201VueForm.setUserCd(user.getUserCd());
			// 出力を取得する
			C0201ListBean c0201ListBean = new C0201ListBean();
			//C0201初期業種選択リストを取得
			List<IndustryMstBean> industryList = c0201Service.getAllIndustry();
			//C0201初期職種選択リストを取得
			List<JobtypeMstBean> jobtypeList = c0201Service.getAllJobtype();
			//C0201初期都道県選択リストを取得
			List<PrefecturesMstBean> prefecturestAndCityList = c0201Service.getPreAndCity();
			//C0201職位推薦応募済み一覧リスト
			List<PositionTblBean> postList = c0201Service.getPost(c0201VueForm);
			
			c0201ListBean.setIndustryMstBean(industryList);
			
			c0201ListBean.setJobtypeMstBean(jobtypeList);
			
			c0201ListBean.setPrefecturesMstBean(prefecturestAndCityList);
			
			c0201ListBean.setGetPost(postList);
			
			return CommonResult.success(c0201ListBean);
		}
		/**
		 * C0201職位推薦気に入る一覧リスト
		 * @param c0201VueForm
		 * @param session
		 * @param results
		 * @return C0201ListBean
		 */
		@RequestMapping(value = "/initLike", method = RequestMethod.POST)
		public CommonResult<C0201ListBean> initLike(@RequestBody @Valid C0201ListVueForm c0201VueForm,HttpSession session,BindingResult results) {
			if (results.hasErrors()) {
				return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
			}
			// SESSIONから会社IDを取得
			UserTblEntity user = (UserTblEntity) session.getAttribute("USERC");
			// SESSIONからユーザーCD取得
			c0201VueForm.setUserCd(user.getUserCd());
			// 出力を取得する
			C0201ListBean c0201ListBean = new C0201ListBean();
			//C0201初期業種選択リストを取得
			List<IndustryMstBean> industryList = c0201Service.getAllIndustry();
			//C0201初期職種選択リストを取得
			List<JobtypeMstBean> jobtypeList = c0201Service.getAllJobtype();
			//C0201初期都道県選択リストを取得
			List<PrefecturesMstBean> prefecturestAndCityList = c0201Service.getPreAndCity();
			//C0201職位推薦気に入る一覧リスト
			List<PositionTblBean> likeList = c0201Service.getLike(c0201VueForm);
			
			c0201ListBean.setIndustryMstBean(industryList);
			
			c0201ListBean.setJobtypeMstBean(jobtypeList);
			
			c0201ListBean.setPrefecturesMstBean(prefecturestAndCityList);
			
			c0201ListBean.setGetLike(likeList);
			
			return CommonResult.success(c0201ListBean);
		}
		/**
		 * C0201応募テーブルに応募済みを追加
		 * @param c0201VueForm
		 * @param session
		 * @param results
		 * @return C0201ListBean
		 */
		@RequestMapping(value = "/insertPost", method = {RequestMethod.POST })
		 public CommonResult<C0201ListBean> insertPost(@RequestBody @Valid AllObjectVueForm vueForm,HttpSession session,BindingResult results) {
			
			if (results.hasErrors()) {
				return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
			}
			 //SESSIONから会社IDとユーザーコードを取得
	      	UserTblEntity user = (UserTblEntity) session.getAttribute("USERC");

	      	Integer appId = c0201Service.getAppId(user.getUserCd());
	      	
	      	// 出力を取得する
			C0201ListBean c0201ListBean = new C0201ListBean();
	      	
	      	if (appId != null) {
	      		
	      		c0201ListBean.setStatusFlg("0");
	      		
	      		for (C0201VueForm C0201Vue : vueForm.getC0201VueForm()) {
		      		C0201Vue.setApplicantId(appId);
		      		C0201Vue.setUserCd(user.getUserCd());
				}
	      		
	      		int insertPost = c0201Service.insertPost(vueForm.getC0201VueForm());
	      		
	      		if (insertPost == 0 ) {
					return CommonResult.failed("失敗");
				}else {
					
					//C0201初期業種選択リストを取得
					List<IndustryMstBean> industryList = c0201Service.getAllIndustry();
					//C0201初期職種選択リストを取得
					List<JobtypeMstBean> jobtypeList = c0201Service.getAllJobtype();
					//C0201初期都道県選択リストを取得
					List<PrefecturesMstBean> prefecturestAndCityList = c0201Service.getPreAndCity();
					//C0201職位推薦応募済み一覧リスト
					List<PositionTblBean> postList = c0201Service.getPost(vueForm.getC0201ListVueForm());
					
					c0201ListBean.setIndustryMstBean(industryList);
					
					c0201ListBean.setJobtypeMstBean(jobtypeList);
					
					c0201ListBean.setPrefecturesMstBean(prefecturestAndCityList);
					
					c0201ListBean.setGetPost(postList);
					
					return CommonResult.success(c0201ListBean);
				}  
			}else {
				
	      		c0201ListBean.setStatusFlg("1");

				//C0201初期業種選択リストを取得
				List<IndustryMstBean> industryList = c0201Service.getAllIndustry();
				//C0201初期職種選択リストを取得
				List<JobtypeMstBean> jobtypeList = c0201Service.getAllJobtype();
				//C0201初期都道県選択リストを取得
				List<PrefecturesMstBean> prefecturestAndCityList = c0201Service.getPreAndCity();
				//C0201職位推薦応募済み一覧リスト
				List<PositionTblBean> postList = c0201Service.getPost(vueForm.getC0201ListVueForm());
				
				c0201ListBean.setIndustryMstBean(industryList);
				
				c0201ListBean.setJobtypeMstBean(jobtypeList);
				
				c0201ListBean.setPrefecturesMstBean(prefecturestAndCityList);
				
				c0201ListBean.setGetPost(postList);
				
				return CommonResult.success(c0201ListBean);
			}
			  	
		}
		/**
		 * C0201応募テーブルに気に入るを追加
		 * @param c0201VueForm
		 * @param session
		 * @param results
		 * @return C0201ListBean
		 */
		@RequestMapping(value = "/insertLike", method = {RequestMethod.POST })
		 public CommonResult<C0201ListBean> insertLike(@RequestBody @Valid AllObjectVueForm vueForm,HttpSession session,BindingResult results) {
			
			if (results.hasErrors()) {
				return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
			}
			 //SESSIONから会社IDとユーザーコードを取得
	      	UserTblEntity user = (UserTblEntity) session.getAttribute("USERC");
	      	vueForm.getC0201ListVueForm().setUserCd(user.getUserCd());
	      	
	      	Integer appId = c0201Service.getAppId(user.getUserCd());
	      	
	      	// 出力を取得する
			C0201ListBean c0201ListBean = new C0201ListBean();
	      	
	      	if (appId != null) {
	      		
	      		c0201ListBean.setStatusFlg("0");
	      	
		      	for (C0201VueForm C0201Vue : vueForm.getC0201VueForm()) {
		      		C0201Vue.setApplicantId(c0201Service.getAppId(user.getUserCd()));
		      		C0201Vue.setUserCd(user.getUserCd());
				}
				
				int insertLike = c0201Service.insertLike(vueForm.getC0201VueForm());
			
				if (insertLike == 0 ) {
					return CommonResult.failed("失敗");
				}else {
					
					//C0201初期業種選択リストを取得
					List<IndustryMstBean> industryList = c0201Service.getAllIndustry();
					//C0201初期職種選択リストを取得
					List<JobtypeMstBean> jobtypeList = c0201Service.getAllJobtype();
					//C0201初期都道県選択リストを取得
					List<PrefecturesMstBean> prefecturestAndCityList = c0201Service.getPreAndCity();
					//C0201職位推薦気に入る一覧リスト
					List<PositionTblBean> likeList = c0201Service.getLike(vueForm.getC0201ListVueForm());
					
					c0201ListBean.setIndustryMstBean(industryList);
					
					c0201ListBean.setJobtypeMstBean(jobtypeList);
					
					c0201ListBean.setPrefecturesMstBean(prefecturestAndCityList);
					
					c0201ListBean.setGetLike(likeList);
					
					return CommonResult.success(c0201ListBean);
				}   
	      	}else {

	      		c0201ListBean.setStatusFlg("1");

				//C0201初期業種選択リストを取得
				List<IndustryMstBean> industryList = c0201Service.getAllIndustry();
				//C0201初期職種選択リストを取得
				List<JobtypeMstBean> jobtypeList = c0201Service.getAllJobtype();
				//C0201初期都道県選択リストを取得
				List<PrefecturesMstBean> prefecturestAndCityList = c0201Service.getPreAndCity();
				//C0201職位推薦応募済み一覧リスト
				List<PositionTblBean> postList = c0201Service.getPost(vueForm.getC0201ListVueForm());
				
				c0201ListBean.setIndustryMstBean(industryList);
				
				c0201ListBean.setJobtypeMstBean(jobtypeList);
				
				c0201ListBean.setPrefecturesMstBean(prefecturestAndCityList);
				
				c0201ListBean.setGetPost(postList);
				
				return CommonResult.success(c0201ListBean);
			}
		}
		/**
		 * C0201単数または複数気に入る
		 * @param c0201VueForm
		 * @param session
		 * @param results
		 * @return C0201ListBean
		 */
		@RequestMapping(value = "/updateLike", method = {RequestMethod.POST })
		 public CommonResult<C0201ListBean> updateLike(@RequestBody @Valid AllObjectVueForm vueForm,HttpSession session,BindingResult results) {
			
			if (results.hasErrors()) {
				return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
			}
			 //SESSIONから会社IDとユーザーコードを取得
	      	UserTblEntity user = (UserTblEntity) session.getAttribute("USERC");
	      	vueForm.getC0201ListVueForm().setUserCd(user.getUserCd());
			
			int update = c0201Service.updateLike(vueForm.getC0201VueForm(), user.getUserCd(), c0201Service.getAppId(user.getUserCd()));
			
			if (update == 0 ) {
				return CommonResult.failed("失敗");
			}else {
				// 出力を取得する
				C0201ListBean c0201ListBean = new C0201ListBean();
				//C0201初期業種選択リストを取得
				List<IndustryMstBean> industryList = c0201Service.getAllIndustry();
				//C0201初期職種選択リストを取得
				List<JobtypeMstBean> jobtypeList = c0201Service.getAllJobtype();
				//C0201初期都道県選択リストを取得
				List<PrefecturesMstBean> prefecturestAndCityList = c0201Service.getPreAndCity();
				//C0201職位推薦気に入る一覧リスト
				List<PositionTblBean> likeList = c0201Service.getLike(vueForm.getC0201ListVueForm());
				
				c0201ListBean.setIndustryMstBean(industryList);
				
				c0201ListBean.setJobtypeMstBean(jobtypeList);
				
				c0201ListBean.setPrefecturesMstBean(prefecturestAndCityList);
				
				c0201ListBean.setGetLike(likeList);
				
				return CommonResult.success(c0201ListBean);
				}    	
		}
		/**
		 * C0201単数または複数削除
		 * @param c0201VueForm
		 * @param session
		 * @param results
		 * @return C0201ListBean
		 */
		@RequestMapping(value = "/deleteApplication", method = {RequestMethod.POST })
		 public CommonResult<C0201ListBean> deleteApplication(@RequestBody @Valid AllObjectVueForm vueForm,HttpSession session,BindingResult results) {
			
			if (results.hasErrors()) {
				return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
			}
			//SESSIONから会社IDとユーザーコードを取得
	      	UserTblEntity user = (UserTblEntity) session.getAttribute("USERC");
	      	vueForm.getC0201ListVueForm().setUserCd(user.getUserCd());

			int deleteApplication = c0201Service.deleteApplication(vueForm.getC0201VueForm(), user.getUserCd(), c0201Service.getAppId(user.getUserCd()));
			
			if (deleteApplication == 0 ) {
				return CommonResult.failed("失敗");
			}else {
				// 出力を取得する
				C0201ListBean c0201ListBean = new C0201ListBean();
				//C0201初期業種選択リストを取得
				List<IndustryMstBean> industryList = c0201Service.getAllIndustry();
				//C0201初期職種選択リストを取得
				List<JobtypeMstBean> jobtypeList = c0201Service.getAllJobtype();
				//C0201初期都道県選択リストを取得
				List<PrefecturesMstBean> prefecturestAndCityList = c0201Service.getPreAndCity();
				//C0201職位推薦気に入る一覧リスト
				List<PositionTblBean> likeList = c0201Service.getLike(vueForm.getC0201ListVueForm());
				
				c0201ListBean.setIndustryMstBean(industryList);
				
				c0201ListBean.setJobtypeMstBean(jobtypeList);
				
				c0201ListBean.setPrefecturesMstBean(prefecturestAndCityList);
				
				c0201ListBean.setGetLike(likeList);
				
				return CommonResult.success(c0201ListBean);
				}    	
		}
		
}
