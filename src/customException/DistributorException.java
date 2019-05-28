package customException;
@SuppressWarnings("serial")
public class DistributorException extends Exception{
	public final static String NOT_FOUND_DISTRIBUTOR= "NOT_FOUND_DISTRIBUTOR";
	/*
	 * This attribute contains the custom message of the custom exception
	 */
	private String customMessage;
	/*
	 * This attribute is for kwon the type of exception
	 */
	private String typeOfOut;
	/*
	 * This attribute is change the super of the exception
	 * 
	 */
	public DistributorException() {
		super("this distributor is not here");
	
		customMessage = "The size is "+typeOfOut;
	}
	
	@Override
	public String getMessage() {
		String msg;
		msg = super.getMessage() + customMessage;
		return msg;
	}

}
