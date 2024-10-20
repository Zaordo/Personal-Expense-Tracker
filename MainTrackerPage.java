package TrackePage;
import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;



public class MainTrackerPage {

	 private static JFrame mainPage;
	    private static JPanel mainPanel;
	    private static JPanel panel2;
	    private static JLabel mainLabel;
	    private JComboBox<String> dropDown;
	    private JTextArea spendingsTextArea;
	    private JTextArea totalSavingsTextArea;

	    public MainTrackerPage() {
	        initialize();
	    }

	    private void initialize() {
	        // Set up the main frame
	        mainPage = new JFrame();
	        mainPage.setSize(500, 500);
	        mainPage.setLayout(new BorderLayout()); // Use BorderLayout for main frame
	        mainPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        mainPage.setLocationRelativeTo(null);
	        mainPage.setResizable(true);
	        mainPage.setTitle("Expense Tracker");

	        // Set up the top panel (mainPanel) for the label and dropdown
	        mainPanel = new JPanel();
	        mainPanel.setLayout(new BorderLayout()); //BorderLayout to organize label and dropdown
	        mainPanel.setBackground(Color.RED);

	     
	        mainLabel = new JLabel("MyTracker", JLabel.CENTER);
	        mainLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Set bigger font
	        mainLabel.setForeground(Color.WHITE); // Set font color to white
	        mainPanel.add(mainLabel, BorderLayout.CENTER);

	        // Dropdown menu aligned to the right
	        String[] dropdownString = {"Home", "Account Info", "Logout"};
	        dropDown = new JComboBox<>(dropdownString);
	        dropDown.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                String selectedOption = (String) dropDown.getSelectedItem();
	                
	                // We act according to the dropdown button selected
	                switch (selectedOption) {
	                    case "Home":
	                    	mainPage.dispose();
	                        new MainTrackerPage(); // Open Home Page
	                        break;
	                    case "Account Info":
	                    	mainPage.dispose();
	                        new AccountInfo(); // Open Account Info Page
	                        break;	           
	                    case "Logout":
	                    	JOptionPane.showMessageDialog(mainPage, "You've been logged out.");
	                    	mainPage.dispose();
	                        new LoginPage(); // Open Logout Page
	                        break;
	                    default:
	                        JOptionPane.showMessageDialog(mainPage, "Invalid option selected.");
	                        break;
	                }
	            }
	        });
	        JPanel dropdownPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT)); // Flow layout for right alignment
	        dropdownPanel.setBackground(Color.RED); // Same background color as mainPanel
	        dropdownPanel.add(dropDown);
	        mainPanel.add(dropdownPanel, BorderLayout.EAST); // Add dropdown to the right

	        // Add the top panel to the top of the frame
	        mainPage.add(mainPanel, BorderLayout.NORTH);

	        // Set up the second panel (panel2) for the rest of the content
	        panel2 = new JPanel();
	        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS)); // Vertical layout for panel2
	        panel2.setBackground(Color.LIGHT_GRAY);

	        // Spendings TextArea with bigger font
	        spendingsTextArea = new JTextArea("Total Spendings this Month: ");
	        spendingsTextArea.setEditable(false); // Make it non-editable
	        spendingsTextArea.setFont(new Font("Arial", Font.PLAIN, 18)); // Set bigger font for readability
	        spendingsTextArea.setPreferredSize(new Dimension(400, 100));
	        spendingsTextArea.setBackground(Color.WHITE);
	        panel2.add(spendingsTextArea);

	        // Savings TextArea with bigger font
	        totalSavingsTextArea = new JTextArea("Total Savings: ");
	        totalSavingsTextArea.setEditable(false);
	        totalSavingsTextArea.setFont(new Font("Arial", Font.PLAIN, 18)); // Set bigger font for readability
	        totalSavingsTextArea.setPreferredSize(new Dimension(400, 100));
	        totalSavingsTextArea.setBackground(Color.WHITE);
	        panel2.add(totalSavingsTextArea);

	        // Add the panel2 to the center of the frame
	        mainPage.add(panel2, BorderLayout.CENTER);

	        // Make the frame visible
	        mainPage.setVisible(true);
	    }
	
}
