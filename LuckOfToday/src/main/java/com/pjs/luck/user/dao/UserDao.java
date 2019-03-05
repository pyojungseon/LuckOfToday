package com.pjs.luck.user.dao;

import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.pjs.luck.user.vo.UserVo;

@Repository
public class UserDao implements IUserDao {

//	private String driver = "oracle.jdbc.driver.OracleDriver";
//	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
//	private String userid = "actmx";
//	private String userpw = "1234";
	
	private String dev_port="3306";
	private String real_port="3307";
	private String driver = "org.mariadb.jdbc.Driver";
	private String url = "jdbc:mariadb://172.30.1.9:3307/springdb";
	private String dev_url = "jdbc:mariadb://localhost:3306/springdb"; 
	private String userid = "springdb";
	private String userpw = "wndtjs@911";
	
	
	private ComboPooledDataSource dataSource;
	
	private JdbcTemplate template;
	
	public UserDao() {
		
		dataSource = new ComboPooledDataSource();
		try {
			dataSource.setDriverClass(driver);
			dataSource.setJdbcUrl(url);
			dataSource.setUser(userid);
			dataSource.setPassword(userpw);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		
		template = new JdbcTemplate();
		template.setDataSource(dataSource);
	}
	
	@Override
	public UserVo selectUser(int seq) {
		// TODO Auto-generated method stub
		String sql = "select * from usertable where seq=?";
		
		List<UserVo> res = template.query(sql, new RowMapper<UserVo>() {

			@Override
			public UserVo mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				UserVo user = new UserVo();
				user.setUserName(rs.getString("userName"));
				user.setBirthDay(rs.getString("birthDay"));
				user.setRgsTrnDt(rs.getString("rgsTrnDt"));
				user.setRgsTrnTs(rs.getString("rgsTrnTs"));
				user.setChgTrnDt(rs.getString("chgTrnDt"));
				user.setChgTrnTs(rs.getString("chgTrnTs"));
				return user;
			}
		}, seq);
		
		if(res.isEmpty()) 
			return null;
		
		return res.get(0);
	}

	@Override
	public int updateUser(UserVo user) {
		// TODO Auto-generated method stub
		int result=0;
		String sql="UPDATE usertable SET ip=?, username=?, birthday=?, rgstrndt=?, rgstrnts=?, chgtrndt=?, chgtrnts=? where seq=?";
		result = template.update(sql, 
				user.getIp(),
				user.getUserName(),
				user.getBirthDay(),
				user.getRgsTrnDt(),
				user.getRgsTrnTs(),
				user.getChgTrnDt(),
				user.getChgTrnTs(),
				user.getSeq()
				);
		
		return result;
	}
	
	@Override
	public int insertUser(UserVo user) {
		int result = 0;
		
		String sql = "INSERT INTO usertable (seq.nextval, ip, userName, birthDay, rgsTrnDt, rgsTrnTs, chgTrnDt, chgTrnTs)"
				+ " values (?,?,?,?,?,?,?)";
		
		result = template.update(sql, 
				user.getIp(),
				user.getUserName(),
				user.getBirthDay(),
				user.getRgsTrnDt(),
				user.getRgsTrnTs(),
				user.getChgTrnDt(),
				user.getChgTrnTs()
				);
		
		return result;
	}

	@Override
	public int deleteUser(UserVo user) {
		// TODO Auto-generated method stub
		int result = 0;
		String sql ="delete usertable where seq=?";
		
		result=template.update(sql, user.getSeq());
		
		return result;
	}

}
