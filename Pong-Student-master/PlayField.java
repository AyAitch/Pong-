/**
 * TODO (132): Fill out an appropriate assignment comment block
 * 
 * Alex Hackbart 
 * Mr. Hardman
 * PTEC
 * 11/30/2018
 * 
 */

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.Color;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayField extends World
{
    //TODO (1): Declare a boolean instance variable called startGame that is initialized to false
    public boolean startGame = false;

    //TODO (2): Declare a Ball instance variable called theBall
    private Ball theBall;

    //TODO (3): Declare a Score instance variable called player1Score
    public Score player1Score;

    //TODO (4): Declare a Score instance variable called player2Score
    public Score player2Score;

    // TODO (5): Declare a default constructor for PlayField
    /**
     * Default constructor for objects of class PlayField.
     * 
     * @param There are no parameters
     * @return an object of class CreatureWorld
     */
    public PlayField() 
    {
        // TODO (6): Use the superclass' constructor to create a world
        //           with 800 by 600 cells with a cell size of 1x1 pixels
        super(800,600,1);           
        // TODO (15): Make a method call to the initializePlayingField method
        initializePlayingField();

    }

    // TODO (7): Declare a method called initializePlayingField that
    //           does not return anything and has no parameters
    
    /**
     * 
     * initializePlayingField makes it so that the actors and objects are ready for the players when they want to 
     * play the game
     * 
     * @param None their are no parameters
     * @return Nothing is returned
     * 
     */
    private void initializePlayingField()
    {
        // TODO (8): Set the color of the background of the world to BLACK
        getBackground().setColor(Color.BLACK); 
        // TODO (9): Fill a rectangle on the background starting at (0,0) and having a width of the width of the world and a height of the height of the world
        getBackground().fillRect(0,0,getWidth(),getHeight() ); 
        // TODO (10): Set the color of the background to GRAY (You may change this later)
        getBackground().setColor(greenfoot.Color.GRAY);  
        // TODO (11): Fill a rectangle on the background starting at (halfway across the screen, 0) and having a width of 4 and a height of the height of the world
        getBackground().fillRect(getWidth()/2,0, 4, getHeight() );
        // TODO (14): Make a method call to addPlayersAndObjects
        addPlayerAndObjects();
        // TODO (12): Show text stating that the player should "press the space bar to begin play" at an x location of 200 and a y location of 550
        showText( " press the space bar to begin play ", 200, 550 );
    }

    // TODO (13): Declare a method called addPlayersAndObjects that
    //           does not return anything and has no parameters
    
    /**
     * 
     * addPlayerAndObjects adds the 2 players and the ball along with the scoreboards for each player. 
     * 
     * @param None their are no parameters
     * @return Nothing is returned
     * 
     */
    private void addPlayerAndObjects()
    {
        // TODO (54): Initialize the theBall variable to a new Ball object
        theBall = new Ball(); 
        // TODO (40): Initialize the player1Score variable to a new Score object with an appropriate parameter value
        player1Score = new Score(true); 
        // TODO (41): Initialize the player2Score variable to a new Score object with an appropriate parameter value
        player2Score = new Score(false); 
        // TODO (55): Add the theBall object in the middle of the world
        addObject( theBall, getWidth()/2, getHeight()/2 ); 
        // TODO (124): Add a new Paddle for player one using an appropriate parameter value at a x location of 10 and a y location of the middle of the height of the world
        addObject( new Paddle(true) , 10, getHeight()/2 );
        // TODO (125): Add a new Paddle for player two using an appropriate parameter value at a x location of 10 pixels less than the width of the world and a y location of the middle of the height of the world
        addObject( new Paddle(false), getWidth()-10, getHeight()/2 ); 
        // TODO (42): Add the player1Score object at an x location of 200 and a y location of 50
        addObject(player1Score, 200, 50 ); 
        // TODO (43): Add the player2Score object at an x location of 200 pixels less than the width of the world and a y location of 50
        addObject(player2Score, getWidth() -200 , 50 );
    }

    // TODO (61): Declare the act method for the PlayField class turn Nothing is returned
    
    /**
     * 
     *  act is the method that
    * runs during every act cycle
    * of the scenario
    *
    * @param There are no parameters
    * @return Nothing is returned
     */
    public void act()
    {
        // TODO (62): If the game has not started...
        if ( startGame == false )
        {
            //      TODO (63): Use a method to check if the space bar key has been pressed 
            checkKeyPress();
        }
        
        
        
            // TODO (80): Otherwise...
            else{
            //      TODO (81): Use a method to check if a player has won
            checkWin();
        }
        
    }
    // TODO (56): Declare a method called checkKeyPress that does not
    //          return anything and has no parameters
    
    /**
     * checkKeyPress checks if the space bar is pressed and if it is, the game will start
     * 
     * @param None there are no parameters
     * @return Nothing is returned
     * 
     */
    private void checkKeyPress()
    {
        // TODO (57): Inside the method, you need to check if the space key has been pressed
        if ( Greenfoot.isKeyDown("space") == true )
        {
            //      TODO (58): If the space bar has been pressed, the game has now started. Change the variable that stores that info
            startGame = true;      
            //      TODO (59): Remove the text that tells the player to press the space bar to begin. You can do this by displaying an empty string, "", at the same location
            showText( " ", 200, 550 );      
            //      TODO (60): Set the velocity of theBall to be 5 pixels
            theBall.setVelocity(5);

        }

    }

    // TODO (64): Declare a public method called reset that does not return
    //            anything and has no parameters
    
    /**
     * reset resets the scenario for the next point
     * @param None their are no parameters
     * @return Nothing is returned
     * 
     */
    public void reset()
    {
        // TODO (65): Set the theBall variable to a new Ball object
        theBall = new Ball(); 
        // TODO (66): Add theBall in the middle of the world
        addObject(theBall, getWidth()/2, getHeight()/2 ); 
        // TODO (67): Set the velocity of theBall to 0
        theBall.setVelocity(0); 
        // TODO (68): Use the show text method to display that the user should Press the space bar to begin at an x location of 200 and a y location of 550
        showText(" Press the space bar to begin " , 200 ,  550 );
        // TODO (69): Set the startGame variable to false
        startGame = false;
    }

    // TODO (70): Declare a method called checkWin that does not
    //            return anything and has no parameters
    /**
     * checkWin checks if one of the players won the game.
     * @param None their are no parameters
     * @return Nothing is returned
     */
    private void checkWin() 
    {
        // TODO (71): Declare a local GreenfootImage variable called player1Win that
        //            is initialized to a new GreenfootImage object with "Player 1 Wins!" as the text, 
        //            45 as the font size, player one's color as the text color, and BLACK as the background color
        GreenfootImage player1Win = new GreenfootImage (" Player 1 Wins! ", 45, Color.RED, Color.BLACK );            
        // TODO (72): Declare a local GreenfootImage variable called player2Win that
        //           is initialized to a new GreenfootImage object with "Player 2 Wins!" as the text, 
        //            45 as the font size, player two's color as the text color, and BLACK as the background color
        GreenfootImage player2Win = new GreenfootImage (" Player 2 Wins! ", 45, Color.BLUE, Color.BLACK );          
        // TODO (73): Declare a local integer variable called player1Total that is 
        //            initialized to the score of player one's scoreboard (use the getScore method)
        int player1Total = player1Score.getScore();           
        // TODO (74): Declare a local integer variable called player2Total that is
        //            initialized to the score of player two's scoreboard
        int player2Total = player2Score.getScore();

        // TODO (75): The game is won if one of the players has a score of 7 or more. Write two conditional statements that will check this, one for each player
        if ( player1Total >= 7 )
        {
            removeObjects(getObjects(null));
            getBackground().setColor(Color.BLACK);
            getBackground().fillRect(0, 0, getWidth(), getHeight() );
            getBackground().drawImage(player1Win, getWidth()/2, getHeight()/2 );
        }
        if ( player2Total >= 7 )
        {
            removeObjects(getObjects(null));
            getBackground().setColor(Color.BLACK);
            getBackground().fillRect(0, 0, getWidth(), getHeight() );
            getBackground().drawImage(player2Win, getWidth()/2, getHeight()/2 );
        }
        //      TODO (76): In both conditional statements from the previous TODO, remove all objects (use null as the parameter for the removeObjects method)

        //     TODO (77): In both conditional statements, set the color of the background to BLACK

        //      TODO (78): In both conditional statements, fill a rectangle on the background that starts at (0,0) and has a width of the width of the world and a height of the height of the world

        //      TODO (79): In both conditional statements, draw an image on the background that will show which player won in the exact center of the world (you should have GreenfootImage variables for this)

    }

    // TODO (16): Declare a public method called getStarted that returns
    //            a boolean and has no parameters
    /**
     * getStarted returns startGame
     * @param None their are no parameters
     * @return A boolean is returned
     */
    public boolean getStarted()
    {
        // TODO (17): Inside the method, return the variable that states whether the game has started or not
        return startGame;
    }
}
