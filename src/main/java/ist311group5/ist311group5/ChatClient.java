package ist311group5.ist311group5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class ChatClient extends Thread {
    private Socket socket;
    private DataInputStream dataInput;
    private DataOutputStream dataOutput;
    
    @Override
    public void run() {
        try {
            socket = new Socket("localhost", 5000);
            dataInput = new DataInputStream(socket.getInputStream());
            dataOutput = new DataOutputStream(socket.getOutputStream());
        } catch (Exception e) {
            System.out.println("Error creating client.");
            e.printStackTrace();
        }       
    }
    
    public void sendMessage(String message) {
        try {
            dataOutput.writeUTF(message);
            dataOutput.flush();
        } catch (Exception e) { e.printStackTrace();}
    }
}