package ist311group5.ist311group5;

import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;
        
/**
 * JavaFX App
 */
public class App extends Application {
//    private Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        LoginCntl loginCntl = new LoginCntl(stage);
    }
    
    public static void main(String[] args) {
        launch();
    }
}