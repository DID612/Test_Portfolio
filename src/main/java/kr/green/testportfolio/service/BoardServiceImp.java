package kr.green.testportfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.testportfolio.dao.BoardDao;

@Service
public class BoardServiceImp implements BoardService {

	@Autowired
	BoardDao boardDao;
}
