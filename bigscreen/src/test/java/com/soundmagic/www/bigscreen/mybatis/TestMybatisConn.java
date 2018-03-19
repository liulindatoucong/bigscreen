package com.soundmagic.www.bigscreen.mybatis;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.soundmagic.www.bigscreen.mybatis.domain.UserTest;
import com.soundmagic.www.bigscreen.mybatis.mapper.UserMapperTest;

public class TestMybatisConn {
	
	@Test
	public void testMybatisHana() throws Exception
	{
		SqlSession ss = null;
		try
		{
			String resource = "mybatis/mybatis-configTest.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			ss = sqlSessionFactory.openSession();
			UserMapperTest um = ss.getMapper(UserMapperTest.class);
			UserTest us = um.findbyid("UserBO:1001,SITE_ADMIN");
			System.out.println(us.getSite());
			System.out.println(us.getCreatedDateTime());
		}
		catch(Exception e)
		{
			throw e;
		} 
		finally
		{
			if(ss!=null)
			{
				ss.close();
			}
		}
		
		
		
	}
}
