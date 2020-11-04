
public class Moderator extends User {

	public Moderator(String user, String pword) {
		super(user, pword);
		
	}
	
	public void removeComment(Application app, String comment) {
		// The comment will always be able to be removed because moderators will use
		// the GUI to select which comments to remove
		app.comments.remove(comment);
		
	}
}
