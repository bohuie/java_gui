import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EventComponent extends JFrame implements ComponentListener
{
  private JLabel labx; 
  private JLabel laby; 

  public EventComponent()
  {
    // initialize privates
    labx = new JLabel( "x: " );
    laby = new JLabel( "y: " );
    labx.setFont( new Font( "Serif", Font.BOLD, 16 ));
    laby.setFont( new Font( "Serif", Font.BOLD, 16 ));
    labx.setBounds( 20, 20, 60, 25 ); 
    laby.setBounds( 20, 20, 60, 25 ); 

    // create basic panel 
    JPanel panel = new JPanel();

    // add components 
    panel.add( labx ); 
    panel.add( laby ); 
    add( panel );
    addComponentListener( this );

    // set frame attributes
    setTitle( "Example" );
    setSize( 300, 200 );
    setLocationRelativeTo( null );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
  }

  // methods needed as part of the interface 
  public void componentResized( ComponentEvent e ) { }
  public void componentShown( ComponentEvent e ) { }
  public void componentHidden( ComponentEvent e ) { }

  // listener code that we actually care about 
  // displays the x,y coordinates of the application frame
  // if user drags the frame around, the x,y coordinates will get updated
  public void componentMoved( ComponentEvent e )
  {
    int x = e.getComponent().getX();
    int y = e.getComponent().getY();
    labx.setText( "x: " + x ); 
    laby.setText( "y: " + y ); 
  }

  public static void main( String[] args )
  {
    EventComponent ex = new EventComponent();
    ex.setVisible( true );
  }
}
