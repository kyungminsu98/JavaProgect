/**
 * member.js
 */
const titles = ['id', 'first_name', 'last_name', 'email', 'gender', 'salary'];
const formIds = ['mid', 'fname', 'lname', 'email', 'gender', 'salary'];
const table = document.querySelector('#show>table');
table.setAttribute('class', 'table');
table.innerHTML = '';
table.appendChild(makeHeader());
table.appendChild(makeBody());

// thead 생성. 아이디/이름/이메일/성별/급여
function makeHeader(){
	let thead = document.createElement('thead');
	let tr = document.createElement('tr');
	thead.appendChild(tr);
	titles.forEach(title => {
		let th = document.createElement('th');
		th.innerText = title;
		tr.appendChild(th);
	});
	return thead;
}

// tbody 생성
function makeBody(){
	let tbody = document.createElement('tbody');
	members.forEach((e, i) => {
		if (i < 3)
			tbody.appendChild(makeRow(e));
	});
	return tbody;
}

function makeRow(member = {}){
	let tr = document.createElement('tr');
	titles.forEach((title) =>{
		let td = document.createElement('td');
		td.innerText = member[title];
		tr.appendChild(td);
	}); // capturing(상 -> 하), bubling(하 -> 상)

	// 버튼추가
	let btn = document.createElement('button');
	btn.innerText = '삭제';
	btn.className = "btn";
	// btn.classList.add('Btn'); 
	btn.classList.add('btn-danger'); // 클래스 추가
	// btn.setAttribute('class', 'btn btn-danger');
	btn.addEventListener('click', e => {
		e.stopPropagation(); // 상위 요소로 이벤트 전파 차단
		btn.parentElement.parentElement.remove();
	}, false);
	
	let td = document.createElement('td');
	td.appendChild(btn);
	tr.appendChild(td);
	tr.setAttribute('style', 'cursor:pointer;')
	tr.addEventListener('click', (e) => {
		document.getElementById('mid').disabled = true;
		formIds.forEach((e, i) =>{
			document.getElementById(e).value = tr.children[i].innerHTML;
		})
	});
	return tr;
}
document.querySelector('form:nth-of-type(1)').addEventListener('submit', (e)=>e.preventDefault());



document.querySelector('form tr td #addBtn')//
.addEventListener('click', (e) => {
	const userVal = {};
	titles.forEach((e, i) => {
		userVal[e] = document.getElementById(formIds[i]).value;
	});
	document.querySelector('#show tbody').appendChild(makeRow(userVal));
});

// 수정처리
document.querySelector('form tr td #updateBtn')//
.addEventListener('click', (e) => {	
	const mid = document.getElementById('mid');
	document.querySelectorAll('#show tbody tr').forEach(tr => {
		if (tr.children[0].innerText == mid.value){
			formIds.forEach((e, i) => {
				tr.children[i].innerText = document.getElementById(e).value;
				document.getElementById(e).value = '';
			});
			mid.disabled = false;
		}
	});
});


