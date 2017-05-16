package com.roamstory.web;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class MySQLConnectionTest {

	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	
	private static final String URL = "jdbc:mysql://localhost:3306/roamstory_dev?useSSL=false&serverTimezone=Asia/Seoul";
	
	private static final String USER = "root";
	
	private static final String PW = "0330gogh";
	
	@Test
	public void connectionTest() throws Exception {
		
		Class.forName(DRIVER);
		
		try (Connection con = DriverManager.getConnection(URL, USER, PW)){
			
			System.out.println(con);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}

}
