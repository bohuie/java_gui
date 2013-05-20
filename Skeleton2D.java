import java.awt.*;
import javax.swing.*;

public class Skeleton2D extends JFrame
{
  public Skeleton2D()
  {
    // setup basic panel 
    DrawPanel pane = new DrawPanel();

    // add components 
    add( pane ); 

    // set frame attributes
    setTitle( "Example" );
    setSize( 300, 200 );
    setLocationRelativeTo( null );
    setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
  }

  public static void main( String[] args )
  {
    Skeleton2D ex = new Skeleton2D();
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
    g2d.drawString( "Java 2D", 50, 50 );
  }
}

