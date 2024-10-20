package TrackePage;
import javax.swing.JFrame;
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

public class MainTrackerPage {

	private static JFrame mainPage;
	private static JPanel mainPanel;
	
	public MainTrackerPage() {
		initialize();		
	}
	
	private void initialize() {
		mainPage = new JFrame();
		mainPanel = new JPanel();
		mainPage.setSize(500, 500);
		mainPage.setLayout(null);
		mainPage.setVisible(true);
	}
	
}
