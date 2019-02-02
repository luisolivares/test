package com.example.projectdemo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.projectdemo.bean.ApiErrorResponse;
import com.example.projectdemo.exception.MathOperationException;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {
	
	@ExceptionHandler(MathOperationException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public @ResponseBody ApiErrorResponse handleException(final MathOperationException e,
			final HttpServletRequest request, HttpStatus status) {

		ApiErrorResponse response = new ApiErrorResponse.ApiErrorResponseBuilder()
				.withStatus(status)
				.withErrorCode(status.BAD_REQUEST.name())
				.withPath(request.getRequestURI())
				.withMessage(e.getLocalizedMessage()).build();

		return response;
	}
	
	@ExceptionHandler(NullPointerException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ApiErrorResponse nullPointException(final Exception e,
			final HttpServletRequest request, HttpStatus status) {

		ApiErrorResponse response = new ApiErrorResponse.ApiErrorResponseBuilder()
				.withStatus(status)
				.withErrorCode(status.INTERNAL_SERVER_ERROR.name())
				.withPath(request.getRequestURI())
				.withMessage(e.getLocalizedMessage()).build();

		return response;
	}
	
	
	@ExceptionHandler(NumberFormatException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ApiErrorResponse numberFormatException(final NumberFormatException e,
			final HttpServletRequest request, HttpStatus status) {

		ApiErrorResponse response = new ApiErrorResponse.ApiErrorResponseBuilder()
				.withStatus(status)
				.withErrorCode(status.INTERNAL_SERVER_ERROR.name())
				.withPath(request.getRequestURI())
				.withMessage(e.getLocalizedMessage()).build();

		return response;
	}
	

}
