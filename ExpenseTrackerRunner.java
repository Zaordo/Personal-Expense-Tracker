package TrackePage;
import javax.swing.SwingUtilities;




public class ExpenseTrackerRunner {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {      
			@Override
			public void run() { // this will be what runs the Jframe and the pop-up panel
				//JFrameOne frame1 = new JFrameOne(); // this is a specific object of JFrame that will have certain JFrame implementations
				// frame1. --> this means that the launcher class has access to modify all the methods from JFrameOne class
				// this is not good because other people and external sources can modify our JFrameOne code
				// which is not what we want
				//JFrameTwo frame2 = new JFrameTwo();
				// frame2. --> we no longer have access to the methods in 
				// JFrameTwo class, meaning JFrameTwo is secured
				LoginPage loginPage = new LoginPage();
//				MainTrackerPage trackerPage = new MainTrackerPage();
//				AccountInfo accountInfo = new AccountInfo();
//				CreateAccount createAccount = new CreateAccount();
				
			}
			
		}); 
	}

}
