<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/menu.jsp" %>
<%@ include file="../includes/header.jsp" %>
<title>글 등록</title>
</head>
<body>
	<h3>글 등록</h3>
	<form action="addBoard.do">
	<table class="table">
		<tr>
			<th>글제목</th>
			<td><input class="form-control" type="text" name="title"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea name="content" ></textarea></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><input class="form-control" type="text" name="writer"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input class="btn btn-primary" type="submit" value="글등록">
			</td>
		</tr>
	</table>
	</form>
<%@ include file="../includes/footer.jsp" %>