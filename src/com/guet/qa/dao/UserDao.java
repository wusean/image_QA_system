/**
 * 
 */
package com.guet.qa.dao;

import java.util.ArrayList;
import java.util.List;

import com.guet.qa.beans.User;
import com.guet.qa.util.BeanListHandler;
import com.guet.qa.util.Beanhandler;

/**
 * @author sean
 *@version 2018-04-04 10:32:47
 */
public class UserDao extends BaseDao{
	
	/**
	 * 用户登录的servlet
	 * @param userName
	 * @param userPass
	 * @return
	 */
	
	//private String username; //用户名 
	//private String password; //用户密码 
	public boolean validateUser(String userName, String userPass) {
		String sql = "select * from user_info_table where username=? and password=?";
		Object o = find(sql, new Object[]{userName,userPass}, new Beanhandler(User.class));
		return o != null;
	}
	
	public boolean validateUserName(String userName) {
		String sql = "select * from user_info_table where username=?";
		Object o = find(sql, new Object[]{userName}, new Beanhandler(User.class));
		return o != null;
	} 

	public boolean validateAdminUser(String name, String password) {
		String sql = "select * from user_info_table where username=? and password=?";
		Object o = find(sql, new Object[]{name,password}, new Beanhandler(User.class));
		return o != null;
	}
	
	public void addUser(String username,String password){
		String sql = "insert into user_info_table (username,password)"+
				" values (?,?)";
		update(sql, new Object[]{username,password});
	}
	
	public List<User> queryAllUsers(){
		List<User> users=new ArrayList<User>();
		String sql = "select * from user_info_table";
		List<User> userList = findAllUser(sql,new BeanListHandler(User.class));
        for(User u:userList){
            String name=u.getUsername();
            String pswd=u.getPassword();
            User user=new User();
            user.setUsername(name);
            user.setPassword(pswd);
            users.add(user);
        }
		return users;
	}

    public void delUser(String username){
    	String sql = "delete from user_info_table where username=?";
    	update(sql,new Object[]{username});
    }
	
}
