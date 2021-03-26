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

public class NavigationGUI{
    
    private final GridPane rootPane;  
    
    public NavigationGUI(Stage navStage) {
        rootPane = new GridPane();
        rootPane.setAlignment(Pos.CENTER);
        rootPane.setHgap(10);
        rootPane.setVgap(10);
        rootPane.setPadding(new Insets(25, 25, 25, 25));
        
        var scene = new Scene(rootPane, 630, 480);
        navStage.setScene(scene);      
        
        Text sceneTitle = new Text("Navigation");
        rootPane.add(sceneTitle, 0, 0, 2, 1);
        
        final Text actiontarget = new Text();
        rootPane.add(actiontarget, 1, 6);
        
        Button chatBtn = new Button("Chat");
        rootPane.add(chatBtn, 1, 2);
        
        chatBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                ChatGUI chatGui = new ChatGUI(navStage);
                rootPane.getScene().setRoot(chatGui.getRootPane());
            }
                
        });
        
        Button settingBtn = new Button("Account Settings");
        rootPane.add(settingBtn, 2, 2);
        settingBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                    actiontarget.setFill(Color.GREEN);
                    actiontarget.setText("Account settings button clicked!");           
            }
        });
    }
    
    public Pane getRootPane() {
        return rootPane;
    }
}