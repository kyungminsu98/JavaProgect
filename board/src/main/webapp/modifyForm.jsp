<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="WEB-INF/includes/menu.jsp" %>
<%@ include file="WEB-INF/includes/header.jsp" %>
<title>게시글 단건 조회</title>

<body>
	<%
		BoardVO vo = (BoardVO)request.getAttribute("bvo");
	%>
		<from action="modifyBoard.do">
			<input type="hidden"name="boardNo"value="<%=vo.getBoardNo()%>">
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
	<%@ include file="WEB-INF/includes/footer.jsp" %>