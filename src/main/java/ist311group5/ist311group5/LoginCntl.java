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
        

public class LoginCntl implements Controller{
    private LoginGUI loginUI;
    private Stage stage;
    private GeneralSettingFile generalSettingFile;
    public LoginCntl(Stage stage) {
        this.stage = stage;
        loginUI = new LoginGUI(stage, this);
    }
    
    /**
     * Looks in local file and checks against saved credentials.
     * Logs in and navigates to Navigation view when credentials match.
     */
    public boolean authenticate(String userName, String password) {
        String file = "userList.txt";
        try {
            File accountFile = new File(file);
            Scanner reader = new Scanner(accountFile);
            while(reader.hasNextLine()) {
                String[] line = reader.nextLine().split(" ");
                if (line[0].equals(userName) && line[1].equals(password)) {
                    generalSettingFile = new GeneralSettingFile(userName, password);
                    getGeneralSetting();
                    return true;
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("No file found.");
        }

        return false;
    }
    
    /**
     * Changes the controller to the Navigation or Create Account controller.
     */
    public void changeControl(String controller) {
        if (controller.equals("Navigation")){
            NavigationCntl navCntl = new NavigationCntl(stage, generalSettingFile);
        } else if (controller.equals("Create Account")) {
            CreateAccountCntl createAccountCntl = new CreateAccountCntl(stage, generalSettingFile);
        }
    }
    
    public String[] getGeneralSetting() {
//        String username = generalSettingFile.getUsername();
        return generalSettingFile.readFile();
    }
}