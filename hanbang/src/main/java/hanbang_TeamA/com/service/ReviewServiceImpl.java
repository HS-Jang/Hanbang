package hanbang_TeamA.com.service;

import hanbang_TeamA.com.dao.ReviewDAO;
import hanbang_TeamA.com.vo.ReviewVO;
import hanbang_TeamA.common.util.HanbangUtil;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService{
	
	@Autowired
	ReviewDAO reviewDAO;

	@Override
	public ReviewVO createReview(ReviewVO reviewVO) {
		reviewVO.setInsertTime(HanbangUtil.getDateTime());
		
		reviewVO = reviewDAO.insert(reviewVO);
		
		return reviewVO;
	}

	@Override
	public ReviewVO updateReview(ReviewVO reviewVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteReview(ReviewVO reviewVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ReviewVO> getReviewList(ReviewVO reviewVO) {
		
		return reviewDAO.findBySubAddr(reviewVO.getSubAddr());
	}

	@Override
	public List<ReviewVO> getAllReviewList() {
		
		return reviewDAO.findAll();
	}
	


}
