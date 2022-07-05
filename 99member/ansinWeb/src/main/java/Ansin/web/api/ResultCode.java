package Ansin.web.api;

public enum ResultCode implements IErrorCode {

	SUCCESS(200, "操作成功"),

	FAILED(500, "操作失敗"),

	VALIDATE_FAILED(404, "パラメータチェック失敗"),

	UNAUTHORIZED(401, "登録していませんまたは登録期限切れ"),

	FORBIDDEN(403, "権限なし");

	private long code;
	private String message;

	private ResultCode(long code, String message) {
		this.code = code;
		this.message = message;
	}

	public long getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}