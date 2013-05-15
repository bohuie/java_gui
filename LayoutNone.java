import javax.swing.*;

public class LayoutNone extends JFrame
{
  public LayoutNone()
  {  
    // specify no layout to be used
    setLayout( null );

    // create two buttons 
    JButton ok = new JButton( "OK" );
    ok.setBounds( 50, 50, 80, 55 );    // x,y,width,height

    JButton clz = new JButton( "Close" );
    clz.setBounds( 250, 50, 80, 25 );

    // add buttons to frame 
    add( ok ); 
    add( clz ); 

    // set frame attributes 
    setTitle( "No Layout Manager" ); 
    setSize( 300, 250 ); 
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    setLocationRelativeTo( null ); 
  }

  public static void main( String[] args )
  {
    LayoutNone ex = new LayoutNone();
    ex.setVisible( true );
  }
}
