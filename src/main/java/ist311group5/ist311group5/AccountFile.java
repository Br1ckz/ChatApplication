package ist311group5.ist311group5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class AccountFile extends Account{
    String filename;
    String creationDate;
  
    public AccountFile(String username, String password) {
        super(username, password);
    }
    
    /**
     * Creates account file. 
     * @param username 
     */
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
    
//    /**
//     * Changes contents of account file.
//     * @param filename
//     * @param data 
//     */
//    public static void manipulateFile(String filename, String data) {
//        try {
//            File file = new File(filename);
//            FileWriter accountFile = new FileWriter(file);
//            accountFile.write(data);
//            accountFile.close();
//        } catch (IOException e){
//            System.out.println("Error during file creation.");
//            e.printStackTrace();
//        }
//    }
    
    /**
     * Reads from account file.
     * @param file
     * @return credentials in file.
     */
    public static List<String> readFile(String file) {
        List credentials = new ArrayList<String>();
        try {
            File accountFile = new File(file);
            Scanner accountFileReader = new Scanner(accountFile);
            while(accountFileReader.hasNextLine()) {
                credentials.add(accountFileReader.nextLine());
            }
            accountFileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file.");
            e.printStackTrace();
        }
        
        return credentials;
    }
    
    /**
     * Sets creation date of account file.
     */
    public void setCreationDate() {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM.dd.yyyy");
        this.creationDate = dateFormat.format(currentDate); 
    }
    
    /**
     * Gets the creation date of account file.
     * @return date file created
     */
    public String getCreationDate() {
        return this.creationDate;
    }
    
    /**
     * Sets the filename.
     * @param username 
     */
    public void setFilename(String username) {
        this.filename = username;
    }
    
    /**
     * Gets the filename.
     * @return name of account file
     */
    public String getFilename() {
        return this.filename;
    }
    
    /**
     * Creation date and filename of account file returned.
     * @return creation date and file name of account file.
     */
    public String toString() {
        return creationDate + " " + filename;
    }
    
    /**
     * Adds the login to file.
     * User can then login to their account.
     */
    public void addLogin() {
        String filename = "userList.txt";
        try {
            File file = new File(filename);
            FileWriter accountFile = new FileWriter(file, true);
            accountFile.write("\n\n" + username + " " + password);
            accountFile.close();
        } catch (IOException e){
            System.out.println("Error finding file.");
            e.printStackTrace();
        }
    }  
}