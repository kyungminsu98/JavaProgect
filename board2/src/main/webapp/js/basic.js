/**
 * basic.js
 */
console.log('basic js started');

// 매개값 -> 처리결과 반환
function sum(n1=10, n2=100){
	return n1 + n2;
}
let result = sum(-10, 10);
console.log(result);

const sum1 = function(a=0,b=0){
	return a+b;
}
const sum2 = sum1;

console.log(sum1()+sum2(10));

function sum3(n1 = [0, 10]){
	let result = 0;
	for (let i of n1){
		result += i;
	}
	return result;
}

console.log(sum3([12,3,4,5,6,6]));

function showDay(days = []){
	const tr = document.createElement('tr');
	for (let day of days){
		const th = document.createElement('th');
		th.innerText = day;
		tr.appendChild(th);
	}
	let thead = document.querySelector('#header');
	thead.appendChild(tr);
}

showDay(['sun', 'mon', 'tue', 'wed', 'thr', 'fri', 'sat']);

const showDate = function (spaces=0, start=1, end=31){
	let tbody = document.querySelector('#tbody');
	let tr = document.createElement('tr');
	for (let d = 0; d < spaces; d++){
		const td = document.createElement('td');
		td.innerText = '';
		tr.appendChild(td);
	}
	for (let d = start; d < end+1; d++){
		const td = document.createElement('td');
		td.innerText = d;
		tr.appendChild(td);
		if ((spaces + d) % 7==0){
			tbody.appendChild(tr);
			tr = document.createElement('tr');	
		}
	}
	tbody.appendChild(tr);
	
	/*
	let arr = [];
	let	temp = [];
	for (let d = start; d < end+1; d++){
		temp.push(d);
		if (d % 7 == 0){
			arr.push(temp);
			temp = []
		}
	}
	arr.push(temp);
	for (let date of arr){
		tr = document.createElement('tr');
		console.log(date)
		for (let d of date){
			const td = document.createElement('td');
			td.innerText = d;
			tr.appendChild(td);
		}
		tbody.appendChild(tr);
	}
	*/
}
showDate(5);

// 공백 계산함수
function getSpaces(month = 1){
	switch(month){
		case 1: return 1;
		case 4: return 1;
		case 5: return 3;
	}
}
// 마지막 날 계산함수
function getLastDate(month = 1){
	switch(month) {
		case 1: return 31;
		case 4: return 30;
		case 5: return 31;			
	}
}






