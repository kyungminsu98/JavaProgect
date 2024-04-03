<%@page import="co.yedam.common.PageDTO"%>
<%@page import="co.yedam.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<style>
.center {
	text-align: center;
}

.pagination {
	display: inline-block;
}

.pagination a {
	color: black;
	float: left;
	padding: 8px 16px;
	text-decoration: none;
	transition: background-color .3s;
	border: 1px solid #ddd;
	margin: 0 4px;
}

.pagination a.active {
	background-color: #0d6efd;
	color: white;
	border: 1px solid #0d6efd;
}

.pagination a:hover:not(.active) {
	background-color: #ddd;
}
</style>

<!-- 검색조건 추가 -->
<div class="mt-3 center">
	<form action="boardList.do" method="get">
		<div class="row">
			<h3 class="col-sm-6" align="left">게시글 목록</h3>
			<div class="col-sm-2">
				<select name="searchCondition" class="form-control">
					<option value="none">===선택===</option>
					<option value="T"  <c:if test="${searchCondition == 'T'.toString()}"> selected</c:if>>제목</option>
					<option value="W"  <c:if test="${searchCondition == 'W'.toString()}"> selected</c:if>>작성자</option>
					<option value="TW" <c:if test="${searchCondition == 'TW'.toString()}">selected</c:if>>제목 & 작성자</option>
				</select>
			</div>
			<div class="col-sm-4">
				<input type="text" name="keyword" class="form-control" value="${keyword}">		
			</div>
			<div class="col-sm-2">
				<input type="submit" value="조회" class="btn btn-primary">
			</div>
		</div>
	</form>
</div>

<!-- 검색조건 추가 -->

<table class="table table-striped">
	<thead>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${ blist }" var="vo">
			<tr>
				<td align="center"><c:out value="${vo.boardNo}" /></td>
				<td><a href="getBoard.do?bno=${vo.boardNo}&page=${paging.page}&searchCondition=${searchCondition}&keyword=${keyword}"><c:out value="${vo.title}" /></a></td>
				<td><c:out value="${vo.writer}" /></td>
				<td><c:out value="${vo.createDate}" /></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<div class="center">
	<div class="pagination">
		<c:if test="${paging.prev}">
			<a href="boardList.do?page=${paging.startPage-1}&searchCondition=${searchCondition}&keyword=${keyword}">&laquo;</a>
		</c:if>
		<c:forEach var="p" begin="${paging.startPage}" end="${paging.endPage}">
			<c:choose>
				<c:when test="${p == paging.page}">
					<a href="boardList.do?page=${p}&searchCondition=${searchCondition}&keyword=${keyword}" class="active"><c:out value="${p}"/></a>
				</c:when>
				<c:otherwise>
					<a href="boardList.do?page=${p}&searchCondition=${searchCondition}&keyword=${keyword}"><c:out value="${p}"/></a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${paging.next}">
			<a href="boardList.do?page=${paging.endPage+1}&searchCondition=${searchCondition}&keyword=${keyword}">&raquo;</a>
		</c:if>
	</div>
</div>
