
import java.util.ArrayList;
import java.util.Arrays;

public class PlatformFilter {

	private ArrayList<String> platforms;
	private ArrayList<ArrayList<String>> data;

	public PlatformFilter() {
		
		this.platforms = new ArrayList<String>();
		data = new ArrayList<ArrayList<String>>(AppOrganizationTool.sortPlatformFilterData);
		
	}
	
	public void setGenres(ArrayList<String> platforms) {
		this.platforms = new ArrayList<String>(platforms);
	}

	public ArrayList<ArrayList<String>> getFilteredPlatforms() {
		ArrayList<ArrayList<String>> filtered = new ArrayList<ArrayList<String>>();
		System.out.println("FilterPlatform");
		boolean isWrong = false;
		for (ArrayList<String> a : data) {
			for (int i = 0; i < platforms.size(); i++) {
				if (a.get(3).indexOf(platforms.get(i)) == -1) {
					isWrong = true;
				}
			}
			if (!isWrong) {
				filtered.add(a);
			}
			isWrong = false;
		}
		return filtered;
	}

}
