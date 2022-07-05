package Ansin.exception;

/**
 */
public class BusinessException extends Exception implements CommonError {

    private CommonError commonError;

    // 直接接收EmBusinessError用于构造业务异常
    public BusinessException(CommonError commonError) {
        super();
        this.commonError = commonError;
    }

    // 同时接收EmBusinessError和自定义错误信息并覆盖掉原本的错误信息
    public BusinessException(CommonError commonError, String errorMsg) {
        super();
        this.commonError = commonError;
        this.commonError.setErrorMsg(errorMsg);
    }

    @Override
    public int getErrorCode() {
        return commonError.getErrorCode();
    }

    @Override
    public String getErrorMsg() {
        return commonError.getErrorMsg();
    }

    @Override
    public CommonError setErrorMsg(String errorMsg) {
        return commonError.setErrorMsg(errorMsg);
    }
}