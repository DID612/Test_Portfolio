package kr.green.testportfolio.service;

import java.util.ArrayList;

import kr.green.testportfolio.vo.BoardVo;

public interface BoardService {
	
	ArrayList<BoardVo> getBoard();

	BoardVo getDetail(int bNum);

	void updateDetail(BoardVo board);

	void insertBoard(BoardVo board);
	
}
