package com.aowin.util;

import java.io.Reader;
import java.nio.charset.Charset;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DbUtil {
	
	private static SqlSessionFactory factory;
	/**
	 * 静态代码块创建SqlSessionFactory对象
	 */
	static{
		try {
			Resources.setCharset(Charset.forName("UTF-8"));
			Reader reader = Resources.getResourceAsReader("mybatis.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 打开 一个SqlSession
	 * @return
	 */
	public static SqlSession openSession(){
		return factory.openSession();
	}
	/**
	 * 关闭一个会话
	 * @param sqlSession
	 */
	public static void close(SqlSession sqlSession){
		if(sqlSession != null){
			sqlSession.close();
		}
	}
	
	public static void main(String[] args) {
		
	}

}
