import java.util.Map;

public class Moderator extends User {

	/**
	 * Creates a moderator object using account credentials.
	 * @param user The username of the moderator account.
	 * @param pword The password for a target user account.
	 */
	public Moderator(String user, String pword) {
		super(user, pword);
	}
	
	/**
	 * Removes a comment that was left on an app.
	 * @param app The application on which the comment should be removed.
	 * @param user The username of the user whose comment should be removed.
	 */
	public void removeComment(Application app, String user) {
		app.comments.remove(user);	
	}
	
	// See user login
	@Override
	public boolean login(AppOrganizationTool AOT, String user, String pword) {
		if (AOT.moderators.containsKey(user) && AOT.moderators.get(user).equals(pword)) 
			return true;
		return false;
	}
}
