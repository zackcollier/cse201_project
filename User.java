
public class User {

	public String username;
	private String password;
		
	public User() {}
		
	public User(String user, String pword) {	
		username = user;
		password = pword;	
	}

	public boolean login(String username, String password) {
			
		return false;	
	}
		
	public void comment(Application app, String userComment) {
		app.comments.add(userComment);	
	}
	
	public void submitRequest() {	
	
		
	}
	
}
