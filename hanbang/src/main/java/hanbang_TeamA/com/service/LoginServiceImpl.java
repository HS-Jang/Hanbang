package hanbang_TeamA.com.service;

import hanbang_TeamA.com.controller.LoginController;
import hanbang_TeamA.com.dao.UserDAO;
import hanbang_TeamA.com.vo.UserVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	UserDAO userDAO;
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Override
	public UserVO doChkLogin(UserVO inUser) {
		
		logger.debug("----------------> doChkLogin --------> " + inUser.toString());
		
		//넘어온 사용자 계정으로 해당 사용자 정보 조회
		UserVO rsltUser = userDAO.findByUserId(inUser.getUserId());
		
		logger.debug("----------------> doChkLogin 결과 --------> " + ((rsltUser != null) ? rsltUser.toString() : "NULL"));
		//조회된 결과가 있고, 비밀번호가 일치할경우 -- 로그인 성공
		if(rsltUser != null && inUser.getPwd().equals(rsltUser.getPwd())){
			logger.debug("로그인 성공!!!!!!!!!!!!!!!!!!!!!");
			
			return rsltUser;
		}//로그인 실패일 경우 null return
		else{
			return null;
		}
		
	}


}
