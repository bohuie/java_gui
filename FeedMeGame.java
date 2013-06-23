import javax.swing.JFrame;

public class FeedMeGame extends JFrame
{
  public FeedMeGame()
  { 
    // basic setup 
    FeedMeBoard myBoard = new FeedMeBoard();

    // pre-load all sound files
    SoundEffect.init();
    SoundEffect.vol = SoundEffect.Volume.LOW;  // un-mute

    // add components 
    add( myBoard ); 

    // set frame attributes
    setTitle( "FeedMe" );
    setSize( 1000, 800 );
    setLocationRelativeTo( null );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    setResizable( false ); 
  }

  public static void main( String[] args )
  {
    FeedMeGame ex = new FeedMeGame();
    ex.setVisible( true );
  }
}
