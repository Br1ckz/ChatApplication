/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ist311group5.ist311group5;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;
public class NavigationCntl{
    private NavigationGUI navUI;
    
    public NavigationCntl(Stage stage) {
        navUI = new NavigationGUI(stage, this);
    } 
}
