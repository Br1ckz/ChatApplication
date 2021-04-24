package ist311group5.ist311group5;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AccountSettingFile extends Account{
    
    public AccountSettingFile(String username, String password) {
        super(username, password);
    }
    
    public void createFile(String username) {
        File accountFile = new File(username + ".txt");
        try {
            if (accountFile.createNewFile()) {
                System.out.println("Created: " + accountFile.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("Error occured");
            e.printStackTrace();
        }
    }
    
        /**
     * Changes contents of account file.
     * @param filename
     * @param data 
     */
    public void writeToFile(String username, String newPassword) {
        try {
            File file = new File(username + ".txt");
            FileWriter accountFile = new FileWriter(file);
            accountFile.write(username);
            accountFile.write("\n");
            accountFile.write(newPassword);
            accountFile.close();
        } catch (IOException e){
            System.out.println("Error during file creation.");
            e.printStackTrace();
        }
    }
}
