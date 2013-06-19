import javax.swing.JPanel;

public class SkeletonBoard extends JPanel 
{
  public SkeletonBoard() 
  {
  }

  // all the drawing is done in this method
  public void paint( Graphics g )
  {
    super.paint( g ); 
    Graphics2D g2d = ( Graphics2D )g;

    // do drawings 
    g2d.drawString( "Java 2D", 50, 50 );
  }
}
