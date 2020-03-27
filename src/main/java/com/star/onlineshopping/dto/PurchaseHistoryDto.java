package com.star.onlineshopping.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PurchaseHistoryDto {
	
	private long userId;
	private List<UserProdoctDto> userProductDto;
	

}
