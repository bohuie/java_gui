import java.awt.*; 
import javax.swing.JPanel; 
import javax.swing.ImageIcon; 

// uses a thread for animation instead of any timer 

// CHANGE #1
// implement Runnable interface 
public class StarBoard3 extends JPanel implements Runnable
{
  private Image star;
  private Thread animator;                  // CHANGE #2: use thread instead
  private int   x, y; 

  private final int DELAY = 50;             // CHANGE #3: create delay constant

  public StarBoard3() 
  {
    ImageIcon ii = new ImageIcon( getClass().getResource( "tako.png" ) );
    star = ii.getImage();

    // this jpanel component will use a buffer to paint
    // all drawings will be done in memory first on the off-screen buffer
    // then copy what's on the off-screen buffer to the screen
    setDoubleBuffered( true ); 

    x = 10; 
    y = 10; 

    // CHANGE #4: remove timer statements
  }

  // CHANGE #5: 
  // this method is called  after the JPanel is added to the JFrame component
  public void addNotify() 
  {
    super.addNotify();
    animator = new Thread( this );
    animator.start();
  }

  // all the drawing is done in this method
  public void paint( Graphics g )
  {
    super.paint( g ); 
    Graphics2D g2d = ( Graphics2D )g;

    // do drawings 
    g2d.drawImage( star, x, y, this ); 
  }

  // CHANGE #6:
  // change this work to a repeatable method 
  public void cycle()
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

  // CHANGE #7:
  // add a new method where the animation takes place
  public void run()
  {
    long beforeTime, timeDiff, sleepTime;
    beforeTime = System.currentTimeMillis();

    while( true ) 
    {
      cycle();
      timeDiff  = System.currentTimeMillis() - beforeTime;
      sleepTime = DELAY - timeDiff; 

      if( sleepTime < 0 )
        sleepTime = 2;

      try
      {
        Thread.sleep( sleepTime );
      }
      catch( InterruptedException e )
      {
        System.err.println( "interrupted" );
      }

      beforeTime = System.currentTimeMillis();
    } 
  }
}
