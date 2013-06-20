import javax.swing.JFrame;

// direct copy of StarGame.java
public class StarGame3 extends JFrame
{
  public StarGame3()
  { 
    // basic setup 
    StarBoard3 myBoard = new StarBoard3();

    // add components 
    add( myBoard ); 

    // set frame attributes
    setTitle( "StarBoard 3" );
    setSize( 300, 320 );
    setLocationRelativeTo( null );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    setResizable( false ); 
  }

  public static void main( String[] args )
  {
    StarGame3 ex = new StarGame3();
    ex.setVisible( true );
  }
}
