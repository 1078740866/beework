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
import Ansin.web.bean.InterviewHisTblBean;
import Ansin.web.entity.UserTblEntity;
import Ansin.web.serviceimpl.IC0501ServiceImpl;
import Ansin.web.vueForm.B0401VueForm;

/**
 * C0501_面接一覧画面Controller
 * 
 * @author 楊卿赫
 * @date 2021-01-04 15:20:10
 */

@RestController
@RequestMapping("/C0501")
public class C0501Controller {

    @Autowired
    private IC0501ServiceImpl iC0501ServiceImpl;

    /**
     * 未処理の面接一覧
     * @param b0401VueForm
     * @param session
     * @param results
     * @return interviewHisTblBean
     */
  
    @PostMapping(value = "/select")
    public CommonResult< List<InterviewHisTblBean>> select(@RequestBody @Valid B0401VueForm c0501VueForm, HttpSession session,
            BindingResult results) {

        if (results.hasErrors()) {
            return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
        }
        
        //SESSIONから会社IDとユーザーコードを取得
      	UserTblEntity user = (UserTblEntity) session.getAttribute("USERC");
      	c0501VueForm.setUserCd(user.getUserCd());

        List<InterviewHisTblBean> interviewHisTblBean = iC0501ServiceImpl.getInterviewHisTblEntityList2(c0501VueForm);

        return CommonResult.success(interviewHisTblBean);

    }
    
    /**
     * 処理後の面接一覧
     * @param b0401VueForm
     * @param session
     * @param results
     * @return interviewHisTblBean
     */
  
    @PostMapping(value = "/selectInfo")
    public CommonResult< List<InterviewHisTblBean>> selectInfo(@RequestBody @Valid B0401VueForm c0501VueForm, HttpSession session,
            BindingResult results) {

        if (results.hasErrors()) {
            return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
        }
        
        //SESSIONから会社IDとユーザーコードを取得
      	UserTblEntity user = (UserTblEntity) session.getAttribute("USERC");
      	c0501VueForm.setUserCd(user.getUserCd());

        List<InterviewHisTblBean> interviewHisTblBean = iC0501ServiceImpl.getInterviewHisTblEntityList(c0501VueForm);

        return CommonResult.success(interviewHisTblBean);

    }
    
    

    /**
     *　ユーザー多数受けたまたは多数断る
     * @param interviewHisTblEntities
     * @param session
     * @param results
     * @return CommonResult<Integer>
     */
    @PostMapping(value = "/flgChange")
    public CommonResult<Integer> delete(@RequestBody @Valid B0401VueForm c0501VueForm, HttpSession session,
            BindingResult results) {

        if (results.hasErrors()) {
            return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
        }
        //SESSIONから会社IDとユーザーコードを取得
      	UserTblEntity user = (UserTblEntity) session.getAttribute("USERC");
      	c0501VueForm.setUserCd(user.getUserCd());

        // 更新数
        int count = iC0501ServiceImpl.update(c0501VueForm.getInterviewIds(), c0501VueForm.getUserCd(), c0501VueForm.getStatusFlg());

        // 更新数の判断
        if (count != 0) {
            return CommonResult.success(count);
        } else {
           return CommonResult.validateFailed("error");
        }
    }

}
