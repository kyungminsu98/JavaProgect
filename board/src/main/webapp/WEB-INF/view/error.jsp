<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h3>error</h3>
  <% String text = (String)request.getAttribute("msg"); %>
  <p><%= text %></p>
</body>
</html>