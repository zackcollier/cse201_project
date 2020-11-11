import java.util.ArrayList;
import java.util.Comparator;
import java.io.IOException;
import java.io.PrintWriter;

public class User {

	public String username;
	private String password;
		
	public User() {}
	
	/**
	 * Creates a user object using account credentials.
	 * @param user The username of the user account.
	 * @param pword The password for a target user account.
	 */	
	public User(String user, String pword) {	
		username = user;
		password = pword;	
	}
	
	/**
	 * Updates an application that the developer has access to.
	 * @param AOT The instance of the tool where the new user is being signed up to.
	 * @return true if the signup was sucessful, false if not.
	 */
	public boolean signUp(AppOrganizationTool AOT) {
		if (!AOT.users.containsKey(username)) {
			AOT.users.put(username, password);
			try { 
		        	PrintWriter writer = new PrintWriter("login_system.txt");
		        	writer.write(username + "," + password);
		        	writer.close();
			 } catch(IOException e) {
					System.out.println("Login Database Not Found");
				}
			System.out.println("Signup Successful");
			return true;
		}
		System.out.println("Username is taken.");
		return false;
	}

	/**
	 * Allows a user to log in, and be stored as the user in the tool.
	 * @param AOT The instance of the tool where the new user is being logged in to.
	 * @param user The username of the desired user to log in.
	 * @param pword The password of the desired user to log in.
	 * @return true if the login was sucessful, false if not.
	 */
	public boolean login(AppOrganizationTool AOT, String user, String pword) {
		if (AOT.users.containsKey(user) && AOT.users.get(user).equals(pword)) {
			AOT.currentUser = this;
			return true;
		}
		System.out.println("Login failed. Please check your login information.");
		return false;		
	}
	
	/**
	 * Allows a user to log out, preventing a comment and rating from being written by their account.
	 * @param AOT The instance of the tool where the new user is being logged in to.
	 * @return true if the logout was sucessful.
	 */
	public boolean logout(AppOrganizationTool AOT) {
		AOT.currentUser = new User("","");
		return true;
	}
	
	/**
	 * Allows a user to leave a comment on an app. Can only have 1 per application.
	 * @param AOT The instance of the tool where the user is logged into.
	 * @param app The app the user wants to leave a comment on.
	 * @param userComment The comment the user wants to give the app.
	 * @return true if the comment was sucessful, false if not.
	 */
	public int comment(AppOrganizationTool AOT, Application app, String userComment) {
		if(AOT.currentUser.username.equals(""))
			return 0;
		
		app.comments.put(username, userComment);
		return 1;
	}
	
	/**
	 * Allows a user to leave a rating on an app. Can only have 1 per application.
	 * @param AOT The instance of the tool where the user is logged into.
	 * @param app The app the user wants to leave a rating on.
	 * @param userRating The rating the user wants to give the app.
	 * @return true if the rating was sucessful, false if not.
	 */
	public boolean rating(AppOrganizationTool AOT, Application app, float userRating) {
		if (AOT.currentUser.username.equals(""))
			return false;
		app.allRatings.add(userRating);
		return true;
	}
	
	/**
	 * Allows a user to search for apps.
	 * @param AOT The instance of the tool where the search is occuring.
	 * @param str The string that the user wants to search for.
	 * @return A list of the apps that satisfied the search.
	 */
	public ArrayList<Application> search(AppOrganizationTool AOT, String str) {
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
		
		return searchApps;
	}

	
	/**
	 * Allows a user to sort by a given parameter: name, genre, rating, platform.
	 * @param AOT The instance of the tool where the sort is occuring.
	 * @param param The parameter that the user wants to sort by.
	 * @return A list of the apps that satisfied the sort.
	 */
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
