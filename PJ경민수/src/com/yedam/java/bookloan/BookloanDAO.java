package com.yedam.java.bookloan;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.java.book.Book;
import com.yedam.java.common.DAO;

public class BookloanDAO extends DAO{
	//싱글톤
	private static BookloanDAO bookloanDAO = null;
	private BookloanDAO() {}
	public static BookloanDAO getInstance() {
		if(bookloanDAO == null) {
			bookloanDAO = new BookloanDAO();
		}		
		return bookloanDAO;
	}
	// 1)전체조회
	public List<Bookloan> selectBookloanAll(){
		List<Bookloan> list = new ArrayList<>();
		try {
			//DB 접속
			connect();
			if(conn == null) {
				System.out.println("데이터베이스에 연결할 수 없습니다.");
	            return list;
			}
			//SQL 작성
			String sql = "SELECT * "
					   + "FROM bookloan "
					   + "ORDER BY isbn";
			//객체 생성
			stmt = conn.createStatement();
			//SQL 실행
			rs = stmt.executeQuery(sql);
			//결과처리
			while(rs.next()) {
				// 한 행에 대한 처리
				Bookloan bookloan = new Bookloan();
				bookloan.setLoanId(rs.getInt("loan_id"));
				bookloan.setIsbn(rs.getString("isbn"));
				bookloan.setMemberId(rs.getString("member_id"));
				bookloan.setLoanDate(rs.getDate("loan_date"));
				bookloan.setReturnDate(rs.getDate("return_date"));
				list.add(bookloan);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			// DB 해제
			disconnect();
		}
		return list;
	}
	public boolean isAvailableForBorrow(String isbn) {
	    boolean available = false;
	    try {
	        connect();
	        // 대출 가능 여부를 확인하는 SQL 작성
	        String sql = "SELECT stock FROM book WHERE isbn = ?";
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, isbn);
	        rs = pstmt.executeQuery();
	        // 결과 처리
	        if (rs.next()) {
	            int stock = rs.getInt("stock");
	            available = stock > 0;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        disconnect();
	    }
	    return available;
	}
	public boolean borrowBook(String isbn) {
	    boolean success = false;
	    try {
	        connect();
	        // 도서 대출 처리 SQL 작성
	        String sql = "UPDATE book SET stock = stock - 1 WHERE isbn = ? AND stock > 0";
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, isbn);
	        int rowCount = pstmt.executeUpdate();
	        // 대출 성공 여부 확인
	        success = rowCount > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        disconnect();
	    }
	    return success;
	}
	public boolean returnBook(String isbn) {
	    int result = 0;
	    try {
	        connect();
	        // 도서 반납 처리 SQL 작성
	        String sql = "UPDATE book SET stock = stock + 1 WHERE isbn = ?";
	        pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, isbn);
	        result = pstmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        disconnect();
	    }
	    // 결과에 따라 반납 성공 여부 반환
	    return result > 0;
	}
	public List<Book> selectBorrowedBooks() {
	    List<Book> borrowedBooks = new ArrayList<>();
	    try {
	        connect();
	        // 대출 중인 도서를 조회하는 SQL 작성
	        String sql = "SELECT * FROM book WHERE stock < original_stock";
	        stmt = conn.createStatement();
	        rs = stmt.executeQuery(sql);
	        // 결과 처리
	        while (rs.next()) {
	            Book book = new Book();
	            book.setIsbn(rs.getString("isbn"));
	            book.setTitle(rs.getString("title"));
	            book.setAuthor(rs.getString("author"));
	            book.setContent(rs.getString("content"));
	            book.setStock(rs.getInt("stock"));
	            borrowedBooks.add(book);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        disconnect();
	    }
	    return borrowedBooks;
	}
	

}
