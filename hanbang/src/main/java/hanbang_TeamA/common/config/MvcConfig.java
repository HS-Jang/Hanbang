package hanbang_TeamA.common.config;

import hanbang_TeamA.common.interceptor.LoginCheckInterceptor;
import hanbang_TeamA.common.interceptor.SessionInterceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

	@Autowired
	private SessionInterceptor sessionInterceptor;
	
	@Autowired
	private LoginCheckInterceptor loginCheckInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(sessionInterceptor).addPathPatterns("/**.do");
		//		.excludePathPatterns(OauthController.OAUTH_CONTROLLER_MAPPING + "/**");
		
		registry.addInterceptor(loginCheckInterceptor).addPathPatterns("/addRoomPage.do").addPathPatterns("/moveMyPage.do");
	}

}