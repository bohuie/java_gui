import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// draws image that slowly fades out 
// restructed version of FadeOut.java
public class DrawFading extends JFrame
{
  public DrawFading()
  {
    // setup basic panel 
    DrawPanel pane = new DrawPanel();

    // add components 
    add( pane ); 

    // set frame attributes
    setTitle( "Example" );
    setSize( 850, 780 );
    setLocationRelativeTo( null );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
  }

  public static void main( String[] args )
  {
    DrawFading ex = new DrawFading();
    ex.setVisible( true );
  }
}

class DrawPanel extends JPanel implements ActionListener
{
  Image img;
  Timer timer;
  private float alpha;

  public DrawPanel()
  {
    alpha = 1f; 
    img   = new ImageIcon( "swim.JPG" ).getImage();
    timer = new Timer( 20, this );     // pass this in as event handler
    timer.start(); 
  } 

  // all the drawing is done in this method
  public void paint( Graphics g )
  {
    super.paint( g );                  // this line is necessary
    Graphics2D g2d = ( Graphics2D )g;

    // do drawings 
    g2d.setComposite( AlphaComposite.getInstance( AlphaComposite.SRC_OVER, alpha ));
    g2d.drawImage( img, 10, 10, null ); 
  }

  public void actionPerformed( ActionEvent e )
  {
    alpha -= 0.05f;
    if( alpha < 0 )
    {
      alpha = 0;
      timer.stop();
    }
    repaint();
  }
}

