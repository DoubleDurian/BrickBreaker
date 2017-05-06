/*
 * Project:BrickBreaker
 * This:Input.java
 * Author:Nick Johnston
 * Date:4/2/2017
 * Purpose:To handle the inputs from the user and bind them to events
 */
package brickbreaker;


import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;


public class Input 
{
    //variables
    //----determines what values even exist
    boolean up = false;
    boolean down = false;
    boolean left = false;
    boolean right = false;
    boolean space = false;
    boolean m = false;
    
    Scene scene;
    
    //constructor
    public Input(Scene scene)
    {
        this.scene = scene;
        init();
    }
    //methods
    public void init()
    {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() 
       {//determines when keys are depressed
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:    up = true; break;
                    case DOWN:  down = true; break;
                    case LEFT:  left  = true; break;
                    case RIGHT: right  = true; break;
                    case SPACE: space = true; break;
                    case M: m = true; break;
                }
            }
        });
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() 
       {//determines when keys are not depressed
          
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:    up = false; break;
                    case DOWN:  down = false; break;
                    case LEFT:  left  = false; break;
                    case RIGHT: right  = false; break;
                    case SPACE: space = false; break;
                    case M: m = false; //break;
                }
            }
        });
        
    }
    
    
    
}
