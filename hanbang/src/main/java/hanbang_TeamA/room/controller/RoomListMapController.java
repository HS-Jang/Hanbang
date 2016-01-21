package hanbang_TeamA.room.controller;

import hanbang_TeamA.com.controller.LoginController;
import hanbang_TeamA.room.service.RoomListMapService;
import hanbang_TeamA.room.service.SearchRoomService;
import hanbang_TeamA.room.vo.RoomOptionVO;
import hanbang_TeamA.room.vo.RoomVO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class RoomListMapController {
	
	@Autowired 
	RoomListMapService roomListMapService;
	
	@Autowired 
	SearchRoomService searchRoomService;
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	 
	@RequestMapping("/roomListMap.do")
	public ModelAndView createRoomListMap(@Valid RoomOptionVO roomOptionVO, BindingResult result,
			RedirectAttributes redirect, HttpServletRequest request,
			HttpServletResponse response){
		
		System.out.println("-------------------------> getRoomList Service Start");
		
		Map<String, Object> rslt = new HashMap<String, Object>();
		
		// List<Object> rslt = new ArrayList<Object>();
		List<RoomVO> totalLoc = searchRoomService.getRoomList(roomOptionVO);
		 
		
		rslt.put("roomList", totalLoc);
		rslt.put("srchCond", roomOptionVO);

		
		logger.debug("result------------------------" + roomOptionVO.toString()); 
		return new ModelAndView("room/roomListMap", "rslt", rslt);
	}
		
}
