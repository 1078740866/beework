package Ansin.web.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Ansin.web.api.CommonResult;
import Ansin.web.bean.InterviewHisTblBean;
import Ansin.web.entity.UserTblEntity;
import Ansin.web.serviceimpl.IB0402ServiceImpl;
import Ansin.web.vueForm.B0402VueForm;

/**
 * B0402 面接詳細情報 interviewInfo
 * 
 * @author コウ テンキ
 * @date 2020-10-22 14:40:15
 */

@RestController
@RequestMapping("/B0402")
public class B0402Controller {

    @Autowired
    private IB0402ServiceImpl b0402Service;
    
    B0402VueForm b0402VueForm = new B0402VueForm();

    /**
     * B0402 面接詳細情報 初期表示
     * 
     * @param interviewId
     * @param results
     * @return CommonResult<B0402VueForm>
     */
    @PostMapping(value = "/getInit")
    public CommonResult<InterviewHisTblBean> getInit(@RequestBody @Valid Integer interviewId, HttpSession session, 
            BindingResult results) {

        if (results.hasErrors()) {
            return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
        }
        //SESSIONから会社IDとユーザーコードを取得
      	UserTblEntity user = (UserTblEntity) session.getAttribute("USER");
      	b0402VueForm.setCompanyId(user.getCompanyId());
      	b0402VueForm.setUserCd(user.getUserCd());

        // 面接IDを取得する
      	InterviewHisTblBean interviewHisTblBean = b0402Service.getInit(interviewId);

      	return CommonResult.success(interviewHisTblBean);


    }

    /**
     * B0402 面接詳細情報 データ更新
     * 
     * @param b0402VueForm
     * @param results
     * @return CommonResult<Integer>
     */
    @PostMapping(value = "/update")
    public CommonResult<Integer> update(@RequestBody @Valid B0402VueForm b0402VueForm, HttpSession session,
            BindingResult results) {

        if (results.hasErrors()) {
            return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
        }
        //SESSIONから会社IDとユーザーコードを取得
      	UserTblEntity user = (UserTblEntity) session.getAttribute("USER");
      	b0402VueForm.setCompanyId(user.getCompanyId());
      	b0402VueForm.setUserCd(user.getUserCd());

        // 更新結果を取得する
        Integer updResult = b0402Service.update(b0402VueForm);

        if (updResult != 0) {
            return CommonResult.success(updResult);
        } else {
            return CommonResult.validateFailed();
        }

    }
    
    /**
     * B0402 面接詳細情報 データ新規
     * @param b0402VueForm
     * @param results
     * @return CommonResult<Integer>
     */
    @PostMapping(value = "/insert")
    public CommonResult<Integer> insert(@RequestBody @Valid B0402VueForm b0402VueForm, HttpSession session,
            BindingResult results) {

        if (results.hasErrors()) {
            return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
        }
        //SESSIONから会社IDとユーザーコードを取得
      	UserTblEntity user = (UserTblEntity) session.getAttribute("USER");
      	b0402VueForm.setCompanyId(user.getCompanyId());
      	b0402VueForm.setUserCd(user.getUserCd());

        // 更新結果を取得する
        Integer updResult = b0402Service.insert(b0402VueForm);

        if (updResult != 0) {
            return CommonResult.success(updResult);
        } else {
            return CommonResult.validateFailed();
        }

    }
    

}
