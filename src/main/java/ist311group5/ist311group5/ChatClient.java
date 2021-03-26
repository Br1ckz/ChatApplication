/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ist311group5.ist311group5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient extends Thread {
    Socket socket;
    DataInputStream dataInput;
    DataOutputStream dataOutput;
  
    public void run() {
        Scanner scanner = new Scanner(System.in);

        try {
            socket = new Socket("localhost", 5000);
            
            dataInput = new DataInputStream(socket.getInputStream());
            dataOutput = new DataOutputStream(socket.getOutputStream());
            
            String thisUser = "", otherUser = "";
            System.out.println("Client running");
            System.out.println("You can enter you message here.");
            while (true) {
                
                thisUser = scanner.nextLine();

                dataOutput.writeUTF(thisUser);
                dataOutput.flush();

            }
        } catch (Exception e) {
            System.out.println("Error creating client.");
            e.printStackTrace();
        };        
    }
    
}