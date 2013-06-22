import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;
import java.util.Random;

// demo that schedules a task to execute once every Interval for Max times

public class FeedMeDrop 
{
  private Timer     timer;
  private int       count;
  private ArrayList targets;
  private int[]     locs;

  private final static int MAX    = 100;
  private final static int NUMPOS = 6;
  private final static int OFFSET = 90; 
  private final static int INCR   = 150;

  public FeedMeDrop( int seconds ) 
  {
    locs = new int[ NUMPOS ]; 
    for( int i=0; i<NUMPOS; i++ )
      locs[i] = OFFSET + ( i * INCR );
    targets = new ArrayList();
    count   = 0;
    timer   = new Timer();
    timer.scheduleAtFixedRate( new RepeatTask(), 0, seconds*1000 );
  }

  public ArrayList getTargets() { return targets; }

  private void drop()
  {
    // position the item somewhere at the top of the board
    Random      r    = new Random();
    int         xpos = locs[ r.nextInt( NUMPOS ) ];
    FeedMeApple a    = new FeedMeApple( xpos, -100 );
    targets.add( a ); 
  }

  class RepeatTask extends TimerTask 
  {
    public void run() 
    {
      drop();
      count++; 
      // terminate the timer thread
      if( count > MAX )
      {
        timer.cancel();
        System.out.println( "Time's up!" );
      }
    }
  }
}
