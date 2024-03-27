package com.yedam.java.bookloan;

import java.sql.Date;

public class Bookloan {
	private int loanId;
	private String isbn;
	private String memberId;
	private Date loanDate;
	private Date returnDate;
	
	@Override
	public String toString() {
		return "Bookloan [loanId=" + loanId + ", isbn=" + isbn + ", memberId=" + memberId + ", loanDate=" + loanDate
				+ ", returnDate=" + returnDate + "]";
	}
	
	public int getLoanId() {
		return loanId;
	}
	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public Date getLoanDate() {
		return loanDate;
	}
	public void setLoanDate(Date loanDate) {
		this.loanDate = loanDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

}
