package com.pjs.luck.user.service;

import com.pjs.luck.user.vo.UserVo;

public interface IUserService {

	public int updateUser(UserVo user);
	public UserVo selectUser(int seq);
	public boolean insertUser(UserVo user);
	public boolean deleteUser(UserVo user);
	
}
