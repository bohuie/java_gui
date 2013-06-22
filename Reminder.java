import java.util.Timer;
import java.util.TimerTask;

// demo that schedules a task to execute once every 2 seconds for 5 times

public class Reminder 
{
  Timer timer;
  int   count;

  public Reminder( int seconds ) 
  {
    count = 0;
    timer = new Timer();
    timer.scheduleAtFixedRate( new RemindTask(), 500, seconds*1000 );
  }

  class RemindTask extends TimerTask 
  {
    public void run() 
    {
      System.out.format( "Time's up!%n" );
      count++; 
      if( count > 4 )
        timer.cancel();     // terminate the timer thread
    }
  }

  public static void main( String args[] ) 
  {
    new Reminder( 2 );
    System.out.format( "Task scheduled.%n" );
  }
}
