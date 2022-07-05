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
import Ansin.web.bean.BriefingInfoTblBean;
import Ansin.web.bean.C0401ListBean;
import Ansin.web.bean.PrefecturesMstBean;
import Ansin.web.entity.UserTblEntity;
import Ansin.web.serviceimpl.IC0401ServiceImpl;
import Ansin.web.vueForm.AllObjectVueForm3;
import Ansin.web.vueForm.C0401ListVueForm;
import Ansin.web.vueForm.C0401VueForm;
/**
 * C0401_説明会一覧画面
 * @author 劉智浩
 *
 */
@RestController
@RequestMapping("/C0401")
public class C0401Controller {
	
		@Autowired
		private IC0401ServiceImpl c0401Service;
		/**
		 * C0401説明会検索ボタン押下リスト
		 * @param c0401VueForm
		 * @param session
		 * @param results
		 * @return
		 */
		@RequestMapping(value = "/getList", method = RequestMethod.POST)
		public CommonResult<C0401ListBean> getList(@RequestBody @Valid C0401ListVueForm c0401VueForm, HttpSession session,BindingResult results) {
			if (results.hasErrors()) {
				return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
			}
			 //SESSIONから会社IDとユーザーコードを取得
	      	UserTblEntity user = (UserTblEntity) session.getAttribute("USERC");
	      	c0401VueForm.setUserCd(user.getUserCd());
			// 出力を取得する
			C0401ListBean c0401ListBean = new C0401ListBean();
			//C0401初期都道県選択リストを取得
			List<PrefecturesMstBean> prefecturestAndCityList = c0401Service.getPreAndCity();
			
			// C0401説明会検索ボタン押下リスト
			List<BriefingInfoTblBean> allList = c0401Service.getList(c0401VueForm);
			
			c0401ListBean.setPrefecturesMstBean(prefecturestAndCityList);
			
			c0401ListBean.setGetBriefing(allList);
			
			return CommonResult.success(c0401ListBean);
		}
		
		/**
		 * C0401説明会推薦一覧リスト
		 * @param c0401VueForm
		 * @param session
		 * @param results
		 * @return
		 */
		@RequestMapping(value = "/init", method = RequestMethod.POST)
		public CommonResult<C0401ListBean> Init(@RequestBody @Valid C0401ListVueForm c0401VueForm, HttpSession session,BindingResult results) {
			if (results.hasErrors()) {
				return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
			}
			 //SESSIONから会社IDとユーザーコードを取得
	      	UserTblEntity user = (UserTblEntity) session.getAttribute("USERC");
			// 出力を取得する
			C0401ListBean c0401ListBean = new C0401ListBean();
			//C0401初期都道県選択リストを取得
			List<PrefecturesMstBean> prefecturestAndCityList = c0401Service.getPreAndCity();
			//C0401説明会推薦一覧リスト
			List<BriefingInfoTblBean> allList = c0401Service.getBriefing(user.getUserCd());
			
			c0401ListBean.setPrefecturesMstBean(prefecturestAndCityList);
			
			c0401ListBean.setGetBriefing(allList);
			
			return CommonResult.success(c0401ListBean);
		}
		/**
		 * C0401説明会応募済み一覧リスト
		 * @param c0401VueForm
		 * @param session
		 * @param results
		 * @return
		 */
		@RequestMapping(value = "/initPost", method = RequestMethod.POST)
		public CommonResult<C0401ListBean> initPost(@RequestBody @Valid C0401ListVueForm c0401VueForm, HttpSession session,BindingResult results) {
			if (results.hasErrors()) {
				return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
			}
			 //SESSIONから会社IDとユーザーコードを取得
	      	UserTblEntity user = (UserTblEntity) session.getAttribute("USERC");
			c0401VueForm.setUserCd(user.getUserCd());
			// 出力を取得する
			C0401ListBean c0401ListBean = new C0401ListBean();
			//C0401初期都道県選択リストを取得
			List<PrefecturesMstBean> prefecturestAndCityList = c0401Service.getPreAndCity();
			//C0401説明会応募済み一覧リスト
			List<BriefingInfoTblBean> postList = c0401Service.getBriefingPost(c0401VueForm);
			
			c0401ListBean.setPrefecturesMstBean(prefecturestAndCityList);
			
			c0401ListBean.setGetBriefingPost(postList);
			
			return CommonResult.success(c0401ListBean);
		}
		/**
		 * C0401説明会気に入る一覧リスト
		 * @param c0401VueForm
		 * @param session
		 * @param results
		 * @return
		 */
		@RequestMapping(value = "/initLike", method = RequestMethod.POST)
		public CommonResult<C0401ListBean> initLike(@RequestBody @Valid C0401ListVueForm c0401VueForm, HttpSession session,BindingResult results) {
			if (results.hasErrors()) {
				return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
			}
			 //SESSIONから会社IDとユーザーコードを取得
	      	UserTblEntity user = (UserTblEntity) session.getAttribute("USERC");
			c0401VueForm.setUserCd(user.getUserCd());
			// 出力を取得する
			C0401ListBean c0401ListBean = new C0401ListBean();
			//C0401初期都道県選択リストを取得
			List<PrefecturesMstBean> prefecturestAndCityList = c0401Service.getPreAndCity();
			//C0401説明会気に入る一覧リスト
			List<BriefingInfoTblBean> likeList = c0401Service.getBriefingLike(c0401VueForm);
			
			c0401ListBean.setPrefecturesMstBean(prefecturestAndCityList);
			
			c0401ListBean.setGetBriefingLike(likeList);;
			
			return CommonResult.success(c0401ListBean);
		}
		/**
		 * C0401説明会応募者テーブルに応募済みを追加
		 * @param c0401VueForm
		 * @param c0401ListVueForm
		 * @param session
		 * @param results
		 * @return
		 */
		@RequestMapping(value = "/insertPost", method = {RequestMethod.POST })
		 public CommonResult<C0401ListBean> insertPost(@RequestBody @Valid AllObjectVueForm3 vueForm,HttpSession session,BindingResult results) {
			
			if (results.hasErrors()) {
				return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
			}
			 //SESSIONから会社IDとユーザーコードを取得
	      	UserTblEntity user = (UserTblEntity) session.getAttribute("USERC");
	      	vueForm.getC0401ListVueForm().setUserCd(user.getUserCd());
	      	
	      	Integer appId = c0401Service.getAppId(user.getUserCd());
	      	
	      	// 出力を取得する
	      	C0401ListBean c0401ListBean = new C0401ListBean();
	      	
	      	if (appId != null) {
	      		
	      		c0401ListBean.setStatusFlg("0");
	      	
		    	for (C0401VueForm C0401Vue : vueForm.getC0401VueForm()) {
		      		C0401Vue.setApplicantId(c0401Service.getAppId(user.getUserCd()));
		      		C0401Vue.setUserCd(user.getUserCd());
				}
		      	
				int insertPost = c0401Service.insertPost(vueForm.getC0401VueForm());
				
				if (insertPost == 0 ) {
					return CommonResult.failed("失敗");
				}else {
					
					//C0401初期都道県選択リストを取得
					List<PrefecturesMstBean> prefecturestAndCityList = c0401Service.getPreAndCity();
					//C0401説明会応募済み一覧リスト
					List<BriefingInfoTblBean> postList = c0401Service.getBriefingPost(vueForm.getC0401ListVueForm());
					
					c0401ListBean.setPrefecturesMstBean(prefecturestAndCityList);
					
					c0401ListBean.setGetBriefingPost(postList);
					
					return CommonResult.success(c0401ListBean);
				}   
	      	}else {

	      		c0401ListBean.setStatusFlg("1");
	    		
	    		//C0401初期都道県選択リストを取得
				List<PrefecturesMstBean> prefecturestAndCityList = c0401Service.getPreAndCity();
				//C0401説明会応募済み一覧リスト
				List<BriefingInfoTblBean> postList = c0401Service.getBriefingPost(vueForm.getC0401ListVueForm());
				
				c0401ListBean.setPrefecturesMstBean(prefecturestAndCityList);
				
				c0401ListBean.setGetBriefingPost(postList);
				
				return CommonResult.success(c0401ListBean);
			}   
		}
		/**
		 * C0401説明会応募者テーブルに気に入るを追加
		 * @param c0401VueForm
		 * @param c0401ListVueForm
		 * @param session
		 * @param results
		 * @return
		 */
		@RequestMapping(value = "/insertLike", method = {RequestMethod.POST })
		 public CommonResult<C0401ListBean> insertLike(@RequestBody @Valid AllObjectVueForm3 vueForm,HttpSession session,BindingResult results) {
			
			if (results.hasErrors()) {
				return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
			}
			 //SESSIONから会社IDとユーザーコードを取得
	      	UserTblEntity user = (UserTblEntity) session.getAttribute("USERC");
	      	vueForm.getC0401ListVueForm().setUserCd(user.getUserCd());

	      	Integer appId = c0401Service.getAppId(user.getUserCd());
	      	
	      	// 出力を取得する
	      	C0401ListBean c0401ListBean = new C0401ListBean();
	      	
	      	if (appId != null) {
	      		
	      		c0401ListBean.setStatusFlg("0");
	      	
		      	for (C0401VueForm C0401Vue : vueForm.getC0401VueForm()) {
		      		C0401Vue.setApplicantId(c0401Service.getAppId(user.getUserCd()));
		      		C0401Vue.setUserCd(user.getUserCd());
				}
				
				int insertLike = c0401Service.insertLike(vueForm.getC0401VueForm());
				
				if (insertLike == 0 ) {
					return CommonResult.failed("失敗");
				}else {
					
					//C0401初期都道県選択リストを取得
					List<PrefecturesMstBean> prefecturestAndCityList = c0401Service.getPreAndCity();
					//C0401説明会気に入る一覧リスト
					List<BriefingInfoTblBean> likeList = c0401Service.getBriefingLike(vueForm.getC0401ListVueForm());
					
					c0401ListBean.setPrefecturesMstBean(prefecturestAndCityList);
					
					c0401ListBean.setGetBriefingLike(likeList);;
					
					return CommonResult.success(c0401ListBean);
				}    
	     	}else {

	      		c0401ListBean.setStatusFlg("1");
	    		
	      		//C0401初期都道県選択リストを取得
				List<PrefecturesMstBean> prefecturestAndCityList = c0401Service.getPreAndCity();
				//C0401説明会気に入る一覧リスト
				List<BriefingInfoTblBean> likeList = c0401Service.getBriefingLike(vueForm.getC0401ListVueForm());
				
				c0401ListBean.setPrefecturesMstBean(prefecturestAndCityList);
				
				c0401ListBean.setGetBriefingLike(likeList);;
				
				return CommonResult.success(c0401ListBean);
			}   
		}
		/**
		 * C0401説明会応募者テーブルに単数または複数気に入るを更新する
		 * @param c0401VueForm
		 * @param c0401ListVueForm
		 * @param session
		 * @param results
		 * @return
		 */
		@RequestMapping(value = "/updateLike", method = {RequestMethod.POST })
		 public CommonResult<C0401ListBean> updateLike(@RequestBody @Valid AllObjectVueForm3 vueForm,HttpSession session,BindingResult results) {
			
			if (results.hasErrors()) {
				return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
			}
			 //SESSIONから会社IDとユーザーコードを取得
	      	UserTblEntity user = (UserTblEntity) session.getAttribute("USERC");
	      	vueForm.getC0401ListVueForm().setUserCd(user.getUserCd());
	      	
			int update = c0401Service.updateLike(vueForm.getC0401VueForm(), user.getUserCd(), c0401Service.getAppId(user.getUserCd()));
			
			if (update == 0 ) {
				return CommonResult.failed("失敗");
			}else {
				// 出力を取得する
				C0401ListBean c0401ListBean = new C0401ListBean();
				//C0401初期都道県選択リストを取得
				List<PrefecturesMstBean> prefecturestAndCityList = c0401Service.getPreAndCity();
				//C0401説明会気に入る一覧リスト
				List<BriefingInfoTblBean> likeList = c0401Service.getBriefingLike(vueForm.getC0401ListVueForm());
				
				c0401ListBean.setPrefecturesMstBean(prefecturestAndCityList);
				
				c0401ListBean.setGetBriefingLike(likeList);;
				
				return CommonResult.success(c0401ListBean);}    	
		}
		/**
		 * C0401説明会応募者テーブルに単数または複数削除する
		 * @param c0401VueForm
		 * @param c0401ListVueForm
		 * @param session
		 * @param results
		 * @return
		 */
		@RequestMapping(value = "/deleteBriefingAppl", method = {RequestMethod.POST })
		 public CommonResult<C0401ListBean> deleteBriefingAppl(@RequestBody @Valid AllObjectVueForm3 vueForm,HttpSession session,BindingResult results) {
			
			if (results.hasErrors()) {
				return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
			}
			//SESSIONから会社IDとユーザーコードを取得
	      	UserTblEntity user = (UserTblEntity) session.getAttribute("USERC");
	      	vueForm.getC0401ListVueForm().setUserCd(user.getUserCd());
	      	
			int deleteBriefingAppl = c0401Service.deleteBriefingAppl(vueForm.getC0401VueForm(), user.getUserCd(), c0401Service.getAppId(user.getUserCd()));
			
			if (deleteBriefingAppl == 0 ) {
				return CommonResult.failed("失敗");
			}else {
				// 出力を取得する
				C0401ListBean c0401ListBean = new C0401ListBean();
				//C0401初期都道県選択リストを取得
				List<PrefecturesMstBean> prefecturestAndCityList = c0401Service.getPreAndCity();
				//C0401説明会気に入る一覧リスト
				List<BriefingInfoTblBean> likeList = c0401Service.getBriefingLike(vueForm.getC0401ListVueForm());
				
				c0401ListBean.setPrefecturesMstBean(prefecturestAndCityList);
				
				c0401ListBean.setGetBriefingLike(likeList);;
				
				return CommonResult.success(c0401ListBean);}    	
		}
}
