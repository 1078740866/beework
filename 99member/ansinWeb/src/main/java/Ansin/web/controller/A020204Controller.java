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
import Ansin.web.entity.B0401ListEntity;
import Ansin.web.entity.UserTblEntity;
import Ansin.web.serviceimpl.IA020204ServiceImpl;
import Ansin.web.vueForm.A020204VueForm;

/**
 *A020204面接一覧画面
 * 
 * @author 楊卿赫
 * @date 2020-10-19 18:50:10
 */

@RestController
@RequestMapping("/A020204")
public class A020204Controller {

    @Autowired
    private IA020204ServiceImpl iA020204ServiceImpl;

    B0401ListEntity b0401ListEntity = new B0401ListEntity();

    /**
     * 初期値またはサーチ結果を表示する
     * @param a020204VueForm
     * @param session
     * @param results
     * @return  List<InterviewHisTblBean>
     */
  
    @PostMapping(value = "/select")
    public CommonResult< List<InterviewHisTblBean>> select(@RequestBody @Valid A020204VueForm a020204VueForm, HttpSession session,
            BindingResult results) {

        if (results.hasErrors()) {
            return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
        }
        
        List<InterviewHisTblBean> interviewHisTblBean = iA020204ServiceImpl.getInterviewHisTblEntityList(a020204VueForm);

        return CommonResult.success(interviewHisTblBean);
        

    }

    /**
     * シングルな削除と複数削除
     * 
     * @param interviewHisTblEntities
     * @param session
     * @param results
     * @return CommonResult<Integer>
     */
    @PostMapping(value = "/delete")
    public CommonResult< List<InterviewHisTblBean>> delete(@RequestBody @Valid A020204VueForm a020204VueForm, HttpSession session,
            BindingResult results) {

        if (results.hasErrors()) {
            return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
        }
      //SESSIONから会社IDとユーザーコードを取得
      	UserTblEntity user = (UserTblEntity) session.getAttribute("USERA");
      	a020204VueForm.setUserCd(user.getUserCd());

        // 更新数
        int count = iA020204ServiceImpl.update(a020204VueForm.getInterviewIds(), a020204VueForm.getApplicantId());

        // 更新数の判断
        if (count != 0) {
        	   
            List<InterviewHisTblBean> interviewHisTblBean = iA020204ServiceImpl.getInterviewHisTblEntityList(a020204VueForm);

            return CommonResult.success(interviewHisTblBean);
        	
        } else {
           return CommonResult.validateFailed("error");
        }
    }

}
