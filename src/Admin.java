
public class Admin extends Moderator {

	public Admin(String user, String pword) {
		super(user, pword);
		
	}
	
	public void viewRequest(Application app) {
		// shows the details of the app, for now this is similar
		app.printDetails();
		
	}
	
	public void approveRequest(AppOrganizationTool tool, Application app) {
		tool.apps.add(app);
		
	}

}
