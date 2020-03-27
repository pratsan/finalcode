/**
 * 
 */
package com.star.onlineshopping.service;

import java.util.List;

import com.star.onlineshopping.dto.ProductsDto;
import com.star.onlineshopping.dto.RateProductDto;
import com.star.onlineshopping.dto.ResponseDto;
import com.star.onlineshopping.exception.ProductException;
import com.star.onlineshopping.exception.RateException;
import com.star.onlineshopping.exception.UserException;

/**
 * @author Prateek
 * @since 2020-03-23
 *
 */
public interface ProductsService  {
	/**
	 * 
	 * @param email
	 * @return List of product detail based on user(normal or priority)
	 * @throws UserException
	 * @throws ProductException
	 */
	public List<ProductsDto> getProductByEmail(String email) throws UserException,ProductException;
  
	/**
	 * 
	 * @param rateProductDto
	 * @return ResponseDto object if product rated successfully
	 * @throws UserException
	 * @throws RateException
	 */
	public ResponseDto rateProduct(RateProductDto rateProductDto)  throws UserException,RateException;
}
