/**
 * 
 */
package com.star.onlineshopping.service;

import com.star.onlineshopping.dto.ResponseDto;
import com.star.onlineshopping.dto.UserDto;
import com.star.onlineshopping.dto.UserReqDto;
import com.star.onlineshopping.dto.UserResDto;
import com.star.onlineshopping.exception.CredentialMissmatchException;
import com.star.onlineshopping.exception.UserExistException;

/**
 * @author User1
 *
 */
public interface UserService {
	/**
	 * 
	 * @param userDto
	 * @return ResponseDto object if user logged in successfully or not with status code and message
	 */
	
	public ResponseDto userLogin(UserDto userDto);
	/**
	 * 
	 * @param userReqDto
	 * @return UserDto object whether user registered successfully or not with status code and message
	 * @throws UserExistException
	 * @throws CredentialMissmatchException
	 */
	public UserResDto userRegistration(UserReqDto userReqDto) throws UserExistException,CredentialMissmatchException;

}
