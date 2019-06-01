package customException;


@SuppressWarnings("serial")
public class IncorrectPassWordException extends Exception{
	public final static String INCORRECT_INPUT= "Contrase�a Incorrecta";
	public final static String WRONG_FORMAT= "Formato Equivocado";
	/**
	 ** This attribute contains the custom message of the custom exception
	 **/
	private String customMessage;
	
	/**
	 ** the builder of the DistributorException class
	 * @throws IncorrectPassWordException 
	 ** 
	 **/
	public IncorrectPassWordException(String type) throws IncorrectPassWordException {	
		super(type);
		if(type.equals(WRONG_FORMAT)){
			customMessage=  "\n\nLa Contrase�a es alfanumerica y debe contener al menos un numero. ";
		}else if(type.equals(INCORRECT_INPUT)){
			customMessage = "\n\nLa contrase�a ingresada es incorrecta.";
		}
	}
	/**
	/**
	 ** This attribute is change the super of the exception
	 ** 
	 **/
	@Override
	public String getMessage() {
		String msg;
		if(customMessage == null) {
			msg = super.getMessage();
		}else {
			msg = super.getMessage() + customMessage;
		}
		return msg;
	}

}