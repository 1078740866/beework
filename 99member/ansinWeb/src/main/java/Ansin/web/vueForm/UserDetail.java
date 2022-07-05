package Ansin.web.vueForm;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
 
 
/**
 * SpringSecurity User
 * @author Hong
 * @Date 2016年11月20日
 */
public class UserDetail implements UserDetails {
	
	private String userName;
 
	private String userPwd;
 
	private static final long serialVersionUID = 1L;
 
	public UserDetail(A0001VueForm user) {
		this.setUserName(user.getUserMail());
		this.setUserPwd(user.getPassword());
	}
 
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}
 
	@Override
	public String getPassword() {
		return this.getUserPwd();
	}
 
	@Override
	public String getUsername() {
		return this.getUserName();
	}
 
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
 
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
 
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
 
	@Override
	public boolean isEnabled() {
		return true;
	}
 
	public String getUserName() {
		return userName;
	}
 
	public void setUserName(String userName) {
		this.userName = userName;
	}
 
	public String getUserPwd() {
		return userPwd;
	}
 
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	
	@Override
	public String toString() {
		return this.userName;
	}
	
	@Override
	public int hashCode() {
		return userName.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.toString().equals(obj.toString());
	}
}