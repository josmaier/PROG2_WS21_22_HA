import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class stwController {

    boolean isRunning = false;

    @FXML
    Text counter;

    @FXML
    Button start;

    @FXML
    Button reset;

    @FXML
    Button stop;

    /**
     * Starts the Stopwatch from the current point
     */
    @FXML
    public void start(ActionEvent event) {
        this.isRunning = true;
    }

    /**
     * Stops the Stopwatch, leaving the current time displayed
     */
    @FXML
    public void stop() {
        this.isRunning = false;
    }

    /**
     * Resets the displayed time on the Stopwatch to 0, no matter if it is running
     * or not
     */
    @FXML
    public void reset() {
        this.isRunning = false;
        
    }
    
    


}
