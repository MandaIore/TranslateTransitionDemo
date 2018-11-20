# TranslateTransitionDemo
This program explains how to use TranslateTransition in JavaFX, it uses a moving background as an example. It is meant to be downloaded and opened in NetBeans IED as there is lots of comments to explain how to use the code and you can try it for your self.

What is TranslateTransition?
It creates a move/translate animation that spans its duration. This is done by updating the translateX, translateY and translateZ variables of the node at regular interval.

How does it work?
To Make a simple TranslateTrnasiton you must frist add the imports that it uses.
Imports:
         
    import javafx.animation.Animation;
    import javafx.animation.Interpolator;
    import javafx.animation.TranslateTransition;
    import javafx.util.Duration;

The next step to setting up your own TranslateTrnasiton is setting it up in the initialize.

The line bellow declares the new TranslateTransition. For this example we will call it example. then it declares how long it will run the animation for (in this example it is 14000 milliseconds). Then it tells it what node it is effecting (in this example i am using a imageVeiw called picOne)

    TranslateTransition (what you want to call the TranslateTransition) example = new TranslateTransition(Duration.millis(14000), picOne);

The next line tells the TranslateTransition were you want it to start, if unspecified it will use the nodes translateX, Y, Z vales

    example.setFromX(0);

The following line tell the TranslateTransition were it is moving to in this case it is moving to translateX 100.   
                          
    example.setToX(100);

 INTERPOLATOR:
 LINEAR it will move at the same speed for the duration of the translation.
 EASE_IN will move slowly to start then speed up.
 EASE_OUT will cause it to slow down near the end of the animaton.
 EASE_BOTH will cause it to slow down at the beginging and the end of the translation.
        
    translateTransition.setInterpolator(Interpolator.LINEAR);
