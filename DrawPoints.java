import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class DrawPoints extends JFrame
{
  public DrawPoints()
  {
    // setup basic panel 
    DrawPanel pane = new DrawPanel();

    // add components 
    add( pane ); 

    // set frame attributes
    setTitle( "Example" );
    setSize( 300, 200 );
    setLocationRelativeTo( null );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
  }

  public static void main( String[] args )
  {
    DrawPoints ex = new DrawPoints();
    ex.setVisible( true );
  }
}

// make custom panel class 
class DrawPanel extends JPanel 
{
  public void paintComponent( Graphics g ) 
  {
    super.paintComponent( g );

    // paint using the Graphics2D object
    Graphics2D g2d = ( Graphics2D )g;
    g2d.setColor( Color.blue );

    Dimension size   = getSize();
    Insets    insets = getInsets();

    int w = size.width  - insets.left - insets.right;
    int h = size.height - insets.top  - insets.bottom;

    Random r = new Random();

    // randomly paint a bunch of points within the window boundary
    for (int i = 0; i<=1000; i++) 
    {
      int x = Math.abs( r.nextInt() ) % w;
      int y = Math.abs( r.nextInt() ) % h;
      g2d.drawLine( x, y, x, y );       // effectively draws a point
    }
  }
}
