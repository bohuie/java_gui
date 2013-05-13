import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Empty extends JFrame 
{
  public Empty() 
  {
   setTitle( "Simple example" );
   setSize( 300, 200 );
   setLocationRelativeTo( null );
   setDefaultCloseOperation( EXIT_ON_CLOSE );
  }

  public static void main( String[] args ) 
  {
    Empty ex = new Empty();
    ex.setVisible( true );
  }
}
