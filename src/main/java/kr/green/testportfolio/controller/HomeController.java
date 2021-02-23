package kr.green.testportfolio.controller;

import java.lang.ProcessBuilder.Redirect;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
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
		UserVo login = userservice.getUserPw(id, pw);
		model.addAttribute("user", login);
		if(login == null) {
			return "redirect:/login";
		}else {
			return "redirect:/";
		}
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutGet(Model model, HttpServletRequest req) {
		
		req.getSession().removeAttribute("user");
		//getHeader에 header가 뭘까? <= 전 경로가 null 이니 주소값이 null 된것
		String referer = req.getHeader("Referer");
		System.out.println(referer);
		return "redirect:"+referer;
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modifyUserGet(Model model, HttpServletRequest req) {
//		UserVo user = (UserVo)req.getAttribute("user");
//		model.addAttribute("user", user);
		ArrayList<UserVo> modifyUser = userservice.getAllUser();
		model.addAttribute("list", modifyUser);
		return "/main/modifyUser";
	}
	
	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public String myPageGet(Model model, HttpServletRequest req) {
		HttpSession session = req.getSession();
		UserVo user = (UserVo)session.getAttribute("user");

		if(user == null) {
			return "/main/home";
		}else {
			System.out.println("작동");
			model.addAttribute("user", user);	
			return "/main/myPage";
		}
	}
	
	@RequestMapping(value = "/mypage", method = RequestMethod.POST)
	public String myPagePost(Model model, HttpServletRequest req, String pw) {
		//session에 대해 고민해보자. 이 경우 session getAttribute를 써야 정상 작동할까? 
		//아니면 단순히 유저서비스를 불러오는 것만으로 세션에 등록이 될까
//		HttpSession session = req.getSession();
//		UserVo user = (UserVo)session.getAttribute("login");
//		model.addAttribute("user", user);
		//
		HttpSession session = req.getSession();
		UserVo mypage = userservice.updateUser(pw);
		return "/main/home";
	}
	
	@RequestMapping(value = "/ajaxModify", method = RequestMethod.GET)
	public String ajaxModifyGet(Model model, HttpServletRequest req) {
		ArrayList<UserVo> modifyUser = userservice.getAllUser();
		model.addAttribute("list", modifyUser);
		return "/main/modifyUser";
	}
}
