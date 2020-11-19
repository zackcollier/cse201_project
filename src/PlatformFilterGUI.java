import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;

public class PlatformFilterGUI extends JPanel implements ItemListener, ActionListener{
	// create constant arraylist and constant variables
	private ArrayList<String> availablePlatforms;
	public ArrayList<String> activePlatforms;
	public ArrayList<JCheckBox> checkBoxes;
	private JPanel buttons;
	private JPanel checkBoxList;
	public JButton filterButton;
	public JButton cancelButton;
	private PlatformFilter filter;
	private ArrayList<ArrayList<String>> data;
	/*
	* the GUI of the filter to the platforms of the applications
	*@return show the GUI part of it
	*/
	public PlatformFilterGUI() {
		
		super();// using the data in the super class of PlatformFilter
		// set up the JPanel and arraylist
		filter = new PlatformFilter();
		data = new ArrayList<ArrayList<String>>();
		this.setLayout(new BorderLayout());
		this.checkBoxList = new JPanel();
		this.checkBoxList.setLayout(new GridLayout(6, 4));
		this.buttons = new JPanel();
		buttons.setLayout(new FlowLayout());
	        //add these 6 platforms to the availableGnres arraylist of the genres
		this.availablePlatforms = new ArrayList<String>(Arrays.asList("iOS","Android","Mac","Windows","Linux","Web App"));
		
		this.activePlatforms = new ArrayList<String>();
		
		checkBoxes = new ArrayList<JCheckBox>();
		//add these 6 platforms to the JCheckBox	
		JCheckBox iOS = new JCheckBox("iOS", false);
		JCheckBox Android = new JCheckBox("Android", false);
		JCheckBox Mac = new JCheckBox("Mac", false);
		JCheckBox Windows = new JCheckBox("Windows", false);
		JCheckBox Linux = new JCheckBox("Linux", false);
		JCheckBox WebApp = new JCheckBox("Web App", false);
		
		//add these 6 platoforms to the checkBoxes
		checkBoxes.add(iOS);
		checkBoxes.add(Android);
		checkBoxes.add(Mac);
		checkBoxes.add(Windows);
		checkBoxes.add(Linux);
		checkBoxes.add(WebApp);
	 
		//using for each method in the arraylist to add the data to the checkBoxList
		for (JCheckBox c: checkBoxes) {
			c.addItemListener(this);
			checkBoxList.add(c);
		}
		// Add the JLabel of "Filter by Platform" and two JButton of "Filter" and "Cancel" which can be clicked
		JLabel filterLabel = new JLabel("Filter by Platform");
		filterButton = new JButton("Filter");
		cancelButton = new JButton("Cancel");
		filterButton.addActionListener(this);
		cancelButton.addActionListener(this);
		// add the two JButtons
		buttons.add(filterButton);
		buttons.add(cancelButton);
		// Add the filterLabel, 6 platoforms of the checkBoxList, and the two buttons to the GUI
		this.add(filterLabel, BorderLayout.NORTH);
		this.add(checkBoxList, BorderLayout.CENTER);
		this.add(buttons, BorderLayout.SOUTH);
		
	}
        // the override auto-genrated method for the GUI
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
        // the override auto-genrated method for the GUI
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	} 
	}
