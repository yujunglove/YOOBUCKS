package com.greedy.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {
	
	//정적인 메모리 영역 택해서 저장
	private static SqlSessionFactory sqlSessionFactory;
	public static SqlSession getSqlSession() {
		
		if(sqlSessionFactory == null) {
			String resource = "mybatis-config.xml";
			
			//문자열 전달하고 sql 섹션 팩토리 만들어주기
			try {
				InputStream inputStream = Resources.getResourceAsStream(resource);
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sqlSessionFactory.openSession(false);
	}
}
