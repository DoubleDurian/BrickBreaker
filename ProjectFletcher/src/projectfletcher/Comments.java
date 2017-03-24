/*
 * Program:ProjectFletcher
 * This:Comments.javaa
 * Author:Nicholas Johnston
 * Date:4/12/2016
 * Purpose:To hold comments about the project as a whole
 */
package projectfletcher;

/**
 *
 * @author thedo
 */
public class Comments 
{
    //Day one
    //i begin my quest to complete the final project by imagining a game like
    //angry birds, i must therefore learn how to draw to a screen object
    
    //first begins the setting up of the jframe, i have decided to set the 
    //dimensions to the size of my screen
    
    
    
    //I have discovered that a screen is something that is overwritten a number 
    //of times every second, i need to create a framerate manager and logic
    // manager that limints the rendering function to sixty times a second
    //and caps the game's internal logic at 60 updates per second as well.
    
    //i can use the system time in milliseconds to modulate the number of 
    //frames per second. also the logic
    
    
    
    //i have leanred how to create an array of pixels that are drawn on the 
    //screen every render update
    
    //i can create a black black screen that can be drawn on
    //and if i modulate the pixle array based on the ticks since the program 
    //began then it creates a tripy ass background. im talking led zepplin here
    
    //Day two
    //I spent time drawing blocks to the screen and then making them move
    //by ordering the graphics section to draw the cube at the position 
    //variable of an object i made i can then use a method of that object to 
    //combine its vector with its current position, this creates the 
    //illusion of motion.
    
    //No i must figure out how to immplement some sot of player input method 
    //maybe it will use the keys to contorl the shot of the arc
    //but for now it will only move a cube
    
    //Day three
    //got this program to read key inputs, the keys can be changed manually but
    //for the moment they allow the user to change the vector of a cube 
    //using wasd as inputs
    
    // i also added a  friction function that normalizes the the vector to zero
    // three times a second,, i use modular arithmatic to change the number of 
    //times a second it is called in the tick function
    
    //Day four
    //Soon i will have enough code to complete the code ship and return to code
    //planet
    
    //Day five
    //I've decided to create a brick breaker game in the style of Thunder and 
    //lightning, ala nintendo snes. 
    //now that i have decided on a brick breaker format i must logically 
    //include some sore of paddle for the player to control
    
    //i have changed the golden brick that moves into a golden paddle
    //i have also bounded it to the length of my screen, it can no longer
    //leave the jframe, however... i used too many literals in 
    //bounding this paddle, and if the app were ported to to another device it
    //might not render in the same proportions... i'll need to review this after
    //the gameplay has been worked out
    
    //i have decided to add another sub paddle drawn in red, it is a shadow of
    // the ,master yellow panel. i intedn for the ball to gain more momentum 
    // if it hits the red part when the paddle is at its height
    
    //now my objective is creating the ball, and seeing if i can detect 
    //when it hits the paddle, i have the walls down enough but the paddle, will
    // be a pain, i can tell. i see that the graphics class has clip detection
    //methods, perhaps these are the path forward, regardless i must focus on
    // gameplay at the moment.
    
    //its been a long day, and i've lost track of time,
    //i managed to add a ball with motion, then i added an array of brick 
    //objects
    //it i then figured out how to give the bricks hit detection
    // i also figured out how to change their color to match their health
    // it is now a full brick breaker game
    
    //now to add scores and victory states.
    //but i have a math 
    
}
