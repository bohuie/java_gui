import javax.swing.JFrame;

public class FeedMeGame extends JFrame
{
  public FeedMeGame()
  { 
    // basic setup 
    FeedMeBoard myBoard = new FeedMeBoard();

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
