/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    private final GridPane rootPane;
    public ChatGUI(Stage chatStage) {
        rootPane = new GridPane();
        var scene = new Scene(rootPane, 630, 480);
        chatStage.setScene(scene);
        setupUI();
    }
 
    private void setupUI() {
        rootPane.setAlignment(Pos.CENTER);
        rootPane.setHgap(10);
        rootPane.setVgap(10);
        rootPane.setPadding(new Insets(25, 25, 25, 25));
        
//        var scene = new Scene(rootPane, 630, 480);
//        chatStage.setScene(scene);      
        
        Text sceneTitle = new Text("Chat GUI");
        rootPane.add(sceneTitle, 0, 0, 2, 1);
        
//        final Text actiontarget = new Text();
//        rootPane.add(actiontarget, 1, 6);
        
        Label chatArea = new Label("Chat Area");
        rootPane.add(chatArea, 2, 3);


        TextField messageBox = new TextField();
        rootPane.add(messageBox, 2, 4);
        
        Button connectBtn = new Button("Connect to chat server");
        
        rootPane.add(connectBtn, 1, 2);
        connectBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                ChatCntl.chat(); 
            }
                
        });
        
        Button sendBtn = new Button("Send");
        
        rootPane.add(sendBtn, 3, 4);
//        connectBtn.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent e) {
//                chatArea.setText(chatArea.getText() + messageBox.getText());
//            }
//                
//        });
        
    }
    
    public Pane getRootPane() {
        return rootPane;
    }
}
