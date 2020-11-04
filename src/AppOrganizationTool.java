import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AppOrganizationTool {

	ArrayList<Application> apps = new ArrayList<>();
	Queue<Application> requests = new LinkedBlockingQueue<>();
	Map<String, String> users = new HashMap<>();
	User currentUser;
	
	private static ArrayList<ArrayList<String>> data;
	public static ArrayList<ArrayList<String>> sortFilterData;
	
	private static SortGUI sorts;
	private static GenreFilterGUI genres;

	
	public AppOrganizationTool()  {}
    
	public ArrayList<Application> getApps() {
		return apps;
	}
	
	public Queue<Application> getRequests() {
		return requests;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
        Application app1 = new Application("App 1 Name", "App 1 Description", "App 1 Company", "App 1 Platforms", "App 1 Version", "App 1 Genre");
        Application app2 = new Application("App 2 Name", "App 2 Description", "App 2 Company", "App 2 Platforms", "App 2 Version", "App 2 Genre");
        Admin a1 = new Admin("username", "password");
        AppOrganizationTool AOT = new AppOrganizationTool();
        AOT.requests.add(app1);
        AOT.requests.add(app2);
        a1.viewRequest(AOT.getRequests().peek());
        a1.approveRequest(AOT, AOT.getRequests().remove());
        a1.viewRequest(AOT.getRequests().peek());
        a1.approveRequest(AOT, AOT.getRequests().remove());
        AOT.getApps().get(0).printDetails();
        AOT.getApps().get(1).printDetails();
	//a1.search("1");
        
        data = new ArrayList<ArrayList<String>>();

		//Scanner in = new Scanner(new File("App_data.txt"));
		//importData(in);
		
		sortFilterData = new ArrayList<ArrayList<String>>(data);

		JFrame.setDefaultLookAndFeelDecorated(true);

		JFrame frame = new JFrame("AppOrganization");

		JTextField jtf = new JTextField("Username");
		JTextField jpwf = new JTextField("Password");
		JButton logInBttn = new JButton("Log in");
		JLabel lbl = new JLabel("New User?");
		JButton signUpBttn = new JButton("Click here to create an account");
		JPanel jp = new JPanel();

		
		//sorts = new SortGUI();
		genres = new GenreFilterGUI();	
		
		jp.setLayout(new FlowLayout());
		frame.setLayout(new BorderLayout());
		frame.add(jp, BorderLayout.CENTER);
		jp.add(jtf);
		jp.add(jpwf);
		jp.add(logInBttn);
		jp.add(lbl);
		jp.add(signUpBttn);
		
		//jp.add(sorts);
		jp.add(genres);
		
		frame.setSize(600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		//in.close();
        
    } 
	
	private static void importData(Scanner in) {
		ArrayList<String> currentApp = new ArrayList<String>();
		String currentInput = null;
		String line = null;
		int index = 0;

		while (in.hasNextLine()) {
			line = in.nextLine();
			index = line.indexOf(" \"");
			currentInput = line.substring(0, index); // App Name
			currentApp.add(currentInput);
			line = line.substring(index + 2);
			index = line.indexOf("\"");
			currentInput = line.substring(0, index); // App Description
			currentApp.add(currentInput);
			line = line.substring(index + 2);
			index = line.indexOf(" \"");
			currentInput = line.substring(0, index); // App Company
			currentApp.add(currentInput);
			line = line.substring(index + 2);
			index = line.indexOf("\"");
			currentInput = line.substring(0, index); // App Platform
			currentApp.add(currentInput);
			line = line.substring(index + 2);
			index = line.indexOf(" ");
			currentInput = line.substring(0, index); // App Version
			currentApp.add(currentInput);
			line = line.substring(index + 1);
			index = line.indexOf(" ");
			currentInput = line.substring(0, index+1); // App Gener
			currentApp.add(currentInput);
			data.add(new ArrayList<String>(currentApp));
			currentApp.clear();
		}
	}
}
