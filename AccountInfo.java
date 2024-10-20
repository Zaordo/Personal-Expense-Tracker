package TrackePage;
import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
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
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;

public class AccountInfo {

	private static JFrame accountPage;
	private static JLabel account;
	private static JLabel label2;
	private static JPanel panel1;
	private static JPanel panel2;
    private static JTextArea nameTextArea;
    private static JTextArea usernameTextArea;
    private static JTextArea numberTextArea;
    private static JLabel image;
    private static JLabel navLabel;
    private JComboBox<String> dropDown;

	public AccountInfo() {
		initialize();
	}
	
	private void initialize() {
        accountPage = new JFrame();
        accountPage.setSize(500, 500);
        accountPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        accountPage.setLocationRelativeTo(null);
        accountPage.setResizable(true);
        accountPage.setTitle("Expense Tracker");
        accountPage.setLayout(new BorderLayout()); // Use BorderLayout for main layout

        // Set up the navbar (panel1)
        panel1 = new JPanel();
        panel1.setBackground(Color.RED);
        panel1.setPreferredSize(new Dimension(500, 50)); // Fixed height for the navbar
        panel1.setLayout(new FlowLayout(FlowLayout.LEFT)); // Align contents of the navbar to the left
        accountPage.add(panel1, BorderLayout.NORTH);

        navLabel = new JLabel("TRACKER");
        navLabel.setForeground(Color.WHITE); // White text on red background
        panel1.add(navLabel);

        // Set up content panel (panel2)
        panel2 = new JPanel();
        panel2.setLayout(new GridBagLayout()); // Use GridBagLayout for flexible positioning
        panel2.setBackground(Color.WHITE); // Light background for contrast
        accountPage.add(panel2, BorderLayout.CENTER);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Add padding between components
        
        
        String[] dropdownString = {"Home", "Account Info", "Logout"};
        dropDown = new JComboBox<>(dropdownString);
        dropDown.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedOption = (String) dropDown.getSelectedItem();
                
                // We act according to the dropdown button selected
                switch (selectedOption) {
                    case "Home":
                    	accountPage.dispose();
                        new MainTrackerPage(); // Open Home Page
                        break;
                    case "Account Info":
                    	accountPage.dispose();
                        new AccountInfo(); // Open Account Info Page
                        break;                    
                    case "Logout":
                    	JOptionPane.showMessageDialog(accountPage, "You've been logged out.");
                    	accountPage.dispose();
                        new LoginPage(); // Open Logout Page
                        break;
                    default:
                        JOptionPane.showMessageDialog(accountPage, "Invalid option selected.");
                        break;
                }
            }
        });
        JPanel dropdownPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT)); // Flow layout for right alignment
        dropdownPanel.setBackground(Color.RED); // Same background color as mainPanel
        dropdownPanel.add(dropDown);
        panel1.add(dropdownPanel, BorderLayout.EAST); // Add dropdown to the right
        

        // Add profile image
        ImageIcon originalIcon = new ImageIcon("src/Resources/Profile_Picture_Png.png");

     // Resize the image to 100x100 pixels (or any size you prefer)
     Image originalImage = originalIcon.getImage();
     Image resizedImage = originalImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
     ImageIcon resizedIcon = new ImageIcon(resizedImage);

     image = new JLabel(resizedIcon);

     // GridBagConstraints settings to center the image
     gbc.gridx = 0;
     gbc.gridy = 0;
     gbc.gridwidth = 2; // Span across two columns for centering
     gbc.anchor = GridBagConstraints.CENTER; // Center the image
     panel2.add(image, gbc);

        // Add name field
        nameTextArea = new JTextArea("Name: ");
        nameTextArea.setEditable(false);
        nameTextArea.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1; // Reset to single column
        gbc.anchor = GridBagConstraints.WEST; // Align to the left
        panel2.add(nameTextArea, gbc);

        // Add username field
        usernameTextArea = new JTextArea("Username: ");
        usernameTextArea.setEditable(false);
        usernameTextArea.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridy = 2; // Move to the next row
        panel2.add(usernameTextArea, gbc);

        // Add phone number field
        numberTextArea = new JTextArea("Phone Number: ");
        numberTextArea.setEditable(false);
        numberTextArea.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridy = 3; // Move to the next row
        panel2.add(numberTextArea, gbc);

        // Make the frame visible
        accountPage.setVisible(true);
	}
}
