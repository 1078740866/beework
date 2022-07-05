package Ansin.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Ansin.web.api.CommonResult;
import Ansin.web.bean.BriefingInfoTblBean;
import Ansin.web.entity.UserTblEntity;
import Ansin.web.serviceimpl.IA020203ServiceImpl;
import Ansin.web.vueForm.A020203VueForm;

/**
 * A020203_応募者説明会一覧
 * 
 * @author 楊卿赫
 *
 */
@RestController
@RequestMapping("/A020203")
public class A020203Controller {

    @Autowired
    private IA020203ServiceImpl iA020203ServiceImpl;

    /**
     * 説明会一覧初期方法とボタン押下検索方法
     * 
     * @param briefingInfoEntity
     * @param results
     * @param session
     * @return List<BriefingInfoTblBean>
     */
    @PostMapping(value = "/init")
    public CommonResult<List<BriefingInfoTblBean>> init(@RequestBody @Valid A020203VueForm a020203VueForm, BindingResult results,
            HttpSession session) {

        if (results.hasErrors()) {
            return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
        }

        // 説明会Lリストを取得する
        List<BriefingInfoTblBean> briefingInfoList = iA020203ServiceImpl.getBriefingInfoEntities(a020203VueForm);

        return CommonResult.success(briefingInfoList);

    }

    /**
     * 削除方法
     * 
     * @param briefingInfoEntity
     * @param results
     * @param session
     * @return String
     */
    @PostMapping(value = "/delete")
    public CommonResult<List<BriefingInfoTblBean>> delete(@RequestBody @Valid A020203VueForm a020203VueForm, BindingResult results,
            HttpSession session) {

        if (results.hasErrors()) {
            return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
        }

		UserTblEntity user = (UserTblEntity) session.getAttribute("USERA");
        // SESSIONからユーザーCD取得
		a020203VueForm.setUserCd(user.getUserCd());
		
		int count = iA020203ServiceImpl.delBriefingInfoEntities(a020203VueForm.getBriefingIds(),
				a020203VueForm.getApplicantId(), 
				a020203VueForm.getUserCd());

        if(count != 0) {
        	
        	 // 説明会Lリストを取得する
            List<BriefingInfoTblBean> briefingInfoList = iA020203ServiceImpl.getBriefingInfoEntities(a020203VueForm);
        	
        	return CommonResult.success(briefingInfoList);
        } else {
        	return CommonResult.failed("失敗");
        }

    }

}
