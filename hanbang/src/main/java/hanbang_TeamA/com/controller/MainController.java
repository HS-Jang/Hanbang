package hanbang_TeamA.com.controller;

import hanbang_TeamA.com.service.HanbangServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MainController {
	
	@Autowired
	HanbangServiceImpl hs;

    @RequestMapping("/")
    private ModelAndView home() {
        return new ModelAndView("index");
    }

}
