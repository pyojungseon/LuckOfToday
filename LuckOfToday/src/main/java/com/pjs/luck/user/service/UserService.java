package com.pjs.luck.user.service;

import java.time.LocalTime;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjs.luck.user.dao.UserDao;
import com.pjs.luck.user.vo.UserVo;

@Service
public class UserService implements IUserService {

	@Autowired
	UserDao userDao;
	
	@Override
	public int updateUser(UserVo user) {
		// TODO Auto-generated method stub
		user.setChgTrnDt(getNowDate());
		user.setChgTrnTs(getNowTime());
		return userDao.updateUser(user);
	}

	@Override
	public UserVo selectUser(int seq) {
		// TODO Auto-generated method stub
		return userDao.selectUser(seq);
	}

	@Override
	public boolean insertUser(UserVo user) {
		// TODO Auto-generated method stub
		
		user.setRgsTrnDt(getNowDate());
		user.setRgsTrnTs(getNowTime());
		user.setChgTrnDt(getNowDate());
		user.setChgTrnTs(getNowTime());
		
		return userDao.insertUser(user)==1 ? true : false;
	}

	@Override
	public boolean deleteUser(UserVo user) {
		// TODO Auto-generated method stub
		return userDao.deleteUser(user)==1 ? true : false;
	}

	public String getNowDate() {
		
		Calendar now = Calendar.getInstance();
		int yy = now.get(Calendar.YEAR);
		int mm = now.get(Calendar.MONTH);
		int dd = now.get(Calendar.DAY_OF_MONTH);
		StringBuilder sb = new StringBuilder();
		sb.append(yy);
		sb.append(mm);
		sb.append(dd);
		return sb.toString();
	}
	
	public String getNowTime() {
		LocalTime now = LocalTime.now();
		return now.toString();	
	}

}
