package kr.green.testportfolio.service;

import kr.green.testportfolio.vo.UserVo;

public interface UserService {
	String getEmail(String id);

	void insertUser(UserVo user);

	UserVo getUser(String string);
}
