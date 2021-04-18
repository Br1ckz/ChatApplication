package ist311group5.ist311group5;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.CheckBox;

public class GeneralSettingGUI extends GUI {
    private GeneralSettingCntl generalSettingCntl;
    private Stage stage;
    private Label fontSize;
    private Slider fontSizeSlider;
    private Label colorScheme;
    private CheckBox colorSchemeCheckBox;

    public GeneralSettingGUI(Stage stage, GeneralSettingCntl generalSettingCntl) {
        this.stage = stage;
        this.generalSettingCntl = generalSettingCntl;
        setupUI();
        setupFont();
        setTheme();
        setupDiscardButton();
        setupDefaultButton();
        setupSaveButton();
        setupFontSizeSlider();
        setupColorSchemeCheckBox();
    }
    
    /**
     * Sets up the general settings UI.
     */
    public void setupUI() {
        rootPane = new GridPane();
        scene = new Scene(rootPane, 630, 480);
        stage.setScene(scene);
        rootPane.setAlignment(Pos.CENTER);
        rootPane.setHgap(10);
        rootPane.setVgap(10);
        rootPane.setPadding(new Insets(25, 25, 25, 25));

        sceneTitle = new Text("General Settings");
        rootPane.add(sceneTitle, 1, 0);
        
        fontSize = new Label("Change Font Size");
        rootPane.add(fontSize, 1, 1);
        
        colorScheme = new Label("Change Color Scheme");
        rootPane.add(colorScheme, 1, 2);
        
        stage.setScene(scene); 
    }
    
    /**
     * Sets up the Discard button.
     */
    public void setupDiscardButton() {
        Button discardBtn = new Button("Discard");
        rootPane.add(discardBtn, 3, 7);
        discardBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
              generalSettingCntl.changeControl("Back");
            }              
        });
    }
    
    /**
     * Sets up the Default button.
     */
    public void setupDefaultButton() {
        Button defaultBtn = new Button("Default");
        rootPane.add(defaultBtn, 4, 7);
        defaultBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
              generalSettingCntl.changeControl("Back");
            }              
        });
    }
    
    /**
     * Sets up the Save button.
     */
    public void setupSaveButton() {
        Button saveBtn = new Button("Save");
        rootPane.add(saveBtn, 5, 7);
        saveBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
              generalSettingCntl.changeControl("Back");
            }              
        });
    }
    
    /**
     * Sets up the slider.
     * Used to change the size of the font.
     */
    private void setupFontSizeSlider() {
        fontSizeSlider = new Slider(0, 1, 0.5);
        fontSizeSlider.setShowTickMarks(true);
        fontSizeSlider.setShowTickLabels(true);
        fontSizeSlider.setMajorTickUnit(0.25f);
        fontSizeSlider.setBlockIncrement(1);
        rootPane.add(fontSizeSlider, 2, 1);
    }
    
    /**
     * Sets up the check bottom.
     * Used for switching between light and dark theme. 
     */
    private void setupColorSchemeCheckBox() {
        colorSchemeCheckBox = new CheckBox("Dark Mode");
        rootPane.add(colorSchemeCheckBox, 2, 2);
        
        colorSchemeCheckBox.selectedProperty().addListener((obs, wasSelected, isSelected) -> {
            if (isSelected) {
                isDarkTheme = true;
                setTheme();
            } else {
                isDarkTheme = false;
                setTheme();
            }
        });
    }
}