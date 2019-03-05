package com.pjs.luck.user.dao;

import com.pjs.luck.user.vo.UserVo;

public interface IUserDao {

	public abstract UserVo selectUser(int seq);
	public abstract int updateUser(UserVo user);
	public abstract int insertUser(UserVo user);
	public abstract int deleteUser(UserVo user);
}
