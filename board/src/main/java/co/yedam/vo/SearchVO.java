package co.yedam.vo;

import lombok.Data;

@Data
public class SearchVO {
	// page, searchCondition, keyword
	private int page;
	private String searchCondition;
	private String keyword;
}
