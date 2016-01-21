package hanbang_TeamA.com.dao;

import hanbang_TeamA.com.vo.UserVO;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserDAO extends MongoRepository<UserVO, String> {
	public UserVO findByUserId(String userId);

}
