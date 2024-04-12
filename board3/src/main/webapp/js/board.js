/**
 * board.js
 */
import {svc} from './boardService.js';
let ul = document.querySelector('.content ul');

const params = new URLSearchParams(location.search);
let bno = params.get('bno');
let page = params.get('rpage')==null? 1:params.get('rpage');
svc.replyList({bno, page}, rlf2);

function rlf1(result){
    result.forEach(e => {
        let li = document.createElement('li');
        li.className = 'list-group-item'
        let span = document.createElement('span');
        span.className = 'col-sm-2';
        span.innerText = e.replyNo;
        li.appendChild(span);

        span = document.createElement('span');
        span.className = 'col-sm-6';
        span.innerText = e.reply;
        li.appendChild(span);

        span = document.createElement('span');
        span.className = 'col-sm-2';
        span.innerText = e.replyer;

        li.appendChild(span);
        let btn = document.createElement('button');
        btn.className = 'btn btn-danger btn-sm';
        btn.innerText='삭제';
        li.appendChild(btn);

        ul.appendChild(li);
    });
}
function rlf2(result){
    console.log(result);
    document.querySelectorAll('.content ul li:not(:first-child)[style="display: block;"]').forEach(e => e.remove());
    result.forEach(e => {
        let template = document.querySelector('.content>ul>li:nth-of-type(2)').cloneNode(true);
        template.querySelector('span:nth-of-type(1)').innerText = e.replyNo;
        template.querySelector('span:nth-of-type(2)').innerText = e.reply;
        template.querySelector('span:nth-of-type(3)').innerText = e.replyer;
        template.querySelector('button').addEventListener('click', ()=>{
            svc.removeReply(e.replyNo, ()=>template.remove(), ()=>alert('삭제실패'));
        });
        template.style.display = 'block';
        ul.appendChild(template);
    });
    // pagig 생성
    svc.pagigList(bno, createPageList);
}

// pagenation
let pagenation = document.querySelectorAll('.pagenation > a').forEach(item => {
    item.addEventListener('click', (e)=>{
        e.preventDefault();
        
        svc.replyList({bno, page:item.innerText}, rlf2);
    });
});

let pageTarget = document.querySelector('div.pagenation')

function createPageList(result){
	// 기존 태그가 존재하면 초기화
	pageTarget.innerHTML = '';
	
	console.log(result);
	let totalCnt = result.totalCount; // 64
	let startPage, endPage; // 시작페이지, 마지막페이지
	let next, prev; // 이전, 이후
	let realEnd = Math.ceil(totalCnt / 5);
	
	endPage = Math.ceil(page / 5) * 5; 
	startPage = endPage - 4;
	endPage = endPage > realEnd ? realEnd : endPage;
	next = endPage < realEnd ? true : false;
	prev = startPage > 1;
	
// a 태그 생성
if(prev){
	let aTag = document.createElement('a');
	aTag.innerHTML = '&laquo;'
	aTag.href = "#";
	aTag.setAttribute('data-page', (startPage - 1));
	pageTarget.appendChild(aTag);	
}
for(let pg = startPage; pg <= endPage; pg++){
	let aTag = document.createElement('a');
	aTag.innerHTML = pg;
	aTag.href = "#";
	aTag.setAttribute('data-page', pg);
	pageTarget.appendChild(aTag);
	if(pg == page){
		aTag.className = 'active';
	}
}
if(next){
	let aTag = document.createElement('a');
	aTag.innerHTML = '&raquo;'
	aTag.href = "#";
	aTag.setAttribute('data-page', (endPage + 1));
	pageTarget.appendChild(aTag);	
}
// pagination 이동 event
document.querySelectorAll('.pagenation > a').forEach(item => {
    item.addEventListener('click', function(e) {
        e.preventDefault();
        console.log(item.dataset.page);
        page = item.dataset.page;
        svc.replyList({bno, page}, rlf2);
        })
    })
}
// 등록버튼
document.getElementById('addReply').addEventListener('click', function(e){
	if(!logId){
		alert("로그인 하세요");
		return;
	}
	let reply = document.getElementById('reply').value;
	if(!reply){
		alert('댓글을 입력하세요');
		return;
	}
	let rvo = {
		bno: bno, replyer: logId, reply: reply
	}
	
	svc.addReply(rvo, function(result){
		if(result.retCode == 'Success'){
			svc.replyList({bno, page}, replyListFnc2);
		}else{
			alert('처리중 에러 발생');
		}
	});
	document.getElementById('reply').value = '';
});


