import java.awt.event.*;
import javax.swing.*;

public class EventByInner extends JFrame
{
  public EventByInner()
  {
    // create basic panel 
    JPanel panel = new JPanel();
    panel.setLayout( null );

    // create example button
    // events are handled via a (named) inner class
    JButton closeButton = new JButton( "Close" );
    closeButton.setBounds( 40, 50, 80, 25 );
    MyButtonCloseListener listener = new MyButtonCloseListener(); 
    closeButton.addActionListener( listener ); 

    // add components to frame
    panel.add( closeButton );
    add( panel ); 

    // set frame attributes
    setTitle( "Example" );
    setSize( 300, 200 );
    setLocationRelativeTo( null );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
  }

  // this is the "inner" class (i.e., a class within a class)
  class MyButtonCloseListener implements ActionListener
  { 
    public void actionPerformed( ActionEvent e )
    { 
      System.exit( 0 );
    } 
  } 

  public static void main( String[] args )
  {
    EventByInner ex = new EventByInner();
    ex.setVisible( true );
  }
}
