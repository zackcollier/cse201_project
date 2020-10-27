
public class User {

	public String username;
	private String password;
		
	public User() {}
		
	public User(String user, String pword) {	
		username = user;
		password = pword;	
	}

	public boolean signUp(AppOrganizationTool AOT, String username, String password) {
		if (!AOT.users.containsKey(username)) {
			AOT.users.put(username, password);
			System.out.println("Signup Successful");
			return true;
		}
		System.out.println("Username is taken.");
		return false;
	}

	public boolean login(AppOrganizationTool AOT, String username, String password) {
		if (AOT.users.containsKey(username) && AOT.users.get(username).equals(password)) {
			AOT.currentUser = this;
			return true;
		}
		System.out.println("Login failed. Please check your login information.");
		return false;		
	}
		
	public boolean logout(AppOrganizationTool AOT) {
		AOT.currentUser = null;
		return true;
	}
	
	public void comment(AppOrganizationTool AOT, Application app, String userComment) {
		if(AOT.currentUser == null)
			return;
		
		app.comments.add(userComment);
	}
	
	public boolean search(AppOrganizationTool AOT, String str) {
		ArrayList<Application> searchApps = new ArrayList<>();
		for (Application a : AOT.apps) {
			for (String s : a.toArray()) {
				if (s.contains(str)) {
					searchApps.add(a);
					break;
				}
			}
		}
		System.out.println("Search Results for '" + str + "':");
		for (Application app : searchApps) {
			app.printDetails();
		}
		
		if (searchApps.isEmpty())
			return false;
		
		return true;
	}

}
