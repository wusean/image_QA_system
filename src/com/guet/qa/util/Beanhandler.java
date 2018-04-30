/**
 * 
 */
package com.guet.qa.util;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import com.guet.qa.util.ResultSetHandler;

/**
 * @author sean
 * @version 2018-04-04 10:47:16
 * 结果集处理类（专门处理单行的结果）
        规则：数据库表的列名必须要与Bean对象的属性名要一致。
 */
public class Beanhandler implements ResultSetHandler{
     
	private Class clazz;
	
	public Beanhandler(Class clazz) {
		this.clazz = clazz;
	}
	
	//对结果集进行处理，处理完成后返回一个Bean对象
	public Object handle(ResultSet rs) {
		Object o = null;
		try {
			//先移动指针
			if (rs.next()) {
				//通过class类创建对象
				o = clazz.newInstance();
				//获取结果集的元数据对象
				ResultSetMetaData metadata = rs.getMetaData();
				//获取列的数量
				int count = metadata.getColumnCount();
				//获取所有列的数据
				for (int i = 1; i <= count; i++) {
					//获取了每一列的数据，把每一列数据设置class对象中？
					//获取列名
					String fieldName = metadata.getColumnLabel(i);
					//使用反射设置对象的属性
					Field field = clazz.getDeclaredField(fieldName);
					//暴力反射
					field.setAccessible(true);
					//设置对象的属性值
					field.set(o, rs.getObject(i));
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return o;
	}
	
	
}
