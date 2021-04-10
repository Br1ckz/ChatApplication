package ist311group5.ist311group5;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AccountSettingGUI {
    private AccountSettingCntl accountSettingCntl;
    private Stage stage;
    private GridPane rootPane;
    private Scene scene;
    private Text sceneTitle;
    public AccountSettingGUI(Stage stage, AccountSettingCntl accountSettingCntl) {
        this.stage = stage;
        this.accountSettingCntl = accountSettingCntl;
        setupUI();
        setupBackButton();
    }
    
    private void setupUI() {
        rootPane = new GridPane();
        scene = new Scene(rootPane, 630, 480);
        stage.setScene(scene);
        rootPane.setAlignment(Pos.CENTER);
        rootPane.setHgap(10);
        rootPane.setVgap(10);
        rootPane.setPadding(new Insets(25, 25, 25, 25));

        sceneTitle = new Text("Account Settings");
        rootPane.add(sceneTitle, 0, 0, 2, 1);
    }
    
    private void setupBackButton() {
        Button backButton = new Button("Back");
        rootPane.add(backButton, 1, 3);
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                accountSettingCntl.changeControl("Back");
            }
        });
    }
}