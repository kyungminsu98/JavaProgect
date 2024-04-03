<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${msg != null}">
	<script>
		window.alert('<c:out value="${msg}"/>');
	</script>
</c:if>
<div>
<form action="login.do" method="post">
	<table class="table">
		<tr>
			<th>아이디</th>
			<td><input type="text" name="id" class="form-control"></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="pw" class="form-control"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="로그인" class="btn btn-primary">
			</td>
		</tr>
	</table>
</form>
</div>
