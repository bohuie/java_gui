import java.awt.*; 
import java.awt.geom.*; 
import javax.swing.JPanel;

public class DonutBoard extends JPanel 
{
  public DonutBoard() 
  {
  }

  // all the drawing is done in this method
  public void paint( Graphics g )
  {
    super.paint( g ); 
    Graphics2D g2d = ( Graphics2D )g;

    // do drawings 
    Ellipse2D e = new Ellipse2D.Double( 0, 0, 80, 130 );
    g2d.setStroke( new BasicStroke( 1 ) ); 
    g2d.setColor( Color.GREEN ); 

    // get the height and weight of this object (panel)
    Dimension size = getSize();
    double    w    = size.getWidth();
    double    h    = size.getHeight();

    // repeatedly draw a transformed ellipse "e" at every 5 degree increment
    for( double deg = 0; deg < 360; deg += 5 )
    {
      AffineTransform at = AffineTransform.getTranslateInstance( w/2, h/2 );
      at.rotate( Math.toRadians( deg ) ); 
      g2d.draw( at.createTransformedShape( e ) );
    }
  }
}
