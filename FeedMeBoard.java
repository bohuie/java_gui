import java.awt.Color; 
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.Timer; 
import java.util.ArrayList;
import java.util.Random; 

public class FeedMeBoard extends JPanel implements ActionListener
{
  private Timer        timer;
  private FeedMeSprite monster;
  private ArrayList    food; 

  public FeedMeBoard() 
  {
    setFocusable( true );
    setDoubleBuffered( true );

    // apply my own event handler  
    TAdapter myListener = new TAdapter();
    addKeyListener( myListener ); 

    // initialize the game pieces  
    monster = new FeedMeSprite();
    food    = new ArrayList();
    timer   = new Timer( 5, this );    // 5ms delay, "this" as the listener object
    timer.start(); 
  }

  // all the drawing is done in this method
  public void paint( Graphics g )
  {
    super.paint( g ); 
    Graphics2D g2d = ( Graphics2D )g;

    // do drawings 
    g2d.drawImage( monster.getImage(), monster.getX(), monster.getY(), this );

    // draw each food item 
    for( int i=0; i<food.size(); i++ )
    {
      FeedMeApple a = ( FeedMeApple )food.get( i );
      g2d.drawImage( a.getImage(), a.getX(), a.getY(), this );
    }
  }

  private void drop()
  {
    // position the item somewhere at the top of the board  
    Random r = new Random();
    if( r.nextFloat() > 0.95 )
    {
      int xpos = Math.abs( r.nextInt() ) % 1000;
      FeedMeApple a = new FeedMeApple( xpos, -100 ); 
      food.add( a );
    }
  } 

  // animate sprite according to the timer event 
  public void actionPerformed( ActionEvent e ) 
  {
    monster.move();
    drop(); 
    // remove item from arraylist if not visible, else let it fall
    for( int i=0; i<food.size(); i++ )
    {
      FeedMeApple a = ( FeedMeApple )food.get( i );
      if( a.isVisible() )
        a.move(); 
      else 
        food.remove( i ); 
    }
    repaint();  
  }

  // my own listener to handle events  
  // the sprite will animate according to the event given
  private class TAdapter extends KeyAdapter 
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
