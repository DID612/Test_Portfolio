package kr.green.testportfolio.controller;

import javax.activation.CommandMap;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import kr.green.testportfolio.util.FileUtils;

import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class UploadController {
//    private final static Logger log = Logger.getGlobal();
    
	private static final Logger log = LoggerFactory.getLogger(UploadController.class);

	
    @RequestMapping("/board/boardInsert")
    public String boardInsert(Model model,CommandMap commandMap, MultipartFile[] file) throws Exception {
        //boardService.insertBoard(commandMap);
        for(int i=0; i<file.length; i++) {
            log.debug("================== file start ==================");
            log.debug("파일 이름: "+file[i].getName());
            log.debug("파일 실제 이름: "+file[i].getOriginalFilename());
            log.debug("파일 크기: "+file[i].getSize());
            log.debug("content type: "+file[i].getContentType());
            log.debug("================== file   END ==================");
        }
        return "redirect:/list";
    }
	
}
