import javax.swing.*;
import java.awt.*;

public class TestImageIcon extends JFrame
{
  private ImageIcon tako = new ImageIcon( "tako.png" );
  private ImageIcon lion = new ImageIcon( "lion.png" );
  private ImageIcon pand = new ImageIcon( "panda.png" );
  private ImageIcon rhin = new ImageIcon( "rhino.png" );
  private ImageIcon hipo = new ImageIcon( "hippo.png" );

  public TestImageIcon()
  {
    JPanel p1 = new JPanel( new GridLayout( 1, 4, 5, 5 )); 
    p1.add( new JLabel( tako )); 
    p1.add( new JLabel( lion )); 
    p1.add( new JLabel( pand )); 
    p1.add( new JLabel( rhin )); 
    p1.add( new JLabel( hipo )); 

    JPanel p2 = new JPanel( new FlowLayout( FlowLayout.CENTER, 2, 2 ));
    p2.add( new JLabel( "Images by C. Morales @ The Noun Project" ));

    // add panels to frame
    setLayout( new BorderLayout( 5, 10 )); 
    add( p1, BorderLayout.CENTER ); 
    add( p2, BorderLayout.SOUTH );
  }

  public static void main( String[] args )
  {
    TestImageIcon frame = new TestImageIcon();
    frame.setTitle( "TestImageIcon" ); 
    frame.setSize( 600, 200 ); 
    frame.setLocationRelativeTo( null );  // centers frame
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    frame.setVisible( true );
  }
}
