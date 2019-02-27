package com.fzu.demo.common;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Created by zzx on 2017/12/4.
 * 
 * @author zzx
 */
@Configuration  
/*@EnableWebMvc  
@ComponentScan(basePackages = "com.fzu.demo.*")  */
public class WebConfiguration extends WebMvcConfigurerAdapter {

	/*@Bean
	@ConditionalOnMissingBean(InternalResourceViewResolver.class)
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("D:/webapp/WEB-INF/jsp/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setViewClass(JstlView.class);
		return viewResolver;
	}*/
	/*
	 * @Override Public void addResourceHandlers(ResourceHandlerRegistry
	 * registry){
	 * Registry.addResourceHandler("/assets/**").addResourceLocations(
	 * "classpath:/assets/") }
	 */

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 多个拦截器组成一个拦截器链
		// addPathPatterns 用于添加拦截规则
		// excludePathPatterns 用户排除拦截
		// registry.addInterceptor(new
		// SessionInterceptor()).addPathPatterns("/**");
		// super.addInterceptors(registry);
	}
}
