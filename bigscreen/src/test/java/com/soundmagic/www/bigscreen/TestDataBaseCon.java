package com.soundmagic.www.bigscreen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import org.junit.Test;

public class TestDataBaseCon {

	private String url;
	
	private String name;
	
	private String password;
	
	private String className;
	
	
	@Test
	public void testHana() throws Exception
	{
		readProperties("HANA");
		Class.forName(className);
		Connection conn = DriverManager.getConnection(url, name, password);
		PreparedStatement ps = conn.prepareStatement("SELECT TOP 1 * FROM Z_EXT_CODE");
		ResultSet rs = ps.executeQuery();
		System.out.println(rs.toString());
	}
	
	/**
	 * 测试nc，oracle是否跑通
	 * @throws Exception
	 */
	@Test
	public void testOracle() throws Exception
	{
		readProperties("NC");
		Class.forName(className);
		Connection conn = DriverManager.getConnection(url, name, password);
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM YY_LOGGER WHERE ROWNUM = 1");
		ResultSet rs = ps.executeQuery();
		System.out.println(rs.toString());	
	}
	
	/**
	 * 读取文件配置
	 */
	private void readProperties(String pre)
	{
		ResourceBundle resource = ResourceBundle.getBundle("developdatabase");
		url = resource.getString(pre+"_URL");
		name = resource.getString(pre+"_NAME");
		password = resource.getString(pre+"_PASSWORD");
		className = resource.getString(pre+"_CLASSNAME");
	}
	
}
