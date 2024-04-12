/**
 * boardService.js
 */

const n1 = 100;
const n2 = 200;

const svc = {
    // 메소드
    replyList(param = {bno:1, page:1}, successCall){ // 매개변수(글번호, 함수)
        let xhtp = new XMLHttpRequest();
        xhtp.open('get', 'replyList.do?bno='+ param.bno + '&page=' + param.page);
        xhtp.send();
        xhtp.onload = () => {
            let result = JSON.parse(xhtp.response);
            successCall(result);
        }
    },
    removeReply(rno = 0, successCall, errorCall){
     //   let xhtp = new XMLHttpRequest();
     //   xhtp.open('get', 'removeReply.do?rno='+ bno);
     //   xhtp.send();
     //  xhtp.onload = () => {
     //       let result = JSON.parse(xhtp.response);
     //      if (result.retCode == 'Success'){
     //           successCall();
     //      } else if (result.retCode == 'Fail'){
     //           errorCall();
     //       } else {
     //           alert('잘못된 접근입니다.');
     //       }
     //   }
     let url = 'replyCount.do?bno=' + bno;
     fetch(url)
     	.then(result=> result.json())
		.then(successCall)
		.catch(err => console.error(err));
    },
    pagigList(bno = 1, successCall){
		let xhtp = new XMLHttpRequest();
		xhtp.open('get', 'replyCount.do?bno=' + bno);
		xhtp.send();
		xhtp.onload = function(){
			let result = JSON.parse(xhtp.response);
            successCall(result);
		}
	},
	// 댓글등록
	addReply(rvo ={bno, reply, replyer}, successCall){
	//	let xhtp = new XMLHttpRequest();
	//	xhtp.open('post', 'addReply.do');
	//	xhtp.setRequestHeader('Content-Type', "application/x-www-form-urlencoded");
	//	xhtp.send('bno='+rvo.bno+'&reply='+rvo.reply+'&replyer='+rvo.replyer);
	//	xhtp.onload = function(){
	//		let result = JSON.parse(xhtp.response);
    //       successCall(result);			
	//	}
		fetch('addReply.do',{
			method:'post',
			headers: {'Content-Type':'application/x-www-form-urlencoded'},
			body: 'bno='+rvo.bno+'&reply='+rvo.reply+'&replyer='+rvo.replyer
		})
			.then(result=> result.json())
			.then(successCall)
			.catch(err => console.error(err));
	}
}

export {svc};