package TrackePage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import UserInformation.UsernamePasswords;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CreateAccount implements ActionListener{

	private static JFrame createPage;
	private static JLabel account;
	private static JLabel label2;
	private static JPanel panel1;
	private static JPanel panel2;
	private static JLabel name;
	private static JTextField nameInput;
    private static JLabel username; 
    private static JTextField usernameInput; // 
    private static JLabel password;
    private static JPasswordField passwordInput;
    private static JLabel number;
    private static JTextField numberInput;
    private static JLabel image;
    private static JLabel navLabel;
    private static JButton create;
    private JComboBox<String> dropDown;
    
    public CreateAccount() {
		initialize();
	}
    
    private void initialize() {
    	 createPage = new JFrame();
    	    createPage.setSize(500, 500);
    	    createPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	    createPage.setLocationRelativeTo(null);
    	    createPage.setResizable(true);
    	    createPage.setTitle("Expense Tracker");
    	    createPage.setLayout(new BorderLayout()); // Use BorderLayout for main layout

    	    // This is the nav bar panel
    	    panel1 = new JPanel();
    	    panel1.setBackground(Color.RED);
    	    panel1.setPreferredSize(new Dimension(500, 50)); // Fixed height for the navbar
    	    panel1.setLayout(new FlowLayout(FlowLayout.RIGHT)); // Align contents of the navbar to the right
    	    createPage.add(panel1, BorderLayout.NORTH);

    	    navLabel = new JLabel("TRACKER");
    	    navLabel.setForeground(Color.WHITE); // White text on red background
    	    panel1.add(navLabel);
    	    
    	    // Drop down will be added to the nav bar
    	    String[] dropdownString = {"Login", "Create Account"};
            dropDown = new JComboBox<>(dropdownString);
            dropDown.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String selectedOption = (String) dropDown.getSelectedItem();
                    if ("Create Account".equals(selectedOption)) {
                    	createPage.dispose();
                        new CreateAccount(); // Navigate to AccountPage
                    } else if ("Login".equals(selectedOption)) {
                        JOptionPane.showMessageDialog(createPage, "Login selected"); // You can implement login here
                        createPage.dispose();
                        new LoginPage();
                    }
                }
            });
    	    panel1.add(dropDown); // Add dropdown to the right of the nav bar

    	    // This will contain all of the content of the page
    	    panel2 = new JPanel();
    	    panel2.setLayout(new GridBagLayout());
    	    createPage.add(panel2, BorderLayout.CENTER); // Add panel2 to the center of the BorderLayout
    	    GridBagConstraints gbc = new GridBagConstraints();
    	    gbc.insets = new Insets(10, 10, 10, 10);  // Add padding between elements

    	    // Name Label
    	    name = new JLabel("Name: ");
    	    gbc.gridx = 0;  // Column 0
    	    gbc.gridy = 0;  // Row 0
    	    panel2.add(name, gbc);

    	    // Name TextField
    	    nameInput = new JTextField(20);
    	    gbc.gridx = 1;  // Column 1
    	    gbc.gridy = 0;  // Row 0
    	    gbc.weightx = 1.0; // Allow the text field to grow horizontally
    	    panel2.add(nameInput, gbc);
    	    
    	    // Number Label
    	    number = new JLabel("Number: ");
    	    gbc.gridx = 0;  // Column 0
    	    gbc.gridy = 1;  // Row 1 (next row after Name)
    	    panel2.add(number, gbc);
    	    
    	    // Number TextField
    	    numberInput = new JTextField(20); // Set the same width as nameInput
    	    gbc.gridx = 1;  // Column 1
    	    gbc.gridy = 1;  // Row 1
    	    gbc.weightx = 1.0; // Allow the text field to grow horizontally
    	    panel2.add(numberInput, gbc);

    	    // Username Label
    	    username = new JLabel("Username: ");
    	    gbc.gridx = 0;  // Column 0
    	    gbc.gridy = 2;  // Row 2
    	    panel2.add(username, gbc);

    	    // Username TextField
    	    usernameInput = new JTextField(20);
    	    gbc.gridx = 1;  // Column 1
    	    gbc.gridy = 2;  // Row 2
    	    gbc.weightx = 1.0; // Allow the text field to grow horizontally
    	    panel2.add(usernameInput, gbc);

    	    // Password Label
    	    password = new JLabel("Password: ");
    	    gbc.gridx = 0;  // Column 0
    	    gbc.gridy = 3;  // Row 3
    	    panel2.add(password, gbc);

    	    // Password Field
    	    passwordInput = new JPasswordField(20);
    	    gbc.gridx = 1;  // Column 1
    	    gbc.gridy = 3;  // Row 3
    	    gbc.weightx = 1.0; // Allow the password field to grow horizontally
    	    panel2.add(passwordInput, gbc);

    	    // Create Button
    	    create = new JButton("Create");
    	    gbc.gridx = 0;  // Column 0
    	    gbc.gridy = 4;  // Row 4 (next row after Password)
    	    gbc.gridwidth = 2;  // Span both columns
    	    create.addActionListener(this);
    	    panel2.add(create, gbc);

    	    createPage.setVisible(true);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		 if (e.getSource() == create) {
		        String user = usernameInput.getText();
		        String password = String.valueOf(passwordInput.getPassword());

		        // Check if username already exists
		        if (!UsernamePasswords.usernameExists(user)) {
		            // Create a new user and store in the HashMap
		            new UsernamePasswords(user, password);
		            JOptionPane.showMessageDialog(createPage, "Account created successfully! Login with new account.");
		            // should take us back to the login page to login with this new account
		            createPage.dispose();
		            new LoginPage();
		        } else {
		            JOptionPane.showMessageDialog(createPage, "Username already exists. Login with existing account.");
		            createPage.dispose();
		            new LoginPage();
		        }
		    }
		
	}
}
