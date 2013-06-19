import java.awt.*; 
import java.util.*; 
import javax.swing.JPanel; 
import javax.swing.ImageIcon; 

// uses a utility timer with scheduled task instead of a listener timer
// should make games more accurate

// CHANGE #1
// remove ActionListener implementation
public class StarBoard2 extends JPanel 
{
  private Image star;
  private Timer timer;
  private int   x, y; 

  public StarBoard2() 
  {
    ImageIcon ii = new ImageIcon( getClass().getResource( "tako.png" ) );
    star = ii.getImage();

    // this jpanel component will use a buffer to paint
    // all drawings will be done in memory first on the off-screen buffer
    // then copy what's on the off-screen buffer to the screen
    setDoubleBuffered( true ); 

    x = 10; 
    y = 10; 

    // CHANGE #2:
    // do scheduled task with a 100 ms initial delay and repeat every 10 ms
    timer = new Timer(); 
    timer.scheduleAtFixedRate( new ScheduleTask(), 100, 10 );
  }

  // all the drawing is done in this method
  public void paint( Graphics g )
  {
    super.paint( g ); 
    Graphics2D g2d = ( Graphics2D )g;

    // do drawings 
    g2d.drawImage( star, x, y, this ); 
  }

  // CHANGE #3:
  // create ScheduleTask class with run()
  // move listener code inside run() 
  class ScheduleTask extends TimerTask 
  {
    public void run()
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
}
