package ist311group5.ist311group5;

import javafx.stage.Stage;

public class GeneralSettingCntl {
    private GeneralSettingGUI generalSettingUI;
    private Stage stage;
    public GeneralSettingCntl(Stage stage) {
        this.stage = stage;
        generalSettingUI = new GeneralSettingGUI(stage, this);
    }
    
    public void changeControl(String controller) {
        if (controller.equals("Back")) {
            NavigationCntl navCntl = new NavigationCntl(stage);
        }
    }
}