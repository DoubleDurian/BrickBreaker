/*
 * Project:BrickBreaker
 * This:LEVELone.java
 * Author:Nick Johnston
 * Date:4/5/2017
 * Purpose:this holds the render and logic for the first level of the game
 */
package brickbreaker;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
public class LEVELone 
{
    //variables
    boolean ballOnPaddle = true;
    boolean shouldExit = false;
    boolean isActive;
    int score = 0;
    int livesLeft = 3;
    Paddle paddle = new Paddle();
    Ball ball = new Ball();
    BrickArray brickArray = new BrickArray();
    Brick tempBrick;
    
    int killed = 0;
    //constructor
    //methods
    public void render(GraphicsContext gc, double time)
    {
        if(isActive)
        {
        
        //Black Background
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, 1366, 768);
        
        //Render the position of the player's paddle
        gc.setFill(Color.ROYALBLUE);
        gc.fillRect(paddle.xPos, paddle.yPos, paddle.xSize, paddle.ySize);
        //Render the Ball
        gc.fillOval(ball.xPos, ball.yPos, ball.xSize, ball.ySize);
        //Render the Brick Array
        for(int i = 0; i<brickArray.down;i++)
        {
            for(int j = 0; j < brickArray.cross; j++)    
            {
                tempBrick = brickArray.bricks[i][j];
                gc.setFill(tempBrick.getShade());
                if(tempBrick.notBroke)
                {
                    gc.fillRect(tempBrick.xPos, tempBrick.yPos, tempBrick.sizeX, tempBrick.sizeY);
                }
                
            }
        }
        }
        
        
    }
    public void tick(Input input, int tickCount) 
    {
        if(isActive)
        {
        //when game is in session
        //update the paddle object
        if(input.left)
        {//the player wishes to move the paddle left
            paddle.decreaseXVec();
        }
        else if(input.right)
        {// the player wishes to move to the right
            paddle.increaseXVec();
            
        }
        
        //check if the ball is on the paddle
        //and if the player presses up the ball is released
        if(input.up)
        {//load ball and fire it
            ballOnPaddle = false;
        }
        //apply friction to paddle
        if(tickCount % 2 ==0)
        {
            if(!input.left && !input.right)
           {
                paddle.normalizeX();
                
           }
        }
        //update all objects
        //update the paddle's position
        paddle.xDelta();
        //update ball
        //decide if the ball should be on the paddle
        
       
        if(ball.Delta(paddle, ballOnPaddle))
        {
            mistake();
        }
        
        
        killed += brickArray.checkAll(ball);
        }
        
        
        
        
        
        
    }
    public boolean exit()
    {
        return shouldExit;
    }
    public void mistake()
    {
        this.livesLeft--;
        if(this.livesLeft == 0)
        {
            shouldExit = true;
        }
        
        
        this.ballOnPaddle = true;
        
    }
    public int destination()
    {
        return 1;
    }
    public void activate()
    {
        this.isActive = true;
        if(this.shouldExit == true)
        {
            this.livesLeft = 3;
            shouldExit = false;
            ballOnPaddle = true;
            this.brickArray = new BrickArray();
            this.score = 0;
            
        }
        
    }
    public void deactivate()
    {
        this.isActive = false;
    }
    
    
}
