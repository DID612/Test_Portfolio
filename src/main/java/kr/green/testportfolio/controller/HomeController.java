package kr.green.testportfolio.controller;

import java.lang.ProcessBuilder.Redirect;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public String home(Model model, Locale locale, HttpServletRequest req) {
		HttpSession session = req.getSession();
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate);
		UserVo user = (UserVo)session.getAttribute("login");
//		UserVo user = (UserVo)req.getAttribute("login");
		model.addAttribute("user", user);
		return "/main/home";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signUp(Model model) {
		System.out.println(userservice.getUser("aaa111"));
		return "/signup/signUp";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signUp(Model model, UserVo user) {
//		System.out.println(user);
		userservice.insertUser(user);
		
		return "/signup/signUp";
	}
	
	@RequestMapping(value = "/iCheck", method = RequestMethod.POST)
	@ResponseBody
	public String iCheckPost(String id) {
		UserVo user = userservice.getUser(id);
		if(user == null)
			return "not user"; 
		return "user";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLogin(Model model) {
		
		return "/login/Login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String postLogin(Model model, HttpServletRequest req, @RequestParam("id")String id, @RequestParam("pw")String pw) {
		logger.info("post login");
		HttpSession session = req.getSession();
		UserVo login = userservice.getUserPw(id, pw);

		if(login == null) {
			session.setAttribute("login", null);
//			model.addAttribute("login", null);
			return "redirect:/login";
		}else {
			session.setAttribute("login", login);
			return "redirect:/";
		}
	}
}
