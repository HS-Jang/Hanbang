package hanbang_TeamA.sample.dao;

import hanbang_TeamA.sample.vo.CustomerVO;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerDAO extends MongoRepository<CustomerVO, String> {

	public CustomerVO findByFirstName(String firstName);

	public List<CustomerVO> findByLastName(String lastName);

}
