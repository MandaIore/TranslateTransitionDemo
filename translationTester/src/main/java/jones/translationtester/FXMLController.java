package jones.translationtester;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class FXMLController implements Initializable {

    // Declaring the Background ImageViews
    @FXML
    private ImageView picOne;
    @FXML
    private ImageView picTwo;
    //unchangeable integer that holds the width of the background
    private final int BACKGROUND_WIDTH = 317;
    //declaring the name of the name of Transition
    private ParallelTransition backgroundMove;
    //Button to start and stop animation (this is not needed as there as other ways to start the animation, i just used a button for demo)
    @FXML
    private Button btnControl;

    //This is the button method for the button that starts and stops the moving background
    @FXML
    public void controlPressed(ActionEvent event) {
        if (backgroundMove.getStatus() == Animation.Status.RUNNING) { //if the background animation is running stop it
            pauseAnimation();
        } else {                //else start the amintion
            startAmination();
        }
    }

    //START method
    public void startAmination() {

        backgroundMove.play();
    }

    //PAUSE method
    public void pauseAnimation() {
        backgroundMove.pause();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //background mover
        /*This Transititon creates a move/translate animation that spans its duration. This is done by updating the translateX, Y and Z vsrisbles at regular interval*/

        //the duration is how long it takes to compleat the animation
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(14000), picOne);

        /*It strats from the (fromX, fromY, fromZ) value if proided else uses the items translateX, Y, Z vales*/
        translateTransition.setFromX(0);

        /*It stops at the (toX, toY, toZ) value if provided else it will use  start value plus (byX,byY, byZ) value*/
        translateTransition.setToX(-1 * BACKGROUND_WIDTH);

        /*the (toX, toY, toZ) value takes precedence if both (toX, toY, toZ) and (byX, byY, byZ) values are specified*/
        translateTransition.setInterpolator(Interpolator.LINEAR);

        TranslateTransition translateTransition2 = new TranslateTransition(Duration.millis(14000), picTwo);

        //setFrom(); Is were you tell the program were the objects starting position is 
        translateTransition2.setFromX(0);

        //setToX Is telling the Tansition that it has reached it's end once it has reached that x value. In this canse it is the obosite of its width
        translateTransition2.setToX(-1 * BACKGROUND_WIDTH);

        /*
        INTERPOLATOR: if set to LINEAR it will move at the same speed for the duration of the translation
        if set to EASE_IN it will move slowly to start then speed up
        EASE_OUT will cause it to slow down near the end of the animaton
        EASE_BOTH will cause it to slow down at the beginging and the end of the translation
         */
        translateTransition2.setInterpolator(Interpolator.LINEAR);

        //This is were you set make it so you can use the translation
        backgroundMove = new ParallelTransition(translateTransition, translateTransition2);//This line is setting the ParallelTranslation called backgroundMove to the translations you want to run in parellel
        backgroundMove.setCycleCount(Animation.INDEFINITE); //This is were you set how long you want it to run this animation

        //
        // Sets the label of the Button based on the animation state
        //
        backgroundMove.statusProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue == Animation.Status.RUNNING) {
                btnControl.setText("||");
            } else {
                btnControl.setText(">");
            }
        });
    }
}
