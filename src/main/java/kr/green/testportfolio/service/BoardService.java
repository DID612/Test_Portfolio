package kr.green.testportfolio.service;

import java.util.ArrayList;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.green.testportfolio.pagination.Criteria;
import kr.green.testportfolio.vo.BoardVo;

public interface BoardService {
	
	BoardVo getDetail(int bNum);

	void updateDetail(BoardVo board);

	void insertBoard(BoardVo board);

	void deleteBoard(int bNum);

	ArrayList<BoardVo> getBoard(Criteria cri);

	int getTotalCount(Criteria cri);

	void registerImg(BoardVo board, MultipartHttpServletRequest mpRequest);
	
}
