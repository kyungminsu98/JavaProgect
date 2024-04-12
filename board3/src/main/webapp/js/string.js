/**
 * string.js
 */
document.querySelector('form').remove();
document.querySelector('#show').innerHTML= '';

let str1 = new String('hello');
console.log(typeof str1);

let str2 = ' hello ';
console.log(str2.trim().toUpperCase().slice(-2));

let str3 = 'hello,nice,kind';
console.log(str3.indexOf('nice'));

let str4 = str3.replace('hello', '안녕');
console.log(str3, str4);

let str3Ary = str3.split(",");
console.log(str3Ary);

function checkGender(sso = '031005-4234567'){
    // let temp = sso.split('');
    // if (temp[6] == '1' || temp[6] == '3') {
    //     return console.log('남자');
    // } else {
    //     return console.log('여자');
    // }

    // charAt 방식
    let n = 6;
    if (sso.indexOf(' ') >= 0 || sso.indexOf('-') >= 0){
        n++;
    }
    let temp = sso.charAt(n);
    if (temp == 1 || temp == 3) {
        return console.log('남자');
    } else {
        return console.log('여자');
    }
}
let numbers = ['990102-2345978', '010204-3123456', '0303044123456', '970304 1123456'];

numbers.forEach(e => {checkGender(e);});

// Date 객체
const today = new Date();
// console.log(today);
// today.setFullYear(2020);
// today.setMonth(0);
// today.setDate(1);
// console.log('말일 : ',today.getDate(-1));
// console.log(today.getFullYear());
// console.log(today.getMonth()+1);
// console.log(today.getDate());
// console.log(today.getHours());
// console.log(today.getMinutes());
// console.log(today.getSeconds());

document.getElementById('calBtn').addEventListener('click', function(e) {
    const year = document.getElementById('year').value;
	const mon = document.getElementById('month').value;
	createCalendar(year, mon);
})
const show = document.querySelector('#show');
function createCalendar(year = 2024, month = 4) {
    show.innerHTML = '';
    const thisMonth = new Date(year, month - 1, 1);
	console.log(thisMonth);

	// table 생성.
	let table = document.createElement('table');
	table.className = 'table';
    let caption = document.createElement('caption');
    caption.innerText = year + '년 ' + month + '월';
    table.appendChild(caption);
	show.appendChild(table);

	// 요일 출력 
	const days = ['Sun', 'Mon', 'Tue', 'Wed', 'Thr', 'Fri', 'Sat']
	let thead = document.createElement('thead');
	let tr = document.createElement('tr');
	days.forEach(function(elem) {
		let th = document.createElement('th');
		th.innerText = elem;
		tr.appendChild(th);
	})
	thead.appendChild(tr);
	table.appendChild(thead);

	// 날짜 출력 ()
	let tbody = document.createElement('tbody');

	// 요일지정.
	let spaces = thisMonth.getDay();
    console.log(spaces);
	tr = document.createElement('tr');
	// 빈공간 td.
	for (let d = 0; d < spaces; d++) {
		let td = document.createElement('td');
		td.innerText = '';
		tr.appendChild(td);
	}
	// 날짜 출력.
	thisMonth.setMonth(month);
	thisMonth.setDate(0);
	let end = thisMonth.getDate();
	for (let d = 1; d <= end; d++) {
		let td = document.createElement('td');
		td.innerText = d;
		tr.appendChild(td);
		if ((d + spaces) % 7 == 0) {
            td.style.color = 'blue'
			tbody.appendChild(tr)
			tr = document.createElement('tr');
		} else if ((d + spaces) % 7 == 1) {
			td.style.color = 'red';
		}
	}
	tbody.appendChild(tr);
	table.appendChild(tbody);
}
let p = document.querySelector('#now');
setInterval(()=>{
    let now = new Date();
    p.innerText = now.format();
}, 1000);

Date.prototype.format = function(){
	let yyyy = this.getFullYear();
	let MM = this.getMonth()+1;
	let dd = this.getDate();
	let hh = this.getHours();
	let mm = this.getMinutes();
	let ss = this.getSeconds();
	
	return yyyy + "/" + ("0" + MM).slice(-2) + "/" + ("0" + dd).slice(-2) + " " + ("0" + hh).slice(-2) + ":" + ("0" + mm).slice(-2) + ":" + ("0" + ss).slice(-2);
}
