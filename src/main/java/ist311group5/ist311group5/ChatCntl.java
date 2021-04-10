package ist311group5.ist311group5;

import java.net.ServerSocket;
import javafx.stage.Stage;

public class ChatCntl {
    private ChatGUI chatUI;
    private ChatClient client;
    private ServerThread serverThread;
    private Stage stage;
    public ChatCntl(Stage stage) {
        this.stage = stage;
        chatUI = new ChatGUI(stage, this);
    }
 
    public void chat() {
         try {
            System.out.println("Starting chat");
            ServerSocket serverSocket = new ServerSocket(5000);
            new Thread(serverThread = new ServerThread(serverSocket, this)).start();
            new Thread(client = new ChatClient()).start();
        } catch (Exception e) {};
    }
    
    public void chatInput(String message) {
        client.sendMessage(message);
    }  
    
    public void serverResponse(String message) {
        chatUI.updateChat("Server", message);
    }
    
    public void changeControl(String controller) {
        if (controller.equals("Chat")) {
//            ChatCntl chatCntl = new ChatCntl(stage);
        } else if (controller.equals("Back")) {
            NavigationCntl navCntl = new NavigationCntl(stage);
        }
    }
}