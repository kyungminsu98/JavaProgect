package com.yedam.java.book;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.java.common.DAO;

public class BookDAO extends DAO{
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
			if(conn == null) {
				System.out.println("데이터베이스에 연결할 수 없습니다.");
	            return list;
			}
			//SQL 작성
			String sql = "SELECT * "
					   + "FROM book "
					   + "ORDER BY isbn";
			//객체 생성
			stmt = conn.createStatement();
			//SQL 실행
			rs = stmt.executeQuery(sql);
			//결과처리
			while(rs.next()) {
				// 한 행에 대한 처리
				Book book = new Book();
				book.setIsbn(rs.getString("isbn"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setContent(rs.getString("content"));
				book.setStock(rs.getInt("stock"));
				list.add(book);
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
	public Book selectBookInfo(String isbn, String title, String author ) {
		Book book = null;
		try {
		connect();
		// SQL 작성
		String sql = "SELECT * "
				   + "FROM book "
				   + "WHERE isbn = ? OR title = ? OR author= ?";
		// 객체생성
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, isbn);
        pstmt.setString(2, title);
        pstmt.setString(3, author);
		// SQL 실행
		rs = pstmt.executeQuery();
		// 결과처리
		if(rs.next()) {
			book = new Book();
			book.setIsbn(rs.getString("isbn"));
			book.setTitle(rs.getString("title"));
			book.setAuthor(rs.getString("author"));
			book.setContent(rs.getString("content"));
			book.setStock(rs.getInt("stock"));
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return book;
	}
	// 3) 등록
	public int insertBookInfo(Book book) {
		int result = 0;
		try {
		// DB 접속
		connect();
		// SQL 작성
		String sql = "INSERT INTO book(isbn, title, author, content, stock)"
				   + "VALUES(book_seq.NEXTVAL,?,?,?,?)";
		// 객체생성
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, book.getTitle());
		pstmt.setString(2, book.getAuthor());
		pstmt.setString(3, book.getContent());
		pstmt.setInt(4, book.getStock());
		// SQL 실행
		result = pstmt.executeUpdate();
		// 결과처리
//		if(rs.next()) {
//			book = new Book();
//			book.setIsbn(rs.getString("isbn"));
//			book.setTitle(rs.getString("title"));
//			book.setAuthor(rs.getString("author"));
//			book.setContent(rs.getString("content"));
//			book.setStock(rs.getInt("stock"));
//		}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			disconnect();
		}
		return result;
	}
	// 4) 수정
	public int updateBookInfo(Book book) {
		int result = 0;
		try {
		// DB 접속
		connect();
		// SQL 작성
		String sql = "UPDATE book "
		           + "SET title = ?, "
		           + "author = ?, "
		           + "content = ?, "
		           + "stock = ? "
		           + "WHERE isbn = ?";
		// 객체생성
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, book.getTitle());
		pstmt.setString(2, book.getAuthor());
		pstmt.setString(3, book.getContent());
		pstmt.setInt(4, book.getStock());
		pstmt.setString(5, book.getIsbn());
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
	public int deleteBookInfo(String isbn) {
	    int result = 0;
	    try {
	        connect();
	        String sql = "DELETE FROM book WHERE isbn = ?";
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, isbn);
	        result = pstmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        disconnect();
	    }
	    return result;
	}
}
