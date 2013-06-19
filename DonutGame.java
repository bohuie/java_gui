import javax.swing.JFrame;

public class DonutGame extends JFrame
{
  public DonutGame()
  { 
    // basic setup 
    DonutBoard myBoard = new DonutBoard();

    // add components 
    add( myBoard ); 

    // set frame attributes
    setTitle( "DonutBoard" );
    setSize( 300, 280 );
    setLocationRelativeTo( null );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    setResizable( false ); 
  }

  public static void main( String[] args )
  {
    DonutGame ex = new DonutGame();
    ex.setVisible( true );
  }
}
