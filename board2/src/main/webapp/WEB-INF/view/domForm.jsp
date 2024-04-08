<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h3>DOM 연습</h3>

<!-- 멤버 추가 화면 -->
<form>
	<table class="table">
		<tr> 
			<th>아이디</th>
			<td><input type="text" id="mid" class="form-control"></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><input type="text" id="fname" class="form-control"></td>
		</tr>
		<tr>
			<th>성씨</th>
			<td><input type="text" id="lname" class="form-control"></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><input type="email" id="email" class="form-control"></td>
		</tr>
		<tr>
			<th>급여</th>
			<td><input type="number" id="salary" class="form-control"></td>
		</tr>
		<tr>
			<th>성별</th>
			<td>
				<select id="gender" class="form-select">
					<option value="Male">Male</option>
					<option value="Female">Female</option>
				</select>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button id="addBtn" class="btn btn-primary">저장</button>
				<button id="updateBtn" class="btn btn-primary">수정</button>
			</td>
		</tr>
	</table>
</form>

<input id ="year"><input id = "month"><butten id ="calBtn">선택</butten>

<div id="show">
	<table border='1' class="table">
		<thead id='header' />
		<tbody id='list' />
	</table>
</div>
시간: <span id="timer"></span>
<script src="js/ajax.js"></script>

<!-- <script src="js/basic.js"></script> -->
<!-- <script src="js/dom.js"></script> -->
<!--<script src="js/mock_data.js"></script>-->
<!-- <script src="js/member.js"></script>-->
<!-- <script src="js/string.js"></script> -->