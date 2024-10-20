package UserInformation;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class UsernamePasswords {
    // Static HashMap to store usernames and passwords
    private static HashMap<String, String> usernameAndPasswords = new HashMap<>();

    // Constructor (optional) - could be used for creating new users
    public UsernamePasswords(String username, String password) {
        usernameAndPasswords.put(username, password);
    }

    // Static method to load user credentials from a file
    public static void loadUserCredentials(String filePath) {
        try {
            File file = new File(filePath);
            Scanner in = new Scanner(file);
            while (in.hasNextLine()) {
                String line = in.nextLine();
                String[] credentials = line.split(" "); // Assuming 'username password' format
                if (credentials.length == 2) {
                    String user = credentials[0];
                    String pass = credentials[1];
                    usernameAndPasswords.put(user, pass); // Add to HashMap
                }
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("User credentials file not found.");
        }
    }

    // Static method to check if a username exists
    public static boolean usernameExists(String username) {
        return usernameAndPasswords.containsKey(username);
    }

    // Static method to check the password for a given username
    public static boolean checkPassword(String username, String password) {
        return password.equals(usernameAndPasswords.get(username));
    }

    // Static method to add a new user (if needed)
    public static void addUser(String username, String password) {
        usernameAndPasswords.put(username, password);
    }
}
