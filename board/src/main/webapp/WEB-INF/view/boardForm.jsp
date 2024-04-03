<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <h3>게시글 등록</h3>
  <form action="addBoard.do" method="post" enctype="multpart/form-data">
  <table class="table">
  	<tr>
  	  <th>글제목</th><td><input class="form-control" type="text" name="title"></td>
  	</tr>
  	<tr>
  	  <th>내용</th><td><textarea class="form-control" rows="3" cols="22" name="content"></textarea></td>
  	</tr>
  	<tr>
  	  <th>이미지</th><td><input class="form-control" type="file" name="myImg"></td>
  	</tr>
  	<tr>
  	  <th>작성자</th><td>${logId }</td>
  	</tr>
  	<tr>
  	  <td align="center" colspan="2"><input class="btn btn-primary" type="submit" value="글 등록"></td>
  	</tr>
  </table>
  </form>