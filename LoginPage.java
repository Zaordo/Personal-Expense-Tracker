package TrackePage;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;

public class LoginPage implements ActionListener {
	private static JFrame loginPage;
	private static JTextField userText;
	private static JLabel username;
	private static JLabel passwordLabel;
	private static JPasswordField passwordField;
	private static JButton loginButton;
	private static JButton resetButton;
	private JLabel label2;
	private JPanel panel;
	
	public LoginPage() {
		initialize();
	}
	
	public void initialize() {
		loginPage = new JFrame();
		panel = new JPanel();
		loginPage.setSize(500, 500);
		loginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// this is our initial page. If we close the frame, we exit out of the overall screen
		// on any other page once we've logged in will dispose on close
		loginPage.setLocationRelativeTo(null);
		loginPage.setResizable(true);
		loginPage.setTitle("Expense Tracker");
		
		panel.setLayout(null);
		
		loginPage.add(panel); // the panel will appear in the frame. Now we have to customize the panel
		
		username = new JLabel("Username: ");
		username.setBounds(5, 10, 80, 25);
		panel.add(username);
		
		userText = new JTextField(20);
		userText.setBounds(100, 20, 165, 25);
		panel.add(userText);
		
		
		
		passwordLabel = new JLabel("Password: ");
		passwordLabel.setBounds(10, 50, 80, 25);
		panel.add(passwordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(100, 50, 165, 25);
		panel.add(passwordField);
		
		loginButton = new JButton("Login");
		loginButton.setBounds(10, 80, 80, 25);
		loginButton.addActionListener(this);
		panel.add(loginButton);
		
		resetButton = new JButton("Reset");
		resetButton.setBounds(20, 80, 80, 25);
		resetButton.addActionListener(this);
		panel.add(resetButton);
		
		
		
		
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

            JFileChooser chooser = new JFileChooser();
            int choice = chooser.showOpenDialog(null);
            if (choice == JFileChooser.APPROVE_OPTION) {
                File f = chooser.getSelectedFile();

                try {
                    Scanner in = new Scanner(f);
                    boolean loginSuccess = false;

                    while (in.hasNextLine()) {
                        String line = in.nextLine();
                        String[] credentials = line.split(" "); // Assuming 'username password' format

                        if (credentials.length == 2) {
                            String fileUser = credentials[0];
                            String filePassword = credentials[1];

                            // Check if user and password match
                            if (fileUser.equals(user) && filePassword.equals(password)) {
                                loginSuccess = true;
                                break;
                            }
                        }
                    }

                    in.close();

                    if (loginSuccess) {
                        JOptionPane.showMessageDialog(loginPage, "Login successful!");
                        // Here you can redirect to another page or action
                        loginPage.dispose();
                        MainTrackerPage mainTrackerPage = new MainTrackerPage();
                    } else {
                        JOptionPane.showMessageDialog(loginPage, "Invalid username or password.");
                    }

                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(loginPage, "File not found.");
                }
            } else {
                JOptionPane.showMessageDialog(loginPage, "File selection was canceled.");
            }
        }
    }
	

}
