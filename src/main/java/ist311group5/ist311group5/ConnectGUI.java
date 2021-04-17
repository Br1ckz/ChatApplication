package ist311group5.ist311group5;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;

public class ConnectGUI extends GUI{
    private ConnectCntl connectCntl;
    public ConnectGUI(Stage stage, ConnectCntl connectCntl) {
        this.stage = stage;
        this.connectCntl = connectCntl;
        setupUI();
        setupFont();
        setupConnectButton();
        setupBackButton();
    }
    
    public void setupUI() {
        rootPane = new GridPane();
        rootPane.setAlignment(Pos.CENTER);
        rootPane.setHgap(10);
        rootPane.setVgap(10);
        rootPane.setPadding(new Insets(25, 25, 25, 25));
        sceneTitle = new Text("Connect");
      
        rootPane.add(sceneTitle, 1, 0);
        scene = new Scene(rootPane, 630, 480);
        stage.setScene(scene);      
    }
    
      /**
     * Sets up the connection button
     */
    private void setupConnectButton() {
        Button connectBtn = new Button("       Connect to chat server        ");
        rootPane.add(connectBtn, 1, 1);
        connectBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                connectCntl.changeControl("Chat");
            }
                
        }); 
    }
    
    /**
    * Sets up back button
    */
    private void setupBackButton() {
        Button backButton = new Button("                    Back                        ");
        rootPane.add(backButton, 1, 2);
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                connectCntl.changeControl("Back");
            }
        });
    }
    
    public Pane getRootPane() {
        return rootPane;
    }
}