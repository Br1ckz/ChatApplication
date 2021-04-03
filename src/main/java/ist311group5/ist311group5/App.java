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
        
/**
 * JavaFX App
 */
public class App extends Application {
    private Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        var scene = new Scene(grid, 630, 480);
        stage.setScene(scene);      
        stage.setTitle("Chat Application");
        
        stage.setScene(scene);
        
        Text sceneTitle = new Text("Chat Application");
        grid.add(sceneTitle, 0, 0, 2, 1);
        
        Label userName = new Label("Username:");
        grid.add(userName, 0, 1);
        
        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);
       
        Label password = new Label("Password");
        grid.add(password, 0, 2);
        
        TextField passwordField = new TextField();
        grid.add(passwordField, 1, 2);
        
        Button loginBtn = new Button("Login");
        grid.add(loginBtn, 1, 4);
            
        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);
        
        loginBtn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent e) {
                String uname = userTextField.getText();
                String pw = passwordField.getText();
                LoginCntl loginCntl = new LoginCntl();
                boolean loginRes = loginCntl.authenticate(uname, pw);

                if (loginRes) {
                    actiontarget.setFill(Color.BLUE);
                    actiontarget.setText("Sign in successful!");
                    
                    NavigationCntl navCntl = new NavigationCntl(stage);
//                    NavigationGUI navUI = new NavigationGUI(stage);
//                    stage.getScene().setRoot(navUI.getRootPane());
                } else {
                    actiontarget.setFill(Color.FIREBRICK);
                    actiontarget.setText("Sign in failed!");
                }
            }
        });
        
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}