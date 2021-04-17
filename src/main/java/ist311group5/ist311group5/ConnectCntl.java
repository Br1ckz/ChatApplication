package ist311group5.ist311group5;

import javafx.stage.Stage;

public class ConnectCntl {
    private ConnectGUI connectUI;
    private Stage stage;
    public ConnectCntl(Stage stage) {
        this.stage = stage;
        connectUI = new ConnectGUI(stage, this);
    }
    
    public void changeControl(String controller) {
        if (controller.equals("Chat")) {
            ChatCntl chatCntl = new ChatCntl(stage);
        } else if (controller.equals("Back")) {
            NavigationCntl navCntl = new NavigationCntl(stage);
        }
    }
}