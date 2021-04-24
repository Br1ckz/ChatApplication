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
    
    /**
     * Creates a new chat server.
     * Manages client connections with threads and sockets.
     */
    public void run() {
        ArrayList<ChatServer> threadList = new ArrayList<>();
        ArrayList<Socket> socketList = new ArrayList<>();
        try {
            while (true) {
                socket = serverSocket.accept();            
                socketList.add(socket);
                chatServer = new ChatServer(socket, threadList, controller, socketList);
                threadList.add(chatServer);
                chatServer.start();
                System.out.println("Accepted new user at " + socket);
            }
        } catch (Exception e) {e.printStackTrace();}
    }
}