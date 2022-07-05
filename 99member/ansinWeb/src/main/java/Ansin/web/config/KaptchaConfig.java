package Ansin.web.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;


/**
 * @Author Bertram.wang
 * @Date 2019年5月12日 下午10:48:58
 * @sign KaptchaConfig.java
 */
@Configuration
public class KaptchaConfig {
    @Bean
    public DefaultKaptcha defaultKaptcha() {
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        Properties properties = new Properties();
        // 设置边框，合法值：yes , no
        properties.setProperty("kaptcha.border", "yes");
        // 设置边框颜色，合法值： c (and optional alpha) 或者 white,
        properties.setProperty("kaptcha.border.color", "0,0,0");
        // 设置字体颜色， r,g,b 或者 white,black,blue.
        properties.setProperty("kaptcha.textproducer.font.color", "blue");
        // 设置图片宽度
        properties.setProperty("kaptcha.image.width", "200");
        // 设置图片高度
        properties.setProperty("kaptcha.image.height", "80");
        // 设置字体尺寸
        properties.setProperty("kaptcha.textproducer.font.size", "60");
        // 设置验证码长度
        properties.setProperty("kaptcha.textproducer.char.length", "6");
        // 字体
        properties.setProperty(Constants.KAPTCHA_TEXTPRODUCER_FONT_NAMES, "宋体,楷体,微软雅黑");
        properties.setProperty(Constants.KAPTCHA_BORDER, "no");
        
        Config config = new Config(properties);
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }
    
}
