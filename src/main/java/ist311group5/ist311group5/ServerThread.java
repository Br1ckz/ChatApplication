package ist311group5.ist311group5;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerThread implements Runnable{
    private ServerSocket serverSocket;
    private ChatCntl controller;
    private ChatServer chatServer;
    private Socket socket;
    public ServerThread (ServerSocket serverSocket, ChatCntl chatController) {
        this.serverSocket = serverSocket;
        controller = chatController;
    }
    
    public void run() {
        ArrayList<ChatServer> threadList = new ArrayList<>();
        try {
            while (true) {
                socket = serverSocket.accept();            
                chatServer = new ChatServer(socket, threadList, controller);
                threadList.add(chatServer);
                chatServer.start();
            }
        } catch (Exception e) {e.printStackTrace();}
    }
}