package ist311group5.ist311group5;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public abstract class Account {
    String username;
    String password;
    int id = 1000;
    String userId;
    
    /**
     * Account constructor
     * @param username
     * @param password 
     */
    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }
     
    abstract public void createFile(String userName);

    /**
     * Updates the username for an account.
     * @param newUsername 
     */
    public void changeUsername(String newUsername) {
        this.username = newUsername;
    }
    
    /**
     * Updates the password for an account.
     * @param newPassword 
     */
    public void changePassword(String newPassword) {
        this.password = newPassword;
    }
    
    /**
     * 
     * @param enteredUsername
     * @param enteredPassword
     * @return boolean for matching credentials.
     */
    protected boolean validateLogin(String enteredUsername, String enteredPassword) {
        boolean correctCredentials = false;
        boolean correctUsername = false;
        boolean correctPassword = false;
        if(this.username.equals(enteredUsername)) {
            correctUsername = true;
        }
        if(this.password.equals(enteredPassword)) {
            correctPassword = true;
        }
        
        if(!correctUsername || !correctPassword) {
            System.out.println("Incorrect credentials");
        } else {
            System.out.println("Correct credentials");
            correctCredentials = true;
        }
        return correctCredentials;
    }
    
    /**
     * Set the userId for based on the username.
     */
    public void setUserId() {
        this.userId = this.username + id;
        updateId();
    }
    
    /**
     * Updates the id used for userId creation.
     */
    public void updateId() {
        id++;
    }
    
    /**
     * Gets the current id number.
     * @return id number
     */
    public int getId() {
        return id;
    }
    
    /**
     * Gets the username of the account instance.
     * @return username
     */
    public String getUsername() {
        return this.username;
    }
    
    /**
     * Get the password for the account instance.
     * @return password
     */
    public String getPassword() {
        return this.password;
    }
    
    /**
     * Gets the userId for the account instance.
     * @return user id
     */
    public String getUserId() {
        return this.userId;
    }
    
    /**
     * Checks that the second password matches the first.
     * Used when creating account.
     * @param otherPassword
     * @return boolean of matching passwords
     */
    public boolean verifyPassword(String otherPassword) {
        boolean samePassword = false;
        if (this.password.equals(otherPassword)) {
            samePassword = true;
        } 
        
        return samePassword;
    } 
    
    /**
     * User id and the username are return
     * @return userId and username
     */
    @Override
    public String toString() {
        return userId + " " + username;
    }
    
    
    /**
     * Changes contents of account file.
     * @param filename
     * @param data 
     */
    public static void writeToFile(String filename, String data) {
        try {
            File file = new File(filename);
            FileWriter accountFile = new FileWriter(file);
            accountFile.write(data);
            accountFile.close();
        } catch (IOException e){
            System.out.println("Error during file creation.");
            e.printStackTrace();
        }
    }
}