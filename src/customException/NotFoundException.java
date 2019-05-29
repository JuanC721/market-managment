package customException;


@SuppressWarnings("serial")
public class NotFoundException extends Exception{



	public final static String NOT_FOUND_EXCEPTION = "NOT_FOUND_EXCEPTION";
	/**
	 ** This attribute contains the custom message of the custom exception
	 **/
	private String customMessage;
	/**
	 ** This attribute is for know the type of exception
	 **/
	private String typeOfOut;
	
	/**
	 ** this is the builder of the NotFoundException class
	 **/
	public NotFoundException() {
		super("The Product is not in the List");
	
		customMessage = "The size is "+typeOfOut;
	}
	/**
	 ** This attribute is change the super of the exception
	 ** 
	 **/

	@Override
	public String getMessage(){
		String msg;
		msg = super.getMessage() + customMessage;
		return msg;
	}
}