<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Join Action</title>
</head>
<body>
    <%
        String memberId = request.getParameter("memeberID");
        String memberPw = request.getParameter("memeberPw");
        String memberNm = request.getParameter("memberName");
        String phone = request.getParameter("phone");
		
    	String jdbcDriver = "oracle.jdbc.driver.OracleDriver";
    	String oracleUrl  = "jdbc:oracle:thin:@192.168.0.11:1521:xe";
        String dbUser = "jsp"; // 데이터베이스 사용자명 수정 필요
        String dbPassword = "jsp"; // 데이터베이스 비밀번호 수정 필요

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(oracleUrl, dbUser, dbPassword);

            String sql = "INSERT INTO user (memberId, memberPw, memberNm, phone) VALUES (?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, memberId);
            pstmt.setString(2, memberPw);
            pstmt.setString(3, memberNm);
            pstmt.setString(4, phone);
            pstmt.executeUpdate();

            out.println("Join Successful");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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
    %>
</body>
</html>