
public class Application {

	public String name;
	public String description;
	public String organization;
	public String platforms;
	public String versions;
	public String genre;
	public double averageRating;
	private double[] allRatings;
	public String[] comments;
	
	public Application (String appName,
			String appDescription,
			String appOrganization,
			String appPlatforms,
	        String appVersions,
	        String appGenre,
			double averageAppRating, 
			double[] allAppRatings,
			String[] appComments) {
		name = appName; 
		
	}
}
