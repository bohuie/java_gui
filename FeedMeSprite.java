import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.*;
import javax.swing.ImageIcon;

public class FeedMeSprite
{
  private String  eater;                  // sprite file name 
  private Image   myImage;                // sprite image 
  private int     x;                      // x coordinate on the board
  private int     y;                      // y coordinate on the board
  private int     dx;                     // change in x when moved 
  private int     dy;                     // change in y when moved 
  private int     incr;                   // animation pixel increment
  private boolean visible;
  private int     width;
  private int     height;

  // constructor 
  public FeedMeSprite() 
  {
    // create the sprite image
    eater        = "ghost.png";
    ImageIcon ii = new ImageIcon( getClass().getResource( eater ) );
    myImage      = ii.getImage();
    width        = myImage.getWidth( null );
    height       = myImage.getHeight( null );
    visible      = true;

    // start off the sprite at the bottom middle of the board
    x  = 460;
    y  = 700;

    // initially, there's no change in x,y
    dx = 0;
    dy = 0;

    // changes in pixel animation 
    incr = 5;
  }

  // this method will be called by the Board's event listener
  public void move() 
  {
    x += dx;
    y += dy;
  }

  public int     getX()      { return x; } 
  public int     getY()      { return y; } 
  public Image   getImage()  { return myImage; }
  public boolean isVisible() { return visible; }

  // if collision happens, the apple disappears
  public void setVisible( boolean val ) 
  {
    visible = val; 
  }

  // returns the bounding box of the item  
  public Rectangle getBounds()
  {
    Rectangle box = new Rectangle( x, y, width, height );
    return box;
  }

  // when keys are pressed, set the change in pixels 
  public void keyPressed( KeyEvent e ) 
  {
    int key = e.getKeyCode();
    if( key == KeyEvent.VK_LEFT )  
    {
      if( x > 0 )
        dx = -incr;
      else 
        dx = 0; 
    }

    if( key == KeyEvent.VK_RIGHT ) 
    {
      if( x < 920 )
        dx = incr;
      else 
        dx = 0; 
    }

    // if( key == KeyEvent.VK_UP )    dy = -1; 
    // if( key == KeyEvent.VK_DOWN )  dy = 1; 
  }

  // when keys are released, set all changes to 0 so that there's no movement 
  public void keyReleased( KeyEvent e ) 
  {
    int key = e.getKeyCode();
    if( key == KeyEvent.VK_LEFT )  dx = 0;
    if( key == KeyEvent.VK_RIGHT ) dx = 0;
    if( key == KeyEvent.VK_UP )    dy = 0; 
    if( key == KeyEvent.VK_DOWN )  dy = 0;
    
    // reset sprite so it always stays within the board
    if( x < 0 )   x = 0;
    if( x > 920 ) x = 920;
  }
}
