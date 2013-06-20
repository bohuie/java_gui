import javax.swing.JFrame;

public class CraftGame extends JFrame
{
  public CraftGame()
  { 
    // basic setup 
    CraftBoard myBoard = new CraftBoard();

    // add components 
    add( myBoard ); 

    // set frame attributes
    setTitle( "CraftBoard" );
    setSize( 400, 380 );
    setLocationRelativeTo( null );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    setResizable( false ); 
  }

  public static void main( String[] args )
  {
    CraftGame ex = new CraftGame();
    ex.setVisible( true );
  }
}
