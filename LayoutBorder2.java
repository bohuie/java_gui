import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class LayoutBorder2 extends JFrame
{
  public LayoutBorder2()
  {
    // create a menu bar 
    JMenuBar menubar = new JMenuBar();
    JMenu file = new JMenu( "File" );
    menubar.add( file );

    // create a horizontal toolbar 
    JToolBar toolbar = new JToolBar();
    toolbar.setFloatable( false );

    ImageIcon exit = new ImageIcon( "exit.png" );
    JButton bexit = new JButton( exit );
    bexit.setBorder( new EmptyBorder( 0 ,0, 0, 0 ));
    toolbar.add( bexit );

    // create a vertical toolbar 
    JToolBar vertical = new JToolBar( JToolBar.VERTICAL );
    vertical.setFloatable( false );
    vertical.setMargin( new Insets( 10, 5, 5, 5 ));

    ImageIcon select   = new ImageIcon( "new.png" );
    ImageIcon freehand = new ImageIcon( "save.png" );
    ImageIcon shapeed  = new ImageIcon( "open.png" );

    JButton selectb   = new JButton( select );
    JButton freehandb = new JButton( freehand );
    JButton shapeedb  = new JButton( shapeed );
    selectb.setBorder(   new EmptyBorder( 3, 0, 3, 0 ));
    freehandb.setBorder( new EmptyBorder( 3, 0, 3, 0 ));
    shapeedb.setBorder(  new EmptyBorder( 3, 0, 3, 0 ));

    vertical.add( selectb );
    vertical.add( freehandb );
    vertical.add( shapeedb );

    // create a text area  
    JTextArea pad = new JTextArea(); 

    // create a status bar 
    JLabel statusbar = new JLabel( " Statusbar" );
    statusbar.setPreferredSize( new Dimension( -1, 22 ));
    statusbar.setBorder( LineBorder.createGrayLineBorder() );

    // add items to frame
    setJMenuBar( menubar );
    add( toolbar,   BorderLayout.NORTH );
    add( vertical,  BorderLayout.WEST );
    add( pad,       BorderLayout.CENTER );
    add( statusbar, BorderLayout.SOUTH );

    // set frame attributes
    setTitle( "Example" );
    setSize( 300, 300 );
    setLocationRelativeTo( null );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
  }

  public static void main( String[] args )
  {
    LayoutBorder2 ex = new LayoutBorder2();
    ex.setVisible( true );
  }
}
