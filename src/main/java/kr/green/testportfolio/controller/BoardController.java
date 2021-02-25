package kr.green.testportfolio.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.green.testportfolio.service.BoardService;
import kr.green.testportfolio.vo.BoardVo;
import kr.green.testportfolio.vo.UserVo;

@Controller
public class BoardController {

	@Autowired
	BoardService boardservice;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getBoard(Model model) {
		ArrayList<BoardVo> list = boardservice.getBoard();
		model.addAttribute("list", list);
		return "/board/list";
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String getDetail(Model model,int bNum) {
		BoardVo board = boardservice.getDetail(bNum);
		model.addAttribute("board", board);
		return "/board/detail";
	}
	
	@RequestMapping(value = "/updateDetail", method = RequestMethod.GET)
	public String getUpdateDetail(Model model, int bNum) {
		BoardVo board = boardservice.getDetail(bNum);
		model.addAttribute("board", board);
		return "/board/updateDetail";
	}
	
	@RequestMapping(value = "/updateDetail", method = RequestMethod.POST)
	public String postUpdateDetail(Model model, BoardVo board) {
		boardservice.updateDetail(board);
		return "redirect:/list";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String getRegisterBoard(Model model, HttpServletRequest req) {
		HttpSession session = req.getSession();
		UserVo user = (UserVo)session.getAttribute("user");
		
//		UserVo user = (UserVo)req.getAttribute("user");
		
		System.out.println(user + "암");
		model.addAttribute("user", user);
		return "/board/register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String postRegisterBoard(Model model, BoardVo board) {
		boardservice.insertBoard(board);
		return "redirect:/list";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String postDelete(Model model, HttpServletRequest req, int bNum) {
		boardservice.deleteBoard(bNum);
		return "board/list";
	}
}
