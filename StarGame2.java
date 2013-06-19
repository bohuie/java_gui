import javax.swing.JFrame;

// direct copy of StarGame.java
public class StarGame2 extends JFrame
{
  public StarGame2()
  { 
    // basic setup 
    StarBoard2 myBoard = new StarBoard2();

    // add components 
    add( myBoard ); 

    // set frame attributes
    setTitle( "StarBoard 2" );
    setSize( 300, 320 );
    setLocationRelativeTo( null );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    setResizable( false ); 
  }

  public static void main( String[] args )
  {
    StarGame2 ex = new StarGame2();
    ex.setVisible( true );
  }
}
