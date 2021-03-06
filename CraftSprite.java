import java.awt.Image;
import java.awt.event.*;
import javax.swing.ImageIcon;
import java.util.ArrayList;

// version 1: basic craft sprite that moves in response to arrow key press
// version 2: added ability to fire missiles when spacebar is pressed
// version 3: added collision detection with asteroids 
//            a. asteroid collide with missile
//            b. asteroid collide with space craft
public class CraftSprite
{
  private String  craft;
  private Image   myImage;
  private int     dx;
  private int     dy;
  private int     x;
  private int     y;
  private boolean visible;
  private int     width; 
  private int     height;

  private ArrayList missiles;
  private final int CRAFT_SIZE = 20;

  // constructor 
  public CraftSprite() 
  {
    craft        = "craft.png";
    ImageIcon ii = new ImageIcon( getClass().getResource( craft ) );
    myImage      = ii.getImage();
    width        = myImage.getWidth( null );
    height       = myImage.getHeight( null );
    missiles     = new ArrayList();
    visible      = true; 

    x  = 40;
    y  = 60;
    dx = 0;
    dy = 0;
  }

  // this method will be called by the Board's event listener
  public void move() 
  {
    x += dx;
    y += dy;
  }

  public int       getX()        { return x; } 
  public int       getY()        { return y; } 
  public Image     getImage()    { return myImage; }
  public ArrayList getMissiles() { return missiles; }
  public boolean   isVisible()   { return visible; }

  // set craft visibility in case it gets destroyed by asteroid
  public void setVisible( boolean val ) 
  {
    visible = val;
  }

  // return bounding box of craft based on current x,y position
  public Rectangle getBounds()
  {
    Rectangle box = Rectangle( x, y, width, height );
    return box;
  }

  // when keys are pressed, we set all changes to -1 or 1 to move one pixel
  public void keyPressed( KeyEvent e ) 
  {
    int key = e.getKeyCode();
    if( key == KeyEvent.VK_LEFT )   dx = -1; 
    if( key == KeyEvent.VK_RIGHT )  dx = 1; 
    if( key == KeyEvent.VK_UP )     dy = -1; 
    if( key == KeyEvent.VK_DOWN )   dy = 1; 
    if( key == KeyEvent.VK_SPACE )  fire();  
  }

  private void fire()
  {
    // position the missile at the "tip" of the craft
    CraftMissile m = new CraftMissile( x + CRAFT_SIZE, y + CRAFT_SIZE/2 );
    missiles.add( m );
  }

  // when keys are released, we set all changes to 0 so that there's no movement 
  public void keyReleased( KeyEvent e ) 
  {
    int key = e.getKeyCode();
    if( key == KeyEvent.VK_LEFT )  dx = 0;
    if( key == KeyEvent.VK_RIGHT ) dx = 0;
    if( key == KeyEvent.VK_UP )    dy = 0; 
    if( key == KeyEvent.VK_DOWN )  dy = 0;
  }
}
