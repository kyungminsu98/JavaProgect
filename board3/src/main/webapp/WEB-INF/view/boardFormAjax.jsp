<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
    table a {
        color: black;
        text-decoration: none;
        width: 100%;
    }
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
<!-- 등록 -->
<table class="table">
    <tr>
        <th>제목</th>
        <td><input type="text" id="title" class="form-control"></td>
    </tr>
    <tr>
        <th>내용</th>
        <td><textarea id="content" class="form-control" cols="30" rows="5"></textarea></td>
    </tr>
    <tr>
        <th>작성자</th>
        <td><input type="text" id="writer" class="form-control" value="${logId}" readonly></td>
    </tr>
    <tr>
        <td colspan="2" align="center">
            <button id="addBtn" class="btn btn-primary">등록</button>
        </td>
    </tr>
</table>
<!-- 검색조건 추가 -->
<div class="mt-3 center">
    <div class="row">
        <h3 class="col-sm-5" align="left">게시글 목록</h3>
        <div class="col-sm-2">
            <select id="searchCondition" class="form-control">
                <option value="none">===선택===</option>
                <option value="T">제목</option>
                <option value="W">작성자</option>
                <option value="TW">제목 & 작성자</option>
            </select>
        </div>
        <div class="col-sm-3">
            <input type="text" id="keyword" class="form-control" value="${keyword}">		
        </div>
        <div class="col-sm-2">
            <button id="searchBtn" class="btn btn-primary">검색</button>
        </div>
    </div>
</div>
<!-- 목록 -->
<div id="show">
    <table class="table table-striped">
        <thead id="thead"></thead>
        <tbody id="tbody"></tbody>
    </table>
</div>
<!-- 페이징 -->
<div class="center">
	<div class="pagination">
		<c:if test="${paging.prev}">
			<a href="boardFormAjax.do?page=${paging.startPage-1}&searchCondition=${searchCondition}&keyword=${keyword}">&laquo;</a>
		</c:if>
		<c:forEach var="p" begin="${paging.startPage}" end="${paging.endPage}">
			<c:choose>
				<c:when test="${p == paging.page}">
					<a href="boardFormAjax.do?page=${p}&searchCondition=${searchCondition}&keyword=${keyword}" class="active"><c:out value="${p}"/></a>
				</c:when>
				<c:otherwise>
					<a href="boardFormAjax.do?page=${p}&searchCondition=${searchCondition}&keyword=${keyword}"><c:out value="${p}"/></a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${paging.next}">
			<a href="boardFormAjax.do?page=${paging.endPage+1}&searchCondition=${searchCondition}&keyword=${keyword}">&raquo;</a>
		</c:if>
	</div>
</div>
<script src="js/boardListAjax.js"></script>