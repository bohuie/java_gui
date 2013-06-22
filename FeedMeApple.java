import java.awt.*;
import javax.swing.*;

public class FeedMeApple 
{
  private int x, y;
  private Image myImage;
  boolean visible;

  private final int BOARD_HEIGHT = 1100;
  private final int FALL_SPEED   = 2;

  public FeedMeApple( int xpos, int ypos )
  {
    ImageIcon ii = new ImageIcon( getClass().getResource( "apple.png" ) );
    myImage      = ii.getImage();
    visible      = true;
    x            = xpos;
    y            = ypos;
  }

  public Image   getImage()  { return myImage; }
  public int     getX()      { return x; }
  public int     getY()      { return y; }
  public boolean isVisible() { return visible; }

  // apple falls at a constant speed from top to bottom of board
  // when it moves past the board, it becomes invisible
  public void move()
  {
    y = y + FALL_SPEED;
    if( y > BOARD_HEIGHT )
      visible = false;
  }
}

