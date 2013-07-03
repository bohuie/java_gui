import java.util.Timer;
import java.util.TimerTask;
import java.util.ArrayList;
import java.util.Random;

public class FeedMeDrop 
{
  private Timer     timer;                  // timer for doing scheduled task
  private int       count;                  // counts number of targets dropped
  private ArrayList targets;                // maintains set of targets
  private int[]     locs;                   // maintains set of locations

  // constants
  private final static int MAX    = 15;
  private final static int NUMPOS = 6;
  private final static int OFFSET = 90; 
  private final static int INCR   = 150;

  public FeedMeDrop( int seconds ) 
  {
    // initialize all private variables
    locs    = new int[ NUMPOS ]; 
    targets = new ArrayList();
    count   = 0;
    timer   = new Timer();

    // create specific spots on the board to drop targets from
    for( int i=0; i<NUMPOS; i++ )
      locs[i] = OFFSET + ( i * INCR );

    // schedule a target to be dropped at fixed intervals
    RepeatTask dropTask = new RepeatTask(); 
    timer.scheduleAtFixedRate( dropTask, 0, seconds*1000 );
  }

  // accessors
  public ArrayList getTargets() { return targets; }
  public int       getMax()     { return MAX; }

  private void drop()
  {
    // position the item somewhere at the top of the board (one of possible locs)
    Random      r    = new Random();
    int         xpos = locs[ r.nextInt( NUMPOS ) ];
    FeedMeApple a    = new FeedMeApple( xpos, -100 );
    targets.add( a ); 
  }

  // inner class that defines the task to do repeatedly
  class RepeatTask extends TimerTask 
  {
    public void run() 
    {
      drop();
      count++; 

      // terminate the timer if MAX is reached 
      if( count >= MAX )
      {
        timer.cancel();
      }
    }
  }
}
