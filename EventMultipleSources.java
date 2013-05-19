import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;

public class EventMultipleSources extends JFrame
{
  JLabel statusbar; 

  public EventMultipleSources()
  {
    // instantiate privates
    statusbar = new JLabel( "Which button will you click?" );
    statusbar.setBorder( BorderFactory.createEtchedBorder( EtchedBorder.RAISED ));

    // create basic panel 
    JPanel panel = new JPanel();

    // create a single event listener
    MyButtonListener listener = new MyButtonListener(); 

    // create several sources
    JButton cloz = new JButton( "Close" );
    JButton open = new JButton( "Open" );
    JButton find = new JButton( "Find" );
    JButton save = new JButton( "Save" );
    cloz.setBounds( 40, 50, 80, 25 );
    open.setBounds( 40, 50, 80, 25 );
    find.setBounds( 40, 50, 80, 25 );
    save.setBounds( 40, 50, 80, 25 );
    cloz.addActionListener( listener ); 
    open.addActionListener( listener ); 
    find.addActionListener( listener ); 
    save.addActionListener( listener ); 

    // add components to frame
    panel.add( cloz );
    panel.add( open );
    panel.add( find );
    panel.add( save );
    add( panel ); 
    add( statusbar, BorderLayout.SOUTH ); 

    // set frame attributes
    setTitle( "Example" );
    setSize( 200, 200 );
    setLocationRelativeTo( null );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
  }

  // this is the "inner" class (i.e., a class within a class)
  class MyButtonListener implements ActionListener
  { 
    public void actionPerformed( ActionEvent e )
    { 
      JButton o   = ( JButton )e.getSource();
      String  lab = o.getText(); 
      statusbar.setText( " " + lab + " button selected" );
    } 
  } 

  public static void main( String[] args )
  {
    EventMultipleSources ex = new EventMultipleSources();
    ex.setVisible( true );
  }
}
