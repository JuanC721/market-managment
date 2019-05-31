package customException;

import model.Distributor;

@SuppressWarnings("serial")

public class CantAddException extends Exception{
	
	public final static String DISTRIBUTOR_EXCEPTION = "DISTRIBUTOR_EXCEPTION";
	public final static String NAME_EXCEPTION = "NAME_EXCEPTION";
	public final static String CODE_EXCEPTION = "CODE_EXCEPTION";
	public final static String MANAGER_EXCEPTION = "MANAGER_EXCEPTION";
	public final static String PRODUCTS_EXCEPTION = "PRODUCTS_EXCEPTION";
	
	/**
	 * This attribute contains the custom message of the custom exception
	 */
	private String customMessage;
	/**
	 * This attribute is for know the type of exception
	 */
	private String typeOfOut;
	/**
	 * this is the builder of the CantAddException class
	 * @param a object type Distributor. newOne != null
	 */
	public CantAddException(Distributor newOne) {
		super("cant add the new Distributos");
		checking(newOne);
		customMessage = ""+typeOfOut;
	}
	/**
	 * this method if the a new Distributor is correctly created
	 * @param newOne != null.
	 */
	public void checking(Distributor newOne) {
		if(newOne.getCompanyName() != null){
			customMessage = NAME_EXCEPTION; 
		}
		if(newOne.getCode() != null) {
			customMessage = CODE_EXCEPTION;
		}
		if(newOne.getDistributorManagerName() != null){
			customMessage = MANAGER_EXCEPTION;
		}if(newOne.getProductsToShow() != null){
			customMessage = PRODUCTS_EXCEPTION;
		}
	}
	/**
	 * This attribute is change the super of the exception
	 */
	@Override
	public String getMessage(){
		String msg;
		msg = super.getMessage() + customMessage;
		return msg;
	}
}
