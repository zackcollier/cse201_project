import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Application {

	public String name;
	public String description;
	public String company;
	public String platforms;
	public String version;
	public String genre;
	public float averageRating;
	public HashMap<String, Float> allRatings = new HashMap<String, Float>();
	public HashMap<String, ArrayList<String>> comments = new HashMap<String, ArrayList<String>>();
	
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
		for (Map.Entry<String, Float> rating : allRatings.entrySet()) {
			sum += rating.getValue();
		}
		averageRating = sum/allRatings.size();	
	}
	
	/**
	 * @return An array containing all of the important instance variables for the application.
	 */
	public String[] toArray() {
		return new String[] {name, description, company, platforms, version, String.valueOf(averageRating)};
	}
}
