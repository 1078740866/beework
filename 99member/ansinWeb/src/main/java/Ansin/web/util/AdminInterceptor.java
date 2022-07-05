package Ansin.web.util;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import Ansin.web.entity.UserTblEntity;

/**
 * 自定義インターセプト
 * @author 楊
 *
 */
//public class AdminInterceptor implements  HandlerInterceptor {
//
//    /**
//     　　　*請求処理以前、利用する（Controller方法利用以前）
//     */
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
//        try {
//            //（查询当前session是否存在user）(这里user会在每次登陆成功后，写入session)
//        	/**
//        	 * 毎回ユーザー登録成功なら、SESSIONに入れる。そして、SESSIONにユーザーデータを取得する
//        	 */
//        	UserLoginEntity user = (UserLoginEntity) request.getSession().getAttribute("USER");
//        	/**
//        	 * もしユーザーデータ存在すれば、TRUEがあります。
//        	 */
//            if(user != null){
//                return true;
//            }
//            /**
//             　　　　　　* もしユーザーデータ存在しなければ、ログイン画面に強制的にジャンプ
//             */
//            response.sendRedirect(request.getContextPath()+"/login");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        /**
//         * falseに設定した場合、インターセプターは要求されたときに動作を継続しません
//         * TRUEの場合、リクエストは引き続き後続の操作を実行します
//         * 
//         */
//        return false;
//        
//    }
// 
//    /**
//            *リクエストが処理された後、ビューがレンダリングされる前に呼び出されます（Controllerメソッドが呼び出された後）
//     */
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
////         System.out.println("执行了TestInterceptor的postHandle方法");
//    }
// 
//    /**
//             * リクエスト全体が終了した後、つまりDispatcherServletが対応するビューをレンダリングした後に実行されます（主にリソースのクリーニングに使用されます）
//     */
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
////        System.out.println("执行了TestInterceptor的afterCompletion方法");
//    }
//    
//}