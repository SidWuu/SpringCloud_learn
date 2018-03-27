package com.springcloud.eureka.util;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionUtil {
	private static SqlSessionFactory sqlSessionFactory;

	public static SqlSessionFactory getFactory(String ds) {
		try {
			if (null == sqlSessionFactory) {
				InputStream is = Resources.getResourceAsStream(ds);
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sqlSessionFactory;
	}
	public static SqlSession getSession(String ds){
		return getFactory(ds).openSession();
	}
}
