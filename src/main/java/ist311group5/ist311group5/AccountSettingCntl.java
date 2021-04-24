package ist311group5.ist311group5;

import javafx.stage.Stage;

public class AccountSettingCntl implements Controller{
    private AccountSettingGUI accountSettingUI;
    private AccountSettingFile accountSettingFile;
    private Stage stage;
    private GeneralSettingFile generalSettingFile;
    public AccountSettingCntl(Stage stage, GeneralSettingFile generalSettingFile) {
        this.stage = stage;
        this.generalSettingFile = generalSettingFile;
        accountSettingUI = new AccountSettingGUI(stage, this);
    }
    
    /**
     * Changes the controls to another controller 
     */
    public void changeControl(String controller) {
        NavigationCntl navCntl = new NavigationCntl(stage, generalSettingFile);
    }
    
    /**
     * Connects to the account setting file class.
     * Writes to account setting file.
     */
    public void updateAccountFile(String username, String password, String newPassword) {
        accountSettingFile = new AccountSettingFile(username, password);
        accountSettingFile.writeToFile(username, newPassword); 
    }
    
    /**
     * Retrieves the general settings.
     */
    public String[] getGeneralSetting() {
        String username = generalSettingFile.getUsername();
        return generalSettingFile.readFile(username);
    }

    /**
     * Gets the font size.
     */
    public int getFont() {
        return generalSettingFile.getFontSize();
    }
}