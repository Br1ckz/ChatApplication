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
import javafx.scene.control.TextArea;
import javafx.application.Platform;

public class ChatGUI extends GUI{
    private ChatCntl chatCntl;
    private TextArea chatArea;
    private TextField messageBox;

    public ChatGUI(Stage stage, ChatCntl chatController) {
        this.stage = stage;
        chatCntl = chatController;
        setupUI();
        setupTitleFont();
        setTheme();
        setupSendButton();
        setupBackButton();
    }
 
    /**
     * Sets up the chat UI
     */
    public void setupUI() {
        rootPane = new GridPane();
        scene = new Scene(rootPane, 630, 480);
        stage.setScene(scene);
        rootPane.setAlignment(Pos.CENTER);
        rootPane.setHgap(10);
        rootPane.setVgap(10);
        rootPane.setPadding(new Insets(25, 25, 25, 25));

        sceneTitle = new Text("Chat");
        rootPane.add(sceneTitle, 2, 0);
        
        chatArea = new TextArea();
        rootPane.add(chatArea, 2, 1);

        messageBox = new TextField();
        rootPane.add(messageBox, 2, 4);
        stage.setScene(scene); 
    }
   
    /**
     * Sets up the send button
     */
    private void setupSendButton() {
        Button sendBtn = new Button("Send");
        rootPane.add(sendBtn, 2, 5);
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
            Platform.runLater(() -> chatArea.appendText("\nResponse: " + message));
        else 
            Platform.runLater(() -> chatArea.appendText("\nYou: " + messageBox.getText()));
    }
    
    /**
    * Sets up back button
    */
    private void setupBackButton() {
        Button backButton = new Button("End Connection");
        rootPane.add(backButton, 2, 6);
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                chatCntl.changeControl("Back");
            }
        });
    }
    
    /**
     * Sets theme for the Chat UI
     */
    public void setTheme() {
        String[] data = chatCntl.getGeneralSetting(); 
        String theme = data[1];
        if (theme.equals("Dark")) {
            setDarkTheme();
        } else {
            setLightTheme();
        }
    }
}