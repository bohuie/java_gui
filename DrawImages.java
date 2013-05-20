import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class DrawImages extends JFrame
{
  public DrawImages()
  {
    // setup image 
    Image img = new ImageIcon( "lion.png" ).getImage();

    // setup basic panel 
    DrawPanel pane = new DrawPanel( img );

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
    DrawImages ex = new DrawImages();
    ex.setVisible( true );
  }
}

// make custom panel class 
class DrawPanel extends JPanel 
{
  Image pix; 

  public DrawPanel( Image img ) 
  {
    pix = img;
    Dimension dim = new Dimension( pix.getWidth( null ), pix.getHeight( null ) );
    setPreferredSize( dim ); 
  }

  public void paintComponent( Graphics g ) 
  {
    super.paintComponent( g );

    // paint using the Graphics2D object
    Graphics2D g2d = ( Graphics2D )g;
  
    // draw the image 
    g2d.drawImage( pix, 0, 0, null ); 
  }
}
