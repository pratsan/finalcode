/**
 * 
 */
package com.star.onlineshopping.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Jyoti
 *
 */
@Setter
@Getter
public class UserReqDto {

	private String name;
	private String phoneNumber;
	private String email;
	private String userType;
	private String password;
	private String confirmPassword;

	
}
