import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 

public class StarBoard extends JPanel implements ActionListener
{
  private Image star;
  private Timer timer;
  private int   x, y; 

  public StarBoard() 
  {
    ImageIcon ii = new ImageIcon( getClass().getResource( "tako.png" ) );
    star = ii.getImage();

    // this jpanel component will use a buffer to paint
    // all drawings will be done in memory first on the off-screen buffer
    // then copy what's on the off-screen buffer to the screen
    setDoubleBuffered( true ); 

    x = 10; 
    y = 10; 

    // every 25ms the timmer will call the actionPerformed() 
    timer = new Timer( 25, this );
    timer.start(); 
  }

  // all the drawing is done in this method
  public void paint( Graphics g )
  {
    super.paint( g ); 
    Graphics2D g2d = ( Graphics2D )g;

    // do drawings 
    g2d.drawImage( star, x, y, this ); 
  }

  // required listener method
  public void actionPerformed( ActionEvent e )
  {
    x++;
    y++;

    if( y > 200 )
    {
      x = x - 90;
      y = y - 90;
    }

    repaint();
  }
}
