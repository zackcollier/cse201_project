import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;

public class PlatformFilterGUI extends JPanel implements ItemListener, ActionListener{
	
	private ArrayList<String> availablePlatforms;
	public ArrayList<String> activePlatforms;
	public ArrayList<JCheckBox> checkBoxes;
	private JPanel buttons;
	private JPanel checkBoxList;
	public JButton filterButton;
	public JButton cancelButton;
	private PlatformFilter filter;
	private ArrayList<ArrayList<String>> data;
	
	public PlatformFilterGUI() {
		
		super();
		
		filter = new PlatformFilter();
		data = new ArrayList<ArrayList<String>>();
		this.setLayout(new BorderLayout());
		this.checkBoxList = new JPanel();
		this.checkBoxList.setLayout(new GridLayout(6, 4));
		this.buttons = new JPanel();
		buttons.setLayout(new FlowLayout());
		
		this.availablePlatforms = new ArrayList<String>(Arrays.asList("iOS","Android","Mac","Windows","Linux","Web App"));
		
		this.activePlatforms = new ArrayList<String>();
		
		checkBoxes = new ArrayList<JCheckBox>();
			
		JCheckBox iOS = new JCheckBox("iOS", false);
		JCheckBox Android = new JCheckBox("Android", false);
		JCheckBox Mac = new JCheckBox("Mac", false);
		JCheckBox Windows = new JCheckBox("Windows", false);
		JCheckBox Linux = new JCheckBox("Linux", false);
		JCheckBox WebApp = new JCheckBox("Web App", false);
		
		checkBoxes.add(iOS);
		checkBoxes.add(Android);
		checkBoxes.add(Mac);
		checkBoxes.add(Windows);
		checkBoxes.add(Linux);
		checkBoxes.add(WebApp);
	 
		
		for (JCheckBox c: checkBoxes) {
			c.addItemListener(this);
			checkBoxList.add(c);
		}
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	} 
	}
