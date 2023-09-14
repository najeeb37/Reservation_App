package org.jsp.reservationapi.exception;

public class InvalidCredentialsException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "Invalid phone or email or password";
	}

	
}
