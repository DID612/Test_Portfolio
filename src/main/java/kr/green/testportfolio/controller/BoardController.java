package kr.green.testportfolio.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import kr.green.spring.utils.UploadFileUtils;
import kr.green.testportfolio.pagination.Criteria;
import kr.green.testportfolio.pagination.PageMaker;
import kr.green.testportfolio.service.BoardService;
import kr.green.testportfolio.vo.BoardVo;
import kr.green.testportfolio.vo.UserVo;

@Controller
public class BoardController {
	private String uploadPath="D:\\kmy\\upfile";
	
	@Autowired
	BoardService boardservice;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getBoard(Model model, Criteria cri) {
		ArrayList<BoardVo> list = boardservice.getBoard(cri);
		int totalCount = boardservice.getTotalCount(cri);
		PageMaker pm = new PageMaker(totalCount, 2, cri);
		model.addAttribute("pm", pm);
		model.addAttribute("list", list);
		return "/board/list";
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String getDetail(Model model,int bNum, Criteria cri) {
		BoardVo board = boardservice.getDetail(bNum);
		model.addAttribute("board", board);
		model.addAttribute("cri", cri);
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
	public String postRegisterBoard(Model model, BoardVo board, MultipartFile[] fileList) throws Exception {
		if(fileList != null) {
			for(MultipartFile file : fileList) {
				if(file != null &&file.getOriginalFilename().length() != 0) {
					String fileName = kr.green.testportfolio.utils.UploadFileUtils.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
					boardservice.insertGoods(board.getbNum(),file.getOriginalFilename(),fileName);
				}
			}
		}
		
		boardservice.insertBoard(board);
		
		return "redirect:/list";
	}
	
	@RequestMapping(value = "/register/img", method = RequestMethod.POST)
	public String postRegisterBoardImg(Model model, BoardVo board, MultipartFile file) throws Exception {
		uploadFile(file.getOriginalFilename(),file.getBytes());
		boardservice.insertBoard(board);
		return "redirect:/list";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String postDelete(Model model, HttpServletRequest req, int bNum) {
		boardservice.deleteBoard(bNum);
//		return "board/list";
		return "redirect:/list";
	}
	
	/* 서버에 저장 */
	private String uploadFile(String name, byte[] data)
		throws Exception{
	    /* 고유한 파일명을 위해 UUID를 이용 */
		UUID uid = UUID.randomUUID();
		String savaName = uid.toString() + "_" + name;
		File target = new File(uploadPath, savaName);
		FileCopyUtils.copy(data, target);
		return savaName;
	}
	
}
