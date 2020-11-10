
public class Admin extends Moderator {

	/**
	 * Creates an admin object using account credentials.
	 * @param user The username of the admin account.
	 * @param pword The password for a target user account.
	 */
	public Admin(String user, String pword) {
		super(user, pword);
	}
	
	/**
	 * Shows the details of an app that was submitted for approval.
	 * @param app The application to be reviewed.
	 */
	public void viewRequest(Application app) {
		app.printDetails();
	}
	
	/**
	 * Approves an app into the app.
	 * @param AOT The Tool where the app will be sent to.
	 * @param app The application to be reviewed.
	 */
	public void approveRequest(AppOrganizationTool tool, Application app) {
		tool.apps.add(app);	
	}
}
