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
import javafx.scene.control.TextField;

public class ConnectGUI extends GUI{
    private ConnectCntl connectCntl;
    private Button connectBtn;
    private Button backButton;
    private Label establishConnectionLabel;
    
    public ConnectGUI(Stage stage, ConnectCntl connectCntl) {
        this.stage = stage;
        this.connectCntl = connectCntl;
        setupUI();
        setupTitleFont();
        setTheme();
        setupConnectButton();
        setupBackButton();
    }
    
    /**
     * Sets up the connection UI
     */
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
        
        establishConnectionLabel = new Label("Establish Connection With other chat clients");
        establishConnectionLabel.setFont(new Font(setFont()));
        rootPane.add(establishConnectionLabel, 1, 1);
    }
    
      /**
     * Sets up the connection button
     */
    private void setupConnectButton() {
        connectBtn = new Button("       Send Request        ");
        rootPane.add(connectBtn, 2, 5);
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
        backButton = new Button("                    Cancel                        ");
        rootPane.add(backButton, 1, 5);
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                connectCntl.changeControl("Back");
            }
        });
    }
    
    /**
     * Sets the theme for the connection UI
     */
    public void setTheme() {
        String[] data = connectCntl.getGeneralSetting(); 
        String theme = data[1];
        if (theme.equals("Dark")) {
            setDarkTheme();
        } else {
            setLightTheme();
        }
    }
    
    /**
     * Gets the font size.
     */
    public int setFont() {
        return connectCntl.getFont();
    }
}