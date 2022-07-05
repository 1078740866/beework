
package Ansin.web.util;
 
import org.springframework.util.DigestUtils;
 
/**
 * パスワード用MD5暗号化方法
 * @author 楊
 * 
 */
public class MD5Util {
	
	public static String md5Util(String password) {
		String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
		return md5Password;
	}
	
	
 
}