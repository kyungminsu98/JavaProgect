<%@page import="co.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/menu.jsp" %>
<%@ include file="../includes/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<title>게시글 단건 조회</title>

<body>
	<%
		BoardVO vo = (BoardVO)request.getAttribute("bvo");
	%>
		<from action="modifyBoard.do">
			<input type="hidden" name="bno" value="${bvo.boardNo}">
			<input type="hidden" name="page" value="${page}">
			<input type="hidden" name="searchCondition" value="${searchCondition}">
			<input type="hidden" name="keyword" value="${keyword}">
		<table class="table">
		<thead>
			<tr>
				<th>글번호</th>
				<th><%=vo.getBoardNo()%></th>
				<th>글제목</th>
				<th><%=vo.getTitle()%></th>
			</tr>
			<tr>
				<th>글내용</th>
				<th colspan="3"><textarea name="content"><%=vo.getContent()%></textarea></th>
			</tr>
			<tr>
				<th>작성자</th>
				<th><%=vo.getWriter()%></th>
				<th>작성일시</th>
				<th><%=vo.getCreateDate()%></th>
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