package ist311group5.ist311group5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer extends Thread {
    private Socket socket;
    private ArrayList<ChatServer> threadList;
    private ChatCntl controller;
    private ArrayList<Socket> socketList;
    
    public ChatServer(Socket socket, ArrayList<ChatServer> threads, ChatCntl chatController, ArrayList<Socket> socketList) {
        this.socket = socket;
        this.threadList = threads;
        controller = chatController;
        this.socketList = socketList;
    }
    
    /**
     * Runs the chat server. 
     * Receives and sends messages from all connected
     * chat clients.
     */
    @Override
    public void run() {
        try {
            DataInputStream dataInput = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutput = new DataOutputStream(socket.getOutputStream());

            String recieved = "";
            while (true) { 
                recieved = dataInput.readUTF();
                for (Socket otherSocket : socketList) {
                    if (otherSocket.getPort() != this.socket.getPort()) {
                        System.out.println(otherSocket);
                        dataOutput = new DataOutputStream(otherSocket.getOutputStream());
                        dataOutput.writeUTF(recieved);
                        dataOutput.flush();
                    }
                }
//                showMessage(recieved); 
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error encountered while running server.");      
        }
    }
    
    /**
     * Sends message to chat controller.
     */
    public void showMessage(String message) {
                controller.serverResponse(message);
    }
}