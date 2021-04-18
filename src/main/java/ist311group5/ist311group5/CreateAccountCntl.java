package ist311group5.ist311group5;

import javafx.stage.Stage;

public class CreateAccountCntl {
    private CreateAccountGUI createAccountUI;
    private Stage stage;
    private AccountFile accountFile;
    
    public CreateAccountCntl(Stage stage) {
        this.stage = stage;
        createAccountUI = new CreateAccountGUI(stage, this);
        accountFile = new AccountFile();
    }
    
    /**
     * Changes the controller to the login controller.
     * @param controller Name of controller
     */
    public void changeControl(String controller) {
        if (controller.equals("Back")){
            LoginCntl loginCntl = new LoginCntl(stage);
        }
    }
   
    /**
     * Creates the account file using the username.
     * @param userName The username entered when creating an account.
     * @param password The password entered when creating an accoun.
     */
    public void createAccountFile(String userName, String password) {
        accountFile.createFile(userName);
        accountFile.manipulateFile(userName + ".txt", userName + "\n" + password);
    }
}