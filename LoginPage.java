package TrackePage;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
import UserInformation.UsernamePasswords;

public class LoginPage implements ActionListener {
	private static JFrame loginPage;
	private static JTextField userText;
	private static JLabel username;
	private static JLabel passwordLabel;
	private static JPasswordField passwordField;
	private static JButton loginButton;
	private static JButton resetButton;
	private static JLabel label2;
	private static JPanel panel1;
	private static JPanel panel2;
    private JComboBox<String> dropDown;
	
	
	public LoginPage() {
		UsernamePasswords.loadUserCredentials("src/Resources/Username&Passwords");
		initialize();
	}
	
    public void initialize() {
        // Create main frame
        loginPage = new JFrame();
        loginPage.setSize(500, 500);
        loginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginPage.setLocationRelativeTo(null);
        loginPage.setResizable(true);
        loginPage.setTitle("Expense Tracker");

        // Panel2 (Navigation Bar)
        panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        panel2.setBackground(Color.RED);

        label2 = new JLabel("MyTracker", JLabel.CENTER);
        label2.setFont(new Font("Arial", Font.BOLD, 24));
        label2.setForeground(Color.WHITE);
        panel2.add(label2, BorderLayout.CENTER);

        // Add panel2 to the top of the frame
        loginPage.add(panel2, BorderLayout.NORTH);

        String[] dropdownString = {"Login", "Create Account"};
        dropDown = new JComboBox<>(dropdownString);
        dropDown.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedOption = (String) dropDown.getSelectedItem();
                
                // Navigate based on selected option
                if ("Login".equals(selectedOption)) {
                    loginPage.dispose();  // Close the current page
                    new LoginPage();  // Open the Login Page
                } else if ("Create Account".equals(selectedOption)) {
                    loginPage.dispose();  // Close the current page
                    new CreateAccount();  // Open the Create Account Page
                }
            }
        });
        JPanel dropdownPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        dropdownPanel.setBackground(Color.RED);
        dropdownPanel.add(dropDown);
        panel2.add(dropdownPanel, BorderLayout.EAST);

        // Panel1 (Form Content)
        panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Username Label
        username = new JLabel("Username: ");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel1.add(username, gbc);

        // Username TextField
        userText = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel1.add(userText, gbc);

        // Password Label
        passwordLabel = new JLabel("Password: ");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel1.add(passwordLabel, gbc);

        // Password Field
        passwordField = new JPasswordField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel1.add(passwordField, gbc);

        // Login Button
        loginButton = new JButton("Login");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        loginButton.addActionListener(this);
        panel1.add(loginButton, gbc);

        // Reset Button
        resetButton = new JButton("Reset");
        gbc.gridx = 1;
        gbc.gridy = 2;
        resetButton.addActionListener(this);
        panel1.add(resetButton, gbc);

        // Add panel1 (form) to the center of the frame
        loginPage.add(panel1, BorderLayout.CENTER);

        // Make the frame visible
        loginPage.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resetButton) {
            userText.setText("");
            passwordField.setText("");
        }

        if (e.getSource() == loginButton) {
            String user = userText.getText();
            String password = String.valueOf(passwordField.getPassword());

            // Check if user exists and password matches
            if (UsernamePasswords.usernameExists(user) && UsernamePasswords.checkPassword(user, password)) {
                JOptionPane.showMessageDialog(loginPage, "Login successful!");
                loginPage.dispose(); // Close the login frame
                MainTrackerPage mainTrackerPage = new MainTrackerPage(); // Assume this class exists
            } else {
                JOptionPane.showMessageDialog(loginPage, "Invalid username or password.");
            }
        }
    }
	

}
