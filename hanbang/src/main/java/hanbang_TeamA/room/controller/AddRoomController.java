package hanbang_TeamA.room.controller;

import hanbang_TeamA.com.controller.LoginController;
import hanbang_TeamA.com.vo.SessionVO;
import hanbang_TeamA.room.service.AddRoomService;
import hanbang_TeamA.room.vo.RoomVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
public class AddRoomController {
	
	@Autowired 
	AddRoomService addRoomService;
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	/**
	 * 매물 등록 페이지를 연다.
	 * @return
	 */
	@RequestMapping("/addRoomPage.do")
	public ModelAndView getAddRoomPage(){
		
		//1.로그인 여부 판단.
		
		//2. 로그인 했으면 매물 등록 페이지로 리턴.
		
		//3. 로그인 안했으면 로그인 페이지로 리턴.
		
		RoomVO roomVO = new RoomVO();
		
		return new ModelAndView("room/addRoom", "roomVO", roomVO);
	}
	
	@RequestMapping("/insertRoom.do")
	public ModelAndView creatRoom(@Valid RoomVO roomVO, BindingResult result,
			RedirectAttributes redirect, HttpServletRequest request,
			HttpServletResponse response){
		
		logger.debug("test----------------------------" + result.toString());
		logger.debug(roomVO.toString());
		
		SessionVO thisSession = (SessionVO) request.getSession().getAttribute("user");
		roomVO.setUserId(thisSession.getUserId());
		roomVO = addRoomService.createCustomer(roomVO);
		
		logger.debug("result------------------------" + roomVO.toString());
		return new ModelAndView("room/detailRoom", "roomVO", roomVO);
	}
	
	@RequestMapping("/updateRoom.do")
	public ModelAndView updateRoom(@Valid RoomVO roomVO, BindingResult result,
			RedirectAttributes redirect, HttpServletRequest request,
			HttpServletResponse response){
		
		logger.debug("update input----------------------------" + result.toString());
		logger.debug(roomVO.toString());
		
		roomVO = addRoomService.updateCustomer(roomVO);
		
		logger.debug("result------------------------" + roomVO.toString());
		return new ModelAndView("room/detailRoom", "roomVO", roomVO);
	}
	
	@RequestMapping("/deleteRoom.do")
	public ModelAndView deleteRoom(@Valid RoomVO roomVO, BindingResult result,
			RedirectAttributes redirect, HttpServletRequest request,
			HttpServletResponse response){
		
		logger.debug("delete input----------------------------" + result.toString());
		logger.debug(roomVO.toString());
		
		addRoomService.deleteCustomer(roomVO);
		
		return new ModelAndView("room/detailRoom", "roomVO", roomVO);
	}
}
