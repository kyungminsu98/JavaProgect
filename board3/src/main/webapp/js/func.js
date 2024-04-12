/**
 * func.js 
 */
const data = ['Apple', 'Banana', 'Cherry'];

const show = document.querySelector('#show');
show.innerHTML = '';

// 화살표 함수
let ul = document.createElement('ul');
ul.setAttribute('style','list-style:none; padding:0');
data.forEach((e, i) => {
	let li = document.createElement('li');
	li.innerText=e;
	let btn = document.createElement('button');
	btn.innerText='삭제';
	btn.addEventListener('click', () => {
		alert(e + '을(를) 삭제하겠습니다.');
		btn.parentElement.remove();
	}); // 이벤트 유형, 이벤트 핸들러.
	li.addEventListener('mouseover', ()=>{
		li.style.backgroundColor = 'red';
	});
	li.addEventListener('mouseout', ()=>{
		li.style.backgroundColor = '';
	});
	li.appendChild(btn);
	
	ul.appendChild(li);
});
show.appendChild(ul);
console.log(data);