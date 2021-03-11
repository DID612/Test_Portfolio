package kr.green.testportfolio.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.apache.commons.io.FileUtils;

import kr.green.testportfolio.dao.BoardDao;
import kr.green.testportfolio.pagination.Criteria;
import kr.green.testportfolio.vo.BoardVo;

@Service
public class BoardServiceImp implements BoardService {

	private FileUtils fileUtils;
	
	@Autowired
	BoardDao boardDao;

	@Override
	public BoardVo getDetail(int bNum) {
		return boardDao.getDetail(bNum);
	}

	@Override
	public void updateDetail(BoardVo board) {
		boardDao.updateDetail(board);
		return;
	}

	@Override
	public void insertBoard(BoardVo board) {
		boardDao.insertBoard(board);
	}

	@Override
	public void deleteBoard(int bNum) {
		boardDao.deleteBoard(bNum);		
	}

	@Override
	public ArrayList<BoardVo> getBoard(Criteria cri) {
		return boardDao.getBoard(cri);
	}

	@Override
	public int getTotalCount(Criteria cri) {
		return boardDao.getTotalCount(cri);
	}

	@Override
	public void registerImg(BoardVo board, MultipartHttpServletRequest mpRequest) {
		boardDao.registerImg(board);
		
		List<Map<String,Object>> list = parseInsertFileInfo(board, mpRequest); 
		int size = list.size();
		for(int i=0; i<size; i++){ 
			boardDao.insertFile(list.get(i)); 
		}
	}
	
}
