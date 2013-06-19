import javax.swing.JFrame;

public class StarGame extends JFrame
{
  public StarGame()
  { 
    // basic setup 
    StarBoard myBoard = new StarBoard();

    // add components 
    add( myBoard ); 

    // set frame attributes
    setTitle( "StarBoard" );
    setSize( 300, 320 );
    setLocationRelativeTo( null );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    setResizable( false ); 
  }

  public static void main( String[] args )
  {
    StarGame ex = new StarGame();
    ex.setVisible( true );
  }
}
