import java.awt.*;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class TipOfDay extends JDialog
{
  public TipOfDay()
  {
    // setup basic panel 
    JPanel basic = new JPanel();
    basic.setLayout( new BoxLayout( basic, BoxLayout.Y_AXIS )); // vertical

    // setup top panel 
    JPanel topPanel = new JPanel( new BorderLayout( 0, 0 ));
    topPanel.setMaximumSize( new Dimension( 450, 0 ));
    JLabel topicText = new JLabel( "Cute Animal Hints" );
    topicText.setBorder( BorderFactory.createEmptyBorder( 0, 25, 0, 0 ));
    JLabel topicIcon = new JLabel( new ImageIcon( "panda.png" ));
    topicIcon.setBorder( BorderFactory.createEmptyBorder( 5, 5, 5, 5 ));
    JSeparator sep = new JSeparator(); 
    sep.setForeground( Color.gray );

    topPanel.add( topicText ); 
    topPanel.add( topicIcon, BorderLayout.EAST );
    topPanel.add( sep,       BorderLayout.SOUTH );
    basic.add( topPanel );

    // setup main text panel 
    JPanel textPanel = new JPanel( new BorderLayout() );
    textPanel.setBorder( BorderFactory.createEmptyBorder( 15, 25, 15, 25 ));
    JTextPane pane = new JTextPane();
    pane.setContentType("text/html");
    String text = "<p><b>How to choose cute animals for your projects</b></p>" +
        "<p>The animal has to be somewhat realistic, and preferrably in color. " +
        "It's best if the animal is a cartoon with a happy expression.</p>";
    pane.setText( text );
    pane.setEditable( false );
    textPanel.add( pane );
    basic.add( textPanel );

    // setup option to show panel
    JPanel boxPanel = new JPanel( new FlowLayout( FlowLayout.LEFT, 20, 0 ));
    JCheckBox cbox = new JCheckBox( "Don't show next time" );
    cbox.setMnemonic( KeyEvent.VK_D );
    boxPanel.add( cbox );
    basic.add( boxPanel );

    // setup dialog buttons 
    JPanel bottom = new JPanel( new FlowLayout( FlowLayout.RIGHT ));
    JButton ntip = new JButton( "Next Tip" );
    ntip.setMnemonic( KeyEvent.VK_N );
    JButton close = new JButton( "Close" );
    close.setMnemonic( KeyEvent.VK_C );
    bottom.add( ntip );
    bottom.add( close );
    bottom.setMaximumSize( new Dimension( 450, 0 ));
    basic.add( bottom );

    add( basic );

    // set dialog attributes
    setTitle( "Example" );
    setSize( 450, 350 );
    setResizable( false ); 
    setLocationRelativeTo( null );
    setDefaultCloseOperation( JDialog.DISPOSE_ON_CLOSE );
  }

  public static void main( String[] args )
  {
    TipOfDay ex = new TipOfDay();
    ex.setVisible( true );
  }
}
