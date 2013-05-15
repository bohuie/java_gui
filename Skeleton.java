import java.awt.*;
import javax.swing.*;

public class Skeleton extends JFrame
{
  public Skeleton()
  {

    // set frame attributes
    setTitle( "Example" );
    setSize( 300, 200 );
    setLocationRelativeTo( null );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
  }

  public static void main( String[] args )
  {
    Skeleton ex = new Skeleton();
    ex.setVisible( true );
  }
}
