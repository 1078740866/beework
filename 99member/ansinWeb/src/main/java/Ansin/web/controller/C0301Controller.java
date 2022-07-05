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
import Ansin.web.bean.C0301ListBean;
import Ansin.web.bean.IndustryMstBean;
import Ansin.web.bean.PrefecturesMstBean;
import Ansin.web.bean.TrainingInfoTblBean;
import Ansin.web.entity.UserTblEntity;
import Ansin.web.serviceimpl.IC0301ServiceImpl;
import Ansin.web.vueForm.AllObjectVueForm2;
import Ansin.web.vueForm.C0301ListVueForm;
import Ansin.web.vueForm.C0301VueForm;
/**
 * C0301_研修一覧画面
 * @author 劉智浩
 *
 */
@RestController
@RequestMapping("/C0301")
public class C0301Controller {
		
		@Autowired
		private IC0301ServiceImpl c0301Service;
		
		/**
		 * C0301検査ボタン押下リスト
		 * @param c0301VueForm
		 * @param session
		 * @param results
		 * @return
		 */
		@RequestMapping(value = "/getList", method = RequestMethod.POST)
		public CommonResult<C0301ListBean> getList(@RequestBody @Valid C0301ListVueForm c0301VueForm, HttpSession session,BindingResult results) {
			if (results.hasErrors()) {
				return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
			}
			 //SESSIONから会社IDとユーザーコードを取得
	      	UserTblEntity user = (UserTblEntity) session.getAttribute("USERC");
			c0301VueForm.setUserCd(user.getUserCd());
			// 出力を取得する
			C0301ListBean c0301ListBean = new C0301ListBean();
			//C0301初期業種選択リストを取得
			List<IndustryMstBean> industryList = c0301Service.getAllIndustry();
			//C0301初期都道県選択リストを取得
			List<PrefecturesMstBean> prefecturestAndCityList = c0301Service.getPreAndCity();
			
			//C0301職位推薦一覧リスト
			List<TrainingInfoTblBean> allList = c0301Service.getList(c0301VueForm);

			c0301ListBean.setIndustryMstBean(industryList);
			
			c0301ListBean.setPrefecturesMstBean(prefecturestAndCityList);
			
			c0301ListBean.setGetTraining(allList);
			
			return CommonResult.success(c0301ListBean);
		}
		
		/**
		 * C0301研修推薦一覧リスト
		 * @param c0301VueForm
		 * @param session
		 * @param results
		 * @return
		 */
		@RequestMapping(value = "/init", method = RequestMethod.POST)
		public CommonResult<C0301ListBean> Init(@RequestBody @Valid C0301ListVueForm c0301VueForm, HttpSession session,BindingResult results) {
			if (results.hasErrors()) {
				return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
			}
			 //SESSIONから会社IDとユーザーコードを取得
	      	UserTblEntity user = (UserTblEntity) session.getAttribute("USERC");
			// 出力を取得する
			C0301ListBean c0301ListBean = new C0301ListBean();
			//C0301初期業種選択リストを取得
			List<IndustryMstBean> industryList = c0301Service.getAllIndustry();
			//C0301初期都道県選択リストを取得
			List<PrefecturesMstBean> prefecturestAndCityList = c0301Service.getPreAndCity();
			//C0301職位推薦一覧リスト
			List<TrainingInfoTblBean> allList = c0301Service.getTraining(user.getUserCd());

			c0301ListBean.setIndustryMstBean(industryList);
			
			c0301ListBean.setPrefecturesMstBean(prefecturestAndCityList);
			
			c0301ListBean.setGetTraining(allList);
			
			return CommonResult.success(c0301ListBean);
		}
		/**
		 * C0301研修応募済み一覧リスト
		 * @param c0301VueForm
		 * @param session
		 * @param results
		 * @return
		 */
		@RequestMapping(value = "/initPost", method = RequestMethod.POST)
		public CommonResult<C0301ListBean> initPost(@RequestBody @Valid C0301ListVueForm c0301VueForm, HttpSession session,BindingResult results) {
			if (results.hasErrors()) {
				return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
			}
			//SESSIONから会社IDとユーザーコードを取得
	      	UserTblEntity user = (UserTblEntity) session.getAttribute("USERC");
			c0301VueForm.setUserCd(user.getUserCd());
			// 出力を取得する
			C0301ListBean c0301ListBean = new C0301ListBean();
			//C0301初期業種選択リストを取得
			List<IndustryMstBean> industryList = c0301Service.getAllIndustry();
			//C0301初期都道県選択リストを取得
			List<PrefecturesMstBean> prefecturestAndCityList = c0301Service.getPreAndCity();
			//C0301職位推薦応募済み一覧リスト
			List<TrainingInfoTblBean> postList = c0301Service.getTrainingPost(c0301VueForm);
			
			c0301ListBean.setIndustryMstBean(industryList);

			c0301ListBean.setPrefecturesMstBean(prefecturestAndCityList);
			
			c0301ListBean.setGetTrainingPost(postList);
			
			return CommonResult.success(c0301ListBean);
		}
		/**
		 * C0301研修気に入る一覧リスト
		 * @param c0301VueForm
		 * @param session
		 * @param results
		 * @return
		 */
		@RequestMapping(value = "/initLike", method = RequestMethod.POST)
		public CommonResult<C0301ListBean> initLike(@RequestBody @Valid C0301ListVueForm c0301VueForm, HttpSession session,BindingResult results) {
			if (results.hasErrors()) {
				return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
			}
			//SESSIONから会社IDとユーザーコードを取得
	      	UserTblEntity user = (UserTblEntity) session.getAttribute("USERC");
			c0301VueForm.setUserCd(user.getUserCd());
			// 出力を取得する
			C0301ListBean c0301ListBean = new C0301ListBean();
			//C0301初期業種選択リストを取得
			List<IndustryMstBean> industryList = c0301Service.getAllIndustry();
			//C0301初期都道県選択リストを取得
			List<PrefecturesMstBean> prefecturestAndCityList = c0301Service.getPreAndCity();
			//C0301職位推薦気に入る一覧リスト
			List<TrainingInfoTblBean> likeList = c0301Service.getTrainingLike(c0301VueForm);
			
			c0301ListBean.setIndustryMstBean(industryList);
			
			c0301ListBean.setPrefecturesMstBean(prefecturestAndCityList);
			
			c0301ListBean.setGetTrainingLike(likeList);
			
			return CommonResult.success(c0301ListBean);
		}
		/**
		 * C0301研修応募者テーブルに応募済みを追加
		 * @param c0301VueForm
		 * @param c0301ListVueForm
		 * @param session
		 * @param results
		 * @return
		 */
		@RequestMapping(value = "/insertPost", method = {RequestMethod.POST })
		 public CommonResult<C0301ListBean> insertPost(@RequestBody @Valid AllObjectVueForm2 vueForm,HttpSession session,BindingResult results) {
			
			if (results.hasErrors()) {
				return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
			}
			 //SESSIONから会社IDとユーザーコードを取得
	      	UserTblEntity user = (UserTblEntity) session.getAttribute("USERC");
	      	vueForm.getC0301ListVueForm().setUserCd(user.getUserCd());
	      	
	      	Integer appId = c0301Service.getAppId(user.getUserCd());
	      	
	      	// 出力を取得する
	      	C0301ListBean c0301ListBean = new C0301ListBean();
	      	
	      	if (appId != null) {
	      		
	      		c0301ListBean.setStatusFlg("0");
	      	
		    	for (C0301VueForm C0301Vue : vueForm.getC0301VueForm()) {
		      		C0301Vue.setApplicantId(c0301Service.getAppId(user.getUserCd()));
		      		C0301Vue.setUserCd(user.getUserCd());
				}
		      	
				int insertPost = c0301Service.insertPost(vueForm.getC0301VueForm());
				
				if (insertPost == 0 ) {
					return CommonResult.failed("失敗");
				}else {
					
					//C0301初期業種選択リストを取得
					List<IndustryMstBean> industryList = c0301Service.getAllIndustry();
					//C0301初期都道県選択リストを取得
					List<PrefecturesMstBean> prefecturestAndCityList = c0301Service.getPreAndCity();
					//C0301職位推薦応募済み一覧リスト
					List<TrainingInfoTblBean> postList = c0301Service.getTrainingPost(vueForm.getC0301ListVueForm());
					
					c0301ListBean.setIndustryMstBean(industryList);
	
					c0301ListBean.setPrefecturesMstBean(prefecturestAndCityList);
					
					c0301ListBean.setGetTrainingPost(postList);
					
					return CommonResult.success(c0301ListBean);
				}
	    	}else {

	    		c0301ListBean.setStatusFlg("1");
	    		
				//C0301初期業種選択リストを取得
				List<IndustryMstBean> industryList = c0301Service.getAllIndustry();
				//C0301初期都道県選択リストを取得
				List<PrefecturesMstBean> prefecturestAndCityList = c0301Service.getPreAndCity();
				//C0301職位推薦応募済み一覧リスト
				List<TrainingInfoTblBean> postList = c0301Service.getTrainingPost(vueForm.getC0301ListVueForm());
				
				c0301ListBean.setIndustryMstBean(industryList);

				c0301ListBean.setPrefecturesMstBean(prefecturestAndCityList);
				
				c0301ListBean.setGetTrainingPost(postList);
				
				return CommonResult.success(c0301ListBean);
	    	}
		}
		/**
		 * C0301研修応募者テーブルに気に入るを追加
		 * @param c0301VueForm
		 * @param c0301ListVueForm
		 * @param session
		 * @param results
		 * @return
		 */
		@RequestMapping(value = "/insertLike", method = {RequestMethod.POST })
		 public CommonResult<C0301ListBean> insertLike(@RequestBody @Valid AllObjectVueForm2 vueForm,HttpSession session,BindingResult results) {
			
			if (results.hasErrors()) {
				return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
			}
			 //SESSIONから会社IDとユーザーコードを取得
	      	UserTblEntity user = (UserTblEntity) session.getAttribute("USERC");
	      	vueForm.getC0301ListVueForm().setUserCd(user.getUserCd());

	      	Integer appId = c0301Service.getAppId(user.getUserCd());
	      	
	      	// 出力を取得する
	      	C0301ListBean c0301ListBean = new C0301ListBean();
	      	
	      	if (appId != null) {
	      		
	      		c0301ListBean.setStatusFlg("0");
	      	
		      	for (C0301VueForm C0301Vue : vueForm.getC0301VueForm()) {
		      		C0301Vue.setApplicantId(c0301Service.getAppId(user.getUserCd()));
		      		C0301Vue.setUserCd(user.getUserCd());
				}
				
				int insertLike = c0301Service.insertLike(vueForm.getC0301VueForm());
				
				if (insertLike == 0 ) {
					return CommonResult.failed("失敗");
				}else {
					
					//C0301初期業種選択リストを取得
					List<IndustryMstBean> industryList = c0301Service.getAllIndustry();
					//C0301初期都道県選択リストを取得
					List<PrefecturesMstBean> prefecturestAndCityList = c0301Service.getPreAndCity();
					//C0301職位推薦気に入る一覧リスト
					List<TrainingInfoTblBean> likeList = c0301Service.getTrainingLike(vueForm.getC0301ListVueForm());
					
					c0301ListBean.setIndustryMstBean(industryList);
					
					c0301ListBean.setPrefecturesMstBean(prefecturestAndCityList);
					
					c0301ListBean.setGetTrainingLike(likeList);
					
					return CommonResult.success(c0301ListBean);
				}    	
	      	}else {

	    		c0301ListBean.setStatusFlg("1");
	    		
	    		//C0301初期業種選択リストを取得
				List<IndustryMstBean> industryList = c0301Service.getAllIndustry();
				//C0301初期都道県選択リストを取得
				List<PrefecturesMstBean> prefecturestAndCityList = c0301Service.getPreAndCity();
				//C0301職位推薦気に入る一覧リスト
				List<TrainingInfoTblBean> likeList = c0301Service.getTrainingLike(vueForm.getC0301ListVueForm());
				
				c0301ListBean.setIndustryMstBean(industryList);
				
				c0301ListBean.setPrefecturesMstBean(prefecturestAndCityList);
				
				c0301ListBean.setGetTrainingLike(likeList);
				
				return CommonResult.success(c0301ListBean);
	    	}
		}
		/**
		 * C0301研修応募者テーブルに単数または複数気に入るを更新する
		 * @param c0301VueForm
		 * @param c0301ListVueForm
		 * @param session
		 * @param results
		 * @return
		 */
		@RequestMapping(value = "/updateLike", method = {RequestMethod.POST })
		 public CommonResult<C0301ListBean> updateLike(@RequestBody @Valid AllObjectVueForm2 vueForm,HttpSession session,BindingResult results) {
			
			if (results.hasErrors()) {
				return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
			}
			 //SESSIONから会社IDとユーザーコードを取得
	      	UserTblEntity user = (UserTblEntity) session.getAttribute("USERC");
	      	vueForm.getC0301ListVueForm().setUserCd(user.getUserCd());
	      	
			int update = c0301Service.updateLike(vueForm.getC0301VueForm(), user.getUserCd(), c0301Service.getAppId(user.getUserCd()));
			
			if (update == 0 ) {
				return CommonResult.failed("失敗");
			}else {
				// 出力を取得する
				C0301ListBean c0301ListBean = new C0301ListBean();
				//C0301初期業種選択リストを取得
				List<IndustryMstBean> industryList = c0301Service.getAllIndustry();
				//C0301初期都道県選択リストを取得
				List<PrefecturesMstBean> prefecturestAndCityList = c0301Service.getPreAndCity();
				//C0301職位推薦気に入る一覧リスト
				List<TrainingInfoTblBean> likeList = c0301Service.getTrainingLike(vueForm.getC0301ListVueForm());
				
				c0301ListBean.setIndustryMstBean(industryList);
				
				c0301ListBean.setPrefecturesMstBean(prefecturestAndCityList);
				
				c0301ListBean.setGetTrainingLike(likeList);
				
				return CommonResult.success(c0301ListBean);}    	
		}
		/**
		 * C0301研修応募者テーブルに単数または複数削除する
		 * @param c0301VueForm
		 * @param c0301ListVueForm
		 * @param session
		 * @param results
		 * @return
		 */
		@RequestMapping(value = "/deleteTrainingAppl", method = {RequestMethod.POST })
		 public CommonResult<C0301ListBean> deleteTrainingAppl(@RequestBody @Valid AllObjectVueForm2 vueForm,HttpSession session,BindingResult results) {
			
			if (results.hasErrors()) {
				return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
			}
			//SESSIONから会社IDとユーザーコードを取得
	      	UserTblEntity user = (UserTblEntity) session.getAttribute("USERC");
	      	vueForm.getC0301ListVueForm().setUserCd(user.getUserCd());
	      	
			int deleteTrainingAppl = c0301Service.deleteTrainingAppl(vueForm.getC0301VueForm(), user.getUserCd(), c0301Service.getAppId(user.getUserCd()));
			
			if (deleteTrainingAppl == 0 ) {
				return CommonResult.failed("失敗");
			}else {
				// 出力を取得する
				C0301ListBean c0301ListBean = new C0301ListBean();
				//C0301初期業種選択リストを取得
				List<IndustryMstBean> industryList = c0301Service.getAllIndustry();
				//C0301初期都道県選択リストを取得
				List<PrefecturesMstBean> prefecturestAndCityList = c0301Service.getPreAndCity();
				//C0301職位推薦気に入る一覧リスト
				List<TrainingInfoTblBean> likeList = c0301Service.getTrainingLike(vueForm.getC0301ListVueForm());
				
				c0301ListBean.setIndustryMstBean(industryList);
				
				c0301ListBean.setPrefecturesMstBean(prefecturestAndCityList);
				
				c0301ListBean.setGetTrainingLike(likeList);
				
				return CommonResult.success(c0301ListBean);}    	
		}
}
