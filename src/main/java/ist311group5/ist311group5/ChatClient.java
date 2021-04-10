package ist311group5.ist311group5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient extends Thread {
    private Socket socket;
    private DataInputStream dataInput;
    private DataOutputStream dataOutput;
  
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
    
    public void sendMessage(String message) {
        try {
            dataOutput.writeUTF(message);
            dataOutput.flush();
        } catch (Exception e) { e.printStackTrace();}
    }
}