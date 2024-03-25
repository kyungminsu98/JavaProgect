package com.yedam.java.book;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.java.common.DAO;

public class BookDAO extends DAO{
	//Oracle(DB) 연결정보
	String jdbcDriver = "oracle.jdbc.driver.OracleDriver";
	String oracleUrl  = "jdbc:oracle:thin:@localhost:1521:xe";
	String connectedId = "hr";
	String connectedPwd = "hr";
	
	protected Connection conn = null;
	protected PreparedStatement pstmt = null;
	protected java.sql.Statement stmt = null;
	protected ResultSet rs = null;
	
	//싱글톤
	private static BookDAO bookDAO = null;
	private BookDAO() {}
	public static BookDAO getInstance() {
		if(bookDAO == null) {
			bookDAO = new BookDAO();
		}		
		return bookDAO;
	}
	// 1)전체조회
	public List<Book> selectBookAll(){
		List<Book> list = new ArrayList<>();
		try {
			//DB 접속
			connect();
			//SQL 작성
			String sql = "SELECT * "
					   + "FROM departments "
					   + "ORDER BY department_id";
			//객체 생성
			stmt = conn.createStatement();
			//SQL 실행
			rs = stmt.executeQuery(sql);
			//결과처리
			while(rs.next()) {
				// 한 행에 대한 처리
				Book dept = new Book();
				dept.setIsbn(rs.getInt("isbn"));
				dept.setTitle(rs.getString("title"));
				dept.setAuthor(rs.getString("author"));
				dept.setContent(rs.getString("content"));
				dept.setInventory(rs.getInt("inventory"));
				list.add(dept);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			// DB 해제
			disconnect();
		}
		return list;
	}
	// 2)단건조회
	public Book selectBookInfo(int deptId) {
		Book dept = null;
		try {
		connect();
		// SQL 작성
		String sql = "SELECT * "
				   + "FROM departments "
				   + "WHERE department_id = ?";
		// 객체생성
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, deptId);
		// SQL 실행
		rs = pstmt.executeQuery();
		// 결과처리
		if(rs.next()) {
			dept = new Book();
			dept.setIsbn(rs.getInt("isbn"));
			dept.setTitle(rs.getString("title"));
			dept.setAuthor(rs.getString("author"));
			dept.setContent(rs.getString("content"));
			dept.setInventory(rs.getInt("inventory"));
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return dept;
	}
	// 3) 등록
	public int insertBookInfo(Book dept) {
		int result = 0;
		try {
		// DB 접속
		connect();
		// SQL 작성
		String sql = "INSERT INTO departments"
				   + "VALUES(?,?,?,?)";
		// 객체생성
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, dept.getIsbn());
		pstmt.setString(2, dept.getTitle());
		pstmt.setString(3, dept.getAuthor());
		pstmt.setString(4, dept.getContent());
		pstmt.setInt(5, dept.getInventory());
		// SQL 실행
		result = pstmt.executeUpdate();
		// 결과처리
		if(rs.next()) {
			dept = new Book();
			dept.setIsbn(rs.getInt("isbn"));
			dept.setTitle(rs.getString("title"));
			dept.setAuthor(rs.getString("author"));
			dept.setContent(rs.getString("content"));
			dept.setInventory(rs.getInt("inventory"));
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return result;
	}
	// 4) 수정
	public int updateBookInfo(Book dept) {
		int result = 0;
		try {
		// DB 접속
		connect();
		// SQL 작성
		String sql = "UPDATE departments"
				   + "SET department_name = ?"
				   + "WHERE department_id = ?";
		// 객체생성
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(2, dept.getTitle());
		pstmt.setString(3, dept.getAuthor());
		pstmt.setString(4, dept.getContent());
		pstmt.setInt(5, dept.getInventory());
		// SQL 실행
		result = pstmt.executeUpdate();
		// 결과처리
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return result;
	}
	// 5) 삭제
	public int deleteBookInfo(int deptId) {
		int result = 0;
		try {
			connect();
			String sql = "DELETE FROM departments"
					   + "WHERE department_id" + deptId;
			stmt = conn.createStatement();
			result = stmt.executeUpdate(sql);
		}catch(SQLException e){
			
		}finally {
			
		}
		return result;
	}
}
