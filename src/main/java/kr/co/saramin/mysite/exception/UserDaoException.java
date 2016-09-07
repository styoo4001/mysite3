package kr.co.saramin.mysite.exception;

public class UserDaoException extends RuntimeException {

	private static final long serialVersionUID= 31234123123L;
	
	
	
	public UserDaoException ( String message) {
		
		super(message);
		
	}
	
	public UserDaoException(){
		
		super( "UserDaoException Occurs");
		
	}
	
	
	
}
