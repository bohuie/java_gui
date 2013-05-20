import java.awt.*;
import javax.swing.*;

public class Skeleton2D extends JPanel
{
  // all the drawing is done in this method
  public void paint( Graphics g )
  {
    Graphics2D g2d = ( Graphics2D )g;

    // do drawings 
    g2d.drawString( "Java 2D", 50, 50 );
  }

  public static void main( String[] args )
  {
    JFrame     frame = new JFrame( "Java 2D Skeleton" );
    Skeleton2D ex    = new Skeleton2D();
    frame.add( ex ); 

    // set frame attributes
    frame.setSize( 300, 200 );
    frame.setLocationRelativeTo( null );
    frame.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
    frame.setVisible( true );
  }
}
