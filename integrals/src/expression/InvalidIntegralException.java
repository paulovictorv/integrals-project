package expression;


public class InvalidIntegralException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1314854734887608492L;

	public InvalidIntegralException(String message){
		super(message);
	}

	public InvalidIntegralException(Exception e) {
		super(e);
	}
	
}
