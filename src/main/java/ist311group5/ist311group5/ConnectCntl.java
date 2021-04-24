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
    
    /**
     * Changes the controller to chat or navigation controller.
     * @Param controller The name of the controller to switch to.
     */
    public void changeControl(String controller) {
        if (controller.equals("Chat")) {
            ChatCntl chatCntl = new ChatCntl(stage, generalSettingFile);
        } else if (controller.equals("Back")) {
            NavigationCntl navCntl = new NavigationCntl(stage, generalSettingFile);
        }
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