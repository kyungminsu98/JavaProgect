/**
 * ajax.js (Asynchronous Javascript And XML)
 */

setTimeout(function(){
	console.log('code 1');
	
	setTimeout(function(){
		console.log('code 2');
		
		setTimeout(function(){
			console.log('code 3');
			
		}, 2000);
		
	}, 3000);
	
}, 1000);

let xhtp = new XMLHttpRequest(); // 비동기 방식 처리 대표 객체
xhtp.open('get', 'js/MOCK_DATA.json'); // 서버의 파일요청.
xhtp.send(); // 처리시작.
xhtp.onload = function(){
	console.log('1');
	//console.log('xhtp :', xhtp.response);
	console.log(JSON.parse(xhtp.response));
}
console.log('2');