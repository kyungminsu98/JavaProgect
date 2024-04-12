/**
 * dom.js
 */
// Ajax 호출
fetch('memberData.do').then((data) => { // 서버의 페이지 요청
	return data.json();
}).then((data) => {
	console.log(data);
	// 표그리기
	makeTable(data);
	
}).catch((err) => {
	console.log(err);
})

// json 출력
function makeTable(datas) {
	const table = document.createElement('table');
	table.setAttribute('class', 'table');
	for (let data of datas){
		let tr = document.createElement('tr');
		for (let prop in data){
			let td = document.createElement('td');
			td.innerText = data[prop];
			tr.appendChild(td);
		}
		table.appendChild(tr);
	}
	document.querySelector('#show').appendChild(table);
}