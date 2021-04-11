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
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class AccountSettingGUI {
    private AccountSettingCntl accountSettingCntl;
    private Stage stage;
    private GridPane rootPane;
    private Scene scene;
    private Text sceneTitle;
    private Label currentPassword;
    private TextField currentPasswordText;
    private Label newPassword;
    private TextField newPasswordText;
    private Label retypeNewPassword;
    private TextField retypeNewPasswordText;
            
    public AccountSettingGUI(Stage stage, AccountSettingCntl accountSettingCntl) {
        this.stage = stage;
        this.accountSettingCntl = accountSettingCntl;
        setupUI();
        setupBackButton();
        setupSaveButton();
    }
    
    private void setupUI() {
        rootPane = new GridPane();
        scene = new Scene(rootPane, 630, 480);
        stage.setScene(scene);
        rootPane.setAlignment(Pos.CENTER);
        rootPane.setHgap(5);
        rootPane.setVgap(10);
        rootPane.setPadding(new Insets(25, 25, 25, 25));
        
        sceneTitle = new Text("Change Password");
        Font font = Font.font("Verdana", FontWeight.BOLD, FontPosture.REGULAR, 15);
        sceneTitle.setFont(font);
        rootPane.add(sceneTitle, 0, 0, 1, 1);
        
        currentPassword = new Label("Enter Current Password:");
        rootPane.add(currentPassword, 0, 2);
        
        currentPasswordText = new TextField();
        rootPane.add(currentPasswordText, 1, 2);
        
        newPassword = new Label("Enter New Password:");
        rootPane.add(newPassword, 0, 3);
        
        newPasswordText = new TextField();
        rootPane.add(newPasswordText, 1, 3);
                
        retypeNewPassword = new Label("Retype New Password:");
        rootPane.add(retypeNewPassword, 0, 4);
        
        retypeNewPasswordText = new TextField();
        rootPane.add(retypeNewPasswordText, 1, 4);
    }
    
    private void setupBackButton() {
        Button backButton = new Button("Discard");
        rootPane.add(backButton, 0, 5);
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                accountSettingCntl.changeControl("Discard");
            }
        });
    }
    
    private void setupSaveButton() {
        Button saveButton = new Button("Save");
        rootPane.add(saveButton, 1, 5);
        saveButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                accountSettingCntl.changeControl("Save");
            }
        });
    }

    /**
     * @return the currentPassword
     */
    public Label getCurrentPassword() {
        return currentPassword;
    }

    /**
     * @param currentPassword the currentPassword to set
     */
    public void setCurrentPassword(Label currentPassword) {
        this.currentPassword = currentPassword;
    }

    /**
     * @return the currentPasswordText
     */
    public TextField getCurrentPasswordText() {
        return currentPasswordText;
    }

    /**
     * @param currentPasswordText the currentPasswordText to set
     */
    public void setCurrentPasswordText(TextField currentPasswordText) {
        this.currentPasswordText = currentPasswordText;
    }

    /**
     * @return the newPassword
     */
    public Label getNewPassword() {
        return newPassword;
    }

    /**
     * @param newPassword the newPassword to set
     */
    public void setNewPassword(Label newPassword) {
        this.newPassword = newPassword;
    }

    /**
     * @return the newPasswordText
     */
    public TextField getNewPasswordText() {
        return newPasswordText;
    }

    /**
     * @param newPasswordText the newPasswordText to set
     */
    public void setNewPasswordText(TextField newPasswordText) {
        this.newPasswordText = newPasswordText;
    }

    /**
     * @return the retypeNewPassword
     */
    public Label getRetypeNewPassword() {
        return retypeNewPassword;
    }

    /**
     * @param retypeNewPassword the retypeNewPassword to set
     */
    public void setRetypeNewPassword(Label retypeNewPassword) {
        this.retypeNewPassword = retypeNewPassword;
    }

    /**
     * @return the retypeNewPasswordText
     */
    public TextField getRetypeNewPasswordText() {
        return retypeNewPasswordText;
    }

    /**
     * @param retypeNewPasswordText the retypeNewPasswordText to set
     */
    public void setRetypeNewPasswordText(TextField retypeNewPasswordText) {
        this.retypeNewPasswordText = retypeNewPasswordText;
    }
}
