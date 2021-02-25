package kr.green.testportfolio.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import kr.green.testportfolio.vo.BoardVo;

public interface BoardDao {

	ArrayList<BoardVo> getBoard();

	BoardVo getDetail(@Param("bNum")int bNum);

	void updateDetail(@Param("board")BoardVo board);

	void insertBoard(@Param("board")BoardVo board);

}
		