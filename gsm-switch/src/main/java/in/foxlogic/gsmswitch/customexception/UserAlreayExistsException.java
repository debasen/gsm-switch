package in.foxlogic.gsmswitch.customexception;

public class UserAlreayExistsException extends Exception {

	private static final long serialVersionUID = -5027830179746652630L;

	public UserAlreayExistsException(String message) {
		super(message);
	}
}
