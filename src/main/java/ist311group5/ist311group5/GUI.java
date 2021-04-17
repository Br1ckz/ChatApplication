package ist311group5.ist311group5;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public abstract class GUI {
    Text sceneTitle;
    final int TITLE_TEXT_SIZE = 25;
    Font titleFont;
    GridPane rootPane;
    Stage stage;
    Scene scene;
    
    abstract public void setupUI();
    
    public void setupFont() {
        titleFont = Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, TITLE_TEXT_SIZE);
        sceneTitle.setFont(titleFont);
    }
}
