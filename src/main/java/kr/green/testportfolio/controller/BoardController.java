package kr.green.testportfolio.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.green.testportfolio.service.BoardService;
import kr.green.testportfolio.vo.BoardVo;

@Controller
public class BoardController {

	@Autowired
	BoardService boardservice;
	
	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public String getBoard(Model model) {
//		BoardVo board = boardservice.getBoard();
		ArrayList<BoardVo> board = boardservice.getBoard();
		
		model.addAttribute("board", board);
		return "/board/Board";
	}
	
}
