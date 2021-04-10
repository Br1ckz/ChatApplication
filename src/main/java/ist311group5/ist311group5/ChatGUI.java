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
        setupUI();
        setupConnectButton();
        setupSendButton();
        setupBackButton();
    }
 
    private void setupUI() {
        rootPane = new GridPane();
        scene = new Scene(rootPane, 630, 480);
        chatStage.setScene(scene);
        rootPane.setAlignment(Pos.CENTER);
        rootPane.setHgap(10);
        rootPane.setVgap(10);
        rootPane.setPadding(new Insets(25, 25, 25, 25));

        sceneTitle = new Text("Chat GUI");
        rootPane.add(sceneTitle, 0, 0, 2, 1);
        
        chatArea = new Label();
        rootPane.add(chatArea, 2, 3);

        messageBox = new TextField();
        rootPane.add(messageBox, 2, 4);
    }
    
    private void setupConnectButton() {
       Button connectBtn = new Button("Connect to chat server");
        
        rootPane.add(connectBtn, 1, 2);
        connectBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                chatArea.setText("");
                chatCntl.chat(); 
            }
                
        }); 
    }
    
    private void setupSendButton() {
        Button sendBtn = new Button("Send");
        rootPane.add(sendBtn, 3, 4);
        sendBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                updateChat("Client", messageBox.getText());
                chatCntl.chatInput(messageBox.getText());
            }              
        });
    }

    public void updateChat(String type, String message) {
        if (type.equals("Server")) 
            chatArea.setText(chatArea.getText() + "\nServer:You said\"" + message + "\"");
        else 
            chatArea.setText(chatArea.getText() + "\nYou: '" + message + "\'");
    }
    
    private void setupBackButton() {
        Button backButton = new Button("Back");
        rootPane.add(backButton, 1, 3);
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                chatCntl.changeControl("Back");
            }
        });
    }
    
    public Pane getRootPane() {
        return rootPane;
    }
}