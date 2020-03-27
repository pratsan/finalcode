/**
 * 
 */
package com.star.onlineshopping.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.star.onlineshopping.utility.ErrorConstant;

/**
 * @author User1
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	

	@ExceptionHandler(ProductException.class)
	public ResponseEntity<ErrorResponse> error(ProductException ex) {

		ErrorResponse er = new ErrorResponse();
		er.setMessage(ex.getMessage());
		er.setStatus(ErrorConstant.NO_RECORD_FOUND_CODE);
		return new ResponseEntity<>(er, HttpStatus.NOT_FOUND);

	}
	
	
	
	@ExceptionHandler(UserException.class)
	public ResponseEntity<ErrorResponse> error(UserException ex) {

		ErrorResponse er = new ErrorResponse();
		er.setMessage(ex.getMessage());
		er.setStatus(ErrorConstant.NO_EMAIL_FOUND_CODE);
		return new ResponseEntity<>(er,HttpStatus.NOT_FOUND);

	}
	
	
	

	
	@ExceptionHandler(UserExistException.class)
	public ResponseEntity<ErrorResponse> error(UserExistException ex) {

		ErrorResponse er = new ErrorResponse();
		er.setMessage(ex.getMessage());
		er.setStatus(ErrorConstant.USER_EXIST_CODE);
		return new ResponseEntity<>(er, HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(CredentialMissmatchException.class)
	public ResponseEntity<ErrorResponse> error(CredentialMissmatchException ex) {

		ErrorResponse er = new ErrorResponse();
		er.setMessage(ex.getMessage());
		er.setStatus(ErrorConstant.CREDENTIAL_MISSMATCH_CODE);
		return new ResponseEntity<>(er, HttpStatus.NOT_FOUND);

	}
	
	
	
	@ExceptionHandler(RateException.class)
	public ResponseEntity<ErrorResponse> error(RateException ex) {

		ErrorResponse er = new ErrorResponse();
		er.setMessage(ex.getMessage());
		er.setStatus(ErrorConstant.BUY_ERROR_CODE);
		return new ResponseEntity<>(er, HttpStatus.NOT_FOUND);

	}
	
	

	
}
