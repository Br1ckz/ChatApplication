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
    public void run(Stage stage) {
        
        chatUI = new ChatGUI(stage);
    }
    
    public static void chat() {
         try {
            System.out.println("Starting chat");
            ServerSocket serverSocket = new ServerSocket(5000);
            new Thread(new ServerThread(serverSocket)).start();
            new Thread(new ChatClient()).start();
        } catch (Exception e) {};
    }
    
    public static String getInput(String message) {
        return message;
    }  
}
