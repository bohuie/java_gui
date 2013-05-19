import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.util.Calendar; 

public class EventMultipleListeners extends JFrame
{
  private JLabel     statusbar;
  private JSpinner   spinner;
  private static int count; 

  public EventMultipleListeners()
  {
    // instantiate privates
    count = 0; 
    statusbar = new JLabel( "0" );
    statusbar.setBorder( BorderFactory.createEtchedBorder( EtchedBorder.RAISED ));
    Calendar cal  = Calendar.getInstance(); 
    int      year = cal.get( Calendar.YEAR );
    SpinnerModel yearModel = new SpinnerNumberModel( year, year-100, year+100, 1 );
    spinner = new JSpinner( yearModel );
    spinner.setEditor( new JSpinner.NumberEditor( spinner, "#" ));
    spinner.setBounds( 190, 30, 80, 25 ); 

    // create basic panel 
    JPanel panel = new JPanel();

    // create button with multiple listeners
    // when button is clicked, it will activate both listeners
    // 1st case: the spinner value will increment
    // 2nd case: the counter value will increment and be displayed on the status bar
    JButton add = new JButton( "+" );
    add.setBounds( 40, 30, 80, 25 );
    MyButtonListener1 list1 = new MyButtonListener1(); 
    MyButtonListener2 list2 = new MyButtonListener2(); 
    add.addActionListener( list1 ); 
    add.addActionListener( list2 ); 

    // add components to frame
    panel.add( add );
    panel.add( spinner );
    add( panel ); 
    add( statusbar, BorderLayout.SOUTH ); 

    // set frame attributes
    setTitle( "Example" );
    setSize( 300, 200 );
    setLocationRelativeTo( null );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
  }

  // this is the "inner" class (i.e., a class within a class)
  class MyButtonListener1 implements ActionListener
  { 
    public void actionPerformed( ActionEvent e )
    { 
      Integer val = ( Integer )spinner.getValue();
      spinner.setValue( ++val );
    } 
  } 

  class MyButtonListener2 implements ActionListener
  { 
    public void actionPerformed( ActionEvent e )
    { 
      statusbar.setText( Integer.toString( ++count ));
    } 
  } 

  public static void main( String[] args )
  {
    EventMultipleListeners ex = new EventMultipleListeners();
    ex.setVisible( true );
  }
}
