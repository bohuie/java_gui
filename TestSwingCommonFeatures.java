import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class TestSwingCommonFeatures extends JFrame
{
  public TestSwingCommonFeatures()
  {
    // setup top panel 
    JPanel p1 = new JPanel( new FlowLayout( FlowLayout.LEFT, 2, 2 ));
    JButton jbtLeft = new JButton( "Left" ); 
    JButton jbtCent = new JButton( "Center" ); 
    JButton jbtRite = new JButton( "Right" ); 
    jbtLeft.setBackground( Color.RED );                         // doesn't work
    jbtCent.setForeground( Color.GREEN );
    jbtRite.setToolTipText( "This button is on the right" );
    p1.add( jbtLeft ); 
    p1.add( jbtCent ); 
    p1.add( jbtRite ); 
    p1.setBorder( new TitledBorder( "Three Buttons" ));

    // setup bottom panel 
    Font largeFont = new Font( "TimesRoman", Font.BOLD, 20 );
    Border lineBorder = new LineBorder( Color.BLACK, 2 ); 
    JPanel p2 = new JPanel( new GridLayout( 1, 2, 5, 5 )); 
    // p2.setBackground( Color.BLUE );
    JLabel jlbRed = new JLabel( "Red" );
    JLabel jlbOrg = new JLabel( "Orange" );
    jlbRed.setBackground( Color.WHITE );                         // doesn't work
    jlbRed.setForeground( Color.RED ); 
    jlbRed.setFont( largeFont ); 
    jlbRed.setBorder( lineBorder ); 
    jlbOrg.setForeground( Color.ORANGE ); 
    jlbOrg.setFont( largeFont ); 
    jlbOrg.setBorder( lineBorder ); 
    p2.add( jlbRed ); 
    p2.add( jlbOrg ); 
    p2.setBorder( new TitledBorder( "Two Labels" ));

    // add two panels to frame 
    setLayout( new GridLayout( 2, 1, 5, 5 ));
    add( p1 );
    add( p2 );
  }
  
  public static void main( String[] args )
  {
    JFrame frame = new TestSwingCommonFeatures();
    frame.setTitle( "TestSwingCommonFeatures" );
    frame.setSize( 300, 150 ); 
    frame.setLocationRelativeTo( null ); // centers frame
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setVisible( true );
  }
}
