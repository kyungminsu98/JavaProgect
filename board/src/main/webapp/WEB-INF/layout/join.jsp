<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Join</title>
</head>
<body>
    <h1>Join</h1>
    <form method="post" action="joinAction.jsp">
        <label for="memberId">ID:</label>
        <input type="text" id="memberId" name="memberId" required>
        <br>
        <label for="memberPw">Password:</label>
        <input type="password" id="memberPw" name="memberPw" required>
        <br>
        <label for="memberNm">Name:</label>
        <input type="text" id="memberNm" name="memberNm" required>
        <br>
        <label for="phone">Gender:</label>
        <input type="text" id="phone" name="phone" required>
        <br>
        <input type="submit" value="Join">
    </form>
</body>
</html>