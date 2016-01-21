package hanbang_TeamA.com.service;

import hanbang_TeamA.com.vo.ReviewVO;

import java.util.List;

public interface ReviewService {

	public ReviewVO createReview(ReviewVO reviewVO);

	public ReviewVO updateReview(ReviewVO reviewVO);

	public void deleteReview(ReviewVO reviewVO);
	
	public List<ReviewVO> getReviewList(ReviewVO reviewVO);
	
	public List<ReviewVO> getAllReviewList();
	
}
