/*
 * Program:ProjectFletcher
 * This:Player.java
 * Author:Nicholas Johnston
 * Date:4/13/2016
 * Purpose:To control the position and 2d vetor of the player character
   //may hold infomation for arc attacks.
 */
package projectfletcher;


public class Player 
{
    //AIEGIS REFLECTOR
    //to be implemented
    //class vaiables
    int xPos;
    int yPos;
    int xSize;
    int ySize;
    
    //vector variables
    int xVec=0;
    int yVec =0;
    int maxSpeed =20;
    int minSpeed = -20;
    //class constructor
    public Player()
    {
        xPos = 0;
        yPos = 600;
        xSize = 250;
        ySize = 10;
        
    }
    public Player(int x,int y)
    {
        this.xPos = x;
        this.yPos = y;
    }
    //class methods
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
    boolean xIsPositive()
    {
        return (xVec >=0);
    }
    boolean yIsPositive()
    {
        return (yVec >=0);
    }
    //==================
    //accelaration block
    //==================
    void increaseXVec()
    {
        if(xVec<maxSpeed)
        {
            xVec++;
        }
    }
    void increaseYVec()
    {
        if(yVec<maxSpeed)
        {
            yVec+=2;
        }
    }
    void decreaseXVec()
    {
        if(xVec > minSpeed)
        {
            xVec-=2;
        }
    }
    void decreaseYVec()
    {
        if(yVec > minSpeed)
        {
            yVec--;
        }
    }
    //=============
    //friction block
    //=============
    void normalizeX()
    {
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
