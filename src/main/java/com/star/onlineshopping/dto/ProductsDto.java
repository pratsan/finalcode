package com.star.onlineshopping.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductsDto {

	private String name;

	private String description;

	private Double price;

	private String productCode;

	private String type;
}
