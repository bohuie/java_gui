import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawLines2D extends JFrame
{
  int coords[][];
  int count;
  DrawPanel pane;

  public DrawLines2D()
  {
    // initializes privates
    coords = new int[ 100 ][ 2 ];
    count  = 0;

    // setup basic panel 
    pane = new DrawPanel();

    // add components 
    add( pane ); 

    // add mouse listener 
    addMouseListener( new MouseAdapter()
    {
      public void mousePressed( MouseEvent e )
      {
        // left button click 
        if( e.getButton() == MouseEvent.BUTTON1 )
        {
          // keep track of x,y of mouse click
          int x = e.getX();
          int y = e.getY();
          coords[ count ][ 0 ] = x;
          coords[ count ][ 1 ] = y;
          count++;
        }
        
        // right button click 
        if( e.getButton() == MouseEvent.BUTTON3 )
        {
          pane.setCoords( coords );
          pane.setCount( count );
          pane.drawLines(); 
          count = 0; 
          // why don't we have to reset coords[][] here?
        }
      }
    });

    // set frame attributes
    setTitle( "Example" );
    setSize( 300, 200 );
    setLocationRelativeTo( null );
    setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
  }

  public static void main( String[] args )
  {
    DrawLines2D ex = new DrawLines2D();
    ex.setVisible( true );
  }
}

class DrawPanel extends JPanel
{
  int coords[][];
  int count;

  public void setCoords( int[][] c ) { coords = c; prCoords(); }
  public void setCount( int c )      { count  = c; System.out.println( c ); }

  public void prCoords()
  {
    for( int i=0; i<(count-1); i++ )
      System.out.println( coords[i][0] + "," + coords[i][1] ); 
  }

  // all the drawing is done in this method
  public void drawLines()
  {
    Graphics   g   = this.getGraphics();
    Graphics2D g2d = ( Graphics2D )g;
    g2d.clearRect( 0, 0, getWidth(), getHeight() );

    // draw lines between every pair of coords
    for( int i=0; i<(count-1); i++ ) 
      for( int j=0; j<(count-1); j++ ) 
        g2d.drawLine( coords[i][0], coords[i][1], coords[j][0], coords[j][1] );
  }
}

