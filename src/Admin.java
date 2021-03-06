import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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
	 * Gets an app that has requested to be implemented into the app.
	 * @param tool The instance of tool 
	 */
	public Application viewRequest(AppOrganizationTool tool) {
		return tool.requests.peek();
	}
	
	/**
	 * Approves an app into the app.
	 * @param AOT The Tool where the app will be sent to.
	 * @param app The application to be reviewed.
	 */
	public void approveRequest(AppOrganizationTool tool, Application app) {
		tool.apps.add(app);
		try { 
        	PrintWriter writer = new PrintWriter(new FileWriter("App_data.txt",true));
        	writer.write(app.name + "," + app.description + "," + app.company + "," + app.platforms + "," + app.version + "," + app.genre + "\n");
        	writer.close();
	 } catch(IOException e) {
			System.out.println("App Database Not Found");
		}
	}
	
	// See user login
	@Override
	public boolean login(AppOrganizationTool AOT, String user, String pword) {
		if (AOT.admins.containsKey(user) && AOT.admins.get(user).equals(pword)) 
			return true;
		return false;
	}
}
