
// 숫자 3자리 콤마찍기
Number.prototype.formatNumber = function() {
	if (this == 0)
		return 0;
	let regex = /(^[+-]?\d+)(\d{3})/;
	let nstr = (this + '');
	while (regex.test(nstr)) {
		nstr = nstr.replace(regex, '$1' + ',' + '$2');
	}
	return nstr;
};

let basket = {
	cartCount: 0, // 전체수량.
	cartTotal: 0, // 전체금액.

	list: function() {
		// 목록.
		svc.cartList(function(result) {

			result.forEach(cart => {
				basket.cartCount += cart.qty;
				basket.cartTotal += (cart.qty * cart.price);

				const rowDiv = document.querySelector('div[data-id="0"]').cloneNode(true);
				rowDiv.style.display = 'block';

				rowDiv.setAttribute('data-id', cart.no);
				rowDiv.querySelector('img').setAttribute('src', 'image/' + cart.productNm + '.jpg');
				rowDiv.querySelector('div.pname span').innerText = cart.productNm;
				rowDiv.querySelector('div.basketprice').childNodes[2].textContent = cart.price;
				rowDiv.querySelector('div.basketprice input[name="p_price"]').value = cart.price;
				rowDiv.querySelector('div.updown input[name="p_num1"]').value = cart.qty;

				rowDiv.querySelector('div.updown input').onkeyup = () => basket.changePNum(cart.no);
				rowDiv.querySelector('div.updown span').onclick = () => basket.changePNum(cart.no);
				rowDiv.querySelector('div.updown span:nth-of-type(2)').onclick = () => basket.changePNum(cart.no);

				rowDiv.querySelector('div.sum').textContent = (cart.qty * cart.price) + "원";

				document.querySelector('#basket').append(rowDiv);
			})
			basket.reCalc();

		}, function(err) {
			console.error(err)
		})
	},

	delItem: function() {
	},

	reCalc: function() {
		//수량, 금액 합계 계산
		//합계 자리에 출력
		var cartTotal = 0;
		var cartCount = 0;

		document.querySelectorAll('#basket>div.data').forEach(function(item) {
			if (item.querySelector('input[type="checkbox"]').checked) {
				checkCnt = item.querySelector('div.num input[name="p_num' + item.dataset.id + '"]');
				if (checkCnt) {

					checkItem = item.querySelector('div.sum');

					var strToNum = checkItem.textContent.replace(/,/g, '');
					var strToCnt = checkCnt.value;

					cartTotal += parseInt(strToNum);
					cartCount += parseInt(strToCnt);
				}
			}
		})

		document.querySelector('#sum_p_num>span').textContent = (cartCount).formatNumber();
		document.querySelector('#sum_p_price>span').textContent = (cartTotal).formatNumber();

	},

	changePNum: function(no) {
		let qty = 0;
		let sumElemement = event.currentTarget.parentElement.parentElement.nextElementSibling;
		let qtyElement;

		if (event.target.nodeName == "I") {
			if (event.target.className.indexOf('up') != -1) {
				qtyElement = event.currentTarget.previousElementSibling;
				qty = 1;
			} else {
				qtyElement = event.currentTarget.previousElementSibling.previousElementSibling;
				qty = -1;
			}
		} else if (event.target.nodeName == "INPUT") {
			qtyElement = event.currentTarget;
			if (event.key == 'ArrowUp') {
				qty = 1;
			} else {
				qty = -1;
			}
		}
		console.log(qtyElement, sumElemement, 'no: ', no, ', qty: ', qty);

		let cvo = { no, qty }
		svc.cartUpdate(cvo,
			() => {
				//수량, 금액변경.
				qtyElement.value = parseInt(qtyElement.value) + qty;
				sumElemement = 0;
				basket.reCalc();
			},
			() => alert('error'))
	},

	delCheckedItem: function() {
	},

	delAllItem: function() {
	},
};

basket.list();
