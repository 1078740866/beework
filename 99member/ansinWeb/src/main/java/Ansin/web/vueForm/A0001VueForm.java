package Ansin.web.vueForm;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
/**
 * WEBからユーザーデータを受け取る用
 * @author 楊
 *
 */
public class A0001VueForm {

    @NotBlank(message="メールアドレスは必須入力項目です。")
    @Email(message="メールアドレスはメールアドレス形式で入力してください。（例：abc@xxx.xxx）")
    private String userMail;
    @NotBlank(message="パスワードは必須入力項目です。")
	@Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9]).*$", message = "パスワードは正しく入力してください。")
    private String password;
    private String passwordConfirm;
    
	public String getPasswordConfirm() {
		return passwordConfirm;
	}
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}
	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "A0001VueForm [userMail=" + userMail + ", password=" + password + ", getUserMail()=" + getUserMail()
				+ ", getPassword()=" + getPassword() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
