
import java.util.ArrayList;
import java.util.Arrays;

public class PlatformFilter {
        //create constant arraylist
	private ArrayList<String> platforms;
	private ArrayList<ArrayList<String>> data;

	public PlatformFilter() {
		
		this.platforms = new ArrayList<String>();
		data = new ArrayList<ArrayList<String>>(AppOrganizationTool.sortPlatformFilterData);
		
	}
	/*
	* make the arraylist for the platforms
	*
	*@param genres the platforms arraylist of the application
	*@return void
	*/
	public void setPlatforms(ArrayList<String> platforms) {
		this.platforms = new ArrayList<String>(platforms);
	}
     /*
      * make the platforms of the filter been filter
      *
      * @return the arraylist that are filtered
      */
	public ArrayList<ArrayList<String>> getFilteredPlatforms() {
		ArrayList<ArrayList<String>> filtered = new ArrayList<ArrayList<String>>();
		System.out.println("FilterPlatform");
		boolean isWrong = false;
		// using for each method in the arrraylist to filter the platforms data
		for (ArrayList<String> a : data) {
			for (int i = 0; i < platforms.size(); i++) {
				if (a.get(3).indexOf(platforms.get(i)) == -1) {
					isWrong = true;
				}
			}
			// if no wrong, the platforms data will be added to the filtered arraylist
			if (!isWrong) {
				filtered.add(a);
			}
			isWrong = false;
		}
		return filtered;
	}

}
