/**
 * array.js
 */

document.querySelector('form').remove();
document.querySelector('#show').innerHTML= '';
document.querySelectorAll('.stringJs').forEach((e)=>e.remove());

const fruits = ['사과'];

fruits.push('수박');
fruits.push('복숭아');
fruits.pop();
fruits.unshift("포도");
fruits.shift();

fruits.splice(1, 0, '참외');
fruits.splice(1, 1);

console.log(fruits)

const members = [{name:"홍길동", age: 20}];
members.push({name:"김길동", age: 21});
members.push({name:"박길동", age:22});

// forEach 반환 -> undefined
members.forEach(e => {
	console.log(e);
});

// filter 반환 -> 배열반환
let result = members.filter(e => e.age > 20);

// map : A -> A'
result = members.map(e => {
    let obj = {}
    obj.fullName = e.name;
    obj.age = e.age;
    obj.point = 100;
    return obj;
});

result = [10, 20, 30, 40].reduce((acc, ele, idx, ary) => {
    console.log(acc, ele, idx, ary);
    return idx == ary.length-1 ? (acc+ele)/ary.length: ( acc + ele );
}, 0);

console.log(result);

let ul = document.createElement('ul');
document.getElementById('show').appendChild(ul);
members.reduce((acc, ele) => {
    let li = document.createElement('li');
    li.innerHTML = '이름 : ' + ele.name + ', 나이 : ' + ele.age;
    acc.appendChild(li);
    return acc;
}, ul);