/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ist311group5.ist311group5;

import javafx.stage.Stage;

public class AccountSettingCntl {
    private AccountSettingGUI accountSettingUI;
    private AccountSettingFile accountSettingFile;
    private Stage stage;
    public AccountSettingCntl(Stage stage) {
        this.stage = stage;
        accountSettingUI = new AccountSettingGUI(stage, this);
    }
    
    public void changeControl(String controller) {
        NavigationCntl navCntl = new NavigationCntl(stage);
    }
    
    public void updateAccountFile(String username, String password, String newPassword) {
        accountSettingFile = new AccountSettingFile(username, password);
        accountSettingFile.writeToFile(username, newPassword); 
    }
}