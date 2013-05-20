import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class DrawRects extends JFrame
{
  public DrawRects()
  {
    // setup basic panel 
    DrawPanel pane = new DrawPanel();

    // add components 
    add( pane ); 

    // set frame attributes
    setTitle( "Example" );
    setSize( 360, 300 );
    setLocationRelativeTo( null );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
  }

  public static void main( String[] args )
  {
    DrawRects ex = new DrawRects();
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

    // draw text 
    g2d.setColor( Color.BLACK ); 
    g2d.drawString( "Series of Nice Rectanges", 100, 12 );

    // draw several rectanges
    g2d.setColor( new Color( 212, 212, 212 ));
    g2d.drawRect(  10,  15,  90,  60 );
    g2d.drawRect( 130,  15,  90,  60 );
    g2d.drawRect( 250,  15,  90,  60 );
    g2d.drawRect(  10, 105,  90,  60 );
    g2d.drawRect( 130, 105,  90,  60 );
    g2d.drawRect( 250, 105,  90,  60 );
    g2d.drawRect(  10, 195,  90,  60 );
    g2d.drawRect( 130, 195,  90,  60 );
    g2d.drawRect( 250, 195,  90,  60 );

    // fill each rectangle with a different color
    g2d.setColor( new Color( 125, 167, 116 ));
    g2d.fillRect(  10,  15,  90,  60 ); 

    g2d.setColor( new Color( 42, 179, 231 ));
    g2d.fillRect( 130,  15,  90,  60 );

    g2d.setColor( new Color( 70, 67, 123 ));
    g2d.fillRect( 250,  15,  90,  60 );

    g2d.setColor( new Color( 130, 100, 84 ));
    g2d.fillRect(  10, 105,  90,  60 );

    g2d.setColor( new Color( 252, 211, 61 ));
    g2d.fillRect( 130, 105,  90,  60 );

    g2d.setColor( new Color( 241, 98, 69 ));
    g2d.fillRect( 250, 105,  90,  60 );

    g2d.setColor( new Color( 217, 146, 54 ));
    g2d.fillRect(  10, 195,  90,  60 );

    g2d.setColor( new Color( 63, 121, 186 ));
    g2d.fillRect( 130, 195,  90,  60 );

    g2d.setColor( new Color( 31, 21, 1 ));
    g2d.fillRect( 250, 195,  90,  60 );
  }
}
