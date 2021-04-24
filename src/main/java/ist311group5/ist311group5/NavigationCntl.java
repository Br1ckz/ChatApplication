package ist311group5.ist311group5;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class NavigationCntl implements Controller {
    private NavigationGUI navUI;
    private Stage stage;
    private GeneralSettingFile generalSettingFile;

    public NavigationCntl(Stage stage, GeneralSettingFile generalSettingFile) {
        this.stage = stage;
        this.generalSettingFile = generalSettingFile;
        navUI = new NavigationGUI(stage, this);
    } 
    
    /**
     * Changes the controls to the connect, general setting,
     * account setting, or login controller.
     */
    public void changeControl(String controller) {
        if (controller.equals("Connect")) {
            ConnectCntl connectCntl = new ConnectCntl(stage, generalSettingFile);
        } else if (controller.equals("General Settings")) {
            GeneralSettingCntl generalSettingCntl = new GeneralSettingCntl(stage, generalSettingFile);
        } else if (controller.equals("Account Settings")) {
            AccountSettingCntl accountSettingCntl = new AccountSettingCntl(stage, generalSettingFile);
        } else if (controller.equals("Logout")) {
            LoginCntl loginCntl = new LoginCntl(stage);
        }
    }
    
    /**
     * Retrieves the general settings.
     */
    public String[] getGeneralSetting() {
        String username = generalSettingFile.getUsername();
        return generalSettingFile.readFile(username);
    }
}