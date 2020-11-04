
import javax.swing.*;

public class guiExampleTest {
	private static void createAndShowGUI() {
		JFrame frame = new JFrame("AppOrganization");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel label = new JLabel("   Hello World!   ");
		//JLabel label2 = new JLabel("   Welcome   ");
		frame.getContentPane().add(label);
		//frame.getContentPane().add(label2);
		
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}
