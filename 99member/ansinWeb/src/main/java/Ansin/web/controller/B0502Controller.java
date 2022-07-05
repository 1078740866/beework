package Ansin.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Ansin.web.api.CommonResult;
import Ansin.web.bean.IndustryMstBean;
import Ansin.web.entity.UserTblEntity;
import Ansin.web.serviceimpl.IB0502ServiceImpl;
import Ansin.web.vueForm.B0502VueForm;
/**
 * B0502_研修詳細情報
 * @author 刘智浩
 *
 */
@RestController
@RequestMapping("/B0502")
public class B0502Controller {
	@Autowired
    private IB0502ServiceImpl b0502service;

	/**
	   *  研修情報を改修する前初期表示の内容	
	   *   業種を取得
	 * @return　List<IndustryMstBean>
	 */
	@RequestMapping(value = "/init", method = {RequestMethod.POST })
	 public CommonResult<List<IndustryMstBean>> IndustrySelect() {
		return CommonResult.success(b0502service.getIndustryAll());
	}
	
	 /**
     * 郵便番号に基づいて都道府県・市区町村の情報を取得する
     * 
     * @param briefingEntity
     * @param results
     * @param session
     * @return CommonResult<PrefecturestAndCityEntity>
     */
    @PostMapping(value = "/postal")
    public CommonResult<List<String>> getPostal(B0502VueForm b0502VueForm, BindingResult results,
            HttpSession session) {

        if (results.hasErrors()) {
            return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
        }
        
		List<String> postalList = b0502service.getPostaOne(b0502VueForm.getPostal());
		
		return CommonResult.success(postalList);
		
    }

	/**
	 *  研修情報の新規と改修
	 * @param trainingEntity
	 * @param session
	 * @param results
	 * @return
	 */
	@RequestMapping(value = "/updateOrInsert", method = {RequestMethod.POST })
	 public CommonResult<Integer> updateOrInsert(@RequestBody @Valid B0502VueForm vueForm,HttpSession session,BindingResult results) {
		
		if (results.hasErrors()) {
			return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
		}
		// SESSIONから会社IDを取得
		UserTblEntity user = (UserTblEntity) session.getAttribute("USER");
		vueForm.setCompanyId(user.getCompanyId());
        // SESSIONからユーザーCD取得
		vueForm.setUserCd(user.getUserCd());
		
		//研修IDはヌルの場合は新規にします
		if(vueForm.getTrainingId() == null) {
			//都道府県を取得
			vueForm.setPrefeNm(b0502service.getPrefeNm(vueForm.getPostal()));
			//登録
			int trainingSpecificsInsert = b0502service.specificsInsert(vueForm);
			//成功するかどうか判断します。
			if (trainingSpecificsInsert == 0 ) {
				return CommonResult.failed();
			}else {
				return CommonResult.success(trainingSpecificsInsert);
			}
		}	
		//研修IDはヌルじゃない場合は改修にします
		else {
			//都道府県を取得
			vueForm.setPrefeNm(b0502service.getPrefeNm(vueForm.getPostal()));
			//更新
			int trainingSpecificsUpdate = b0502service.specificsUpdate(vueForm);
			//成功するかどうか判断します。
			if (trainingSpecificsUpdate == 0 ) {
				return CommonResult.failed();
			}else {
				return CommonResult.success(trainingSpecificsUpdate);
			}		
		}     
	}
}
