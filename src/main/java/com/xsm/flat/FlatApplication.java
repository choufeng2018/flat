package com.xsm.flat;

import com.xsm.flat.config.JwtFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import java.util.Collection;


@SpringBootApplication
@EnableTransactionManagement//开启事务管理
@EnableScheduling//开启对计划任务的支持
@MapperScan("com.xsm.flat.dao")// MyBatis 支持
@ServletComponentScan(basePackages = { "com.xsm.flat.servlet" })// Druid 支持,扫描自己编写的servlet和filter
public class FlatApplication extends SpringBootServletInitializer{

//	@Bean
//	public FilterRegistrationBean jwtFilter() {
//		FilterRegistrationBean rbean = new FilterRegistrationBean();
//	//	rbean.setFilter(new JwtFilter());
//	//	rbean.addUrlPatterns("/*");// 过滤需要验证权限的链接
//
//		return rbean;
//	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(this.getClass());
	}

	public static void main(String[] args) {
		SpringApplication.run(FlatApplication.class, args);
	}
}
