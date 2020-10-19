import java.util.ArrayList;

public class Application {

	public String name;
	public String description;
	public String company;
	public String platforms;
	public String version;
	public String genre;
	public float averageRating;
	private ArrayList<float> allRatings = new ArrayList<>();
	public ArrayList<String> comments = new ArrayList<>();
	
	/**
	 * The basic class that contains information for applications
	 * 
	 * @param appName The name of the applications.
	 * @param appDescription The description of the application that will be displayed for all users.
	 * @param appCompany The company that uploaded the application.
	 * @param appPlatforms The platforms that the application is available on.
	 * @param appVersion The current version of the application.
	 * @param appGenre The genre that best describes the application.
	 */
	public Application (String appName,
			String appDescription,
			String appCompany,
			String appPlatforms,
	      		String appVersion,
	        	String appGenre) {
		name = appName; 
		description = appDescription;
		company = appCompany;
		platforms = appPlatforms;
		version = appVersion;
		genre = appGenre;
	}
	
	/**
	 * Calculates the average rating for the app and changes the variable.
	 */
	public void calcAvgRating() {
		float sum = 0;
		for (float rating : allRatings) 
			sum += rating;
		averageRating = sum/allRatings.size();
		
	}
	
	/**
	 * 
	 * @return An array containing all of the instance variables for the application.
	 */
	public String[] toArray() {
		return new String[] {name, description, company, platforms, version, averageRating};
	}
	
	/**
	 * 
	 *  Prints all of the instance variables for the application.
	 *  Will likely be changed to use graphics at a later date.
	 */
	public void printDetails() {
		String[] details = this.toArray();
		String print = "";
		for (String s : details)
			print += s + ", ";
		System.out.println(print);
	}
}
