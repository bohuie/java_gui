import java.awt.event.*;
import javax.swing.*;

public class EventByAnonInner extends JFrame
{
  public EventByAnonInner()
  {
    // create basic panel 
    JPanel panel = new JPanel();
    panel.setLayout( null );

    // create example button
    // events are handled via an anonymous inner class
    JButton closeButton = new JButton( "Close" );
    closeButton.setBounds( 40, 50, 80, 25 );
    closeButton.addActionListener( new ActionListener()
    {
      public void actionPerformed( ActionEvent event )
      {
        System.exit( 0 );
      }
    });

    // add components to frame
    panel.add( closeButton );
    add( panel ); 

    // set frame attributes
    setTitle( "Example" );
    setSize( 300, 200 );
    setLocationRelativeTo( null );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
  }

  public static void main( String[] args )
  {
    EventByAnonInner ex = new EventByAnonInner();
    ex.setVisible( true );
  }
}
