import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 

// draws an image that fades out in time
public class FadeOut extends JPanel implements ActionListener 
{
  Image castle;
  Timer timer;
  private float alpha = 1f;

  public FadeOut() 
  {
    castle = new ImageIcon( "hippo.png" ).getImage();
    timer = new Timer( 20, this );
    timer.start();
  }

  public void paint( Graphics g ) 
  {
    super.paint( g );

    Graphics2D g2d = ( Graphics2D )g;
    g2d.setComposite( AlphaComposite.getInstance( AlphaComposite.SRC_OVER, alpha ));
    g2d.drawImage( castle, 10, 10, null );
  }

  public static void main( String[] args ) 
  {
    JFrame frame = new JFrame( "Fade out" );
    frame.add( new FadeOut() );
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setSize( 280, 240 );
    frame.setLocationRelativeTo( null );
    frame.setVisible( true );
  }

  public void actionPerformed( ActionEvent e ) 
  {
    alpha += -0.01f;
    if( alpha <= 0 ) 
    {
      alpha = 0;
      timer.stop();
    }
    repaint();
  }
}
