package Ansin.web.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//import Ansin.web.util.AdminInterceptor;

/**
 * インターセプター構成ファイルを書き込む
 * @author 楊
 *
 */
//@Configuration
//public class LoginConfig implements WebMvcConfigurer {
//    
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        /**
//                     *  インターセプター
//         */
//        InterceptorRegistration registration = registry.addInterceptor(new AdminInterceptor());
//        registration.addPathPatterns("/**");        
//        /**
//                     * 以下設定のアドレス、インターセプター使用しない
//         */
//        registration.excludePathPatterns(
//        								 "/*", 
//        								 "/**",
//        								 "/admin/login", 
//        								 "/login",                //a自分のインターセプター処理必要がないのアドレス
//                                         "/**/*.html",            //html
//                                         "/**/*.js",              //js
//                                         "/**/*.css",             //css
//                                         "/**/*.woff",
//                                         "/**/*.ttf"
//                                         );    
//    }
//}