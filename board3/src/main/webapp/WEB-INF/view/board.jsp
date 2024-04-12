<%@page import="co.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href = "//cdn.datatables.net/2.0.3/css/dataTables.dataTables.min.css" rel="stlyeseet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.2/moment.min.js"></script>
<script src="//cdn.datatables.net/2.0.3/js/dataTables.min.js"></script>
<style>
	div.reply div{
		margin: auto;
	}
	div.reply ul{
		list-style-type: none;
		margin-top: 10px;
	}
	div.reply li {
		padding: 4px 0;
	}
	div.reply span{ 
		display: inline-block;
	}
	.center {
	text-align: center;
	}

	.pagenation {
		display: inline-block;
	}

	.pagenation a {
		color: black;
		float: left;
		padding: 8px 16px;
		text-decoration: none;
		transition: background-color .3s;
		border: 1px solid #ddd;
		margin: 0 4px;
	}

	.pagenation a.active {
		background-color: #0d6efd;
		color: white;
		border: 1px solid #0d6efd;
	}

	.pagenation a:hover:not(.active) {
		background-color: #ddd;
	}
</style>


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
	
	
<table id="example" class="display" style="width:100%">
    <thead>
        <tr>
            <th>댓글번호</th>
            <th>내용</th>
            <th>작성자</th>
            <th>작성일시</th>
        </tr>
    </thead>
    <tfoot>
        <tr>
     	  	<th>댓글번호</th>
      	  	<th>내용</th>
      	  	<th>작성자</th>
      	  	<th>작성일시</th>
        </tr>
    </tfoot>
</table>
<button onclick="addNewRow()">칼럼추가</button>
	
</form>
<div class="container reply">
	<!-- 등록 -->
	<div>
		<input class="btn btn-outline-primary" type = "text" id = "reply">
		<button class="btn btn-danger" type="button" id = "addReply">등록</button>
	</div>
	<div class="content">
		<ul class="list-group list-group-flush">
			<li class="list-group-item">
				<span class="col-sm-2"><b>글번호</b></span>
				<span class="col-sm-6"><b>댓글내용</b></span>
				<span class="col-sm-2"><b>작성자</b></span>
				<span class="col-sm-1"><b>삭제</b></span>
			</li>
			<li class="list-group-item" style="display:none;">
				<span class="col-sm-2"><b></b></span>
				<span class="col-sm-6"><b></b></span>
				<span class="col-sm-2"><b></b></span>
				<button class="col-sm-1 btn btn-danger btn-sm">삭제</button>
			</li>
		</ul>
	</div>
	<!-- 댓글목록 -->
	<div class="footer">
		<div class="center">
			<div class="pagenation">
			</div>
		</div>
	</div>
</div>

<!-- <script src="js/boardService.js"></script> -->
<script type="module" src="js/board.js"></script>

<script>
	const bno ="${bno}"
	const logId = "${logId}";
	const writer = "${bvo.writer}";
	new DataTable('#example', {
	    ajax: 'datatable.do?bno='+bno,
	    columns: [
	        { data: 'replyNo' },
	        { data: 'reply' },
	        { data: 'replyer' },
	        { data: 'replyDate' },
	        { data: 'start_date' },
	        { data: 'salary' }
	    ]
	    lengthMenu[
	    	[5,10,25,-1],
	    	[5,10,25'All]
	    ]
	});
	
	function addNewRow(reply={}){
		table.row
			.add({
				replyNo:reply.replyNo,
				reply:reply.reply,
				replyer:reply.replyer,
				replyDate:reply.replyDate
			})
			.draw(false);
	}
	document.querySelector('#addReply').addEventListener('click',function(){
		let reply = document.querySelector('#reply').value;
		if(!logId){
			alert('로그인 하세요');
			return;
		}
		if(!reply){
			alert('댓글을 입력하세요.');
			return;
		}
		fetch('addReply.do',{
			method:'post',
			headers:{'Content-Type':'application/x-www-form-urlencoded'}
			body:'&bno='+bno+'&reply='+reply+'&replyer='+logId
		})
		.then(result => result.json())
		.then(result =>{
			console.log(result);
			if(result.resCode == 'Success'){
				alert('등록성공');
				addNewRow(result.retVal);
			}
		})
		.catch(err => console.error(err));
	})
		
	
	
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

	function removeFormFunc() {
		document.forms[0].action = "removeForm.do";
		document.forms[0].submit();
	}
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
