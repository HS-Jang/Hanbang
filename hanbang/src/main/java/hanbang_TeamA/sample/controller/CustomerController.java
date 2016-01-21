package hanbang_TeamA.sample.controller;

import hanbang_TeamA.sample.service.CustomerService;
import hanbang_TeamA.sample.vo.CustomerVO;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@RequestMapping("/customer.do")
	public ModelAndView list() {
		System.out.println("---------------------> customerList ");
		CustomerVO inVO = new CustomerVO();
		
		List<CustomerVO> customerVO = customerService.getCustomerList(inVO);
		System.out.println("---------------------> 결과 : " + customerVO.toString());
		
		return new ModelAndView("customer/customerList", "customer", customerVO);
	}
	
	@RequestMapping("/customerform.do")
	public ModelAndView createForm(@ModelAttribute CustomerVO customer) {
		CustomerVO customerVO = new CustomerVO();
		return new ModelAndView("customer/customerForm", "customer", customerVO);
	}
	
	@RequestMapping("/customerInsert.do")
	public ModelAndView create(@Valid CustomerVO customerVO, BindingResult result,
			RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return new ModelAndView("customer/customerForm", "formErrors", result.getAllErrors());
		}
		
		customerVO = customerService.insCustomer(customerVO);
		
		redirect.addFlashAttribute("globalMessage", "Successfully created a new customer");
		
		return new ModelAndView("redirect:/customer.do");
		//return new ModelAndView("redirect:/{customerVO.id}", "customerVO.id", customerVO.getId());
	}
	

	@RequestMapping("/mark.do")
	public ModelAndView test() {
		System.out.println("---------------------> customerList ");
		CustomerVO inVO = new CustomerVO();
		
		List<CustomerVO> customerVO = customerService.getCustomerList(inVO);
		System.out.println("---------------------> 결과 : " + customerVO.toString());
		
		return new ModelAndView("customer/mainForm", "customer", customerVO);
	}
	
//	@RequestMapping("{id}")
//	public ModelAndView view(@PathVariable("id") CustomerVO customerVO, RedirectAttributes redirect) {
//		System.out.println("--->여기까지");
//		return new ModelAndView("redirect:/customer.do", "customer", customerVO);
//	}


}
