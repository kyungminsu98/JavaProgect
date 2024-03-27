package com.yedam.java.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {
	//Oracle(DB) 연결정보
	String jdbcDriver = "oracle.jdbc.driver.OracleDriver";
	String oracleUrl  = "jdbc:oracle:thin:@localhost:1521:xe";
	String connectedId = "hr";
	String connectedPwd = "hr";
	
	protected Connection conn = null;
	protected PreparedStatement pstmt = null;
	protected Statement stmt = null;
	protected ResultSet rs = null;
	
	protected Connection connect() {
		try {
		// 1. JDBC Driver 로딩하기
		Class.forName(jdbcDriver);
		// 2. DB 서버 접속하기
		conn = DriverManager.getConnection(oracleUrl, connectedId, connectedPwd);
		}catch(ClassNotFoundException e) {
			System.out.println("JDBC Driver Loading Fail");
		}catch(SQLException e) {
			System.out.println("DB Connect Fail");
			System.out.println(e.getMessage());
		}
		return conn;
	}
	//2) DB와 해제
	protected void disconnect() {
		try {
			// 6. 자원해제하기
			if(rs != null) rs.close();
			if(pstmt != null ) pstmt.close();
			if(stmt != null)  stmt.close();
			if(conn != null) conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}