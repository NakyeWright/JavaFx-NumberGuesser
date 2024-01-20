package NumberGuessingGame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import java.util.Random;


public class Controller {

    @FXML
    private Label T_Number;

    @FXML
    private Label T_NumberIs;

    @FXML
    private TextArea ui_Input;
    private Stage mainWindow;
    int min = 1;
    int max = 10;


    public void SetMainWindow(Stage mainWindow)
    {
        this.mainWindow = mainWindow;
        SetTitle(min, max);
    }

    public int randomNumberGenerator(int min, int max)
    {
        Random randNum = new Random();

        int RandomNumber = randNum.nextInt((max - min ) + 1) + min;
        
        return RandomNumber;
    }

    void SetTitle(int min, int max)
    {
        T_NumberIs.setText("Number is between : " + min + " and " + max);
    }

    @FXML
    void onBtnPressed(ActionEvent event) 
    {
        try {
        int rn = randomNumberGenerator(min, max);
        int userInput = Integer.parseInt(ui_Input.getText());
        

    
        if ( rn == userInput)
        {
        T_Number.setVisible(true);
        T_Number.setText("Correct! number was : " + rn);
        }
        else if (userInput > max || userInput < min)
        {
            T_Number.setVisible(true);
            T_Number.setText("That was out of bounds ");
        }

        else 
        {
            T_Number.setVisible(true);
            T_Number.setText("Wrong, number was : " + rn);
        }
    }
    catch (NumberFormatException nfe)
    {
        T_Number.setVisible(true);
        T_Number.setText("INVALID INPUT");

    }
    }
    


    

}

