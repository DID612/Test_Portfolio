package kr.green.testportfolio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.testportfolio.dao.UserDao;
import kr.green.testportfolio.vo.UserVo;
@Service
public class UserServiceImp implements UserService{
	
	@Autowired
	UserDao userDao;
	
	@Override
	public String getEmail(String id) {
		return userDao.getEmail(id);
	}

	@Override
	public void insertUser(UserVo user) {
		userDao.insertUser(user);
	}

	@Override
	public UserVo getUser(String id) {	
		return userDao.getUser(id);
	}
}
