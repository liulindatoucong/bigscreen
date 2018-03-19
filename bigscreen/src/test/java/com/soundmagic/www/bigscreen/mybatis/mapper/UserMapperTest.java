package com.soundmagic.www.bigscreen.mybatis.mapper;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.soundmagic.www.bigscreen.mybatis.domain.UserTest;

public interface UserMapperTest {
	public UserTest findbyid(String handle);
	
	@Results(id = "userResultJava",
			value = {
					@Result(property = "handle", column = "handle", id = true),
					@Result(property = "site", column = "site"),
					@Result(property = "userId", column = "user_id"),
					@Result(property = "createdDateTime", column = "created_date_time")
			})
	@Select("select HANDLE, SITE, USER_ID, created_date_time from USR where user_id = #{userid}")
	public UserTest findUserByName(String userId);
}
