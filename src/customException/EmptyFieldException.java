package customException;

@SuppressWarnings("serial")
public class EmptyFieldException extends Exception{
	
	private String customMessage;
	
	public EmptyFieldException(String field) {
		super("El campo " + field + " está vacio. Para continuar todos los campos deben estar llenados. ");
	}
	
	public EmptyFieldException(String field, String customMessage) {
		super("El campo " + field + " está vacio. Para continuar todos los campos deben estar llenados. ");
		this.customMessage = customMessage;
	}
	
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
