import java.awt.*;
import javax.swing.*;

public class FeedMeApple 
{
  private int     x, y;                     // locations of apple
  private Image   myImage;                  // my image
  private boolean visible;                  // my visibility
  private int     width, height;            // my bounding box dimensions

  // constants
  private final int BOARD_HEIGHT = 800;     // game board dimension
  private final int FALL_SPEED   = 2;       // number of pixels to fall each time

  // constructor
  public FeedMeApple( int xpos, int ypos )
  {
    // initialize private variables
    ImageIcon ii = new ImageIcon( getClass().getResource( "apple.png" ) );
    myImage      = ii.getImage();
    width        = myImage.getWidth( null );
    height       = myImage.getHeight( null );
    visible      = true;
    x            = xpos;
    y            = ypos;
  }

  // accessors
  public Image   getImage()  { return myImage; }
  public int     getX()      { return x; }
  public int     getY()      { return y; }
  public boolean isVisible() { return visible; }

  // returns the bounding box of the item  
  public Rectangle getBounds()
  {
    Rectangle box = new Rectangle( x, y, width, height );
    return box;
  }

  // mutator 
  // if collision happens, the apple disappears
  public void setVisible( boolean val ) 
  {
    visible = val; 
  }

  // apple falls at a constant speed from top to bottom of board
  public void move()
  {
    y = y + FALL_SPEED;

    // when it moves beyond the board, it becomes invisible
    if( y > BOARD_HEIGHT )
      visible = false;
  }
}

