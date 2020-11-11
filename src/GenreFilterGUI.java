import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;

public class GenreFilterGUI extends JPanel implements ItemListener, ActionListener{
	
	private ArrayList<String> availableGenres;
	public ArrayList<String> activeGenres;
	public ArrayList<JCheckBox> checkBoxes;
	private JPanel buttons;
	private JPanel checkBoxList;
	public JButton filterButton;
	public JButton cancelButton;
	private GenreFilter filter;
	private ArrayList<ArrayList<String>> data;
	
	public GenreFilterGUI() {
		
		super();
		
		filter = new GenreFilter();
		data = new ArrayList<ArrayList<String>>();
		this.setLayout(new BorderLayout());
		this.checkBoxList = new JPanel();
		this.checkBoxList.setLayout(new GridLayout(6, 4));
		this.buttons = new JPanel();
		buttons.setLayout(new FlowLayout());
		
		this.availableGenres = new ArrayList<String>(Arrays.asList("Education","Chat","Games","Photo","Music","Shopping","News"));
		
		this.activeGenres = new ArrayList<String>();
		
		checkBoxes = new ArrayList<JCheckBox>();
			
		JCheckBox Education = new JCheckBox("Education", false);
		JCheckBox Chat = new JCheckBox("Chat", false);
		JCheckBox Games = new JCheckBox("Games", false);
		JCheckBox Photo = new JCheckBox("Photo", false);
		JCheckBox Music = new JCheckBox("Music", false);
		JCheckBox Shopping = new JCheckBox("Shopping", false);
		JCheckBox News = new JCheckBox("News", false);
		
		checkBoxes.add(Education);
		checkBoxes.add(Chat);
		checkBoxes.add(Games);
		checkBoxes.add(Photo);
		checkBoxes.add(Music);
		checkBoxes.add(Shopping);
		checkBoxes.add(News);
	 
		
		for (JCheckBox c: checkBoxes) {
			c.addItemListener(this);
			checkBoxList.add(c);
		}
		
		JLabel filterLabel = new JLabel("Filter by Genre");
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}

 
	 
	}
