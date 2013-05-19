import java.awt.event.*;
import javax.swing.*;

public class EventByDerived extends JFrame
{
  public EventByDerived()
  {
    // create basic panel 
    JPanel panel = new JPanel();
    panel.setLayout( null );

    // create example button
    // events are handled via a derived inner class
    // MyButton class will specify the event listener, so no need for that here
    MyButton closeButton = new MyButton( "Close" );
    closeButton.setBounds( 40, 50, 80, 25 );

    // add components to frame
    panel.add( closeButton );
    add( panel ); 

    // set frame attributes
    setTitle( "Example" );
    setSize( 300, 200 );
    setLocationRelativeTo( null );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
  }

  // this is the inner derived class 
  class MyButton extends JButton implements ActionListener
  { 
    public MyButton( String text ) 
    { 
      super.setText( text );   // asks JButton to put text as its text
      addActionListener( this ); 
    } 

    public void actionPerformed( ActionEvent e )
    { 
      System.exit( 0 );
    } 
  } 

  public static void main( String[] args )
  {
    EventByDerived ex = new EventByDerived();
    ex.setVisible( true );
  }
}
