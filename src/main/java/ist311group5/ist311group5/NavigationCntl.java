package ist311group5.ist311group5;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;
public class NavigationCntl{
    private NavigationGUI navUI;
    private Stage stage;
    public NavigationCntl(Stage stage) {
        this.stage = stage;
        navUI = new NavigationGUI(stage, this);
    } 
    
    public void changeControl(String controller) {
        if (controller.equals("Connect")) {
            ConnectCntl connectCntl = new ConnectCntl(stage);
        } else if (controller.equals("General Settings")) {
            GeneralSettingCntl generalSettingCntl = new GeneralSettingCntl(stage);
        } else if (controller.equals("Account Settings")) {
            AccountSettingCntl accountSettingCntl = new AccountSettingCntl(stage);
        } else if (controller.equals("Logout")) {
            LoginCntl loginCntl = new LoginCntl(stage);
        }
    }
}