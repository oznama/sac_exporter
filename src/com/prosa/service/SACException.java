package com.prosa.service;

public class SACException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1203069631364064864L;

	public SACException() {
		super();
	}
	
	public SACException(String msgError) {
		super(msgError);
	}
	
	public SACException(String msgError, Throwable error) {
		super(msgError, error);
	}

}
