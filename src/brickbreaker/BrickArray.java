/*
 * Project:BrickBreaker
 * This:BrickArray.java
 * Author:Nick Johnston
 * Date:4/8/2017
 * Purpose:This holds an array of Brick objects and tells the render which
           should be displayed and if there was a collision.
 */
package brickbreaker;


public class BrickArray 
{
    //variables
    int cross = 27;
    int down = 5;
    Brick bricks[][] = new Brick[down][cross];
    //constructor
    public BrickArray()
    {
        init();
    }
    //methods
    void init()
    {
        for(int i =0; i < down;i++)
        {
            for(int j = 0; j <cross;j++)
            {
                bricks[i][j] = new Brick((j * 50)+15,(i *50)+10,3);
            }
        }
    }
    int checkAll(Ball ball)
    {
        int numberKilled = 0;
        for(int i =0; i <down;i++)
        {
            for(int j=0; j<cross;j++)
            {
                if(bricks[i][j].detect(ball))
                {
                    numberKilled++;
                }
                
            }
        }
        //System.out.println(numberKilled);
        return numberKilled;
    }
    void killAll()
    {// for clearing out all the bricks in the event of a defeat
        for(int i=0;i<down;i++)
        {
            for(int j=0; j<cross;j++)
            {
                bricks[i][j].kill();
            }
        }
    }
    
   
    
    
}
