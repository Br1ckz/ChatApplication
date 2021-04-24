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
 
    /**
     * Starts the server thread and chat client
     */
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
    
    /**
     * Sends input to chat client
     */
    public void chatInput(String message) {
        client.sendMessage(message);
    }  
    
    /**
     * Receives message from chat client and 
     * sends to chat UI
     */
    public void serverResponse(String message) {
        chatUI.updateChat("Server", message);
    }
    
    /**
     * Changes the controls to to navigation controller
     */
    public void changeControl(String controller) {
        if (controller.equals("Back")) {
            ConnectCntl navCntl = new ConnectCntl(stage, generalSettingFile);
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