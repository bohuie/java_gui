import java.awt.*;
import javax.swing.*;
import java.awt.geom.AffineTransform;

public class DrawTranslation extends JFrame
{
  public DrawTranslation()
  {
    // setup basic panel 
    DrawPanel pane = new DrawPanel();

    // add components 
    add( pane ); 

    // set frame attributes
    setTitle( "Translation" );
    setSize( 650, 400 );
    setLocationRelativeTo( null );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
  }

  public static void main( String[] args )
  {
    DrawTranslation ex = new DrawTranslation();
    ex.setVisible( true );
  }
}

class DrawPanel extends JPanel
{
  // all the drawing is done in this method
  public void paintComponent( Graphics g )
  {
    super.paintComponent( g ); 
    Graphics2D g2d = ( Graphics2D )g;

    // do drawings 
    g2d.setColor( new Color( 150, 150, 150 ));

    // draw first shape
    g2d.fillRect( 20, 20, 80, 50 ); 

    // translate it 
    g2d.translate( 150, 50 );
    g2d.fillRect( 20, 20, 80, 50 ); 

    // translate + rotate it 
    g2d.translate( 150, 50 );
    g2d.rotate( Math.PI/4 );
    g2d.fillRect( 20, 20, 80, 50 ); 

    // translate + scale up
    AffineTransform tx1 = new AffineTransform(); 
    tx1.scale( 2.0, 2.0 ); 
    g2d.setTransform( tx1 ); 
    g2d.translate( 200, 100 );
    g2d.fillRect( 20, 20, 80, 50 ); 
  }
}

