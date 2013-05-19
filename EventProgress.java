import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EventProgress extends JFrame
{
  ActionListener updateProBar;
  Timer          timer; 
  JProgressBar   pbar;  
  JButton        button;

  public EventProgress()
  {
    // initialize privates 
    pbar = new JProgressBar();     // default min=0, max=100, initial=0
    pbar.setMaximumSize( new Dimension( 150, 20 ));
    pbar.setMinimumSize( new Dimension( 150, 20 ));
    pbar.setPreferredSize( new Dimension( 150, 20 ));
    pbar.setAlignmentX( 0f );      // left alignment

    button = new JButton( "Start" );
    button.setMaximumSize( button.getPreferredSize() );

    updateProBar = new ActionListener()
    { 
      // stop pbar if max pbar val is reached, else increment pbar val
      public void actionPerformed( ActionEvent ev )
      { 
        int val = pbar.getValue();
        if( val >= 100 ) 
        { 
          timer.stop();
          button.setText( "End" );
        } 
        pbar.setValue( ++val );
      } 
    };

    // listen with updateProBar every 50ms
    // this is an example where event source is not an interface wodget, but the timer
    timer = new Timer( 50, updateProBar ); 

    // setup basic panel 
    JPanel panel = new JPanel();
    panel.setBorder( BorderFactory.createEmptyBorder( 40, 40, 40, 40 ));
    panel.setLayout( new BoxLayout( panel, BoxLayout.Y_AXIS )); 

    // setup button listener
    button.addActionListener( new ActionListener()
    {
      // change button to start & pause timer if it's running
      // change button to stop  & un-pause timer o/w, as long as pbar val < max val
      public void actionPerformed( ActionEvent e )
      { 
        if( timer.isRunning() )
        { 
          timer.stop();
          button.setText( "Start" );
        } 
        else if( button.getText() != "End" )
        { 
          timer.start();
          button.setText( "Stop" );
        } 
      } 
    });

    // add components 
    panel.add( pbar );
    panel.add( Box.createRigidArea( new Dimension( 0, 20 )));
    panel.add( button );
    add( panel );

    // set frame attributes
    setTitle( "Example" );
    setSize( 300, 200 );
    setLocationRelativeTo( null );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
  }

  public static void main( String[] args )
  {
    EventProgress ex = new EventProgress();
    ex.setVisible( true );
  }
}
