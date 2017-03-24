/*
 * Program:ProjectFletcher
 * This:Game.java
 * Author:Nicholas Johnston
 * Date:4/2/2016
 * Purpose:Manages the game and the JFrame
 */
package projectfletcher;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;


import javax.swing.JFrame;
public class Game extends Canvas implements Runnable
{//=======class variables====================
   //=============dimensions of the screen
   public static final int Height = 768;
   public static final int Width = 1366;

   public static final String NAME = "Nicholas Johnston Final Project";
   //=============JFrame==================
   private JFrame frame;
   //=============frame rate variables====
   public boolean running = false;
   public int tickCount = 0;
   
   private BufferedImage image = new BufferedImage(Width,Height,BufferedImage.TYPE_INT_RGB);
   private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
   //entity variables
   Player player = new Player();
   BallOfPower ball = new BallOfPower();
   //Control variables
   Control input = new Control(this);
   BrickArray bricks = new BrickArray();
   Brick tempBrick;
   boolean playing = true;
   boolean victory;
   boolean playAgain = false;
   boolean hasChoosen = false;
   int score = 0;
   int killed = 0;
   int mistakes =0;
   //=============class constructor=======
   public Game()
   {
       setMinimumSize(new Dimension(Width,Height));
       setMaximumSize(new Dimension(Width,Height));
       setPreferredSize(new Dimension(Width,Height));
       
       frame = new JFrame(NAME);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setLayout(new BorderLayout());
       frame.add(this,BorderLayout.CENTER);
       frame.pack();
       frame.setResizable(false);
       frame.setLocationRelativeTo(null);
       frame.setVisible(true);
       
       
       setFocusable(true);
       //setFocusTraversalKeysEnabled(false);
   }
   public synchronized void start()
   {
       running = true;
       new Thread(this).start();
   }
   public synchronized void stop()
   {
       running = false;
       //this.stop();
       
   }
   @Override
   public void run()
   {
       long lastTime = System.nanoTime();
       double nsPerTick =1000000000D/60D;
       
       int frames = 0;
       int ticks = 0;
       
       long lastTimer = System.currentTimeMillis();
       double delta = 0;
       while(running)
       {
           long now = System.nanoTime();
           delta += (now - lastTime)/nsPerTick;
           lastTime = now;
           boolean shouldRender = false;
           while(delta>=1)
           {
               ticks++;
               tick();
               delta = delta - 1;
               shouldRender = true;
           }
           if(shouldRender)
           {
               frames++;
               render();
           }
           //System.out.println("The game is running now");
           if(System.currentTimeMillis() - lastTimer >=1000)
           {
               lastTimer +=1000;
               System.out.println("Frames:" + frames + "  Ticks:" + ticks);
               frames =0;
               ticks = 0;
           }
           
       }
   }
   public void tick()
   {
       tickCount++;//time since game has begun
       //------------------
       //input block
       //-------------------
       if(input.up.isPressed())
       {
           player.decreaseYVec();
       }
       else if(input.down.isPressed())
       {
           //player.increaseYVec();
       }
       if(input.left.isPressed())
       {
           player.decreaseXVec();
           if(!playing)
           {
               
               playAgain = false;
               hasChoosen = true;
               //stop();
           }
       }
       else if(input.right.isPressed())
       {
           player.increaseXVec();
           if(!playing)
           {
              playAgain = true;
              hasChoosen = true;
           }
       }
       //-------------
       //friction block
       //---------------
       if(tickCount % 2 ==0)
       {
           if(!input.down.isPressed() && !input.up.isPressed())
           {
                player.normalizeY();
           }
           if(!input.left.isPressed() && !input.right.isPressed())
           {
                player.normalizeX();
           }
       }
       
       //------------------
       //motion block
       //-----------------
       if(playing)
       {
           Delta(player);
           if(ball.Delta(player))
           {
               mistakes++;
           }
           killed +=bricks.checkAll(ball);
           score = killed - (mistakes*10);
       }
       
       //win lose conditions
       if(score < 0)
       {
           //faliure
           fail();
       }
       if(score ==135)
       {
           win();
       }
       
       randImage();
   }
   public void render()
   {
       BufferStrategy bs = getBufferStrategy();
       if(bs==null)
       {
           createBufferStrategy(3);
           return;
       }
       //set the black background
       //=============================
       Graphics g = bs.getDrawGraphics();
       g.setColor(Color.BLACK);
       g.fillRect(0, 0, getWidth(), getHeight());
       //================================
       //draw trippy background
       //=================================
       g.drawImage(image,0,0,getWidth(),getHeight(),null);
       //==============================
       //Entity render blocks
       //===========================
       if(playing)
       {
           g.setColor(Color.yellow);
           g.fillRect(player.xPos, player.yPos, player.xSize, player.ySize);
           g.setColor(Color.red);
           g.fillRect( (player.xPos-((player.yPos-730)/2) ) , player.yPos, (player.yPos-480),player.ySize/2 );
           g.setColor(Color.GREEN);
           g.fillOval(ball.xPos, ball.yPos, 20, 20);
           g.setColor(Color.yellow);
           g.drawString("Health:"+score, player.xPos+100, 650);
       }
       else if(!playing)
       {
           g.setColor(Color.yellow);
           g.drawString("Your Final Score is: " + killed, 600, 400);
           if(victory)
           {
               g.drawString("YOU WIN!!!!!",620,350);
              // g.drawString("Would you like to play again", 600, 500);
           }
           else if(!victory)
           {
               g.drawString("YOU LOSE", 600, 300);
              // g.drawString("Would you like to play again", 600, 500);
           }
       }
       
       //---------
       //block rendering
       //---------
       //g.setColor(Color.magenta);
       for(int i =0; i < bricks.down;i++)
       {
           for(int j = 0; j<bricks.cross;j++)
           {
               tempBrick =bricks.bricks[i][j];
               g.setColor(tempBrick.getShade());
               if(tempBrick.notBroke)
               {
                   g.fillRect(tempBrick.xPos, tempBrick.yPos, tempBrick.sizeX, tempBrick.sizeY);
               } 
           }
       }
       
       //========================
       //clear the thing
       //========================
       g.dispose();
       bs.show();
   }
   public void randImage()
   {
       for(int i = 0;i<pixels.length;i++)
       {
           pixels[i] = i /tickCount;
       }
   }
    public void Delta(Player player)
    {//applies the x and y vectors of the player object in updating its 
       //x and y position
       
       player.xDelta();
       player.yDelta();
    }
    public void fail()
    {
        bricks.killAll();
        playing = false;
        victory = false;
        
    }
    public void win()
    {
        bricks.killAll();
        playing = false;
        victory = true;
    }
    public boolean reset()
    {
        /*
        this.score = 0;
        this.tickCount = 0;
        this.ball = new BallOfPower();
        this.player = new Player();
        this.bricks = new BrickArray();
        this.killed = 0;
        this.mistakes = 0;
*/
        this.playing = true;
        return true;
    }
    
}
