package Ansin.web.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

import Ansin.web.api.CommonResult;
import Ansin.web.bean.BriefingInfoTblBean;
import Ansin.web.bean.PositionTblBean;
import Ansin.web.bean.TrainingInfoTblBean;
import Ansin.web.serviceimpl.IA0602ServiceImpl;
/**
 * A0602_通報詳細画面
 * @author 楊卿赫
 *
 */
@RestController
@RequestMapping("/A0602")
public class A0602Controller {
		
	@Autowired
    private IA0602ServiceImpl iA0602ServiceImpl;
	
	
	/**
	 * A0602_職位データ取得
	 * @param positionId
	 * @param session
	 * @param results
	 * @return PositionTblBean
	 */
	@RequestMapping(value = "/getPosition", method = {RequestMethod.POST })
	 public CommonResult<PositionTblBean> getPosition(@RequestBody JSONObject positionId, HttpSession session,BindingResult results) {
		
		// 職位ID取得
		Map<String, Object> jsonToMap =  JSONObject.parseObject(positionId.toJSONString());
		Integer pId = (Integer)jsonToMap.get("positionId");
		
		//データ取得
		return CommonResult.success( iA0602ServiceImpl.getPosition(pId));
	}
	
	/**
	 * A0602_研修会データ取得
	 * @param trainingId
	 * @param session
	 * @param results
	 * @return TrainingInfoTblBean
	 */
	@RequestMapping(value = "/getTraining", method = {RequestMethod.POST })
	 public CommonResult<TrainingInfoTblBean> getTraining(@RequestBody JSONObject trainingId, HttpSession session,BindingResult results) {
		
		// 職位ID取得
		Map<String, Object> jsonToMap =  JSONObject.parseObject(trainingId.toJSONString());
		Integer tId = (Integer)jsonToMap.get("trainingId");
		
		//データ取得
		return CommonResult.success( iA0602ServiceImpl.getTraining(tId));
	}

	
	/**
	 * A0602_説明会データ取得
	 * @param briefingId
	 * @param session
	 * @param results
	 * @return BriefingInfoTblBean
	 */
	@RequestMapping(value = "/getBriefing", method = {RequestMethod.POST })
	 public CommonResult<BriefingInfoTblBean> getBriefing(@RequestBody JSONObject briefingId, HttpSession session,BindingResult results) {
		
		// 職位ID取得
		Map<String, Object> jsonToMap =  JSONObject.parseObject(briefingId.toJSONString());
		Integer bId = (Integer)jsonToMap.get("briefingId");
		
		//データ取得
		return CommonResult.success( iA0602ServiceImpl.getBriefing(bId));
	}


}
