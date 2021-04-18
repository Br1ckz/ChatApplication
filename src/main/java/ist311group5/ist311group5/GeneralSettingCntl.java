package ist311group5.ist311group5;

import javafx.stage.Stage;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.util.Arrays;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class GeneralSettingCntl {
    private GeneralSettingGUI generalSettingUI;
    private GeneralSettingFile generalSettingFile;
    private Stage stage;
    public GeneralSettingCntl(Stage stage) {
        this.stage = stage;
        generalSettingUI = new GeneralSettingGUI(stage, this);
    }
    
    public void changeControl(String controller) {
        if (controller.equals("Back")) {
            NavigationCntl navCntl = new NavigationCntl(stage);
        }
    }
    
    public void createGeneralSettingFile(String username, int fontSize, boolean isDark) {
        ArrayList data = new ArrayList<String>();
        data = getAccountFile(username + ".txt");
        generalSettingFile = new GeneralSettingFile((String)data.get(0), (String) data.get(1));
        generalSettingFile.createFile(username);
        generalSettingFile.manipulateFile(username + "GeneralSettings.txt", fontSize, isDark);
    }
    
    public ArrayList getAccountFile(String filename) {
        ArrayList credentials = new ArrayList<String>();
        try {
            File accountFile = new File(filename);
            Scanner accountFileReader = new Scanner(accountFile);
            while(accountFileReader.hasNextLine()) {
                credentials.add(accountFileReader.nextLine());
            }
            accountFileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error reading file.");
            e.printStackTrace();
        }
        
        return credentials;
    }
}