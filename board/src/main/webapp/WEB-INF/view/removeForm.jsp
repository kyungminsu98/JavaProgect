<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../includes/menu.jsp" %>
<%@ include file="../includes/header.jsp" %>
<% String bno = (String)request.getAttribute("bno"); %>
<form action="removeBoard.do">
	<table class="table">
		<tr>
			<th>삭제글 번호</th>
			<td><input type="text" class="from-control" name="bno" value=""<%=bno%>></td>
		</tr>
		<tr>
			<th>삭제글 번호</th>
			<td><input type="text" class="from-control" name="bno" value=""<%=bno%>></td>
		</tr> 
	</table>
	
</form>
<%@ include file="../includes/footer.jsp" %>