package Ansin.web.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.google.code.kaptcha.impl.DefaultKaptcha;

import Ansin.web.api.CommonResult;

/**
 * @author zsh
 * @company wlgzs
 * @create 2019-03-10 9:41
 * @Describe Captcha测试controller
 */
@RestController
@RequestMapping("/")
public class KaptchaController {

    @Autowired
    DefaultKaptcha defaultKaptcha;

    /**
     * 显示验证码
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/defaultKaptcha", method = RequestMethod.GET)
    public void defaultKaptcha(HttpServletRequest request, HttpSession session, HttpServletResponse response) throws Exception {
        byte[] captchaChallengeAsJpeg = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try {
            //生产验证码字符串并保存到session中
            String createText = defaultKaptcha.createText();
            session.setAttribute("verifyCode", createText);
            //使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
            BufferedImage challenge = defaultKaptcha.createImage(createText);
            ImageIO.write(challenge, "jpg", jpegOutputStream);
        } catch (IllegalArgumentException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        //定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        ServletOutputStream responseOutputStream =
                response.getOutputStream();
        responseOutputStream.write(captchaChallengeAsJpeg);
        responseOutputStream.flush();
        responseOutputStream.close();
    }

//    @RequestMapping(value = "/verifyCode", method = RequestMethod.POST)
//    public CommonResult<Model> imgverifyControllerDefaultKaptcha(Model model, HttpSession session, @RequestBody JSONObject jsonCode, BindingResult results) {
//		// 会社名取得
//		Map<String, Object> jsonToMap =  JSONObject.parseObject(jsonCode.toJSONString());
//		String code = (String)jsonToMap.get("code");
//        String captchaId = (String) session.getAttribute("verifyCode");
//        System.out.println("验证码是：" + captchaId);
//        System.out.println("用户输入的是：" + code);
//        if (!captchaId.equals(code)) {
//            System.out.println("输入错误");
//            model.addAttribute("info", "错误的验证码");
//        } else {
//            System.out.println("输入正确");
//            model.addAttribute("info", "正确");
//        }
//
//		return CommonResult.success(model);
//    }

	@RequestMapping(value = "/verifyCode", method = RequestMethod.POST)
	public CommonResult<String> imgverifyControllerDefaultKaptcha(@RequestBody JSONObject jsonCode, BindingResult results, HttpSession session) {
		// 会社名取得
		Map<String, Object> jsonToMap =  JSONObject.parseObject(jsonCode.toJSONString());
		String code = (String)jsonToMap.get("code");
        String captchaId = (String) session.getAttribute("verifyCode");
        System.out.println("職別コードは：" + captchaId);
        System.out.println("ユーザー入力の職別コードは：" + code);
        if (!captchaId.equals(code)) {
            System.out.println("入力エラー");
    		return CommonResult.success("入力エラー");
        } else {
            System.out.println("入力成功");
    		return CommonResult.success("入力成功");
        }
	}

    @GetMapping("/")
    public ModelAndView test() {
        return new ModelAndView("index");
    }

}