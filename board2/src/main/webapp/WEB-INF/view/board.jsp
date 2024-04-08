<%@page import="co.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h3 class="mt-4">게시글 조회</h3>
<form action="modifyForm.do" name="modifyForm">
	<input type="hidden" name="bno" value="${bvo.boardNo}">
	
	<!-- 페이지 따라가기 -->
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
			<td colspan="3"><c:out value="${bvo.title}" /></td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3">
				<c:out value="${bvo.content}" /><br>
				<c:if test="${bvo.img != null}">
					<img src="upload/${bvo.img}" width="200px">
				</c:if>
			</td>
		</tr>

		<tr>
			<th>작성자</th>
			<td><c:out value="${bvo.writer}" /></td>
			<th>작성일</th>
			<td><c:out value="${bvo.createDate}" /></td>
		</tr>

		<tr>
			<td align="right" colspan="4">
				<button class="btn btn-outline-primary" type="submit">수정</button>
				<button class="btn btn-danger" type="button" ${logId != bvo.writer ? 'disabled' : ''}
					onclick="removeFormFunc1(this.form)">삭제</button>
				<!--<button class="btn btn-danger" type="button"
					onclick="removeFormFunc()">새창삭제</button> -->
			</td>
		</tr>

	</table>
</form>

<script>
	const logId = "${logId}";
	const writer = "${bvo.writer}";
	document.querySelector('form[name="modifyForm"]')//
		.addEventListener('submit', function(e) {
		e.preventDefault();
		console.log(logId, writer);
		if (logId == writer){
			this.submit();
		} else {
			window.alert('권한이 없습니다.');			
		}
	});
</script>

<script>
	function removeFormFunc() {
		document.forms[0].action = "removeForm.do";
		document.forms[0].submit();
	}
</script>

<script>
	function removeFormFunc1(f) {
		let check = window.confirm("삭제하시겠습니까?");
		if (check) {
			f.action = "removeBoard.do";
			f.submit();
			window.alert("삭제되었습니다.");
		} else {
			window.alert("취소되었습니다.");
		}

	}
</script>
