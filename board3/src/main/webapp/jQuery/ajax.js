/**
 * ajax.js
 */
$(document).ready(function(){
	// 페이지 로딩 후 목록 출력 .memberAjax.do
	// fetch().then().then().then().then()
	$.ajax({
		url:'../memberAjax123.do',
		method:'get',
		dataType:'json' // JSON.parse(); => 자동변경
	})
	.done(function(result){
		console.log(result);
		// 목록출력 id, 이름, 연락처, 비번 => 작성
		$('<tr />').append($('<td />').text(member.memberId),
				      	$('<td />').text(member.memberNm),
				        $('<td />').text(member.memberPh),
				        $('<td />').text(member.memberPw)
		)		
        let btn = $('<button>삭제</button>').on('click', deleteBook);
		$('#list').append(
			$('<tr />').append(
				$('<td />').append(btn)
			));	
	})
	.fail(function(err){
		console.log(err);
	})
	.always(function(data){
		// console.log(data);		
	})
	// 등록버튼 이벤트
	$('div#register form[name="myFrm"]').on('submit', function(){
		e.preventDefault(); // 기본기능차단
		console.log($('form[name="myFrm"]').serialize());
		$.ajax({
			url:'../addmemberAjax.do',
			method:'post',
			data: $('form[name="myFrm"]').serialize(),  // = {mid: id, name: nm, phone: ph, pass: pw}, //전송데이터
			dataType:'json'
		})
		.done(function(result){
			console.log(result);
		})
		.fail(function(err){
			console.log(err);
		})
		
	})
});