package ist311group5.ist311group5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer extends Thread {
    private Socket socket;
    private ArrayList<ChatServer> threadList;
    private ChatCntl controller;
    public ChatServer(Socket socket, ArrayList<ChatServer> threads, ChatCntl chatController) {
        this.socket = socket;
        this.threadList = threads;
        controller = chatController;
    }
    
    @Override
    public void run() {
        try {
            DataInputStream dataInput = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutput = new DataOutputStream(socket.getOutputStream());

            String recieved = "";
            while (true) {
                recieved = dataInput.readUTF();
                showMessage(recieved); 
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error encountered while running server.");      
        }
    }
    
    public void showMessage(String message) {
                controller.serverResponse(message);
    }
}