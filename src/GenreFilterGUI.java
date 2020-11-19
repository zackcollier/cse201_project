import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;

public class GenreFilterGUI extends JPanel implements ItemListener, ActionListener{
	// create constant arraylist and constant variables
	private ArrayList<String> availableGenres;
	public ArrayList<String> activeGenres;
	public ArrayList<JCheckBox> checkBoxes;
	private JPanel buttons;
	private JPanel checkBoxList;
	public JButton filterButton;
	public JButton cancelButton;
	private GenreFilter filter;
	private ArrayList<ArrayList<String>> data;
	
	/*
	* the GUI of the filter to the genre of the applications
	*@return show the GUI part of it
	*/
	public GenreFilterGUI() {
		super();  // using the data in the super class of GenreFilter
		// set up the JPanel and arraylist
		filter = new GenreFilter();
		data = new ArrayList<ArrayList<String>>();
		this.setLayout(new BorderLayout());
		this.checkBoxList = new JPanel();
		this.checkBoxList.setLayout(new GridLayout(6, 4));
		this.buttons = new JPanel();
		buttons.setLayout(new FlowLayout());
		
		//add these 9 genres to the availableGnres arraylist of the genres
		this.availableGenres = new ArrayList<String>(Arrays.asList("Education","Chat","Game","Photo","Music","Shopping","News","Weather","Book"));
		
		this.activeGenres = new ArrayList<String>();
		
		checkBoxes = new ArrayList<JCheckBox>();
		
		// add these 9 genres to the JCheckBox
		JCheckBox Education = new JCheckBox("Education", false);
		JCheckBox Chat = new JCheckBox("Chat", false);
		JCheckBox Games = new JCheckBox("Game", false);
		JCheckBox Photo = new JCheckBox("Photo", false);
		JCheckBox Music = new JCheckBox("Music", false);
		JCheckBox Shopping = new JCheckBox("Shopping", false);
		JCheckBox News = new JCheckBox("News", false);
		JCheckBox Weather = new JCheckBox("Weather",false);
		JcheckBox Book = new JCheckBox("Book",false);
		
		// add these nine genres to the checkBoxes
		checkBoxes.add(Education);
		checkBoxes.add(Chat);
		checkBoxes.add(Game);
		checkBoxes.add(Photo);
		checkBoxes.add(Music);
		checkBoxes.add(Shopping);
		checkBoxes.add(News);
		checkBoxes.add(Weather);
		checkBoxes.add(Book);
	 
		// using for each method in arraylist to add addItemListener to the checkBoxList
		for (JCheckBox c: checkBoxes) {
			c.addItemListener(this);
			checkBoxList.add(c);
		}
		
		// Add the JLabel of "Filter by Genre" and two JButton of "Filter" and "Cancel" which can be clicked
		JLabel filterLabel = new JLabel("Filter by Genre");
		filterButton = new JButton("Filter");
		cancelButton = new JButton("Cancel");
		filterButton.addActionListener(this);
		cancelButton.addActionListener(this);
		// add the two JButtons
		buttons.add(filterButton);
		buttons.add(cancelButton);
		// Add the filterLabel, 9 genres of the checkBoxList, and the two buttons to the GUI
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
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
	}

 
	 
	}
