<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div>
<form action="addMember.do" method="post">
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
			<th>이름</th>
			<td><input type="text" name="name" class="form-control"></td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td><input type="tel" name="phone" class="form-control"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="회원가입" class="btn btn-primary">
			</td>
		</tr>
	</table>
</form>
</div>