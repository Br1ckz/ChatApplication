package ist311group5.ist311group5;

import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;
        
public class App extends Application {
    /**
     * Starts JavaFX
     * @param stage for constructing UI
     * @throws IOException catches IOException error
     */
    @Override
    public void start(Stage stage) throws IOException {
        LoginCntl loginCntl = new LoginCntl(stage);
    }

    /**
     * Main method 
     * @param args 
     */
    public static void main(String[] args) {
        launch();
    }
}