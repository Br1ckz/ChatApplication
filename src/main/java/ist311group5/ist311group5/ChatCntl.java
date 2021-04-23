package ist311group5.ist311group5;

import java.net.ServerSocket;
import javafx.stage.Stage;

public class ChatCntl implements Controller {
    private ChatGUI chatUI;
    private ChatClient client;
    private ServerThread serverThread;
    private Stage stage;
    private GeneralSettingFile generalSettingFile;
    public ChatCntl(Stage stage, GeneralSettingFile generalSettingFile) {
        this.stage = stage;
        this.generalSettingFile = generalSettingFile;
        chatUI = new ChatGUI(stage, this);
        chat();
    }
 
    public void chat() {
         try {
            System.out.println("Starting chat");
            ServerSocket serverSocket = new ServerSocket(6000);
            new Thread(serverThread = new ServerThread(serverSocket, this)).start();
        } catch (Exception e) {
            System.out.println("Error creating server");
        };
        
        try {
            new Thread(client = new ChatClient(this)).start();  
        } catch (Exception e) {
            System.out.println("Error creating client");
        };
    }
    
    public void chatInput(String message) {
        client.sendMessage(message);
    }  
    
    public void serverResponse(String message) {
        chatUI.updateChat("Server", message);
    }
    
    public void changeControl(String controller) {
        if (controller.equals("Back")) {
            ConnectCntl navCntl = new ConnectCntl(stage, generalSettingFile);
        }
    }
    
    public String[] getGeneralSetting() {
        String username = generalSettingFile.getUsername();
        return generalSettingFile.readFile(username);
    }
}