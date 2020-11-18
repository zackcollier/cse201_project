
import java.util.ArrayList;
import java.util.Arrays;

public class GenreFilter {
	//create constant arraylist
	private ArrayList<String> genres;
	private ArrayList<ArrayList<String>> data;
 
	public GenreFilter() {
		this.genres = new ArrayList<String>();
		data = new ArrayList<ArrayList<String>>(AppOrganizationTool.sortGenreFilterData);	
	}
	/*
	* make the arraylist for the genres
	*
	*@param genres the genres arraylist of the application
	*@return void
	*/
	public void setGenres(ArrayList<String> genres) {
		this.genres = new ArrayList<String>(genres);
	}
      /*
      * make the genres of the filter been filter
      *
      * @return the arraylist that are filtered
      */
	public ArrayList<ArrayList<String>> getFilteredGenres() {
		ArrayList<ArrayList<String>> filtered = new ArrayList<ArrayList<String>>();
		System.out.println("FilterGenre");
		boolean isWrong = false;
		// using for each method in the arrraylist to filter the genres data
		for (ArrayList<String> a : data) {
			for (int i = 0; i < genres.size(); i++) {
				if (a.get(3).indexOf(genres.get(i)) == -1) {
					isWrong = true;
				}
			}
			if (!isWrong) {
				// if no wrong, the genre data will be added to the filtered arraylist
				filtered.add(a);
			}
			isWrong = false;
		}
		return filtered;
	}

}
