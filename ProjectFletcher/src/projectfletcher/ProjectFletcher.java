/*
 * Program:ProjectFletcher
 * This:ProjectFletcher.java
 * Author:Nicholas Johnston
 * Date:4/2/2016
 * Purpose:This tries to make a game using JFrame
 */
package projectfletcher;

/**
 *
 * @author thedo
 */
public class ProjectFletcher 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Game game = new Game();
        game.start();
        
        boolean tryAgain = true;
        while(tryAgain)
        {
            if(!game.playing&&game.hasChoosen)
            {
                if(game.playAgain)
                {
                    game = new Game();
                }
                else
                {
                    tryAgain = false;
                }
                  
            }
        }
        
    }
    
}
