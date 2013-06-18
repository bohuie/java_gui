import java.awt.*;
import java.awt.geom.Ellipse2D;
import javax.swing.*;

// draws rectangles and circles
public class DrawShapes extends JFrame
{
  public DrawShapes()
  {
    // setup basic panel 
    DrawPanel pane = new DrawPanel();

    // add components 
    add( pane ); 

    // set frame attributes
    setTitle( "Example" );
    setSize( 350, 250 );
    setLocationRelativeTo( null );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
  }

  public static void main( String[] args )
  {
    DrawShapes ex = new DrawShapes();
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
    g2d.setColor( new Color( 150, 150, 150 ));

    // different sized rectangles and rect with rounded corners
    g2d.fillRect( 20, 20, 50, 50 );
    g2d.fillRect( 120, 20, 90, 60 );
    g2d.fillRoundRect( 250, 20, 70, 60, 25, 25 );

    // oval, partial oval, circle 
    g2d.fill( new Ellipse2D.Double( 10, 100, 80, 100 ));
    g2d.fillArc( 120, 130, 110, 100, 5, 150 );
    g2d.fillOval( 270, 130, 50, 50 ); 
  }
}

