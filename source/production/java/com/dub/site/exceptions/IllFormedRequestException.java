package com.dub.site.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IllFormedRequestException extends RuntimeException
{
	private String param;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public IllFormedRequestException(String param) {
		this.param = param;	
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}
	
	

}
