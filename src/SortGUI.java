import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class SortGUI extends JComboBox<String> implements ActionListener {

	private String[] sortMethods;
	private Sort sorter;
	private ArrayList<ArrayList<String>> data;

	public SortGUI() {
		super();

		sortMethods = new String[] { "Name Descending", "Name Ascending" 
				}; //need add more

		for (String s : sortMethods) {
			this.addItem(s);
		}
		
		sorter = new Sort();
		data = new ArrayList<ArrayList<String>>();
		this.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		JComboBox<String> combo = (JComboBox<String>) e.getSource();
		String selectedSort = (String) combo.getSelectedItem();

		if (selectedSort.equals("Name Descending")) {
			 //need add
		} else if (selectedSort.equals("Name Ascending")) {
			 //need add
		}  
	}
	 
	}
