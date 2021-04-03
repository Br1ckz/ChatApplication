/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ist311group5.ist311group5;

import java.net.ServerSocket;
import javafx.stage.Stage;

public class ChatCntl {
    private ChatGUI chatUI;
    private ChatClient client;
    private ServerThread serverThread;
    
    public ChatCntl(Stage stage) {
        chatUI = new ChatGUI(stage, this);
    }
    
    
    
//    public void run(Stage stage) {
//        
//        chatUI = new ChatGUI(stage);
//    }
    
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
    
    
    
}
