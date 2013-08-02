import java.awt.*; 
import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.Timer; 
import javax.swing.ImageIcon;
import javax.swing.JButton; 
import java.util.ArrayList;
import java.util.Random; 

public class FeedMeBoard extends JPanel implements ActionListener
{
  private Timer        timer;          // a timer to handle events
  private FeedMeSprite monster;        // the dog that eats everything
  private FeedMeDrop   dropper;        // manages when food items drop from sky
  private Image        bkgrd;          // background image 
  private int          score;          // keeps track of game score
  private boolean      happy;          // changes animation of monster after eating
  private boolean      gameOver;       // keeps track of when game is over

  public FeedMeBoard() 
  {
    // setup basic GUI layout
    setLayout( null ); 
    setFocusable( true );
    setDoubleBuffered( true );

    // apply my own event handler  
    MyKeyAdapter myListener = new MyKeyAdapter();
    addKeyListener( myListener ); 

    // setup background 
    ImageIcon ii = new ImageIcon( getClass().getResource( "sky.png" ) );
    bkgrd        = ii.getImage();

    // initialize the game pieces  
    gameOver = false;
    happy    = false;
    score    = 0; 
    dropper  = new FeedMeDrop( 3 );    // itms fall at 3 seconds apart
    monster  = new FeedMeSprite();     // create monster eater
    timer    = new Timer( 5, this );   // 5ms delay, "this" as the listener object
    timer.setInitialDelay( 5 );        // 5ms initial delay before timer starts 
    timer.setDelay( 3 );               // 3ms delay between checks 
    timer.start(); 
  }

  // all the drawing is done in this method
  public void paint( Graphics g )
  {
    // setup basic panel for drawing
    super.paint( g ); 
    Graphics2D g2d = ( Graphics2D )g;

    // do drawings 
    g2d.drawImage( bkgrd, 0, 0, null ); 

    // draw the corresponding monster image depending on whether he's happy or not
    if( monster.getHappy() )
      g2d.drawImage( monster.getHappyImage(), monster.getX(), monster.getY(), this );
    else
      g2d.drawImage( monster.getImage(), monster.getX(), monster.getY(), this );

    // draw each food item at given locations
    ArrayList food = dropper.getTargets();
    for( int i=0; i<food.size(); i++ )
    {
      FeedMeApple a = ( FeedMeApple )food.get( i );
      g2d.drawImage( a.getImage(), a.getX(), a.getY(), this );
    }

    // change to ending scene if game is over
    // ending scene will display credits, game score, and stops the music
    if( gameOver )
    {
      g2d.setColor( Color.WHITE ); 
      g2d.setFont( new Font( "Comic Sans MS", Font.BOLD, 48 ));
      g2d.drawString( "Game Over", 370, 350 );
      g2d.drawString( "Your Score: " + score + " / " + dropper.getMax(), 280, 400 );

      g2d.setColor( Color.GRAY ); 
      g2d.setFont( new Font( "Comic Sans MS", Font.BOLD, 24 ));
      g2d.drawString( "Game made by Bowen Hui", 20, 20 ); 
      g2d.drawString( "Music from Kevin MacLeod", 20, 50 ); 
      g2d.drawString( "Sound effects from MediaCollege.com", 20, 80 ); 

      SoundEffect.SONG.stoploop();
    }
  }

  // animate sprite according to the timer event 
  // execute this method everytime an event is detected
  public void actionPerformed( ActionEvent e ) 
  {
    monster.move();                    // move monster accordingly

    // remove item from arraylist if not visible, else let it fall
    ArrayList food = dropper.getTargets();
    for( int i=0; i<food.size(); i++ )
    {
      FeedMeApple a = ( FeedMeApple )food.get( i );
      if( a.isVisible() )
        a.move(); 
      else 
        food.remove( i ); 
    }

    checkCollision();                  // check if monster collides with food item
    checkGameOver();                   // check if game is over
    repaint();                         // effectively, calls paint()
  }

  // if nothing is left to drop then game is over
  private void checkGameOver()  
  {
    ArrayList food = dropper.getTargets();
    if( food.size() == 0 )
      gameOver = true;
  }

  // if the bounding boxes of two items intersect, then there is a collision
  private void checkCollision() 
  {
    // get bounding box of monster
    Rectangle r1   = monster.getBounds();

    // get bounding box of all possible food items
    ArrayList food = dropper.getTargets();
    for( int i=0; i<food.size(); i++ )
    {
      FeedMeApple a  = ( FeedMeApple )food.get( i );
      Rectangle   r2 = a.getBounds(); 

      // checks intersection - if so, monster eats food item
      if( r1.intersects( r2 ) )
      {
        a.setVisible( false );
        SoundEffect.EAT.play();
        monster.setHappy( true );
        score++; 
      }
    }
  }
  
  // my own listener to handle keyboard events  
  // the sprite will animate according to the event given
  private class MyKeyAdapter extends KeyAdapter 
  {
    public void keyReleased( KeyEvent e ) 
    {
      monster.keyReleased( e );
    }

    public void keyPressed( KeyEvent e ) 
    {
      monster.keyPressed( e );
    }
  }
}
