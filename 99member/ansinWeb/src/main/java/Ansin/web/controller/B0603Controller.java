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
import Ansin.web.bean.BriefingApplTblBean;
import Ansin.web.entity.UserTblEntity;
import Ansin.web.serviceimpl.IB0603ServiceImpl;
import Ansin.web.vueForm.B0603VueForm;

/**
 * B0603_説明会申込一覧
 * 
 * @author 侯添琦
 */

@RestController
@RequestMapping("/B0603")
public class B0603Controller {

    @Autowired
    private IB0603ServiceImpl b0603Service;

    /**
     * 説明会応募者リストを取得する
     * 
     * @param briefingApplEntities
     * @return
     */
    @PostMapping(value = "/briefingAppl")
    public CommonResult<List<BriefingApplTblBean>> getBriefingApplResult(@RequestBody @Valid B0603VueForm b0603VueForm,
            BindingResult results, HttpSession session) {

        if (results.hasErrors()) {
            return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
        }
	
		// SESSIONから会社IDを取得
		UserTblEntity user = (UserTblEntity) session.getAttribute("USER");
		b0603VueForm.setCompanyId(user.getCompanyId());
        // SESSIONからユーザーCD取得
		b0603VueForm.setUserCd(user.getUserCd());

        // 応募者リストを取得する
        List<BriefingApplTblBean> briefingApplEntities = b0603Service.getBriefingApplEntities(b0603VueForm);

        return CommonResult.success(briefingApplEntities);

    }

}
