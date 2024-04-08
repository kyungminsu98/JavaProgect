package co.yedam.common;

import lombok.Data;

@Data
public class PageDTO {
	private int page; // 현재 페이지.
	private int startPage, endPage; // ex page : 3, startPage : 1, endPage : 5
	private boolean prev, next; // 이전, 다음 페이지
	
	public PageDTO(int page, int totalCnt) { // 123건 => 5로 나누기
		this.page = page;
		int realEnd = (int)Math.ceil(totalCnt/5.0);
		
		this.endPage = (int)Math.ceil(page/5.0) * 5;
		this.startPage = this.endPage - 4;
		
		this.endPage = this.endPage > realEnd ? realEnd : this.endPage;
		
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
//		this.startPage = this.startPage < 1 ? 1 : this.startPage;
	}
}
