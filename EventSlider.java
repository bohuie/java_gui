import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class EventSlider extends JFrame
{
  private JSlider slider;
  private JLabel  label; 
  ImageIcon mute, min, med, max;

  public EventSlider()
  {
    // initialize privates
    mute = new ImageIcon( "none.png" );
    min  = new ImageIcon( "lo.png" );
    med  = new ImageIcon( "me.png" );
    max  = new ImageIcon( "hi.png" );
    label  = new JLabel( mute, JLabel.CENTER );
    slider = new JSlider( 0, 150, 0 ); 
    slider.setPreferredSize( new Dimension( 150, 30 ));

    // create basic panel
    JPanel panel = new JPanel(); 
    panel.setLayout( new BoxLayout( panel, BoxLayout.X_AXIS ));
    panel.setBorder( BorderFactory.createEmptyBorder( 40, 40, 40, 40 ));

    // add listener to slider
    slider.addChangeListener( new ChangeListener()
    {
      public void stateChanged( ChangeEvent ev )
      { 
        int val = slider.getValue();
        if( val == 0 )       label.setIcon( mute );
        else if( val <= 30 ) label.setIcon( min ); 
        else if( val <= 80 ) label.setIcon( med ); 
        else                 label.setIcon( max ); 
      } 
    });

    // add components 
    panel.add( slider ); 
    panel.add( Box.createRigidArea( new Dimension( 5, 0 )));
    panel.add( label ); 
    panel.add( Box.createHorizontalGlue()); 
    setLayout( new BorderLayout() ); 
    add( panel, BorderLayout.CENTER );

    // set frame attributes
    setTitle( "Example" );
    setSize( 300, 200 );
    setLocationRelativeTo( null );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
  }

  public static void main( String[] args )
  {
    EventSlider ex = new EventSlider();
    ex.setVisible( true );
  }
}
