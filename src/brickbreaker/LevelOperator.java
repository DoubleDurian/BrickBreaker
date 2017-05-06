/*
 * Project:BrickBreaker
 * This:LevelOperator.java
 * Author:Nick Johnston
 * Date:4/2/2017
 * Purpose:The purpose of this class is to allow the program to load different 
           levels of the game from different files by passing the graphical
           context and the inputs to those levels
           Currently this is impllemented in a switch statment but 
           will be updated in future to load levels and their data from 
           txt files.
 */
package brickbreaker;


import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;


public class LevelOperator 
{
    //variables
    int levelNumber = 1;
    
   
    LEVELmenu menu = new LEVELmenu();
    LEVELone firstLevel = new LEVELone();
   
    //constructors
    
    //methods
    public void levelRender( GraphicsContext gc, double t)
    {//determines which level will render
        switch(levelNumber)
        {
            case 0:
            {//exit
                
                break;
            }
            case 1:
            {//Menu
                menu.render(gc, t);
                break;
            }
            case 2:
            {//levelOne
                firstLevel.render(gc,t);
                break;
            }
        }  
    }
    public void levelTick( Input input, int tickCount)
    {// tells the game to perform a logic tick and asks if the 
       //level should be exited
        switch(levelNumber)
        {
            case 0: 
            {//exit application
                Platform.exit();
                break;
            }
            case 1:
            {//opeing menu
                menu.activate();
                menu.tick(input);
                if(menu.exit())
                {
                    menu.deactivate();
                    levelNumber = menu.destination();
                }
                break;
            }
            case 2:
            {//first level
                firstLevel.activate();
                
                firstLevel.tick(input, tickCount);
                if(firstLevel.exit())
                {
                    firstLevel.deactivate();
                    levelNumber = firstLevel.destination();
                }
                break;
                
            }
            
            
        }
    }
    
}