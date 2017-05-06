/*
 * Project:BrickBreaker
 * This:BrickBreaker.java
 * Author:Nick Johnston
 * Date:4/2/2017
 * Purpose: An example of a cleanly made brick breaker game
 */

package brickbreaker;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author DoubleDurian
 */
public class BrickBreaker extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        Application.launch(args);
    }
    @Override
    public void start(Stage primaryStage)
    {
        Game game = new Game();
        game.run(primaryStage);
    }
    
}
