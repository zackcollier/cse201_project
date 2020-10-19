
public class Developer extends User {
	
	private String company;

	/**
	 * Creates a developer object using account credentials.
	 * @param user The username of the developer account.
	 * @param pword The password for a target user account.
	 */
	public Developer(String user, String pword) {
		super(user,pword);
	}
	
	/**
	 * Updates an application that the developer has access to.
	 * @param app The application data that should overwrite the previous data.
	 */
	public void updateApp(Application app) {
		if (app.company.equals(company)) {
			//code to allow developers to select an field to alter, alter it, or go back to the selection screen
		}
	}
	/**
	 * Sends an app to be requested to be approved by an admin
	 * @param AOT Instance of AppOrganizationTool that the app will be sent to.
	 * @param app The application to be sent.
	 */
	public void submitRequest(AppOrganizationTool AOT, Application app) {	
		AOT.requests.add(app);
	}
	
}
