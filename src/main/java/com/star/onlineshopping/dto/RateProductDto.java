package com.star.onlineshopping.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RateProductDto {
	private long userId;
	private long productId;
	private float rating;

}
