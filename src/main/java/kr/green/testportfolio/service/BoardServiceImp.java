package kr.green.testportfolio.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.testportfolio.dao.BoardDao;
import kr.green.testportfolio.vo.BoardVo;

@Service
public class BoardServiceImp implements BoardService {

	@Autowired
	BoardDao boardDao;

	@Override
	public ArrayList<BoardVo> getBoard() {
		return boardDao.getBoard();
	}
}
