package hanbang_TeamA.room.controller;

import hanbang_TeamA.room.service.SearchRoomService;
import hanbang_TeamA.room.vo.RoomOptionVO;
import hanbang_TeamA.room.vo.RoomVO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
public class SearchRoomController {
	@Autowired
	SearchRoomService searchRoomService;
	
	@RequestMapping("/roomList.do") 
	public ModelAndView list() {
		System.out.println("---------------------> RoomList ");
		RoomOptionVO inVO = new RoomOptionVO();
		
		List<RoomVO> roomVO = searchRoomService.getRoomList(inVO);
		System.out.println("---------------------> result : " + roomVO.toString());
		
		return new ModelAndView("room/roomList", "room", roomVO);
	} 
	
	@RequestMapping("/returnRoomList.do") 
	public ModelAndView returnRoomList(@Valid RoomOptionVO RoomVOList2, BindingResult result,
			RedirectAttributes redirect, HttpServletRequest request,
			HttpServletResponse response){
		
		String obj = request.getParameter("RoomVOList");
		//System.out.println(obj);
		String roomId[] = obj.split(",");

		RoomVO roomVO = new RoomVO();
		List<RoomVO> selectedRoom = new ArrayList<RoomVO>();
		
		for (int i = 0; i < roomId.length; i++) {
			roomVO.setId(roomId[i]);
			selectedRoom.add(searchRoomService.getRoomVOById(roomVO));
		}
		return new ModelAndView("room/roomList", "room", selectedRoom);
	}
	
	
	 
	@RequestMapping("/roomSearch.do")// 寃?됱“嫄댁엯??寃?됲븯???붾㈃
	public ModelAndView createForm(@ModelAttribute RoomVO room) {
		RoomOptionVO roomOptionVO = new RoomOptionVO();
		
		System.out.println("---------------------> RoomSearchStart! ");
		return new ModelAndView("room/roomSearch", "roomOptionVO", roomOptionVO);
	}
	
	@RequestMapping("/roomDetail.do")// 寃?됱“嫄댁엯??寃?됲븯???붾㈃
	public ModelAndView detailForm(@ModelAttribute RoomVO room) {
		RoomVO roomVO = new RoomVO();
		
		System.out.println("---------------------> RoomDeatilStart! "+ roomVO.toString());
		return new ModelAndView("room/detailRoom", "room", roomVO);
	}
	

	
}
