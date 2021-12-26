
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;


public class TODOController {

    //ANCHOR start
    /**
     * Variables for class
     */
    int x = 1;

    @FXML
    VBox TODOVBox;

    @FXML
    Text succImport;

    @FXML
    Text succExport;

    @FXML
    Button okButtonTop;

    @FXML
    TextField TODOTextInput;

    String[] list = new String[1];

    /**
     * Code Handling the press of the "Add new" Button. Saves the entry into a String[] and then adds the line 
     * in the VBox with a checkmark so tasks can be checked off when completed
     * @param event     Button Press
     */
    @FXML
    private void handleAddNewButton(ActionEvent event) {
        String textInput = TODOTextInput.getText();
    

        String[] temp = new String[this.list.length + 1];
        if (this.list[0] != null) {
            System.arraycopy(list, 0, temp, 0, this.list.length);
            if (x == this.list.length) {
                temp[x] = textInput;
                this.list = temp;
                x++;
            }
        } else {
            this.list[0] = textInput;
        }
        Label l = new Label(textInput);
        Label y = new Label("\n");

        CheckBox checkBox = new CheckBox();
        TODOVBox.getChildren().add(l);
        TODOVBox.getChildren().add(checkBox);
        TODOVBox.getChildren().add(y);

    }

    //ANCHOR import export
    /**
     * Reads a textfile and automatically adds entries to the String[] as the add new button does and adds them to the 
     * VBox, then presents the User with a prompt for successfull export and a button to close said prompt.
     * Also updates the x variable used to place new elements into the list array 
     * 
     * @param event     Button Press
     */
    @FXML
    private void importList(ActionEvent event){

        String line;
        String[] inputRead = new String[1];
        int x = 1;
        BufferedReader reader;
        try {
            reader = new BufferedReader((new FileReader("output.txt")));
            while ((line = reader.readLine()) != null) {
                String[] temp = new String[inputRead.length + 1];
                if (inputRead[0] != null) {
                    System.arraycopy(inputRead, 0, temp, 0, inputRead.length);
                    if (x == inputRead.length) {
                        temp[x] = line;
                        inputRead = temp;
                        x = x + 1;
                    }
                } else {
                    inputRead[0] = line;
                }

            }
            reader.close();
            for(String inputText : inputRead){
            
                Label l = new Label(inputText);
                Label y = new Label("\n");
                CheckBox checkBox = new CheckBox();
                TODOVBox.getChildren().add(l);
                TODOVBox.getChildren().add(checkBox);
                TODOVBox.getChildren().add(y);
    
                }

                String[] temp2 = new String[this.list.length + inputRead.length];
                System.arraycopy(this.list, 0, temp2, 0, this.list.length);
                System.arraycopy(inputRead, 0, temp2, this.list.length, inputRead.length);
                this.list = temp2;
                this.x = this.list.length;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        succImport.setOpacity(1);
        okButtonTop.setOpacity(1);

    }


    /**
     * Exports the current list String Array to a textfile, while overwriting the textfile or creating it, if it does 
     * not exist, then presents the User with a prompt for successfull export and a button to close said prompt
     * 
     * @param event
     */
    @FXML
    private void exportList(ActionEvent event) {

        BufferedWriter writer;

        try {
            writer = new BufferedWriter(new FileWriter("output.txt"));
            for(String exportString : this.list){
                if(exportString != null){
                writer.write(exportString + "\n");
                writer.flush();
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        succExport.setOpacity(1);
        okButtonTop.setOpacity(1);        

    }


    /**
     * Handles pressing the "OK" Button at the top of the Window when a Im- or Export was successfukll
     * 
     * @param event     Button Press
     */
    @FXML
    private void closeText(ActionEvent event) {

        succExport.setOpacity(0);
        succImport.setOpacity(0);
        okButtonTop.setOpacity(0);
    }
}
