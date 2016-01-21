package hanbang_TeamA.sample.service;

import hanbang_TeamA.sample.dao.CustomerDAO;
import hanbang_TeamA.sample.vo.CustomerVO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerDAO customerDAO;
	
	@Override
	public List<CustomerVO> getCustomerList(CustomerVO inVO) {
		System.out.println("-------------------------> getCustomerList Service Start");
		
		//BeanUtils.copyProperties(source, target);
		List<CustomerVO> rslt = customerDAO.findAll();

		return rslt;
	}

	@Override
	public CustomerVO insCustomer(CustomerVO customerVO) {
		System.out.println("-------------------------> insCustomer Service Start");
		
		customerVO = customerDAO.save(customerVO);
		
		System.out.println("id-------------------->" + customerVO.toString());
		return customerVO;
	}

}
