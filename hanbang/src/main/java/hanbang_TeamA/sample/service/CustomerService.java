package hanbang_TeamA.sample.service;

import hanbang_TeamA.sample.vo.CustomerVO;

import java.util.List;


public interface CustomerService {
	
	public List<CustomerVO> getCustomerList(CustomerVO inVO);

	public CustomerVO insCustomer(CustomerVO customerVO);

}
