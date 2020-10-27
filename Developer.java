
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
	 * @param case The number of the case that the user will have inputted with a button press
	 * @param update The updated text that needs to be applied
	 */
	public void updateApp(Application app, int param, String update) {
		if (app.company.equals(company)) {
			switch (param) {
				case 1 : app.name = update;  break;
				case 2 : app.description = update;  break;
				case 3 : app.company = update;  break;
				case 4 : app.platforms = update;  break;
				case 5 : app.version = update;  break;
				case 6 : app.genre = update;  break;
			}
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
