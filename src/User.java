import java.util.ArrayList;
import java.util.Comparator;

public class User {

	public String username;
	private String password;
		
	public User() {}
		
	public User(String user, String pword) {	
		username = user;
		password = pword;	
	}

	public boolean signUp(AppOrganizationTool AOT) {
		if (!AOT.users.containsKey(username)) {
			AOT.users.put(username, password);
			System.out.println("Signup Successful");
			return true;
		}
		System.out.println("Username is taken.");
		return false;
	}

	public boolean login(AppOrganizationTool AOT, String user, String pword) {
		if (AOT.users.containsKey(user) && AOT.users.get(user).equals(pword)) {
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

	public boolean sort(AppOrganizationTool AOT, int param) {
		switch (param) {
			case 1 : AOT.apps.sort(nameSort);  break;
			case 2 : AOT.apps.sort(genreSort);  break;
			case 3 : AOT.apps.sort(ratingSort);  break;
			default: return false;
		}
		String str;
		if (param == 1)		str = "name";
		else if (param == 2)	str = "genre";
		else			str = "rating";
		System.out.println("Apps Sorted by '" + str + "':");
		for (Application app : AOT.apps) 
			app.printDetails();
		return true;
	}
		
	Comparator<Application> nameSort = new Comparator<Application>() {
		@Override
		public int compare(Application a1, Application a2) {
			return a1.name.compareTo(a2.name);
		}
	};
	
	Comparator<Application> genreSort = new Comparator<Application>() {
		@Override
		public int compare(Application a1, Application a2) {
			return a1.genre.compareTo(a2.genre);
		}
	};
	
	Comparator<Application> ratingSort = new Comparator<Application>() {
		@Override
		public int compare(Application a1, Application a2) {
			return a1.averageRating < a2.averageRating ? 1 : -1;
		}
	};
}