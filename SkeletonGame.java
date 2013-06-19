import javax.swing.JFrame;

public class SkeletonGame extends JFrame
{
  public SkeletonGame()
  { 
    // basic setup 
    SkeletonBoard myBoard = new SkeletonBoard();

    // add components 
    add( myBoard ); 

    // set frame attributes
    setTitle( "SkeletonBoard" );
    setSize( 300, 280 );
    setLocationRelativeTo( null );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    setResizable( false ); 
  }

  public static void main( String[] args )
  {
    SkeletonGame ex = new SkeletonGame();
    ex.setVisible( true );
  }
}
