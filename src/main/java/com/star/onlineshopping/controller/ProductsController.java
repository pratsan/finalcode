package com.star.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.star.onlineshopping.dto.ProductsDto;
import com.star.onlineshopping.dto.RateProductDto;
import com.star.onlineshopping.dto.ResponseDto;
import com.star.onlineshopping.exception.ProductException;
import com.star.onlineshopping.exception.RateException;
import com.star.onlineshopping.exception.UserException;
import com.star.onlineshopping.service.ProductsService;

/**
 * @author Prateek
 * @since 2020-03-23
 *
 */
@RestController
@RequestMapping("products")
public class ProductsController {
	@Autowired
	ProductsService productService;

	/**
	 * 
	 * @param email
	 * @return ResponseEntity object if product is found for particular user
	 * @throws UserException
	 * @throws ProductException
	 */
	@GetMapping("/{emailId}")
	public ResponseEntity<List<ProductsDto>> getProductByEmail(@PathVariable("emailId") String email)
			throws UserException, ProductException {
		List<ProductsDto> productList = productService.getProductByEmail(email);
		return new ResponseEntity<>(productList, HttpStatus.ACCEPTED);
	}

	/**
	 * 
	 * @param rateProductDto
	 * @return ResponseEntity object if user rated successfully
	 * @throws UserException
	 * @throws RateException
	 */
	@PostMapping("/rating")
	public ResponseEntity<ResponseDto> rateProduct(@RequestBody RateProductDto rateProductDto)
			throws UserException, RateException {
		ResponseDto responseDto = productService.rateProduct(rateProductDto);
		return new ResponseEntity<>(responseDto, HttpStatus.ACCEPTED);
	}

}
