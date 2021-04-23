/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    
    public void changeControl(String controller) {
        NavigationCntl navCntl = new NavigationCntl(stage, generalSettingFile);
    }
    
    public void updateAccountFile(String username, String password, String newPassword) {
        accountSettingFile = new AccountSettingFile(username, password);
        accountSettingFile.writeToFile(username, newPassword); 
    }
    
    public String[] getGeneralSetting() {
        String username = generalSettingFile.getUsername();
        return generalSettingFile.readFile(username);
    }

    public int getFont() {
        return generalSettingFile.getFontSize();
    }
}