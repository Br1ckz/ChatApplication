package ist311group5.ist311group5;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileNotFoundException;
        
public class LoginGUI {
    private LoginCntl loginCntl;
    private Stage stage;
    private GridPane grid;
    private Scene scene;
    private Text sceneTitle;
    private Label userName;
    private TextField userTextField;
    private Label password;
    private TextField passwordField;
    private Button loginBtn;
    private Text actiontarget;
    public LoginGUI(Stage stage, LoginCntl loginCntl) {
        this.loginCntl = loginCntl;
        this.stage = stage;
        setupUI();
        setupLoginButton();
        displayUI();
    }
    
    private void setupUI() {
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        scene = new Scene(grid, 630, 480);
        stage.setScene(scene);      
        stage.setTitle("Chat Application");
        
        stage.setScene(scene);
        
        sceneTitle = new Text("Chat Application");
        grid.add(sceneTitle, 0, 0, 2, 1);
        
        userName = new Label("Username:");
        grid.add(userName, 0, 1);
        
        userTextField = new TextField();
        grid.add(userTextField, 1, 1);
       
        password = new Label("Password:");
        grid.add(password, 0, 2);
        
        passwordField = new TextField();
        grid.add(passwordField, 1, 2);
        
        loginBtn = new Button("Login");
        grid.add(loginBtn, 1, 4);
            
        actiontarget = new Text();
        grid.add(actiontarget, 1, 6);
    } 
    
    private void setupLoginButton() {
        loginBtn.setOnAction(new EventHandler<ActionEvent>() {            
            @Override
            public void handle(ActionEvent e) {
                String uname = userTextField.getText();
                String pw = passwordField.getText();
                boolean loginRes = loginCntl.authenticate(uname, pw);

                if (loginRes) {
                    actiontarget.setFill(Color.BLUE);
                    actiontarget.setText("Sign in successful!");
                    loginCntl.changeControl();
                } else {
                    actiontarget.setFill(Color.FIREBRICK);
                    actiontarget.setText("Sign in failed!");
                }
            }
        });
    }
    
    private void displayUI() {
        stage.show();
    }
}