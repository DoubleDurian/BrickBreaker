/*
 * Project:BrickBreaker
 * This:Paddle.java
 * Author:Nick Johnston
 * Date:4/8/2017
 * Purpose:This class represents the players paddle, it's position, speed and 
   hitbox
 */
package brickbreaker;

public class Paddle 
{
    //variables
        //dimensions of the paddle and its location in space
    int xPos;
    int yPos;
    int xSize;
    int ySize;
        //sets the bounds of the stage where the paddle is allowed to go
    int xLimRight;
    int xLimLeft;
    
    
        //vector variables
    int xVec=0;
    int yVec =0;
    int maxSpeed =20;
    int minSpeed = -20;
    
    //constructor
    public Paddle()
    {
        xPos = 0;
        yPos = 600;
        xSize = 250;
        ySize = 10;
        xLimRight = 1116;
        xLimLeft = 0;
        
    }
    
    //methods
    //=================
    //DELTA BLOCK
    //================
    void xDelta()
    {//moves player along the x axis
        xPos += xVec;
        if(xPos<0)
        {
            xPos=0;
        }
        if((xPos > 1116))
        {
            xPos=1116;
        }
    }
    void yDelta()
    {//moves player along the y axis
        yPos += yVec;
        if(yPos > 730)
        {
            yPos=730;
        }
        if(yPos <625)
        {
            yPos = 625;
        }
    }
    //===============
    //Validator block
    //===============
    //note: i briefly consider/am still considering adding a move to the 
    //paddle where it move forward like and inch to hit the ball with extra
    //force applied to the ball. So i'm leaving features checking y axis motion
    boolean xIsPositive()
    {//returns if the paddle is moving along x axis
        return (xVec >=0);
    }
    boolean yIsPositive()
    {//returns if paddle is moving along y axis
        return (yVec >=0);
    }
    //================
    //Accelaration Block
    //================
    void increaseXVec()
    {//increases movment if the momvemt is below max speed
        if(xVec<maxSpeed)
        {
            xVec++;
        }
    }
    void increaseYVec()
    {//increased y movment if it is below max speed
        if(yVec<maxSpeed)
        {
            yVec+=2;
        }
    }
    void decreaseXVec()
    {//decreases the x veleocity
        if(xVec > minSpeed)
        {
            xVec-=2;
        }
    }
    void decreaseYVec()
    {//decreases the y velocity
        if(yVec > minSpeed)
        {
            yVec--;
        }
    }
    void normalizeX()
    {// this applies friction to the paddle if called, slowing it's movment to 
        //zero
        if(xVec<0)
        {
            xVec++;
        }
        else if(xVec >0)
        {
            xVec--;
        }
        //System.out.println("norm x");
    }
    void normalizeY()
    {
        if(yVec<-2)
        {
            yVec-=10;
            //yVec = 0;
        }
        else if(yVec >2)
        {
            
            //yVec--;
            //yVec = 0;
        }
    }
}
