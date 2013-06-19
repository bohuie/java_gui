import java.awt.*; 
import javax.swing.*;

public class PictureBoard extends JPanel 
{
  private Image myImage; 

  public PictureBoard() 
  {
    ImageIcon ii = new ImageIcon( getClass().getResource( "swim.JPG" ) );
    myImage      = ii.getImage(); 
  }

  public int getWidth() 
  {
    int w = myImage.getWidth( null );
    return w; 
  }

  public int getHeight() 
  {
    int h = myImage.getHeight( null );
    return h; 
  }

  // all the drawing is done in this method
  public void paint( Graphics g )
  {
    super.paint( g ); 
    Graphics2D g2d = ( Graphics2D )g;

    // do drawings 
    g2d.drawImage( myImage, 0, 0, null );
  }
}
