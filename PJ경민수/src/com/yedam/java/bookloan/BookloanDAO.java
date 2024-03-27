package com.yedam.java.bookloan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	 public List<Bookloan> selectUserLoans(String memberId) {
	        List<Bookloan> userLoans = new ArrayList<>();
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        ResultSet rs = null;
	        
	        try {
	            String sql = "SELECT * FROM loanbook WHERE member_id = ?";
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, memberId);
	            rs = pstmt.executeQuery();
	            
	            while (rs.next()) {
	                Bookloan loan = new Bookloan();
	                loan.setLoanId(rs.getInt("loan_id"));
	                loan.setIsbn(rs.getString("isbn"));
	                loan.setMemberId(rs.getString("member_id"));
	                loan.setLoanDate(rs.getDate("loan_date"));
	                loan.setReturnDate(rs.getDate("return_date"));
	                userLoans.add(loan);
	            }
	        }catch (SQLException e) {
	            e.printStackTrace();
	        }finally {
	            // 리소스 해제 코드
	            if (rs != null) {
	                try {
	                    rs.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	            if (pstmt != null) {
	                try {
	                    pstmt.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	            if (conn != null) {
	                try {
	                    conn.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	        return userLoans;
	    }
}
