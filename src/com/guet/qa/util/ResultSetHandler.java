/**
 * 
 */
package com.guet.qa.util;

import java.sql.ResultSet;

/**
 * @author sean
 * @version 2018-04-04 10:06:26
 */
public interface ResultSetHandler {
	//专门处理结果集的方法
	public Object handle(ResultSet rs) throws Exception;
}
