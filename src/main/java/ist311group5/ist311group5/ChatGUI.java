package ist311group5.ist311group5;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class ChatGUI {
    private ChatCntl chatCntl;
    private GridPane rootPane;
    private Label chatArea;
    private Scene scene;
    private Stage chatStage;
    private Text sceneTitle;
    private TextField messageBox;
    
    public ChatGUI(Stage chatStage, ChatCntl chatController) {
        this.chatStage = chatStage;
        chatCntl = chatController;
        setupConnectUI();
        setupConnectButton();
        setupBackButton();
    }
 
    /**
     * Sets up the connection UI
     */
    
    private void setupConnectUI() {
        rootPane = new GridPane();
        scene = new Scene(rootPane, 630, 480);
        chatStage.setScene(scene);
        rootPane.setAlignment(Pos.CENTER);
        rootPane.setHgap(10);
        rootPane.setVgap(10);
        rootPane.setPadding(new Insets(25, 25, 25, 25));

        sceneTitle = new Text("Chat");
        Font font = Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 15);
        sceneTitle.setFont(font);
        rootPane.add(sceneTitle, 0, 0, 2, 5);
        
        chatArea = new Label();
        rootPane.add(chatArea, 2, 3);
    }
    
    /**
     * Sets up the chat UI
     */
    
    private void setupChatUI(){
        messageBox = new TextField();
        rootPane.add(messageBox, 2, 7);
    }
    
    /**
     * Sets up the connection button
     */
    
    private void setupConnectButton() {
       Button connectBtn = new Button("Connect to chat server");
        
        rootPane.add(connectBtn, 1, 6);
        connectBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                chatArea.setText("");
                chatCntl.chat(); 
                setupSendButton();
                setupChatUI();
                connectBtn.setVisible(false);
            }
                
        }); 
    }
    
    /**
     * Sets up the send button
     */
    
    private void setupSendButton() {
        Button sendBtn = new Button("Send");
        rootPane.add(sendBtn, 3, 7);
        sendBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                updateChat("Client", messageBox.getText());
                chatCntl.chatInput(messageBox.getText());
            }              
        });
    }

    /**
     * Updates chat when a message is submitted
     * @param type
     * @param message 
     */
    
    public void updateChat(String type, String message) {
        if (type.equals("Server")) 
            chatArea.setText(chatArea.getText() + "\nServer:You said\"" + message + "\"");
        else 
            chatArea.setText(chatArea.getText() + "\nYou: '" + message + "\'");
    }
    
    /**
    * Sets up back button
    */
    
    private void setupBackButton() {
        Button backButton = new Button("Cancel");
        rootPane.add(backButton, 1, 8);
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                chatCntl.changeControl("Back");
            }
        });
    }
    
    /**
     * Gets root pane
     * @return root pane
     */
    
    public Pane getRootPane() {
        return rootPane;
    }
}
