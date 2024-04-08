/**
 * service.js
 */

const fields = ['memberId', 'memberPw', 'memberNm', 'phone'];
function makeRow(member = {}){
	let tr = document.createElement('tr');
	// td.생성
	fields.forEach(elem => {
        let td = document.createElement('td');
        td.innerText = member[elem] == undefined ? '': member[elem]; // 만약 해당 필드에 데이터가 없으면 빈 문자열 출력
        tr.appendChild(td);
    });
	let btn = document.createElement('button');
	btn.innerText = '삭제';
	btn.addEventListener('click', function(e) {
		const delHtp = new XMLHttpRequest();
		delHtp.open('get', 'removeMember.do?mid='+ member.memberId);
		delHtp.send();
		delHtp.onload = function(){
			let result = JSON.parse(delHtp.response);
			if(result.retCode == 'Success'){
				tr.remove();	
				alert('삭제성공.');
			}else if(result.retCode == 'Fail'){
				alert('삭제처리중 에러.');
			}else{
				alert('알수 없는 코드.');
			}
		}
	}, false);
	let td = document.createElement('td');
	td.appendChild(btn);
	tr.appendChild(td);
	return tr;
}

// xhtp 호출
const xhtp = new XMLHttpRequest();
xhtp.open('get', 'memberAjax.do');
xhtp.send();

xhtp.onload = function(){
	let members = JSON.parse(xhtp.response);
	members.forEach(member => {
		document.getElementById('list').appendChild(makeRow(member));
	})
}
// 등록
document.getElementById('addBtn').addEventListener('click', function(e){
	let id = document.getElementById('mid').value;
	let nm = document.getElementById('name').value;
	let pw = document.getElementById('mpw').value;
	let ph = document.getElementById('phone').value;
	const addHtp = new XMLHttpRequest();
	addHtp.open('get', 'addMemberAjax.do?mid='+id+'&name='+nm+'&pass='+pw+'&phone='+ph);
	addHtp.send();
	addHtp.onload = function(){
		let result = JSON.parse(addHtp.response);
		if(result.retCode == 'Success'){
			alert('등록성공.');
			document.getElementById('list').append(makeRow(merber));
		}else if(result.retCode == 'Fail'){
			alert('등록처리중 에러.');
		}else{
			alert('알수 없는 코드.');
		}
	}
});
