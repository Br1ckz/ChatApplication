/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ist311group5.ist311group5;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class ChatServer extends Thread {
    private Socket socket;
    private ArrayList<ChatServer> threadList;
    public ChatServer(Socket socket, ArrayList<ChatServer> threads) {
        this.socket = socket;
        this.threadList = threads;
    }
    
    @Override
    public void run() {

        try {
            DataInputStream dataInput = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutput = new DataOutputStream(socket.getOutputStream());

            String recieved = "";
            while (true) {
                recieved = dataInput.readUTF();
                System.out.println("Server: You said \"" + recieved + "\"");        
            }
//            dataInput.close();
//            dataOutput.close();
//            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error encountered while running server.");
            
        }
    }
}
