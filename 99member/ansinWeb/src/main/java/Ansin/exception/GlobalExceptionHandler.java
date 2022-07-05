package Ansin.exception;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.HashMap;
import java.util.Map;

/**
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	// 统一处理所有的异常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public CommonReturnType doError(Exception e) {
        e.printStackTrace();
        Map<String, Object> data = new HashMap<>();
        if (e instanceof BusinessException) {
            BusinessException businessException = (BusinessException)e;
            data.put("errorCode", businessException.getErrorCode());
            data.put("errorMsg", businessException.getErrorMsg());
        } else if (e instanceof NoHandlerFoundException) {
            data.put("errorCode", EmBusinessError.UNKNOWN_ERROR.getErrorCode());
            data.put("errorMsg", "没有找到访问路径");
        } else {
            data.put("errorCode", EmBusinessError.UNKNOWN_ERROR.getErrorCode());
            data.put("errorMsg",EmBusinessError.UNKNOWN_ERROR.getErrorMsg());
        }
        return CommonReturnType.create(data, "fail");
    }
}