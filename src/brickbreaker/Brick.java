/*
 * Project:BrickBreaker
 * This:Brick.java
 * Author:Nick Johnston
 * Date:4/9/2017
 * Purpose:To hold the position, health, and color of a brick object
 */
package brickbreaker;
import javafx.scene.paint.Color;
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
    Color shade;
    boolean notBroke = true;
    //constructor
    public Brick(int x,int y, int health)
    {
        this.xPos = x;
        this.yPos = y;
        this.health = health;
        top = yPos;
        lower = yPos+sizeY;
        right = xPos;
        left = xPos + sizeX;
        
    }
    //methods
    Color getShade()
    {
        if(health == 1)
        {
            shade = Color.DEEPPINK;
        }
        else if(health ==2)
        {
            shade = Color.CRIMSON;
        }
        else if(health ==3)
        {
            shade = Color.BROWN;
        }
        return shade;
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
    boolean ballDetect(Ball ball)
    {
        if(notBroke)
        {
            //detect top or bottom
        if(ball.xPos <left &&ball.xPos >right)
        {
            if((ball.yPos+15) ==lower)
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
    boolean detect(Ball ball)
    {
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
            else if(ball.yPos ==top )
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
