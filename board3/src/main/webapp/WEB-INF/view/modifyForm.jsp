<%@page import="co.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h3 class="mt-4">게시글 수정</h3>

<form action="modifyBoard.do">
	<input type="hidden" name="bno" value="${bvo.boardNo}">
	
	<!-- 새창 따라가기 -->
	<input type="hidden" name="searchCondition" value="${searchCondition}">
	<input type="hidden" name="keyword" value="${keyword}">
	<input type="hidden" name="page" value="${page}">
	
	<table class="table">
		<tr>
			<th>글번호</th>
			<td><c:out value="${bvo.boardNo}" /></td>
			<th>조회수</th>
			<td><c:out value="${bvo.viewCnt}" /></td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="3"><input class="form-control" type="text"
				name="title" value="${bvo.title}"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3"><textarea class="form-control" name="content"><c:out value="${bvo.content}" /></textarea></td>
		</tr>
		<tr> 
			<th>작성자</th>
			<td><c:out value="${bvo.writer}" /></td>
			<th>작성일</th>
			<td><c:out value="${bvo.createDate}" /></td>
		</tr>
		<tr>
			<td align="right" colspan="4">
				<button class="btn btn-outline-primary" type="submit">저장</button>
			</td>
		</tr>
	</table>
</form>