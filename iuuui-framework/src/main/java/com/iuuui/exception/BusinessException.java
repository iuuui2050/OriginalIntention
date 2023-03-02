package com.iuuui.exception;


import com.iuuui.constants.ExceptionEnum;

public class BusinessException extends RuntimeException {

	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(ExceptionEnum exceptionEnum) {
		super(exceptionEnum.getMessage());
	}

}
