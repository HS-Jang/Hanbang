package hanbang_TeamA.com.dao;



import hanbang_TeamA.com.vo.ReviewVO;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReviewDAO extends MongoRepository<ReviewVO, String> {

	public ReviewVO findById(String id);
	
	public List<ReviewVO> findByUserId(String userId);
	
	public List<ReviewVO> findByTitle(String title);
	
	public List<ReviewVO> findByContents(String contents);
	
	public List<ReviewVO> findBySubAddr(String subAddr);
	
}
