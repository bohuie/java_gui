import java.awt.*;
import javax.swing.*;

public class CraftMissile
{
  private int x, y;
  private Image myImage;
  boolean visible;

  private final int BOARD_WIDTH   = 390;
  private final int MISSILE_SPEED = 2;

  public CraftMissile( int xpos, int ypos )
  {
    ImageIcon ii = new ImageIcon( getClass().getResource( "missile.png" ) );
    myImage      = ii.getImage();
    visible      = true;
    x            = xpos;
    y            = ypos;
  }

  public Image   getImage()  { return myImage; }
  public int     getX()      { return x; }
  public int     getY()      { return y; }
  public boolean isVisible() { return visible; }

  // missile moves at a constant speed from left side to right side of board
  // when it moves past the board, it becomes invisible
  public void move()
  {
    x = x + MISSILE_SPEED;
    if( x > BOARD_WIDTH )
      visible = false;
  }
}
