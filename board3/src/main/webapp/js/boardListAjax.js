/**
 * boardListAjax.js
 */
const fileds = ['boardNo', 'title', 'writer', 'createDate'];
const filedTitles = ['번호', '제목', '작성자', '작성일'];
function makeRow(board = {}) {
    let tr = document.createElement('tr');
    fileds.forEach(e => {
        let td = document.createElement('td');
        td.setAttribute('onclick', 'location.href="getBoard.do?bno='+board.boardNo+'"');
        td.setAttribute('style', 'cursor:pointer;');
        td.innerText = board[e] == undefined ? '' : board[e];
        tr.appendChild(td);
    });
    return tr;
}

// list title 그리기
let tbody = document.querySelector('#tbody');
let thead = document.querySelector('#thead');
let tr = document.createElement('tr');
filedTitles.forEach(e =>{
    let th = document.createElement('th');
    th.innerText = e;
    tr.appendChild(th);
});
tbody.appendChild(tr);
// Ajax 호출.
const searchParams = new URLSearchParams(location.search);
let page = searchParams.get('page');
let keyword = searchParams.get('keyword');
let searchCondition = searchParams.get('searchCondition');
if (searchCondition != null && keyword != null){
    console.log(document.querySelector('#searchCondition').options[0])
    let select = document.querySelector('#searchCondition').options;
    for (let i = 0; i < select.length; i++){
        if (select[i].value == searchCondition) select[i].selected = true;
    }
}


const xhtp = new XMLHttpRequest();
let search = 'boardListAjax.do';
search += page == null ? '?page=1' : '?page=' + page;
search += keyword == null ? '' : '&keyword=' + keyword;
search += searchCondition == null ? '' : '&searchCondition=' + searchCondition;

xhtp.open('get', search);
xhtp.send();
xhtp.onload = function () {
    for (e of JSON.parse(xhtp.response)) {
        tbody.appendChild(makeRow(e))
    };
}
// 등록
document.querySelector('#addBtn').addEventListener('click', function(){
    let title = document.querySelector('#title').value;
    let content = document.querySelector('#content').value;
    let writer = document.querySelector('#writer').value;
    if (writer == ''){
        alert('로그인하고 등록해주세요');
        return;
    }
    const addHtp = new XMLHttpRequest();
    let req = 'addBoardAjax.do?';
    req += 'title='+title;
    req += '&content='+content;
    req += '&writer='+writer;
    addHtp.open('get', req);
    addHtp.send();
    addHtp.onload = function(){
        let result = JSON.parse(addHtp.response);
        if (result.retCode == 'Success'){
            alert('추가 성공');
            
            // Ajax 호출. (마음에 안듬)
            tbody.innerHTML='';
            const xhtp = new XMLHttpRequest();
            xhtp.open('get', search);
            xhtp.send();
            xhtp.onload = function () {
                for (e of JSON.parse(xhtp.response)) {
                    tbody.appendChild(makeRow(e));
                };
            }

            // document.getElementById('list').append(makeRow(json));
            document.querySelector('#title').value = '';
            document.querySelector('#content').value = '';
        } else if (result.retCode == 'Fail'){
            alert('추가중 에러');
        } else {
            alert('알 수 없는 코드');
        }
    }
});

// 검색
document.querySelector('#searchBtn').addEventListener('click', () => {
    let searchCondition = document.querySelector('#searchCondition').value;
    let keyword = document.querySelector('#keyword').value;
    location.href='boardFormAjax.do?keyword='+keyword+'&searchCondition='+searchCondition;
});
