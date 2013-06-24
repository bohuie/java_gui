import java.awt.*;
import javax.swing.*;

public class FeedMeApple 
{
  private int     x, y;
  private Image   myImage;
  private boolean visible;
  private int     width, height;

  private final int BOARD_HEIGHT = 800;
  private final int FALL_SPEED   = 2;

  // constructor
  public FeedMeApple( int xpos, int ypos )
  {
    ImageIcon ii = new ImageIcon( getClass().getResource( "apple.png" ) );
    myImage      = ii.getImage();
    width        = myImage.getWidth( null );
    height       = myImage.getHeight( null );
    visible      = true;
    x            = xpos;
    y            = ypos;
  }

  public Image   getImage()  { return myImage; }
  public int     getX()      { return x; }
  public int     getY()      { return y; }
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

  // apple falls at a constant speed from top to bottom of board
  // when it moves past the board, it becomes invisible
  public void move()
  {
    y = y + FALL_SPEED;
    if( y > BOARD_HEIGHT )
      visible = false;
  }
}

