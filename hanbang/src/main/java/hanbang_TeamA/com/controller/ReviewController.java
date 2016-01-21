package hanbang_TeamA.com.controller;

import hanbang_TeamA.com.service.ReviewService;
import hanbang_TeamA.com.vo.ReviewVO;
import hanbang_TeamA.com.vo.SessionVO;
import hanbang_TeamA.com.vo.Temp;
import hanbang_TeamA.room.service.SearchRoomService;
import hanbang_TeamA.room.service.SelectMapPointService;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
public class ReviewController {
	
	@Autowired 
	SelectMapPointService selectMapPointService;
	
	@Autowired 
	SearchRoomService searchRoomService;
	
	@Autowired 
	ReviewService reviewService;
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	 
	@RequestMapping("/moveReviewPage.do")
	public ModelAndView moveReviewPage(@Valid RoomVO roomVO, BindingResult result,
			RedirectAttributes redirect, HttpServletRequest request,
			HttpServletResponse response){
		
		//List<RoomVO> rslt = searchRoomService.getRoomList(roomVO);
		
		Map<String, Object> rslt = new HashMap<String, Object>();
		
		RoomOptionVO optinVO = new RoomOptionVO();
		
		
		List<RoomVO> roomList = searchRoomService.getAllRoomList(optinVO);
		List<ReviewVO> reviewList = reviewService.getAllReviewList();
		Temp tmp = new Temp();
		tmp.setLat("37.51670520064188");
		tmp.setLon("127.10121513225553");
		tmp.setTime("15");
		
		rslt.put("roomList", roomList);
		rslt.put("reviewList", reviewList);
		rslt.put("srchCond", tmp);
		
		logger.debug("result------------------------" + rslt.toString());
		
		return new ModelAndView("review/reviewPage", "rslt", rslt);
	}
	
	@RequestMapping("/moveAddReviewPage.do")
	public ModelAndView moveAddReviewPage(@Valid ReviewVO reviewVO, BindingResult result,
			RedirectAttributes redirect, HttpServletRequest request,
			HttpServletResponse response){
		
		
		logger.debug("moveAddReview------------------------"  + reviewVO.toString());
		
		return new ModelAndView("review/addReview", "reviewVO", reviewVO);
	}
	
	@RequestMapping("/insertReview.do")
	public ModelAndView addReview(@Valid ReviewVO reviewVO, BindingResult result,
			RedirectAttributes redirect, HttpServletRequest request,
			HttpServletResponse response){
		
		logger.debug("moveAddReview 시작------------------------"  + reviewVO.toString());
		
		SessionVO thisSession = (SessionVO) request.getSession().getAttribute("user");
		logger.debug("세션정보>  " + thisSession.getUserId());
		
		reviewVO.setUserId(thisSession.getUserId());
		
		reviewVO = reviewService.createReview(reviewVO);
		
		logger.debug("moveAddReview 결과------------------------"  + reviewVO.toString());
		
		return new ModelAndView("redirect:/moveReviewPage.do");
	}
	
	@RequestMapping("/refReviewPage.do")
	@ResponseBody
	public Map<String, Object> refReviewPage(@Valid ReviewVO reviewVO, BindingResult result,
			RedirectAttributes redirect, HttpServletRequest request,
			HttpServletResponse response){
		
		Map<String, Object> rslt = new HashMap<String, Object>();
		
		logger.debug("refReviewPage.do 시작------------------------"  + reviewVO.toString());
		List<ReviewVO> reviewList =  reviewService.getReviewList(reviewVO);
		rslt.put("reviewList", reviewList);
		logger.debug("refReviewPage.do 결과------------------------"  + reviewList.toString());
		
		return rslt;
	}
	
	
	
	
	

}

