package com.pjs.luck.user.vo;

public class UserVo {

	private int seq;
	private String ip;
	private String userName;
	private String birthDay;
	private String rgsTrnDt;
	private String chgTrnDt;
	private String rgsTrnTs;
	private String chgTrnTs;
	
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getRgsTrnDt() {
		return rgsTrnDt;
	}
	public void setRgsTrnDt(String rgsTrnDt) {
		this.rgsTrnDt = rgsTrnDt;
	}
	public String getChgTrnDt() {
		return chgTrnDt;
	}
	public void setChgTrnDt(String chgTrnDt) {
		this.chgTrnDt = chgTrnDt;
	}
	public String getRgsTrnTs() {
		return rgsTrnTs;
	}
	public void setRgsTrnTs(String rgsTrnTs) {
		this.rgsTrnTs = rgsTrnTs;
	}
	public String getChgTrnTs() {
		return chgTrnTs;
	}
	public void setChgTrnTs(String chgTrnTs) {
		this.chgTrnTs = chgTrnTs;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}
	
	
}
