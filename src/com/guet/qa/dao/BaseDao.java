/**
 * 
 */
package com.guet.qa.dao;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.guet.qa.beans.User;
import com.guet.qa.util.BeanListHandler;
import com.guet.qa.util.DbUtil;
import com.guet.qa.util.ResultSetHandler;


/**
 * @author sean
 * @version 2018-04-04 09:49:16
 *
 */
public class BaseDao {

	/**
	 * 该类专门提供了一些基本数据库的操作。
	 *
	 */
	//增删改操作
		public void update(String sql, Object[] params) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				//数据库连接
				conn = DbUtil.getConnection();
				//创建PrepardStatement对象
				pstmt = conn.prepareStatement(sql);
				//问题：如果用户传参数的个数与实际需要传入参数的个数不一致，咋办？
				ParameterMetaData metadata = pstmt.getParameterMetaData();
				//获取参数的个数
				int count = metadata.getParameterCount(); 
				if (params != null) {
					if (count != params.length) {
						throw new RuntimeException("参数个数不正确！");
					}
					//设置参数
					for (int i = 1; i <= params.length; i++) {
						pstmt.setObject(i, params[i-1]);
					}
				}
				//执行更新操作
				pstmt.executeUpdate();
			} catch (Exception e) {
				throw new RuntimeException(e);
			} finally {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
		//单一查询
		public Object find(String sql, Object[] params, ResultSetHandler handler) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				//数据库连接
				conn = DbUtil.getConnection();
				//创建PrepardStatement对象
				pstmt = conn.prepareStatement(sql);
				//设置参数
				if (params != null) {
					ParameterMetaData metadata = pstmt.getParameterMetaData();
					//获取参数的个数
					int count = metadata.getParameterCount(); 
					if (count != params.length) {
						throw new RuntimeException("参数个数不正确！");
					}
					//设置参数
					for (int i = 1; i <= params.length; i++) {
						pstmt.setObject(i, params[i-1]);
					}
				}
				//执行查询
				rs = pstmt.executeQuery();
				//问题：怎么处理结果集？结果集有可能只返回一条数据，也有可能返回多行数据。
				return handler.handle(rs);
			} catch (Exception e) {
				throw new RuntimeException(e);
			} finally {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
		//全部查询
		public List<User> findAllUser(String sql,BeanListHandler handler) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				//数据库连接
				conn = DbUtil.getConnection();
				//创建PrepardStatement对象
				pstmt = conn.prepareStatement(sql);
				//执行查询
				rs = pstmt.executeQuery();
				//问题：怎么处理结果集？结果集有可能只返回一条数据，也有可能返回多行数据。
				return handler.handle(rs);
			} catch (Exception e) {
				throw new RuntimeException(e);
			} finally {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if (pstmt != null) {
					try {
						pstmt.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if (conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
		
}
