/*
 * Program:ProjectFletcher
 * This:Brick.java
 * Author:Nicholas Johnston
 * Date:4/29/2016
 * Purpose:This holds the brick object
 */
package projectfletcher;
import java.awt.Color;

public class Brick 
{
    //variables
    int xPos;
    int yPos;
    int health;
    int sizeX = 40;
    int sizeY = 20;
    int lower;
    int left;
    int right;
    int top;
    Color maShade;
    boolean notBroke = true;
    //constructor
    public Brick(int x,int y, int health)
    {
        this.xPos = x;
        this.yPos = y;
        this.health = health;
        top = yPos;
        lower = yPos+20;
        right = xPos;
        left = xPos +40;
        
    }
    //methods
    Color getShade()
    {
        if(health == 1)
        {
            maShade = Color.MAGENTA;
        }
        else if(health ==2)
        {
            maShade = Color.cyan;
        }
        else if(health ==3)
        {
            maShade = Color.orange;
        }
        return maShade;
    }
    boolean hit()
    {
        health --;
        if(health <= 0)
        {
            health = 0;
            notBroke = false;
            return true;
        }
        return false;
    }
    boolean detect(BallOfPower ball)
    {//returns true if it killed a brick, also manages hit detection
        if(notBroke)
        {
            //detect top or bottom
        if(ball.xPos <left &&ball.xPos >right)
        {
            if(ball.yPos ==lower)
            {
                //the ball is attacking from below
                //System.out.println("attack");
                ball.reflectY();
                return hit();
            }
            else if(ball.yPos==top )
            {
                //the ball is attacking from above
                ball.reflectY();
                 return hit();
            }
        }
        //detect left or right
        else if(ball.yPos < lower && ball.yPos>top)
        {
            if(ball.xPos ==right)
            {
                //ball is attacking from the right
                ball.reflectX();
                 return hit();
            }
            else if (ball.xPos == left)
            {
                //ball is attacking from the right
                ball.reflectX();
                 return hit();
            }
        }
        }
        return false;
    }
    void kill()
    {
        this.health = 0;
        this.notBroke = false;
    }
    
}
