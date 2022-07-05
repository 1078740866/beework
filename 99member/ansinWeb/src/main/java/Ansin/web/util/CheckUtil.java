package Ansin.web.util;

import java.util.regex.Pattern;

public class CheckUtil {
	
	/**
	 * 半角数字チェック
	 * @param str
	 * @return true false
	 */
	public static boolean isHalfNumeric(String str) {

        return Pattern.matches("^[0-9]*$", str);

    }
	
	/**
	 * 郵便番号半角数字と位数チェック
	 * @param str
	 * @return true false
	 */
	public static boolean isPostal(String str) {

        return Pattern.matches("^([0-9]{3})-([0-9]{4})$", str);

    }

	/**
	 * 一致性チェック
	 * @param str restr
	 * @return true false
	 */
	public static boolean checkEqual(String str, String restr) {

		return str.equals(restr);

	}

	/**
	 * メール格式チェック
	 * @param email
	 * @return true false
	 */
	public static boolean checkEmail(String email) { 
		
//		String regex = "^(\\w+((-\\w+)|(\\.\\w+))*)\\+\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";
	    
		String regex = "[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?";
		
	    return Pattern.matches(regex, email); 
	}
	
	/**
	 * パスワード桁数チェック（８～１６）とパスワードフォーマットチェック（英字と数字をそれぞれ１文字以上）
	 * @param pwd
	 * @return true false
	 */
	public static boolean checkPwdFormat(String pwd) {
		
		String regex = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,16}$";
		
		return	Pattern.matches(regex, pwd);
	}
	
	
	/**
	 * パスワードフォーマットチェック
	 * @param pwd
	 * @return true false
	 */
	public static boolean checkPwdSymbolFormat(String pwd) {
		
		String regex = "^[a-zA-Z0-9#$&+-=.:?@/__^`|()\\\\[\\\\]]$";
		
		return	Pattern.matches(regex, pwd);
	}
	

}