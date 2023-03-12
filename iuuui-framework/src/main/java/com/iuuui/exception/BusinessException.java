package com.iuuui.exception;


import com.iuuui.constants.ExceptionEnum;

public class BusinessException extends RuntimeException {

	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(ExceptionEnum exceptionEnum) {
		super(exceptionEnum.getMessage());
	}

	public BusinessException(ExceptionEnum exceptionEnum, Object... args) {
		super(wrap(exceptionEnum, args));
	}

	private static String wrap(ExceptionEnum exceptionEnum, Object... args) {
		String msg = exceptionEnum.getMessageArgs();
		return String.format(msg, args);
	}

}
