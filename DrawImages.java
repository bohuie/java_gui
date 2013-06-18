import java.awt.*;
import javax.swing.*;
import java.awt.geom.AffineTransform;

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
    setSize( 600, 400 );
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

    // draw image again with translation
    g2d.translate( 150, 50 );
    g2d.drawImage( pix, 0, 0, null ); 

    // draw image again with translation + rotation
    g2d.translate( 150, 50 );
    g2d.rotate( Math.PI/4 );
    g2d.drawImage( pix, 0, 0, null ); 

    // draw image again with translation + scaling
    AffineTransform tx1 = new AffineTransform(); 
    tx1.scale( 2.0, 2.0 ); 
    g2d.setTransform( tx1 ); 
    g2d.translate( 200, 100 );
    g2d.drawImage( pix, 0, 0, null ); 
  }
}
