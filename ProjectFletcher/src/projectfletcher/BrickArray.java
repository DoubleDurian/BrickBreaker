/*
 * Program:ProjectFletcher
 * This:BrickArray.java
 * Author:Nicholas Johnston
 * Date:4/29/2016
 * Purpose:To hold an array of bricks
 */
package projectfletcher;

public class BrickArray 
{
    int cross = 27;
    int down = 5;
    Brick bricks[][] = new Brick[down][cross];
    public BrickArray()
    {
        init();
    }
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
    int checkAll(BallOfPower ball)
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
    {
        for(int i=0;i<down;i++)
        {
            for(int j=0; j<cross;j++)
            {
                bricks[i][j].kill();
            }
        }
    }
    
}
