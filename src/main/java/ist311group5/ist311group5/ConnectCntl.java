package ist311group5.ist311group5;

import javafx.stage.Stage;

public class ConnectCntl implements Controller{
    private ConnectGUI connectUI;
    private Stage stage;
    private GeneralSettingFile generalSettingFile;
    public ConnectCntl(Stage stage, GeneralSettingFile generalSettingFile) {
        this.stage = stage;
        this.generalSettingFile = generalSettingFile;
        connectUI = new ConnectGUI(stage, this);
    }
    
    public void changeControl(String controller) {
        if (controller.equals("Chat")) {
            ChatCntl chatCntl = new ChatCntl(stage, generalSettingFile);
        } else if (controller.equals("Back")) {
            NavigationCntl navCntl = new NavigationCntl(stage, generalSettingFile);
        }
    }
    
    public String[] getGeneralSetting() {
        String username = generalSettingFile.getUsername();
        return generalSettingFile.readFile(username);
    }
    
    public int getFont() {
        return generalSettingFile.getFontSize();
    }
}