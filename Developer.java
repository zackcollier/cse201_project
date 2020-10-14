
public class Developer extends User {
	
	private String company;


	public Developer(String user,
			    String pword) {
		super(user,pword);
		
	}
	
	public void updateApp(Application app) {
		if (app.company.equals(company)) {
			//code to allow developers to select an field to alter, alter it, or go back to the selection screen
		}
	}
}
