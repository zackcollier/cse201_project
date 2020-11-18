import java.util.ArrayList;

/*
the platform filter
*/

public class Sort {
	private ArrayList<String> sorts;
	private ArrayList<ArrayList<String>> data;

	public Sort() {
		
		this.sorts = new ArrayList<String>();
		data = new ArrayList<ArrayList<String>>(AppOrganizationTool.sortGenreFilterData);
		
	}
	/* make the arraylist of the platform sort
	* 
	*/
	public void setSorts(ArrayList<String> sorts) {
		this.sorts = new ArrayList<String>(sorts);
	}
/*
* @return the arraylist that have been already filtered
* use arraylist to filter the platforms sdorts
*/
	public ArrayList<ArrayList<String>> getFilteredSorts() {
		ArrayList<ArrayList<String>> filtered = new ArrayList<ArrayList<String>>();
		System.out.println("Platform Sort");
		boolean isWrong = false;
		for (ArrayList<String> a : data) {
			for (int i = 0; i < sorts.size(); i++) {
				if (a.get(3).indexOf(sorts.get(i)) == -1) {
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
