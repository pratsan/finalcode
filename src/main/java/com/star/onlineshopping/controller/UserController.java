/**
 * 
 */
package com.star.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.star.onlineshopping.dto.PurchaseHistoryDto;
import com.star.onlineshopping.dto.ResponseDto;
import com.star.onlineshopping.dto.UserDto;
import com.star.onlineshopping.dto.UserReqDto;
import com.star.onlineshopping.dto.UserResDto;
import com.star.onlineshopping.exception.CredentialMissmatchException;
import com.star.onlineshopping.exception.ProductException;
import com.star.onlineshopping.exception.UserException;
import com.star.onlineshopping.exception.UserExistException;
import com.star.onlineshopping.service.PurchaseHistoryService;
import com.star.onlineshopping.service.UserService;

/**
 * @author User1
 * @since 2020-03-23
 *
 */
@RestController
@RequestMapping("/users")
/**
 * 
 * @author prateek.pal
 * @since 2020-03-23
 *
 */
public class UserController {

	@Autowired
    UserService userService;
	@Autowired
	PurchaseHistoryService purchaseHistoryService;

 /**
  * 
  * @param userReqDto
  * @return ResponseEntity object and contains status message and status code
  * @throws UserExistException
  * @throws CredentialMissmatchException
  */
	@PostMapping("")
	public ResponseEntity<UserResDto> userRegistration(@RequestBody UserReqDto userReqDto) throws UserExistException , CredentialMissmatchException {
		UserResDto userResDto = userService.userRegistration(userReqDto);
		return new ResponseEntity<>(userResDto, HttpStatus.OK);
	}


    /**
     * This method is used to check the login details of the user
     * 
     * @author Manideepika
     * @since 2020-03-23
     * @param emailId  -Here we use emailId to check the username correct or not
     * @param password -Here we use password to check the password correct or not
     * @return ResponseEntity Object along with status code and success login
     *         message
     * 
     */

 
	
    @PostMapping("login")
    public ResponseEntity<ResponseDto> userLogin(@RequestBody UserDto userDto) {
        ResponseDto responseDto = userService.userLogin(userDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
    
    /**
     * 
     * @param purchaseHistoryDto
     * @return ResponseEntity Object along with status code if purchased successfully
     * @throws UserException 
     * @throws ProductException 
     * 
     */
   @PostMapping("buyproduct")
   public ResponseEntity<ResponseDto> buyProduct(@RequestBody PurchaseHistoryDto purchaseHistoryDto) throws UserException, ProductException
   {
	  ResponseDto responseDto= purchaseHistoryService.buyProduct(purchaseHistoryDto);
	return new ResponseEntity<>(responseDto,HttpStatus.ACCEPTED);   
   }
    

 

}

