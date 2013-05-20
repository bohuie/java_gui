import java.awt.*;
import javax.swing.*;

public class DrawTransparentRects extends JFrame
{
  public DrawTransparentRects()
  {
    // setup basic panel 
    DrawPanel pane = new DrawPanel();

    // add components 
    add( pane ); 

    // set frame attributes
    setTitle( "Example" );
    setSize( 590, 120 );
    setLocationRelativeTo( null );
    setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
  }

  public static void main( String[] args )
  {
    DrawTransparentRects ex = new DrawTransparentRects();
    ex.setVisible( true );
  }
}

class DrawPanel extends JPanel
{
  // all the drawing is done in this method
  public void paint( Graphics g )
  {
    Graphics2D g2d = ( Graphics2D )g;

    // do drawings 
    g2d.setColor( Color.BLUE ); 
    
    // draw a series of rectangles side by side with varying transparency levels
    // transparency is done via alpha composition - combine image with a background
    for( int i=1; i<=10; i++ )
    {
      // SRC_OVER rule specifies how source and destination pixels are combined
      // i*0.1f the alpha value (where 0.0f is transparency, 1.0f is opaque)
      g2d.setComposite( AlphaComposite.getInstance( AlphaComposite.SRC_OVER, i*0.1f ));
      g2d.fillRect( 50*i, 20, 40, 40 ); 
    }
  }
}

