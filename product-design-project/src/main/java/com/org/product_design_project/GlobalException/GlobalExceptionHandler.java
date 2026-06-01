package com.org.product_design_project.GlobalException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.org.product_design_project.ResponseStructure.ResponseStructure;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ResponseStructure<String>> handleException(RuntimeException ex) {

		ResponseStructure<String> rs = new ResponseStructure<>();

		rs.setStatuscode(HttpStatus.BAD_REQUEST.value());
		rs.setMessage(ex.getMessage());
		rs.setData(null);

		return new ResponseEntity<>(rs, HttpStatus.BAD_REQUEST);
	}

}
