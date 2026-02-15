package com.hackerrank.restcontrolleradvice.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.hackerrank.restcontrolleradvice.dto.BuzzException;
import com.hackerrank.restcontrolleradvice.dto.FizzBuzzException;
import com.hackerrank.restcontrolleradvice.dto.FizzException;
import com.hackerrank.restcontrolleradvice.dto.GlobalError;

@RestControllerAdvice
public class FizzBuzzExceptionHandler extends ResponseEntityExceptionHandler {

  //TODO:: implement handler methods for FizzException, BuzzException and FizzBuzzException
	@ExceptionHandler(BuzzException.class)
	public ResponseEntity<GlobalError> hanleBuzzException(BuzzException ex){
		GlobalError er= new GlobalError(ex.getMessage(),ex.getErrorReason());
		return ResponseEntity.status(400).body(er);
	}
	
	@ExceptionHandler(FizzException.class)
	public ResponseEntity<GlobalError> hanleFizzException(FizzException ex){
		GlobalError er= new GlobalError(ex.getMessage(),ex.getErrorReason());
		return ResponseEntity.status(500).body(er);
	}
	
	@ExceptionHandler(FizzBuzzException.class)
	public ResponseEntity<GlobalError> hanleFizzBuzzException(FizzBuzzException ex){
		GlobalError er= new GlobalError(ex.getMessage(),ex.getErrorReason());
		return ResponseEntity.status(507).body(er);
	}
	
}
