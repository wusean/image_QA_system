/**
 * 
 */
package com.guet.qa.util;

import java.sql.Connection;
import java.sql.SQLException;
import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 数据库工具类
 * 
 * @author sean
 * @version 1.0 2018-04-02 09:11:35
 */
/**
 * @author lenovo
 *
 */
public class DbUtil {

	/**
	 * 数据库连接池对象
	 */
	private static ComboPooledDataSource ds = null;

	static {
		// 初始化数据库连接池
		try {
			// 创建数据库连接池
			ds = new ComboPooledDataSource();
			// 设置JDBC的Driver类
			ds.setDriverClass("com.mysql.jdbc.Driver");
			// 设置JDBC的URL
			ds.setJdbcUrl("jdbc:mysql://localhost:3306/imageqasystem");
			// 设置数据库的登录用户名
			ds.setUser("root");
			// 设置数据库的登录用户密码
			ds.setPassword("lijiahui");
			// 设置连接池的最大连接数
			ds.setMaxPoolSize(100);
			// 设置连接池的最小连接数
			ds.setMinPoolSize(10);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 数据库连接
	 * @return connection
	 * @exception SQLException
	 */
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}

}
