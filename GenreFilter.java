
import java.util.ArrayList;
import java.util.Arrays;

public class GenreFilter {

	private ArrayList<String> genres;
	private ArrayList<ArrayList<String>> data;

	public GenreFilter() {
		
		this.genres = new ArrayList<String>();
		data = new ArrayList<ArrayList<String>>(AppOrganizationTool.sortFilterData);
		
	}
	
	public void setGenres(ArrayList<String> genres) {
		this.genres = new ArrayList<String>(genres);
	}

	public ArrayList<ArrayList<String>> getFilteredGenres() {
		ArrayList<ArrayList<String>> filtered = new ArrayList<ArrayList<String>>();
		System.out.println("FilterGenre");
		boolean isWrong = false;
		for (ArrayList<String> a : data) {
			for (int i = 0; i < genres.size(); i++) {
				if (a.get(3).indexOf(genres.get(i)) == -1) {
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