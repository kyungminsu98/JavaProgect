package co.yedam.vo;

import lombok.Data;

@Data
public class ProductVO {
    private String prodCode;
    private String prodName;
    private String prodDesc;
    private int price;
    private Integer salePrice;
    private int likeCnt = 3; // 기본값으로 3 설정
    private String prodImg;

}
