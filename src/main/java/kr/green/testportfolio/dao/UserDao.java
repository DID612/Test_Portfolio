package kr.green.testportfolio.dao;

import org.apache.ibatis.annotations.Param;

import kr.green.testportfolio.vo.UserVo;

public interface UserDao {
	
	public String getEmail(@Param("id")String id);

	public UserVo insertUser(@Param("user")UserVo user);

	public UserVo getUser(String id);
}
