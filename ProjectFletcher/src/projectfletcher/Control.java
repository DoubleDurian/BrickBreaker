/*
 * Program:ProjectFletcher
 * This:Control.java
 * Author:Nicholas Johnston
 * Date:4/15/2016
 * Purpose:To accept inputs from the user and to do things based on those inputs

 */
package projectfletcher;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author thedo
 */
public class Control implements KeyListener 
{//the control class detects player input via the arrow keys
    public Control(Game game)
    {
        game.addKeyListener(this);
    }
    public class Key
    {// this object is held in a list of Key objects
        public boolean pressed = false;
        public boolean isPressed()
        {
            return pressed;
        }
        public void toggleKey(boolean isPressed)
        {
            this.pressed = isPressed;
            
        }
        
    }
    public List<Key> keys = new ArrayList<Key>();
    public Key up = new Key();
    public Key down = new Key();
    public Key left = new Key();
    public Key right = new Key();
    public void keyTyped(KeyEvent ke) 
    {
        
    }

    public void keyPressed(KeyEvent ke) 
    {
        toggle(ke.getKeyCode(),true);
    }

    public void keyReleased(KeyEvent ke) 
    {
        deToggle(ke.getKeyCode());
    }
    public void toggle(int keyCode,boolean isPressed)
    {
        if(keyCode == KeyEvent.VK_W)  
        {//maps 'w' to up
            up.toggleKey(isPressed);
        }
        if(keyCode == KeyEvent.VK_S)  
        {//maps 's' to down
            down.toggleKey(isPressed);
        }
        if(keyCode == KeyEvent.VK_D)  
        {//maps 'd' to right
            right.toggleKey(isPressed);
        }
        if(keyCode == KeyEvent.VK_A)  
        {//maps 'a' to left
            left.toggleKey(isPressed);
        }
    }
    public void deToggle(int keyCode)
    {
         if(keyCode == KeyEvent.VK_W)  
        {//maps 'w' to up
            up.pressed = false;
        }
        if(keyCode == KeyEvent.VK_S)  
        {//maps 's' to down
            down.pressed = false;
        }
        if(keyCode == KeyEvent.VK_D)  
        {//maps 'd' to right
            right.pressed = false;
        }
        if(keyCode == KeyEvent.VK_A)  
        {//maps 'a' to left
             left.pressed = false;
        }
        
        
        
       
    }
}
