package hanbang_TeamA.room.controller;

import hanbang_TeamA.com.controller.LoginController;
import hanbang_TeamA.room.service.SelectMapPointService;
import hanbang_TeamA.room.vo.RoomOptionVO;
import hanbang_TeamA.room.vo.RoomVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//70.121.244.190/gitnsam/soldevgroup_rbsd/hanbang.git
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class SelectMapPointController {
	
	@Autowired 
	SelectMapPointService selectMapPointService;
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	 
	@RequestMapping("/selectMapPoint.do")
	public ModelAndView createSelectMapPoint(@Valid RoomVO roomVO, BindingResult result,
			RedirectAttributes redirect, HttpServletRequest request,
			HttpServletResponse response){
		
		logger.debug("result------------------------" + roomVO.toString()); 
		return new ModelAndView("room/selectMapPoint", "roomVO", roomVO);
	}
	
	@RequestMapping("/returnMapPoint.do")
	public ModelAndView returnSelectMapPoint(@Valid RoomVO roomVO, BindingResult result,
			RedirectAttributes redirect, HttpServletRequest request,
			HttpServletResponse response){
		

//		RoomVO inVO = new RoomVO();
		logger.debug("returnMapPoint-------" + roomVO.toString()); 
		return new ModelAndView("room/addRoom", "roomVO", roomVO);
	}
	

	@RequestMapping("/selectMapPoint2.do")
	public ModelAndView createSelectMapPoint2(@Valid RoomOptionVO roomOptionVO, BindingResult result,
			RedirectAttributes redirect, HttpServletRequest request,
			HttpServletResponse response){
		
		logger.debug("start------------------------" + roomOptionVO.toString()); 
		return new ModelAndView("room/selectMapPoint2", "roomOptionVO", roomOptionVO);
	}
	
	@RequestMapping("/returnMapPoint2.do")
	public ModelAndView returnSelectMapPoint2(@Valid RoomOptionVO roomOptionVO, BindingResult result,
			RedirectAttributes redirect, HttpServletRequest request,
			HttpServletResponse response){
		

//		RoomVO inVO = new RoomVO();
		logger.debug("returnMapPoint-------" + roomOptionVO.toString()); 
		return new ModelAndView("room/roomSearch", "roomOptionVO", roomOptionVO);
	}

}
