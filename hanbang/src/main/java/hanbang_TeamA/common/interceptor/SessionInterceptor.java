package hanbang_TeamA.common.interceptor;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class SessionInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private ServletContext context;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SessionInterceptor.class);

//	@Autowired
//	private OAuthSession session;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		// Redirect to OAuth authentication if not signed in.
		// WebSecurityConfig prevents this interceptor from being applied to
		// the OAuth authentication URL to prevent an infinite loop.
		
		LOGGER.debug("[SessionInterceptor 동작 시작]---------------->");
        Object obj = request.getSession().getAttribute("user");
        if (obj == null) {
      //  	 request.getSession().s
        }
        
        return true;

	}
	
}