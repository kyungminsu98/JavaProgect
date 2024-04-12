/**
 * service.js
 */
const fileds = ['memberId', 'memberPw', 'memberNm', 'phone'];
function makeRow(member = {}){
    let tr = document.createElement('tr');
    let td = document.createElement('td');
    fileds.forEach(e => {
        td = document.createElement('td');
        td.innerText = member[e] == undefined ? '' : member[e];
        tr.appendChild(td);
    });

    // 삭제버튼
    td = document.createElement('td');
    let button = document.createElement('button');
    button.innerText = '삭제';
    button.className = 'btn';
    button.classList.add('btn-danger');
    button.addEventListener('click', ()=>{
        const delHtp = new XMLHttpRequest();
        delHtp.open('get', 'removeMember.do?mid=' + member.memberId);
        delHtp.send();
        delHtp.onload = function() {
            let result = JSON.parse(delHtp.response);
            if (result.retCode == 'Success'){
                alert('삭제 성공');
                tr.remove();
            } else if (result.retCode == 'Fail'){
                alert('삭제중 에러');
            } else {
                alert('알 수 없는 코드');
            }
        }
    });
    td.appendChild(button);
    tr.appendChild(td);
    return tr;
}

let tbody = document.querySelector('#list');

// Ajax 호출.
const xhtp = new XMLHttpRequest();
xhtp.open('get', 'memberAjax.do');
xhtp.send();
xhtp.onload = function() {
    for (e of JSON.parse(xhtp.response)){
        console.log(e);
        tbody.appendChild(makeRow(e))
    };
}

document.querySelector('#addBtn').addEventListener('click', function(){
    let mid = document.querySelector('#mid').value;
    let mpw = document.querySelector('#mpw').value;
    let mnm = document.querySelector('#name').value;
    let phn = document.querySelector('#phone').value;
    const addHtp = new XMLHttpRequest();
    let req = 'addMemberAjax.do?';
    req += 'mid='+mid;
    req += '&pass='+mpw;
    req += '&name='+mnm;
    req += '&phone='+phn;
    addHtp.open('get', req);
    addHtp.send();
    addHtp.onload = function(){
        let result = JSON.parse(addHtp.response);
        if (result.retCode == 'Success'){
            alert('추가 성공');
            let json = {'memberId':mid, 'memberPw':mpw, 'memberNm':mnm, 'phone':phn};
            document.getElementById('list').append(makeRow(json));
            document.querySelector('#mid').value = '';
            document.querySelector('#mpw').value = '';
            document.querySelector('#name').value = '';
            document.querySelector('#phone').value = '';
            // location.reload();
        } else if (result.retCode == 'Fail'){
            alert('추가중 에러');
        } else {
            alert('알 수 없는 코드');
        }
    }
});