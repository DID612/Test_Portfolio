package kr.green.testportfolio.dao;

import org.apache.ibatis.annotations.Param;

public interface UserDao {
	
	public String getEmail(@Param("id")String id);
}
