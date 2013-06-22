import java.awt.Color; 
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.Timer; 
import java.util.ArrayList;

// version 1: supports basic craft movement
// version 2: supports craft with ability to shoot missiles 
public class CraftBoard extends JPanel implements ActionListener
{
  private Timer       timer;
  private CraftSprite ship;

  public CraftBoard() 
  {
    setFocusable( true );
    setDoubleBuffered( true );

    // apply my own event handler  
    TAdapter myListener = new TAdapter();
    addKeyListener( myListener ); 

    // initialize the game pieces  
    ship  = new CraftSprite();
    timer = new Timer( 5, this );    // 5ms delay, "this" as the listener object
    timer.start(); 
  }

  // all the drawing is done in this method
  public void paint( Graphics g )
  {
    super.paint( g ); 
    Graphics2D g2d = ( Graphics2D )g;

    // do drawings 
    g2d.drawImage( ship.getImage(), ship.getX(), ship.getY(), this );

    // draw each of the missiles that the ship has
    ArrayList missiles = ship.getMissiles();
    for( int i=0; i<missiles.size(); i++ )
    {
      CraftMissile m = ( CraftMissile )missiles.get( i );
      g2d.drawImage( m.getImage(), m.getX(), m.getY(), this );
    }
  }

  // animate sprite according to event 
  public void actionPerformed( ActionEvent e ) 
  {
    ship.move();

    // move missiles if still visible on board, otherwise remove it from arraylist
    ArrayList missiles = ship.getMissiles();
    for( int i=0; i<missiles.size(); i++ )
    {
      CraftMissile m = ( CraftMissile )missiles.get( i );
      if( m.isVisible() )
        m.move();
      else
        missiles.remove( i );
    }

    repaint();  
  }

  // my own listener to handle events  
  // the sprite will animate according to the event given
  private class TAdapter extends KeyAdapter 
  {
    public void keyReleased( KeyEvent e ) 
    {
      ship.keyReleased( e );
    }

    public void keyPressed( KeyEvent e ) 
    {
      ship.keyPressed( e );
    }
  }
}
