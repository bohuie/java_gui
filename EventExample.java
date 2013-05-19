import java.awt.event.*;
import javax.swing.*;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class EventExample extends JFrame implements ActionListener
{
  private JList list;
  private DefaultListModel model;

  public EventExample()
  {
    JPanel panel = new JPanel();
    panel.setLayout( null );

    // create button
    JButton okButton = new JButton( "Ok" );
    okButton.setBounds( 30, 35, 80, 25 );
    okButton.addActionListener( this );

    // create a list, so when button is clicked, info is displayed in the list
    model = new DefaultListModel();
    list  = new JList( model );
    list.setBounds( 150, 30, 220, 150 );

    // add components to frame
    panel.add( okButton );
    panel.add( list );
    add( panel );


    // set frame attributes
    setTitle( "Example" );
    setSize( 420, 250 );
    setLocationRelativeTo( null );
    setDefaultCloseOperation( EXIT_ON_CLOSE );
  }

  public void actionPerformed( ActionEvent e ) 
  {
    // get the time when event occurred 
    Locale locale = Locale.getDefault();
    Date   date   = new Date( e.getWhen() );   // this date is in milliseconds
    String s      = DateFormat.getTimeInstance( DateFormat.SHORT,
                    locale ).format( date );

    // make sure the model was instantiated
    if( !model.isEmpty() ) 
      model.clear();

    // display event information 
    if( e.getID() == ActionEvent.ACTION_PERFORMED ) 
      model.addElement( " Event Id: ACTION_PERFORMED" );

    model.addElement( " Time: " + s );

    String source = e.getSource().getClass().getName();
    model.addElement( " Source: " + source );

    // check if the event has any modifiers associated with it and display them too
    // modifier key is a bitwise OR of the modifier constant 
    int mod = e.getModifiers();
    StringBuffer buffer = new StringBuffer( " Modifiers: " );
    if(( mod & ActionEvent.ALT_MASK )   > 0 ) buffer.append( "Alt " );
    if(( mod & ActionEvent.SHIFT_MASK ) > 0 ) buffer.append( "Shift " );
    if(( mod & ActionEvent.META_MASK )  > 0 ) buffer.append( "Meta " );
    if(( mod & ActionEvent.CTRL_MASK )  > 0 ) buffer.append( "Ctrl ");
    model.addElement( buffer );
  }

  public static void main( String[] args )
  {
    EventExample ex = new EventExample();
    ex.setVisible( true );
  }
}
