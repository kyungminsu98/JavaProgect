<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<form action="removeBoard.do">
	<input type="hidden" name="searchCondition" value="${searchCondition}">
	<input type="hidden" name="keyword" value="${keyword}">
	<input type="hidden" name="page" value="${page}">
  <table class="table">
	<tr>
	  <th>삭제글 번호</th>
	  <td><input class="form-control" type="text" name="bno" value="${bno}" readonly></td>
	</tr>
	<tr>
      <td colspan="2" align="center">
      	<input class="btn btn-danger" type="submit" value="삭제">
      </td>
	</tr>
  </table>
</form>