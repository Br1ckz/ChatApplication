package ist311group5.ist311group5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class ChatClient extends Thread {
    private Socket socket;
    private DataInputStream dataInput;
    private DataOutputStream dataOutput;
    private ChatCntl chatCntl;
    public ChatClient(ChatCntl chatCntl)  {
        this.chatCntl = chatCntl;
    }
    
    @Override
    /**
     * Initializes and runs networking components.
     */
    public void run() {
        try {
            socket = new Socket("localhost", 6000);
            dataInput = new DataInputStream(socket.getInputStream());
            dataOutput = new DataOutputStream(socket.getOutputStream());
            while (true) {
                String data = dataInput.readUTF();
                receiveMessage(data);
            }
        } catch (Exception e) {
            System.out.println("Error creating client.");
            e.printStackTrace();
        }       
    }
    
    /**
     * Sends message to server and resets.
     * @param message The chat message inputted in the GUI.
     */
    public void sendMessage(String message) {
        try {
            dataOutput.writeUTF(message);
            dataOutput.flush();
        } catch (Exception e) { e.printStackTrace();}
    }
    
    public void receiveMessage(String message) {
        chatCntl.serverResponse(message);
    }
}