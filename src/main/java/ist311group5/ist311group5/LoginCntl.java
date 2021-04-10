package ist311group5.ist311group5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
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
        

public class LoginCntl {
    private LoginGUI loginUI;
    private Stage stage;
    public LoginCntl(Stage stage) {
        this.stage = stage;
        loginUI = new LoginGUI(stage, this);
    }
    
    public boolean authenticate(String userName, String password) {
        String file = "userList.txt";
        try {
            File accountFile = new File(file);
            Scanner reader = new Scanner(accountFile);
            while(reader.hasNextLine()) {
                String[] line = reader.nextLine().split(" ");
                if (line[0].equals(userName) && line[1].equals(password)) {
                    return true;
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("No file found.");
        }

        return false;
    }
    
    public void changeControl() {
        NavigationCntl navCntl = new NavigationCntl(stage);
    }
}