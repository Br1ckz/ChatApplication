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

public class NavigationGUI{
    private GridPane rootPane;  
    private NavigationCntl navCntl;
    private Scene scene;
    private Text sceneTitle;
    private Text actiontarget;
    private Stage navStage;
    public NavigationGUI(Stage navStage, NavigationCntl cntl) {
        this.navStage = navStage;
        navCntl = cntl;
        setupUI();
        setupChatButton();
        setupSettingButton();
        setupBackButton();
    }
    
    private void setupUI() {
        rootPane = new GridPane();
        rootPane.setAlignment(Pos.CENTER);
        rootPane.setHgap(10);
        rootPane.setVgap(10);
        rootPane.setPadding(new Insets(25, 25, 25, 25));
        
        scene = new Scene(rootPane, 630, 480);
        navStage.setScene(scene);      
        
        sceneTitle = new Text("Navigation");
        rootPane.add(sceneTitle, 0, 0, 2, 1);
        
        actiontarget = new Text();
        rootPane.add(actiontarget, 1, 6);
    }
    
    private void setupChatButton() {
        Button chatBtn = new Button("Chat");
        rootPane.add(chatBtn, 1, 2); 
        chatBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                navCntl.changeControl("Chat");
            }
        });
    }
    
    private void setupSettingButton() {
        Button settingBtn = new Button("Account Settings");
        rootPane.add(settingBtn, 2, 2);
        settingBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                navCntl.changeControl("Account Settings");
            }
        });
    }
   
    private void setupBackButton() {
        Button backButton = new Button("Logout");
        rootPane.add(backButton, 1, 3);
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                navCntl.changeControl("Logout");
            }
        });
    }
    
    public Pane getRootPane() {
        return rootPane;
    }
}
