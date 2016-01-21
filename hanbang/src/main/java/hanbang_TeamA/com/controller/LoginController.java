package hanbang_TeamA.com.controller;

import java.util.List;

import hanbang_TeamA.com.service.LoginService;
import hanbang_TeamA.com.vo.SessionVO;
import hanbang_TeamA.com.vo.UserVO;
import hanbang_TeamA.room.service.SearchRoomService;
import hanbang_TeamA.room.vo.RoomVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	SearchRoomService searchRoomService;
	
	@Autowired
	SessionVO sessionVO;
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping("/moveLoginPage.do")
	public ModelAndView moveLoginPage(@ModelAttribute UserVO userVO, HttpServletRequest request) {
		logger.debug("---------------------> moveLoginPage ");
		System.out.println("리퀘스트 -2---> " + request.getRequestURI());

		return new ModelAndView("login/login");
	}
	
	@RequestMapping("/moveMyPage.do")
	public ModelAndView moveMyPage(@ModelAttribute SessionVO sessionVO, HttpServletRequest request) {
		logger.debug("---------------------> moveMyPage ");
		
		SessionVO thisSession = (SessionVO) request.getSession().getAttribute("user");
		
		logger.debug("세션정보>  " + thisSession.getUserId());
		
		RoomVO inRoom = new RoomVO();
		inRoom.setUserId(thisSession.getUserId());
		
		List<RoomVO> rslt = searchRoomService.getRoomListByUserId(inRoom);

		return new ModelAndView("login/myPage", "roomList", rslt);
	}
	
	@RequestMapping("/login.do")
	public ModelAndView doLogin(@Valid UserVO userVO, BindingResult result,
			RedirectAttributes redirect, HttpServletRequest request,
			HttpServletResponse response) {
		logger.debug("-------------------> login.do start --------->" + result.toString());
		logger.debug("----------------> userVO--> " + userVO.toString());
		if (result.hasErrors()) {
			logger.debug("----------------> Has Error!!!!!!!!!!!!!!!!!!!!!! ");
			return new ModelAndView("login/login", "formErrors", result.getAllErrors());
		}
		logger.debug("----------------> PASS!!!!!!!!!!!!!!!!!!!!!! ");
		HttpSession session =request.getSession();
		
		//login 확인 service 호출
		UserVO loginUser = loginService.doChkLogin(userVO);

		
		
		//login 성공일 경우 세션에 넣어줌
		if(loginUser != null){
			BeanUtils.copyProperties(loginUser, sessionVO);
			
			session.setAttribute("user", sessionVO);
		}else{
			
			return new ModelAndView("login/login", "loginError", "loginError");
		}
		
		
		redirect.addFlashAttribute("globalMessage", "Successfully login");
		
		return new ModelAndView("redirect:/");
		//return new ModelAndView("redirect:/{customerVO.id}", "customerVO.id", customerVO.getId());
	}
	
	@RequestMapping("/logout.do")
	public ModelAndView doLogout(@Valid UserVO userVO, BindingResult result,
			RedirectAttributes redirect, HttpServletRequest request,
			HttpServletResponse response) {
		
		logger.debug("-------------------> logout.do start --------->" );
		
		request.getSession().removeAttribute("user");
		
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping("/goDetailRoom.do")
	public ModelAndView goDetailRoom(RoomVO roomVO, BindingResult result,
			RedirectAttributes redirect, HttpServletRequest request,
			HttpServletResponse response) {
		
		roomVO = searchRoomService.getRoomVOById(roomVO);
		
		return new ModelAndView("room/detailRoom", "roomVO", roomVO);
	}

	@RequestMapping("/goDetailRoomFromList.do")
	public ModelAndView goDetailRoomFromList(RoomVO roomVO, BindingResult result,
			RedirectAttributes redirect, HttpServletRequest request,
			HttpServletResponse response) {
		
		roomVO = searchRoomService.getRoomVOById(roomVO);
		
		SessionVO thisSession = (SessionVO) request.getSession().getAttribute("user");
		if(thisSession!=null && roomVO.getUserId().equals(thisSession.getUserId())){
			//로그인이랑 등록자랑 같을떄.
			return new ModelAndView("room/detailRoom", "roomVO", roomVO);
		}
		return new ModelAndView("room/readRoom", "roomVO", roomVO);
	}
	
}
