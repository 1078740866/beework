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
import Ansin.web.bean.BriefingInfoTblBean;
import Ansin.web.entity.UserTblEntity;
import Ansin.web.serviceimpl.IB0601ServiceImpl;
import Ansin.web.vueForm.B0601VueForm;

/**
 * B0601_説明会一覧
 * 
 * @author 侯添琦
 *
 */
@RestController
@RequestMapping("/B0601")
public class B0601Controller {

    @Autowired
    private IB0601ServiceImpl IB0601ServiceImpl;

    /**
     * 説明会一覧初期方法とボタン押下検索方法
     * 
     * @param briefingInfoEntity
     * @param results
     * @param session
     * @return List<BriefingInfoTblBean>
     */
    @RequestMapping(value = "/init", method = RequestMethod.POST)
    public CommonResult<List<BriefingInfoTblBean>> init(@RequestBody @Valid B0601VueForm b0601VueForm, BindingResult results,
            HttpSession session) {

        if (results.hasErrors()) {
            return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
        }

		// SESSIONから会社IDを取得
		UserTblEntity user = (UserTblEntity) session.getAttribute("USER");
		b0601VueForm.setCompanyId(user.getCompanyId());
        // SESSIONからユーザーCD取得
		b0601VueForm.setUserCd(user.getUserCd());

        // 説明会Lリストを取得する
        List<BriefingInfoTblBean> briefingInfoList = IB0601ServiceImpl.getBriefingInfoEntities(b0601VueForm);
        
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
    public CommonResult<List<BriefingInfoTblBean>> delete(@RequestBody @Valid B0601VueForm b0601VueForm, BindingResult results,
            HttpSession session) {

        if (results.hasErrors()) {
            return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
        }

		// SESSIONから会社IDを取得
		UserTblEntity user = (UserTblEntity) session.getAttribute("USER");
		b0601VueForm.setCompanyId(user.getCompanyId());
        // SESSIONからユーザーCD取得
		b0601VueForm.setUserCd(user.getUserCd());
		
		int count = IB0601ServiceImpl.delBriefingInfoEntities(b0601VueForm.getBriefingIds(),
				b0601VueForm.getCompanyId(), 
				b0601VueForm.getUserCd());

        if(count != 0) {
        	
        	 // 説明会Lリストを取得する
            List<BriefingInfoTblBean> briefingInfoList = IB0601ServiceImpl.getBriefingInfoEntities(b0601VueForm);
        	
        	return CommonResult.success(briefingInfoList);
        } else {
        	return CommonResult.failed("失敗");
        }

    }

}
