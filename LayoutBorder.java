import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class LayoutBorder extends JFrame
{
  public LayoutBorder()
  {
    JPanel panel = new JPanel( new BorderLayout() );
    JPanel top   = new JPanel();
    top.setBackground( Color.green );
    top.setPreferredSize( new Dimension( 250, 150 ));
    //panel.add( top, BorderLayout.WEST ); 
    panel.add( top );     // by default, add to CENTER
    /*
    JPanel top2  = new JPanel();
    top2.setBackground( Color.red );
    top2.setPreferredSize( new Dimension( 250, 150 ));
    panel.add( top2, BorderLayout.NORTH );
    */
    panel.setBorder( new EmptyBorder( new Insets( 20, 20, 20, 20 )));

    add( panel ); 

    // set frame attributes
    setTitle( "Border Example" );
    setSize( 500, 200 );
    setLocationRelativeTo( null );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
  }

  public static void main( String[] args )
  {
    LayoutBorder ex = new LayoutBorder();
    ex.setVisible( true );
  }
}
