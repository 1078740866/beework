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
import Ansin.web.entity.UserTblEntity;
import Ansin.web.serviceimpl.IB0602ServiceImpl;
import Ansin.web.vueForm.B0602VueForm;

/**
 * B0602_説明会詳細
 * 
 * @author 侯添琦
 *
 */
@RestController
@RequestMapping("/B0602")
public class B0602Controller {

    @Autowired
    private IB0602ServiceImpl b0602Service;

    /**
     * 郵便番号に基づいて都道府県・市区町村の情報を取得する
     * 
     * @param briefingEntity
     * @param results
     * @param session
     * @return CommonResult<PrefecturestAndCityEntity>
     */
    @PostMapping(value = "/postal")
    public CommonResult<List<String>> getPostal(B0602VueForm b0602VueForm, BindingResult results,
            HttpSession session) {

        if (results.hasErrors()) {
            return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
        }
        
		List<String> postalList = b0602Service.getPostaOne(b0602VueForm.getPostal());
		
		return CommonResult.success(postalList);

    }

    /**
     * 研修提出
     * 
     * @param briefingEntity
     * @param results
     * @param session
     * @return CommonResult<Integer>
     */
    @PostMapping(value = "/new")
    public CommonResult<Integer> newBriefing(@RequestBody @Valid B0602VueForm b0602VueForm, BindingResult results,
            HttpSession session) {

        if (results.hasErrors()) {
            return CommonResult.validateFailed(results.getFieldError().getDefaultMessage());
        }
        
		// SESSIONから会社IDを取得
		UserTblEntity user = (UserTblEntity) session.getAttribute("USER");
		b0602VueForm.setCompanyId(user.getCompanyId());
        // SESSIONからユーザーCD取得
		b0602VueForm.setUserCd(user.getUserCd());
		
		int count;
		
        // briefingIdの内容を判断する
        if (b0602VueForm.getBriefingId() == null) {
        	//都道府県を取得
        	b0602VueForm.setPrefeNm(b0602Service.getPrefeNm(b0602VueForm.getPostal()));
        	// 追加
            count = b0602Service.insert(b0602VueForm);
        } else {
        	//都道府県を取得
        	b0602VueForm.setPrefeNm(b0602Service.getPrefeNm(b0602VueForm.getPostal()));
            // 更新
            count = b0602Service.update(b0602VueForm);
        }
        if (count == 1) {
            // 成功する場合
            return CommonResult.success(count);
        } else {
            return CommonResult.failed();
        }
    }
}
