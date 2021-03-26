/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ist311group5.ist311group5;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerThread implements Runnable{
    ServerSocket serverSocket;
    public ServerThread (ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }
    
    public void run() {
        ArrayList<ChatServer> threadList = new ArrayList<>();
        try {
            while (true) {
                Socket socket = serverSocket.accept();            
                ChatServer chatServer = new ChatServer(socket, threadList);
                threadList.add(chatServer);
                chatServer.start();
            }
        } catch (Exception e) {e.printStackTrace();}
    }
}
