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
    boolean isDarkTheme;
    
    abstract public void setupUI();
    
    /**
     * Sets up the font for the title.
     */
    public void setupFont() {
        titleFont = Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, TITLE_TEXT_SIZE);
        sceneTitle.setFont(titleFont);
    }
    
    /**
     * Sets the title of the application.
     */
    public void setTitle() {
        stage.setTitle("Chat Application");
    }
    
    /**
     * Determines the theme to use when rendering views.
     */
    public void setTheme() {
        if (isDarkTheme) {
            rootPane.getStylesheets().setAll(getClass().getResource("dark-theme.css").toExternalForm());
        } else {
            rootPane.getStylesheets().setAll(getClass().getResource("caspian.css").toExternalForm());
        } 
    }
    
    /**
     * Gets the active theme.
     * @return isDarkTheme Determines weather to use dark or light theme. 
     */
    public boolean getTheme() {
        return isDarkTheme;
    }
    
    /**
     * Sets the active theme.
     * @param isDarkTheme Sets weather to use dark or light theme.
     */
    public void setTheme(boolean isDarkTheme) {
        this.isDarkTheme = isDarkTheme;
    }
}