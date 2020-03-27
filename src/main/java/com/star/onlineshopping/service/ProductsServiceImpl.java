/**
 * 
 */
package com.star.onlineshopping.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.star.onlineshopping.dto.ProductsDto;
import com.star.onlineshopping.dto.RateProductDto;
import com.star.onlineshopping.dto.ResponseDto;
import com.star.onlineshopping.entity.Products;
import com.star.onlineshopping.entity.PurchaseHistory;
import com.star.onlineshopping.entity.User;
import com.star.onlineshopping.exception.ProductException;
import com.star.onlineshopping.exception.RateException;
import com.star.onlineshopping.exception.UserException;
import com.star.onlineshopping.respository.ProductsRepository;
import com.star.onlineshopping.respository.PurchaseHistoryRepository;
import com.star.onlineshopping.respository.UserRepository;
import com.star.onlineshopping.utility.ErrorConstant;

/**
 * @author User1
 *
 */
@Service
public class ProductsServiceImpl implements ProductsService {
	@Autowired
	ProductsRepository productRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	PurchaseHistoryRepository purchaseHistoryRepository;

	/**
	 * 
	 * @param email
	 * @return List of product detail based on user(normal or priority)
	 * @throws UserException
	 * @throws ProductException
	 */
	@Override
	public List<ProductsDto> getProductByEmail(String email) throws UserException, ProductException {

		Optional<User> user = userRepository.findByEmail(email);

		if (!user.isPresent()) {
			throw new UserException(ErrorConstant.NO_EMAIL_FOUND);
		}

		if (user.get().getUserType().equals("priority")) {
			List<Products> productList = productRepository.findAll();

			List<ProductsDto> productsDtos = productList.stream().map(product -> {
				ProductsDto dto = new ProductsDto();
				BeanUtils.copyProperties(product, dto);
				return dto;
			}).collect(Collectors.toList());
			if (productsDtos.isEmpty())
				throw new ProductException(ErrorConstant.NO_RECORD_FOUND);
			else
				return productsDtos;
		} else {
			List<Products> productList = productRepository.findByType(user.get().getUserType());
			if (productList.isEmpty())
				throw new ProductException(ErrorConstant.NO_RECORD_FOUND);
			else {
				List<ProductsDto> productsDtos = productList.stream().map(product -> {
					ProductsDto dto = new ProductsDto();
					BeanUtils.copyProperties(product, dto);
					return dto;
				}).collect(Collectors.toList());
				return productsDtos;
			}

		}

	}

	/**
	 * 
	 * @param rateProductDto
	 * @return ResponseDto object if product rated successfully
	 * @throws UserException
	 * @throws RateException
	 */
	@Override
	public ResponseDto rateProduct(RateProductDto rateProductDto) throws UserException, RateException {

		Optional<User> user = userRepository.findById(rateProductDto.getUserId());
		Optional<Products> product = productRepository.findById(rateProductDto.getProductId());
		ResponseDto responseDto = null;
		if (!user.isPresent())
			throw new UserException(ErrorConstant.NO_EMAIL_FOUND);
		else if (!product.isPresent()) {
			throw new UserException(ErrorConstant.NO_RECORD_FOUND);
		} else if (user.get().getBuyProduct().isEmpty()) {
			throw new RateException(ErrorConstant.BUY_ERROR);
		} else {
			float rating = product.get().getRating();

			float userRating = rateProductDto.getRating();

			List<PurchaseHistory> purchaseHistories = user.get().getBuyProduct();
			for (PurchaseHistory purchaseHistory : purchaseHistories) {
				purchaseHistory.setRating(userRating);
				purchaseHistoryRepository.save(purchaseHistory);
			}

			float total = (rating + userRating) / 2;
			
			product.get().setRating(total);
			productRepository.save(product.get());
			responseDto = new ResponseDto();
			responseDto.setStatusMessage(ErrorConstant.RATE_SUCCESS);
			responseDto.setStatusCode(ErrorConstant.RATE_SUCCESS_CODE);

		}

		return responseDto;
	}

}
