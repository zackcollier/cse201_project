import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;

// the filter of the platform

public class SortGUI extends JPanel implements ItemListener, ActionListener {

	private String[] sortMethods;
	private Sort sorter;
	private ArrayList<ArrayList<String>> data;
	
	private ArrayList<String> availableSorts;
	public ArrayList<String> activeSorts;
	public ArrayList<JCheckBox> checkBoxes;
	private JPanel buttons;
	private JPanel checkBoxList;
	public JButton filterButton;
	public JButton cancelButton;
	private Sort filter;
	 
/*
* the GUI of the platoform sort filter, which will be used in AppOrganizationTool.java
*/
	public SortGUI() {
		super();

		filter = new Sort();
		data = new ArrayList<ArrayList<String>>();
		this.setLayout(new BorderLayout());
		this.checkBoxList = new JPanel();
		this.checkBoxList.setLayout(new GridLayout(6, 4));
		this.buttons = new JPanel();
		buttons.setLayout(new FlowLayout());
		
		// make the arraylist of the ios and andriod platform
		this.availableSorts = new ArrayList<String>(Arrays.asList("IOS","Andriod"));
		
		this.activeSorts = new ArrayList<String>();
		
		checkBoxes = new ArrayList<JCheckBox>();
	        
		// Add the JcheckBox of IOS and Andriod
		JCheckBox IOS = new JCheckBox("IOS", false);
		JCheckBox Andriod = new JCheckBox("Andriod", false);
	       // Add the checkbox for IOS and Andriod
		checkBoxes.add(IOS);
		checkBoxes.add(Andriod);
		 
		
		for (JCheckBox c: checkBoxes) {
			c.addItemListener(this);
			checkBoxList.add(c);
		}
		// add the JLabel of the "Filter by platform"
		JLabel filterLabel = new JLabel("Filter by Platform");
		filterButton = new JButton("Filter");
		cancelButton = new JButton("Cancel");
		filterButton.addActionListener(this);
		cancelButton.addActionListener(this);
		
		buttons.add(filterButton);
		buttons.add(cancelButton);
		
		this.add(filterLabel, BorderLayout.NORTH);
		this.add(checkBoxList, BorderLayout.CENTER);
		this.add(buttons, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e) {
		/*  JComboBox<String> combo = (JComboBox<String>) e.getSource();
		String selectedSort = (String) combo.getSelectedItem();

		if (selectedSort.equals("Name Descending")) {
			 //need add
		} else if (selectedSort.equals("Name Ascending")) {
			 //need add
		}    */
	}
	 

 
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	 
	}
