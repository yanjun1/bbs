package cn.edu.qtech.business.common;

public class BusinessException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BusinessException(String message, Throwable t){
		super(message,t);
	}
	
	public BusinessException(Throwable t){
		super(t);
	}
	
	public BusinessException(String message){
		super(message);
	}
}
