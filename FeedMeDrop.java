import java.util.Timer;
import java.util.TimerTask;

// demo that schedules a task to execute once every Interval for Max times

public class FeedMeDrop 
{
  Timer timer;
  int   count;
  int   max;

  public FeedMeDrop( int seconds ) 
  {
    max   = 100;
    count = 0;
    timer = new Timer();
    timer.scheduleAtFixedRate( new RepeatTask(), 0, seconds*1000 );
  }

  class RepeatTask extends TimerTask 
  {
    public void run() 
    {
      System.out.format( "Time's up!%n" );
      count++; 
      if( count > max )
        timer.cancel();     // terminate the timer thread
    }
  }
}
