package kr.green.testportfolio.controller;

import java.lang.ProcessBuilder.Redirect;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.green.testportfolio.service.UserService;
import kr.green.testportfolio.vo.UserVo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
		UserService userservice;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		return "/main/home";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signUp(Model model) {
		System.out.println(userservice.getUser("aaa111"));
		return "/signup/signUp";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signUp(Model model, UserVo user) {
		System.out.println(user);
		//userservice.insertUser(user);
		
		return "/signup/signUp";
	}
}
