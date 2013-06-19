import javax.swing.JFrame;

public class PictureGame extends JFrame
{
  public PictureGame()
  { 
    // basic setup 
    PictureBoard myBoard = new PictureBoard();

    // add components 
    add( myBoard ); 

    // set frame attributes
    setTitle( "PictureBoard" );
    setSize( myBoard.getWidth(), myBoard.getHeight()+20 );
    setLocationRelativeTo( null );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    setResizable( false ); 
  }

  public static void main( String[] args )
  {
    PictureGame ex = new PictureGame();
    ex.setVisible( true );
  }
}
