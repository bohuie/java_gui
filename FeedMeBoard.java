import java.awt.*; 
import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.Timer; 
import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.util.Random; 

public class FeedMeBoard extends JPanel implements ActionListener
{
  private Timer        timer;
  private FeedMeSprite monster;
  private FeedMeDrop   dropper;
  private Image        bkgrd; 
  private int          score; 

  public FeedMeBoard() 
  {
    setFocusable( true );
    setDoubleBuffered( true );

    // apply my own event handler  
    TAdapter myListener = new TAdapter();
    addKeyListener( myListener ); 

    // setup background 
    ImageIcon ii    = new ImageIcon( getClass().getResource( "sky.png" ) );
    bkgrd           = ii.getImage();

    // initialize the game pieces  
    score   = 0; 
    dropper = new FeedMeDrop( 3 );
    monster = new FeedMeSprite();
    timer   = new Timer( 5, this );    // 5ms delay, "this" as the listener object
    timer.start(); 
  }

  // all the drawing is done in this method
  public void paint( Graphics g )
  {
    super.paint( g ); 
    Graphics2D g2d = ( Graphics2D )g;

    // do drawings 
    g2d.drawImage( bkgrd, 0, 0, null ); 
    g2d.drawImage( monster.getImage(), monster.getX(), monster.getY(), this );

    // draw each food item 
    ArrayList food = dropper.getTargets();
    for( int i=0; i<food.size(); i++ )
    {
      FeedMeApple a = ( FeedMeApple )food.get( i );
      g2d.drawImage( a.getImage(), a.getX(), a.getY(), this );
    }
  }

  // animate sprite according to the timer event 
  public void actionPerformed( ActionEvent e ) 
  {
    monster.move();
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
    checkCollision();
    repaint();  
  }

  private void checkCollision() 
  {
    Rectangle r1   = monster.getBounds();
    ArrayList food = dropper.getTargets();
    for( int i=0; i<food.size(); i++ )
    {
      FeedMeApple a  = ( FeedMeApple )food.get( i );
      Rectangle   r2 = a.getBounds(); 
      if( r1.intersects( r2 ) )
      {
        a.setVisible( false );
        score++; 
      }
    }
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
