<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h3 class="col-sm-6" align="left">유저 목록</h3>
<table class="table table-striped">
	<thead>
		<tr>
			<th>권한</th>
			<th>ID</th>
			<th>PW</th>
			<th>이름</th>
			<th>전화번호</th>
			<th>가입일</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${ mlist }" var="vo">
			<tr>
				<td><c:out value="${vo.responsibility}" /></td>
				<td><c:out value="${vo.memberId}" /></td>
				<td><c:out value="${vo.memberPw}" /></td> 
				<td><c:out value="${vo.memberNm}" /></td>
				<td><c:out value="${vo.phone}" /></td>
				<td><c:out value="${vo.createDate}" /></td>
			</tr>
		</c:forEach>
	</tbody>
</table>