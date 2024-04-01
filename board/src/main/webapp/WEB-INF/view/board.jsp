<%@page import="co.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/menu.jsp" %>
<%@ include file="../includes/header.jsp" %>
<title>게시글 단건 조회</title>
</head>
<body>
	<%
		BoardVO vo = (BoardVO)request.getAttribute("bvo");
	%>
	<h3>상세페이지</h3>
	<form action="modifyForm.do">
	<input type="hidden" name="bno" value="<%=vo.getBoardNo()%>">
	<table class="table">
		<thead>
			<tr>
				<th>글번호</th><th><%=vo.getBoardNo()%></th><th>조회수</th><th><%=vo.getViewCnt()%></th>
			</tr>
			<tr>
				<th>글제목</th><th colspan="3"><%=vo.getContent()%></th>
			</tr>
			<tr>
				<th>작성자</th><th><%=vo.getWriter()%></th><th>작성일시</th><th><%=vo.getCreateDate()%></th>
			</tr>
			<tr>
				<td colspan="4" align="center">
					<button type="submit">수정</button>
					<button type="button">삭제</button>
				</td>
			</tr>
		</thead>
	</table>
	</form>
<%@ include file="../includes/footer.jsp" %>
