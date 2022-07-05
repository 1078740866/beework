package Ansin.web.security;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import Ansin.web.entity.UserTblEntity;
import Ansin.web.serviceimpl.IB0001ServiceImpl;

/**
 * 用户登录认证信息查询
 * @author Louis
 * @date Jun 29, 2019
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IB0001ServiceImpl userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	UserTblEntity user = userService.findByMail(username);
        if (user == null) {
            throw new UsernameNotFoundException("当ユーザーが存在しません。");
        }

    	user.setPwd(new BCryptPasswordEncoder().encode(user.getPwd()));
        // 用户权限列表，根据用户拥有的权限标识与如 @PreAuthorize("hasAuthority('sys:menu:view')") 标注的接口对比，决定是否可以调用接口
        Set<String> permissions = userService.findPermissions(username);
        List<GrantedAuthority> grantedAuthorities = permissions.stream().map(GrantedAuthorityImpl::new).collect(Collectors.toList());
        return new JwtUserDetails(username, user.getPwd(), grantedAuthorities);
    }
}