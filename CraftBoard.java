import java.awt.Color; 
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.Timer; 

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
  }

  // animate sprite according to event 
  public void actionPerformed( ActionEvent e ) 
  {
    ship.move();
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
