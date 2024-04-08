/**
 * string.js
 */
document.querySelector('form').remove();
document.getElementById('show').innerHTML='';

let str1= new String('hello');
console.log(typeof str1);

let str2 = 'hello';
console.log(str2.trim().toUpperCase().slice(-2)); // slice(-2) 뒤에서 두번쨰 글자 toUpperCase() 대문자변환 trim() 양쪽공백제거

let str3 = 'hello,nice,kind';
console.log(str3.indexOf('nice')); // ()문자열 찾는것

let str4 = str3.replace('hello','안녕'); // replace('hello','안녕') str3의 hello를 안녕으로 변환
console.log(str3, str4);

let str3Ary = str3.split(","); // split(",")  배열변환
console.log(str3Ary);
str3.charAt(0); // 위치의 인덱스에 해당하는 문자반환.

// 성별을 구별하는 함수.
function checkGender(sso = '031005-4234567'){
    //let genChar = sso.trim().slice(-7).charAt(0);
   // switch(genChar){
		//case'1':
		//case'2': console.log("남자"); break;
		//case'3':
		//case'4': console.log("여자");
//	}
	// 1,3 남자변환
	// 2,4 여자변환
	let genChar = sso.replace('-','').replace(' ','');
	console.log(genChar);
    switch(genChar.charAt(6)){
		case'1':
		case'2': console.log("남자"); break;
		case'3':
		case'4': console.log("여자");
	}

}
let numbers = ['990102-2345678', '010204-3123456', '0303044123456', '970304 1123456'];
numbers.forEach(elem => checkGender(elem));
console.clear();


// Date객체
//const today = new Date(); //실행 시점의 시스템 시간
console.log(today);
today.setFullYear(2020);
today.setMonth(4); // 
today.setDate(0);

console.log('말일:', today.getDate());

console.log(today.getFullYear()); // 년도
console.log(today.getMonth()+1); // 월(0부터 시작)
console.log(today.getDate()); // 날짜
console.log(today.getHours()); // 시
console.log(today.getMinutes()); // 분
console.log(today.getSeconds()); // 초
console.log(today.getDay()); // 요일 (0 ~ 6).

const today = new Date(); // 실행 시점의 시스템 시간.

// 년 월을 지정해서 달력 출력
document.getElementById('calBtn').addEventListener('click', function(e){
    const year = document.getElementById('year').value;
    const month = document.getElementById('month').value;
    createCalendar(year, month);
});

// 출력 위치 지정
const show = document.querySelector('#show');

function createCalendar(year = 2024, month = 4){
    show.innerHTML = "<h3>"+year+"년 "+month+"월"+"</h3>";
    
    const thisMonth = new Date(year, month-1, 1);
    console.log(thisMonth);
    // 테이블 생성
    let table = document.createElement('table');
    table.className = 'table';
    show.appendChild(table);
    // 요일 출력 
    const days = ['일', '월', '화', '수', '목', '금', '토'];
    let thead = document.createElement('thead');
    let tr = document.createElement('tr');
    days.forEach(function(elem){
        let th = document.createElement('th');
        th.innerText = elem;
        tr.appendChild(th);
    });
    thead.appendChild(tr);
    table.appendChild(thead);

    let tbody = document.createElement('tbody');
    let spaces = thisMonth.getDay();
    // 빈 날짜 채우기
    tr = document.createElement('tr');
    for (let d = 0; d < spaces; d++){
        const td = document.createElement('td');
        td.innerText = '';
        tr.appendChild(td);
    }
    
    let thisMonthEnd = new Date(year, month, 0).getDate();
    for(let d = 1; d <= thisMonthEnd; d++){
        let td = document.createElement('td');
        td.innerText = d;
        tr.appendChild(td);
        if ((d + spaces) % 7 === 0 || (d + spaces) % 7 === 1){
            td.style.background = 'red';
            td.style.color = 'yellow';
        }
        if ((d + spaces) % 7 === 0){
            tbody.appendChild(tr);
            tr = document.createElement('tr');    
        }
    }
    tbody.appendChild(tr);
    
    table.appendChild(tbody);
}


// timer.
let timer = document.getElementById('timer');
// setInterval (함수, 시간간격)
setInterval(function(){
	let now = new Date();
	timer.innerHTML = now.format();
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