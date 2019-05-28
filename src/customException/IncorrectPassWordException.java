package customException;

import model.Manager;

@SuppressWarnings("serial")
public class IncorrectPassWordException extends Exception{
	public final static String INCORRECT_PASSWORD= "INCORRECT_PASSWORD";
	public final static String WRONG_FORMAT= "WRONG_FORMAT";
	/*
	 * This attribute contains the custom message of the custom exception
	 */
	private String customMessage;
	/*
	 * This attribute is for know the type of exception
	 */
	private String typeOfOut;
	/*
	 * the builder of the DistributorException class
	 * 
	 */
	public IncorrectPassWordException(Manager manager) {
		super("the passWord is incorrect");
		boolean flag = manager.passWordCheck();
		if(flag == false){
			customMessage = WRONG_FORMAT;
		}else {
			customMessage = typeOfOut;
		}
	}
	
	/*
	 * This attribute is change the super of the exception
	 * 
	 */
	@Override
	public String getMessage() {
		String msg;
		msg = super.getMessage() + customMessage;
		return msg;
	}

}