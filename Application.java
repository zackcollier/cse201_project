import java.util.ArrayList;

public class Application {

	public String name;
	public String description;
	public String company;
	public String platforms;
	public String version;
	public String genre;
	public int questionAnswer;
	public String answer;
	public float averageRating;
	private ArrayList<Float> allRatings = new ArrayList<>();
	public ArrayList<String> comments = new ArrayList<>();
	
	private List<Answer> mAllAnswers;
        private Filter<Tag> mFilter;
	
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
			int getQuestionAnswer,
			String questionAnswer,
	        	String appGenre) {
		name = appName; 
		description = appDescription;
		company = appCompany;
		platforms = appPlatforms;
		questionAnswer = getQuestionAnswer;
		answer = answer;
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
	 * @return An arraylist containing all of the instance variables for the application.
	 *
	 *didn't finish yet, these variables need change to arrays, which can help filter better, and this method change to return arraylist
	 */
	public String[][] toArray() {
		return new String[][] {name[], description[], company[], platforms[], version[], String.valueOf(averageRating)[]};
	}
	
	/**
	*get the number of what part of the app information that the user is interested in, so we can use it to filter the search.
	*/
	public int getfilter(){
	   String questiontext1 = "User please input the number of the information part of the app you interested to use the filter.";
	   String questiontext2 = "number 1 is the name, 2 is the description, 3 is the company, 4 is the platforms, 5 is the version, 6 is the averagerating.";
	   if (questionAnswer.equals("name")) return 1;
		else if (questionAnswer.equals("description"))return 2;
		else if (questionAnswer.equals("company"))return 3;
		else if (questionAnswer.equals("platforms"))return 4;
		else if (questionAnswer.equals("version"))return 5;
		else if (questionAnswer.equals("averageRating"))return 6;
		else return 0;
	}
	
	/**
	* return the arraylist that have been use the filter
	* didn't finish yet, in the upcoming edition, the filter should use the getfilter to change sort the different array in the arraylist
	*/
	private List<Answer> findByTags(List<Tag> tags) {
           List<Answer> answers = new ArrayList<>();

           for (Answer answer : mAllAnswers) {
              for (Tag tag : tags) {
                  if (answer.hasTag(tag.getText()) && !answers.contains(answer)) {
                      answers.add(answer);
                   }
               }
           }
           return questions;
       }
	
	
	/**
	* return the tags in an arraylist, which will be use in the findByTags method to use the filter for the app arraylist
	*/
	
	private Filter<Tag> getTags() {
        Filter<Tag> mFilter = new ArrayList<>();
		
        for (int i = 0; i < name.length; ++i) {
            tags.add(new Tag(name[i], description[i],company[i],platforms[i],version[i],averageRating[i]));
        }
		
        return tags;
    }
	
	
	/**
	 * 
	 *  Prints all of the instance variables for the application.
	 *  Will likely be changed to use graphics at a later date.
	 */
	public void printDetails() {
		String print = "";
		for (String s : this.toArray())
			print += s + ", ";
		System.out.println(print.substring(0, print.length - 2));
	}
}
