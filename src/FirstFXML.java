import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FirstFXML extends Application {
    
    /*
    Es kann sein, das der Pfad für die JavaFX libraries in launch.json neu gesetzt werden müssen,
    bzw Linie 18 ausgeschnitten und wieder eingefügt werden muss um die FXML datei zu finden
    */


    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("TODO.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
