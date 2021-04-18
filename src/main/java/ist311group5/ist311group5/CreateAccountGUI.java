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

public class CreateAccountGUI extends GUI{
    private CreateAccountCntl createAccountCntl;
    private Label username;
    private TextField usernameTextField;
    private Label password;
    private TextField passwordTextField;
    private Label retypePassword;
    private TextField retypePasswordTextField;
    private Button cancelBtn;
    private Button createAccountBtn;
    private Text actiontarget;
    
    public CreateAccountGUI(Stage stage, CreateAccountCntl createAccountCntl) {
        this.stage = stage;
        this.createAccountCntl = createAccountCntl;
        setupUI();
        setupFont();
        setTheme();
        setupCancelButton();
        setupCreateAccountButton();
    }
    
    /**
     * Sets up the create account UI.
     * 
     */
    public void setupUI() {
        rootPane = new GridPane();
        rootPane.setAlignment(Pos.CENTER);
        rootPane.setHgap(10);
        rootPane.setVgap(10);
        rootPane.setPadding(new Insets(25, 25, 25, 25));
        
        scene = new Scene(rootPane, 630, 480);
        stage.setScene(scene);      
        stage.setTitle("Chat Application");
        
        stage.setScene(scene);
        
        sceneTitle = new Text("Create an Account");
        rootPane.add(sceneTitle, 1, 0);
        
        username = new Label("Username");
        rootPane.add(username, 1, 2);

        usernameTextField = new TextField("Enter Username");
        rootPane.add(usernameTextField, 2, 2);
        
        password = new Label("Password");
        rootPane.add(password, 1, 3);
        
        passwordTextField = new TextField("Enter Password");
        rootPane.add(passwordTextField, 2, 3);
        
        retypePassword = new Label("Retype Password");
        rootPane.add(retypePassword, 1, 4);
        
        retypePasswordTextField = new TextField("Retype Password");
        rootPane.add(retypePasswordTextField, 2, 4);
        
        cancelBtn = new Button("Cancel");
        rootPane.add(cancelBtn, 2, 5);
        
        createAccountBtn = new Button("Create Account");
        rootPane.add(createAccountBtn, 3, 5);
        
        actiontarget = new Text();
        rootPane.add(actiontarget, 1, 6);
    } 
    
    /**
     * Sets up the cancel button.
     */
    public void setupCancelButton() {
        cancelBtn.setOnAction(new EventHandler<ActionEvent>() {            
            @Override
            public void handle(ActionEvent e) {
                createAccountCntl.changeControl("Back");
            }
        });
    }
    
    /**
     * Sets up the create account button.
     */
    public void setupCreateAccountButton() {
        createAccountBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if ((passwordTextField.getText()).equals(retypePasswordTextField.getText())) {
                    createAccountCntl.createAccountFile(usernameTextField.getText(), passwordTextField.getText());
                    createAccountCntl.changeControl("Back");
                } else {
                    actiontarget.setFill(Color.FIREBRICK);
                    actiontarget.setText("Passwords do not match!");
                }
            }
        });
    } 
}