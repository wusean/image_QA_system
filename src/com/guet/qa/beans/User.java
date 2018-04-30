package com.guet.qa.beans;

/**
 * @author sean
 * @version 2018-04-04 09:39:34
 */
public class User {

	/**
	 * 用户实体类
	 */
	private String username; //用户名 或者邮箱
	private String password; //用户密码 
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
