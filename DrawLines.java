import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class DrawLines extends JFrame
{
  public DrawLines()
  {
    // setup basic panel 
    DrawPanel pane = new DrawPanel();

    // add components 
    add( pane ); 

    // set frame attributes
    setTitle( "Example" );
    setSize( 300, 300 );
    setLocationRelativeTo( null );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
  }

  public static void main( String[] args )
  {
    DrawLines ex = new DrawLines();
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

    // draw basic solid line 
    g2d.drawLine( 20, 40, 250, 40 );

    // draw four types of dashed lines of decreasing widths
    float[] dash1 = { 2f, 0f, 2f };
    float[] dash2 = { 1f, 1f, 1f };
    float[] dash3 = { 4f, 0f, 2f };
    float[] dash4 = { 4f, 4f, 1f };

    BasicStroke bs1 = new BasicStroke( 4, BasicStroke.CAP_BUTT,
                      BasicStroke.JOIN_ROUND, 1.0f, dash1, 2f );

    BasicStroke bs2 = new BasicStroke( 3, BasicStroke.CAP_BUTT,
                      BasicStroke.JOIN_ROUND, 1.0f, dash2, 2f );

    BasicStroke bs3 = new BasicStroke( 2, BasicStroke.CAP_BUTT,
                      BasicStroke.JOIN_ROUND, 1.0f, dash3, 2f );

    BasicStroke bs4 = new BasicStroke( 1, BasicStroke.CAP_BUTT,
                      BasicStroke.JOIN_ROUND, 1.0f, dash4, 2f );

    g2d.setStroke( bs1 );
    g2d.drawLine( 20, 80,  250, 80 );

    g2d.setStroke( bs2 );
    g2d.drawLine( 20, 120, 250, 120 );

    g2d.setStroke( bs3 );
    g2d.drawLine( 20, 160, 250, 160 );

    g2d.setStroke( bs4 );
    g2d.drawLine( 20, 200, 250, 200 );
  }
}
