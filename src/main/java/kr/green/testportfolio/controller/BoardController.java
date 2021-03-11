package kr.green.testportfolio.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.System.Logger;
import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.google.gson.JsonObject;

import kr.green.testportfolio.pagination.Criteria;
import kr.green.testportfolio.pagination.PageMaker;
import kr.green.testportfolio.service.BoardService;
import kr.green.testportfolio.vo.BoardVo;
import kr.green.testportfolio.vo.UserVo;

@Controller
public class BoardController {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(BoardController.class);
		
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
	
	@RequestMapping(value = "/register/img", method = RequestMethod.POST)
	public String postRegisterBoard(Model model, BoardVo board, MultipartHttpServletRequest mpRequest) {
		logger.info("write");
		boardservice.registerImg(board, mpRequest);
		boardservice.insertBoard(board);
		return "redirect:/list";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String postDelete(Model model, HttpServletRequest req, int bNum) {
		boardservice.deleteBoard(bNum);
//		return "board/list";
		return "redirect:/list";
	}
	@RequestMapping(value = "/uploadSummernoteImageFile", method = RequestMethod.POST)
	@ResponseBody
	public String profileUpload(Model model, MultipartFile multipartfile, HttpServletRequest request, HttpServletResponse response) throws Exception {		
		System.out.println("아예??");
		JsonObject jsonObject = new JsonObject();
		
        /*
		 * String fileRoot = "C:\\summernote_image\\"; // 외부경로로 저장을 희망할때.
		 */
		
		// 내부경로로 저장
		String contextRoot = new HttpServletRequestWrapper(request).getRealPath("/");
		String fileRoot = contextRoot+"resources/fileupload/";
		
		String originalFileName = multipartfile.getOriginalFilename();	//오리지날 파일명
		String extension = originalFileName.substring(originalFileName.lastIndexOf("."));	//파일 확장자
		String savedFileName = UUID.randomUUID() + extension;	//저장될 파일 명
		System.out.println(savedFileName);
		
		File targetFile = new File(fileRoot + savedFileName);	
		try {
			InputStream fileStream = multipartfile.getInputStream();
			FileUtils.copyInputStreamToFile(fileStream, targetFile);	//파일 저장
			jsonObject.addProperty("url", "/summernote/resources/fileupload/"+savedFileName); // contextroot + resources + 저장할 내부 폴더명
			System.out.println(jsonObject);
			jsonObject.addProperty("responseCode", "success");
				
		} catch (IOException e) {
			FileUtils.deleteQuietly(targetFile);	//저장된 파일 삭제
			jsonObject.addProperty("responseCode", "error");
			e.printStackTrace();
		}
		String a = jsonObject.toString();
		return a;
	}
}
