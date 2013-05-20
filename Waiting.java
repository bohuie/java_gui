import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Waiting extends JFrame
{
  public Waiting()
  {
    // setup basic panel 
    DrawPanel pane = new DrawPanel();

    // add components 
    add( pane ); 

    // set frame attributes
    setTitle( "Example" );
    setSize( 300, 200 );
    setLocationRelativeTo( null );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
  }

  public static void main( String[] args )
  {
    Waiting ex = new Waiting();
    ex.setVisible( true );
  }
}

class DrawPanel extends JPanel implements ActionListener
{
  Timer timer;
  int   count;

  public DrawPanel() 
  {
    count = 0; 
    timer = new Timer( 80, this );   // pass this as listener
    timer.setInitialDelay( 190 ); 
    timer.start(); 
  }

  // all the drawing is done in this method
  public void paint( Graphics g )
  {
    super.paint( g ); 
    Graphics2D g2d = ( Graphics2D )g;

    // do drawings 
    final double[][] trs = { { 0.0, 0.15, 0.30, 0.5, 0.65, 0.80, 0.9, 1.0 },
                             { 1.0, 0.0,  0.15, 0.30, 0.5, 0.65, 0.8, 0.9 },
                             { 0.9, 1.0,  0.0,  0.15, 0.3, 0.5, 0.65, 0.8 },
                             { 0.8, 0.9,  1.0,  0.0,  0.15, 0.3, 0.5, 0.65},
                             { 0.65, 0.8, 0.9,  1.0,  0.0,  0.15, 0.3, 0.5 },
                             { 0.5, 0.65, 0.8, 0.9, 1.0,  0.0,  0.15, 0.3 },
                             { 0.3, 0.5, 0.65, 0.8, 0.9, 1.0,  0.0,  0.15 },
                             { 0.15, 0.3, 0.5, 0.65, 0.8, 0.9, 1.0,  0.0, }
                           };

    int width, height;
    width = getWidth();
    height = getHeight();

    g2d.setStroke( new BasicStroke( 3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND ));
    g2d.translate( width/2, height/2 );

    for( int i=0; i<8; i++ ) 
    {
      g2d.setComposite( AlphaComposite.getInstance( AlphaComposite.SRC_OVER,
                                                    ( float )trs[ count%8 ][ i ] ));

      g2d.rotate( Math.PI/4f );
      g2d.drawLine( 0, -10, 0, -40 );
    }
  }

  public void actionPerformed( ActionEvent e ) 
  {
    repaint();
    count++;
  }
}

