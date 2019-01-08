package com.acn.masg.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.acn.masg.exception.MasgUserNotFoundException;
import com.acn.masg.util.CommonError;

@ControllerAdvice
@RestController
public class APIExceptionHub {

	@ExceptionHandler(MasgUserNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public CommonError MasgUserNotFound(MasgUserNotFoundException exception) {
		String msg;
		
		msg = "User \"" + exception.getMasgUser().getUsername() + "\" Not Found / Password Error!";
		
		return new CommonError(0, msg);
	}
}
