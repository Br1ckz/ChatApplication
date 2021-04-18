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
    
    public void changeControl(String controller) {
        if (controller.equals("Back")){
            LoginCntl loginCntl = new LoginCntl(stage);
        }
    }
    
    public void createAccountFile(String userName, String password) {
        accountFile.createFile(userName);
        accountFile.manipulateFile(userName + ".txt", userName + "\n" + password);
    }
}