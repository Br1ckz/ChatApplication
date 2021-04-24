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

public class AccountSettingGUI extends GUI{
    private AccountSettingCntl accountSettingCntl;
    private Text changePassword;
    private Label currentPassword;
    private TextField currentPasswordText;
    private Label newPassword;
    private TextField newPasswordText;
    private Label retypeNewPassword;
    private TextField retypeNewPasswordText;
    private Button backButton;
    private Button saveButton;
    private Label usernameLabel;
    private TextField usernameTextField;
    
    public AccountSettingGUI(Stage stage, AccountSettingCntl accountSettingCntl) {
        this.stage = stage;
        this.accountSettingCntl = accountSettingCntl;
        setupUI();
        setupTitleFont();
        setTheme();
        setupBackButton();
        setupSaveButton();
    }
    
    /**
     * Creates root pane and attaches scene.
     * Adds components to root pane.
     */
    public void setupUI() {
        rootPane = new GridPane();
        scene = new Scene(rootPane, 630, 480);
        stage.setScene(scene);
        rootPane.setAlignment(Pos.CENTER);
        rootPane.setHgap(5);
        rootPane.setVgap(10);
        rootPane.setPadding(new Insets(25, 25, 25, 25));
        
        sceneTitle = new Text("Account Settings");
        rootPane.add(sceneTitle, 0, 0);
        
        changePassword = new Text("Change Password");
        rootPane.add(changePassword, 0, 1);
        
        currentPassword = new Label("Enter Current Password:");
        currentPassword.setFont(new Font(setFont()));
        rootPane.add(currentPassword, 0, 3);
        
        currentPasswordText = new TextField();
        rootPane.add(currentPasswordText, 1, 3);
        
        newPassword = new Label("Enter New Password:");
        newPassword.setFont(new Font(setFont()));
        rootPane.add(newPassword, 0, 4);
        
        newPasswordText = new TextField();
        rootPane.add(newPasswordText, 1, 4);
                
        retypeNewPassword = new Label("Retype New Password:");
        retypeNewPassword.setFont(new Font(setFont()));
        rootPane.add(retypeNewPassword, 0, 5);
        
        retypeNewPasswordText = new TextField();
        rootPane.add(retypeNewPasswordText, 1, 5);
        
        backButton = new Button("Discard");
        rootPane.add(backButton, 0, 6);
        
        saveButton = new Button("Save");
        rootPane.add(saveButton, 1, 6);
        
        usernameLabel = new Label("Enter Username:"); 
        usernameLabel.setFont(new Font(setFont()));
        rootPane.add(usernameLabel, 0, 2);
        
        usernameTextField = new TextField();
        rootPane.add(usernameTextField, 1, 2);
    }
    
    /**
     * Creates the action for the Discard button.
     * Moves back to Navigation scene.
     */
    private void setupBackButton() {
        backButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                accountSettingCntl.changeControl("Discard");
            }
        });
    }
    
    /**
     * Creates the action for the Save button.
     * Saves account settings to a file.
     * Moves back to Navigation scene.
     */
    private void setupSaveButton() {
        saveButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                accountSettingCntl.updateAccountFile(usernameTextField.getText(),
                    currentPasswordText.getText(), newPasswordText.getText());
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
    
    /**
     * Sets theme for the account settings UI.
     */
    public void setTheme() {
        String[] data = accountSettingCntl.getGeneralSetting(); 
        String theme = data[1];
        if (theme.equals("Dark")) {
            setDarkTheme();
        } else {
            setLightTheme();
        }
    }
    
    /**
     * Gets the font size.
     */
    public int setFont() {
        return accountSettingCntl.getFont();
    }
}