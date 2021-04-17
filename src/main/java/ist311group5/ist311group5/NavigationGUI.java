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

public class NavigationGUI extends GUI{
    private GridPane rootPane;  
    private NavigationCntl navCntl;
    private Scene scene;
    private Text actiontarget;
    private Stage navStage;
    private Label loginText;
            
    public NavigationGUI(Stage navStage, NavigationCntl cntl) {
        this.navStage = navStage;
        navCntl = cntl;
        setupUI();
        setupFont();
        setupChatButton();
        setupGeneralSettingButton();
        setupAccountSettingButton();
        setupBackButton();
    }
    
    public void setupUI() {
        rootPane = new GridPane();
        rootPane.setAlignment(Pos.CENTER);
        rootPane.setHgap(10);
        rootPane.setVgap(10);
        rootPane.setPadding(new Insets(25, 25, 25, 25));
        sceneTitle = new Text("Navigation");
      
        rootPane.add(sceneTitle, 1, 0);
        scene = new Scene(rootPane, 630, 480);
        navStage.setScene(scene);      
        
        actiontarget = new Text();
        rootPane.add(actiontarget, 1, 6);
    }
    
    private void setupChatButton() {
        Button chatBtn = new Button("                    Start A Chat                        ");
        rootPane.add(chatBtn, 1, 1); 
        chatBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                navCntl.changeControl("Connect");
            }
        });
    }
    
    private void setupGeneralSettingButton() {
        Button generalSettingButton = new Button("                  General Settings                  ");
        rootPane.add(generalSettingButton, 1, 2);
        generalSettingButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent e) {
                navCntl.changeControl("General Settings");
            }
        });
    }
    
    private void setupAccountSettingButton() {
        Button accountSettingBtn = new Button("                  Account Settings                  ");
        rootPane.add(accountSettingBtn, 1, 3);
        accountSettingBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                navCntl.changeControl("Account Settings");
            }
        });
    }
   
    private void setupBackButton() {
        Button backButton = new Button("                   Exit Application                   ");
        rootPane.add(backButton, 1, 4);
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

    /**
     * @return the loginText
     */
    public Label getLoginText() {
        return loginText;
    }

    /**
     * @param loginText the loginText to set
     */
    public void setLoginText(Label loginText) {
        this.loginText = loginText;
    }
}