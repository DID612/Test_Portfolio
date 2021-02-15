package kr.green.testportfolio.service;

import org.springframework.beans.factory.annotation.Autowired;

import kr.green.testportfolio.dao.UserDao;

public class UserServiceImp implements UserService{
	
	@Autowired
	UserDao userDao;
	
	@Override
	public String getEmail(String id) {
		return userDao.getEmail(id);
	}
}
