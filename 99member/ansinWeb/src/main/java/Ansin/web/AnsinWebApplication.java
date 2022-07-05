package Ansin.web;

import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import Ansin.web.entity.UserTblEntity;

@MappedTypes(UserTblEntity.class)
@SpringBootApplication
@MapperScan("Ansin.web.mapper")
public class AnsinWebApplication extends SpringBootServletInitializer {

	// 输入http://localhost:8088/swagger-ui.html，能够看到测试页面
	public static void main(String[] args) {
		SpringApplication.run(AnsinWebApplication.class, args);
	}

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(this.getClass());
    }

}
