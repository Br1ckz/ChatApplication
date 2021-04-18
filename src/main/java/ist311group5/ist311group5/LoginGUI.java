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
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileNotFoundException;
        
public class LoginGUI extends GUI{
    private LoginCntl loginCntl;
    private Stage stage;
//    private GridPane ;
    private Scene scene;
    private Label userName;
    private TextField userTextField;
    private Label password;
    private TextField passwordField;
    private Button loginBtn;
    private Text actiontarget;
    private Button createAccountBtn;
    public LoginGUI(Stage stage, LoginCntl loginCntl) {
        this.loginCntl = loginCntl;
        this.stage = stage;
        setupUI();
        setupFont();
        setTheme();
        setupLoginButton();
        setupCreateAccountButton();
        displayUI();
    }
    
    /**
     * Sets up login UI.
     */
    public void setupUI() {
        rootPane = new GridPane();
        rootPane.setAlignment(Pos.CENTER);
        rootPane.setHgap(10);
        rootPane.setVgap(10);
        rootPane.setPadding(new Insets(25, 25, 25, 25));
        
        scene = new Scene(rootPane, 630, 480);     
        stage.setTitle("Chat Application");
        stage.setScene(scene);
        
        sceneTitle = new Text("Login");
        rootPane.add(sceneTitle, 0, 1);
        
        userName = new Label("Username:");
        rootPane.add(userName, 0, 2);
        
        userTextField = new TextField();
        rootPane.add(userTextField, 1, 2);
       
        password = new Label("Password:");
        rootPane.add(password, 0, 3);
        
        passwordField = new TextField();
        rootPane.add(passwordField, 1, 3);
        
        loginBtn = new Button("Login");
        rootPane.add(loginBtn, 1, 4);
            
        actiontarget = new Text();
        rootPane.add(actiontarget, 1, 6);
        
        createAccountBtn = new Button("Create Account");
        rootPane.add(createAccountBtn, 2, 4);
    } 

    /**
     * Sets up login button.
     */
    private void setupLoginButton() {
        loginBtn.setOnAction(new EventHandler<ActionEvent>() {            
            @Override
            public void handle(ActionEvent e) {
                String uname = userTextField.getText();
                String pw = passwordField.getText();
                boolean loginRes = loginCntl.authenticate(uname, pw);

                if (loginRes) {
                    loginCntl.changeControl("Navigation");
                } else {
                    actiontarget.setFill(Color.FIREBRICK);
                    actiontarget.setText("Sign in failed!");
                }
            }
        });
    }
    
    /**
     * Sets up create account button.
     */
    public void setupCreateAccountButton() {
        createAccountBtn.setOnAction(new EventHandler<ActionEvent>() {            
            @Override
            public void handle(ActionEvent e) {
                loginCntl.changeControl("Create Account");
            }
        });
    }
    
    /**
     * Shows the login UI.
     */
    private void displayUI() {
        stage.show();
    }
}