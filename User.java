
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
	
	public void search(AppOrganizationTool AOT, String str) {
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
	}

}
