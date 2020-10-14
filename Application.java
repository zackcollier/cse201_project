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
	
	public Application (String appName,
			String appDescription,
			String appCompany,
			String appPlatforms,
	      		String appVersion,
	        	String appGenre) {
		name = appName; 
		description = appDescription;
		company = appCompany;
		platform = appPlatform;
		version = appVersion;
		genre = appGenre;
	}
	
	public void calcAvgRating() {
		float sum = 0;
		for (float rating : allRatings) 
			sum += rating;
		averageRating = sum/allRatings.size();
		
	}
}
